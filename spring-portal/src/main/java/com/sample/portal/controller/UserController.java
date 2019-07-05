package com.sample.portal.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sample.portal.exception.AlreadyUsedIdException;
import com.sample.portal.exception.LoginFailureException;
import com.sample.portal.form.UserForm;
import com.sample.portal.service.UserService;
import com.sample.portal.vo.User;

@Controller
@RequestMapping("/user") // url 주소에 /user/~~~.do 가 들어가게하는거
public class UserController {
	
	@Value("${dir.image.profile}")
	private String profileImageSaveDirectory;
	
	@ExceptionHandler(AlreadyUsedIdException.class)
	public String alreadyUsedIdExceptionHandler(AlreadyUsedIdException ex) {
		return "error/user/registerfail";
	}
	
	@ExceptionHandler(LoginFailureException.class)
	public String LoginFailureException(LoginFailureException ex){
		return "error/user/loginfail";
	}
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="register.do", method=RequestMethod.GET)
	public String registerform(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "user/form"; //views 밑에 user 폴더 아래 form.jsp
	}
	
	@RequestMapping(value="register.do", method=RequestMethod.POST)
	public String register(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult errors) throws Exception {
		// BindingResult 안에는 유효성체크의 수행결과 ( 메세지와 필드명)이 들어있음
		
		System.out.println(errors);
		if(errors.hasErrors()) {
			System.out.println("유효성 체크를 통과하지 못함");
			return "user/form"; //입력폼으로 다시보냄
		}
		User user = new	User();
		BeanUtils.copyProperties(userForm, user);
		
		MultipartFile mf = userForm.getPhotofile();
		
		if(!mf.isEmpty()) {
			long maxFileSize = 1024*1024; // 1MB
			long fileSize = mf.getSize();
			
			if(fileSize > maxFileSize) {
				errors.rejectValue("photofile", null, "첨부파일의 최대용량을 초과하였습니다.");
				return "user/form";
			}
			String filename = mf.getOriginalFilename();
			FileCopyUtils.copy(mf.getBytes(), new File(profileImageSaveDirectory, filename));
			user.setProfile(filename);
		}
		
		userService.registerUser(user);
		return "redirect:complete.do";	
	}
	@RequestMapping("complete.do")
	public String complete() {
		return "user/completed";
		
	}
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String loginform() {
		return "user/loginform";
	}
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session) { //@Requestparam 안적어도 댐
		User user = userService.login(id, password);
		
		String returnUrl = (String) session.getAttribute("returnUrl");
		String queryString = (String) session.getAttribute("queryString");
		
		session.removeAttribute("returnUrl");
		session.removeAttribute("queryString");
		
		String path = "redirect:/home.do";
		if(returnUrl != null) {
			path = "redirect:"+returnUrl;
		}
		if(queryString != null) {
			path += "?" + queryString;
		}
		
		session.setAttribute("LOGIN_USER", user);
		
		return path;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home.do";
	}
	
	@InitBinder 
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dataFormat, true));
	}
}
