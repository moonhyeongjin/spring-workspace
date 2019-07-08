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
	
	// 로그를 남기기위해서는 lgger객체를 획득해야한다
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Value("${dir.file.attachment}")
	private String attachmentFileSaveDirectory;
	
   @Autowired
   private NoticeService noticeService;
   
   @Autowired
   private FileDownloadView fileDownloadView;
   
   @RequestMapping("/form.do")
   public String form() {
	   logger.debug("form()실행됌");
	   logger.info("공지사항 등록폼 요청이 접수됌");
	   logger.debug("form()종료됌");
      return "notice/form";
   }
   
   @RequestMapping("/add.do")
   public String add(NoticeForm noticeForm)throws IOException{
	   logger.debug("add() 실행됌");
	   logger.info("공지사항 제목 - " +noticeForm.getTitle());
	   logger.info("공지사항 내용 - " +noticeForm.getContents());
	   Notice notice = new Notice();
	   BeanUtils.copyProperties(noticeForm, notice);
	   logger.debug("NoticeForm의 값이 Notice에 복사됨");
	   
	   if(!noticeForm.getAttachmentfile().isEmpty()) {
		   logger.debug("첨부파일이 존재함.");
		   logger.debug("첨부파일이 처리를 시작함.");
		   
		   MultipartFile mf = noticeForm.getAttachmentfile();
		   String filename = mf.getOriginalFilename();
		   
		   logger.info("첨부파일이름 : " + filename);
		   filename = System.currentTimeMillis() +filename;
		   
		   FileCopyUtils.copy(mf.getBytes(),new File(attachmentFileSaveDirectory, filename));
		   notice.setAttachment(filename);
		   
		   logger.debug("첨부파일이 처리를 종료함.");
	   }
	   noticeService.addNewNotice(notice);
	   logger.debug("공지사항정보를 저장함");
	   logger.debug("재요청URL - redirect:list.do 임");
	   
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