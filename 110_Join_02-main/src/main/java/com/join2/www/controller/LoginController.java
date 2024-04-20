package com.join2.www.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.join2.www.service.JoinService;

@Controller
public class LoginController {

	//Controller bean생성 확인용
	public LoginController() {
		System.out.println("----------<<<---생성완료-->>>----------" );
	}
	
	@RequestMapping("/joinPage.do")
	public String joinPage() {
		
		return "login";
	}
	
	@Autowired
	private JoinService joinService;
	
	
	@RequestMapping("/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params) {
//		System.out.println("--------------------"+params+"params");
		int result = joinService.join(params);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		String msg = (result == 1) ? "A가입 성공" : "B가입 실패";
		mv.addObject("msg",msg);
		mv.setViewName("login");
		return mv;
	}
}
