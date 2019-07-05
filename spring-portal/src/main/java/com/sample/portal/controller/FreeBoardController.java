package com.sample.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.portal.service.FreeBoardService;
import com.sample.portal.vo.FreeBoard;

@Controller
@RequestMapping("/free")
public class FreeBoardController {
	
	@Value("${dir.image.free}")
	private String freeImageSaveDirectory;
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("list.do")
	public String list(Model model) {
		List<FreeBoard> boards= freeBoardService.getAllBoards();
		
		model.addAttribute("boards", boards);
		
		return "free/list";
	}
	@RequestMapping(value = "add.do",method = RequestMethod.GET)
	public String addform() {
		
		return "free/form";
	}
	@RequestMapping(value = "add.do",method = RequestMethod.POST)
	public String addboard() {
		
		return "redirect:/list.do";
	}
	
	
	
}
