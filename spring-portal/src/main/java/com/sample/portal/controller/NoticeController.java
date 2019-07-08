package com.sample.portal.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sample.portal.form.NoticeForm;
import com.sample.portal.service.NoticeService;
import com.sample.portal.view.FileDownloadView;
import com.sample.portal.vo.Notice;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	// �α׸� ��������ؼ��� lgger��ü�� ȹ���ؾ��Ѵ�
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Value("${dir.file.attachment}")
	private String attachmentFileSaveDirectory;
	
   @Autowired
   private NoticeService noticeService;
   
   @Autowired
   private FileDownloadView fileDownloadView;
   
   @RequestMapping("/form.do")
   public String form() {
	   logger.debug("form()������");
	   logger.info("�������� ����� ��û�� ������");
	   logger.debug("form()�����");
      return "notice/form";
   }
   
   @RequestMapping("/add.do")
   public String add(NoticeForm noticeForm)throws IOException{
	   logger.debug("add() ������");
	   logger.info("�������� ���� - " +noticeForm.getTitle());
	   logger.info("�������� ���� - " +noticeForm.getContents());
	   Notice notice = new Notice();
	   BeanUtils.copyProperties(noticeForm, notice);
	   logger.debug("NoticeForm�� ���� Notice�� �����");
	   
	   if(!noticeForm.getAttachmentfile().isEmpty()) {
		   logger.debug("÷�������� ������.");
		   logger.debug("÷�������� ó���� ������.");
		   
		   MultipartFile mf = noticeForm.getAttachmentfile();
		   String filename = mf.getOriginalFilename();
		   
		   logger.info("÷�������̸� : " + filename);
		   filename = System.currentTimeMillis() +filename;
		   
		   FileCopyUtils.copy(mf.getBytes(),new File(attachmentFileSaveDirectory, filename));
		   notice.setAttachment(filename);
		   
		   logger.debug("÷�������� ó���� ������.");
	   }
	   noticeService.addNewNotice(notice);
	   logger.debug("�������������� ������");
	   logger.debug("���ûURL - redirect:list.do ��");
	   
	   return "redirect:list.do";
   }
   
   @RequestMapping("/list.do")
   public String list(Model model) {
      model.addAttribute("notices", noticeService.getAllNotices());
      return "notice/list";
   }
   
   @RequestMapping("/download.do")
   public ModelAndView download(@RequestParam("no") int noticeNo) {
	   
	   Notice notice = noticeService.getNoticeDetail(noticeNo);
	   
	   ModelAndView mav = new ModelAndView();
	   mav.addObject("directory", attachmentFileSaveDirectory);
	   mav.addObject("filename", notice.getAttachment());
	   
	   mav.setView(fileDownloadView);
	   
	   return mav;
   }
}