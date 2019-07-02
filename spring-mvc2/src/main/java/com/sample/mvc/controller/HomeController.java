package com.sample.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sample.mvc.view.CustomExcelView;

@Controller
public class HomeController {

	@RequestMapping("/home.do")
	public String home() {
		return "home";
	}
	@RequestMapping("/about.do")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("about");

		return mav;
	}
	@RequestMapping("/history.do")
	public void history() {

	}
	@RequestMapping("/excel.do")
	public ModelAndView xls() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("제목", "2019년 상방기 매출현황");
		mav.addObject("매입", 1000000000);
		mav.addObject("매출", 1700000000);
		mav.addObject("영업이익", 700000000);

		mav.setView(new CustomExcelView());
		return mav;
	}
	@RequestMapping("/web.do")
	public ModelAndView web() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "2019년 상방기 매출현황");
		mav.addObject("buy", 1000000000);
		mav.addObject("sell", 1700000000);
		mav.addObject("profit", 700000000);
		
		mav.setViewName("web");
		return mav;
	}
}
