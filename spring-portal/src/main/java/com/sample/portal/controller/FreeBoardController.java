package com.sample.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.portal.service.FreeBoardService;
import com.sample.portal.vo.FreeBoard;
import com.sample.portal.vo.FreeBoardComment;

@Controller
@RequestMapping("/free")
public class FreeBoardController {
	
	@Value("${dir.image.free}")
	private String freeImageSaveDirectory;
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("list.do")
	public String list(Model model) {
		List<FreeBoard> boards= freeBoardService.getAllFreeBoards();
		
		model.addAttribute("boards", boards);
		
		return "free/list";
	}
	@RequestMapping("/detail.do")
	public String detail(@RequestParam("no") int boardNo, Model model) {
		model.addAttribute("board", freeBoardService.getFreeBoardDetail(boardNo));
		model.addAttribute("comments", freeBoardService.getFreeBoardComments(boardNo));
		
		return "free/detail";
	}
	
	@RequestMapping("/addcomment.do")
	public @ResponseBody List<FreeBoardComment> addComment(@RequestParam("writer") String writer, String contents, @RequestParam("no") int boardNo){
		FreeBoardComment comment = new FreeBoardComment();
		comment.setWriter(writer);
		comment.setContents(contents);
		comment.setBoardNo(boardNo);
		freeBoardService.addNewFreeBoardComment(comment);
		
		List<FreeBoardComment> comments = freeBoardService.getFreeBoardComments(boardNo);
		return comments;
	}
	
	/*
	 * @RequestMapping(value = "add.do",method = RequestMethod.GET) public String
	 * addform() {
	 * 
	 * return "free/form"; }
	 * 
	 * @RequestMapping(value = "add.do",method = RequestMethod.POST) public String
	 * addboard() {
	 * 
	 * return "redirect:/list.do"; }
	 */
	
	
	
}
