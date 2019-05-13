package com.example.spring02.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.member.dto.MemberDTO;
import com.example.spring02.service.member.MemberService;

@Controller
@RequestMapping("/member/*")//공통적인 url mapping
public class MemberController {
	
	private static final Logger logger=
	LoggerFactory.getLogger(MemberController.class);
	
	
	@Inject
	MemberService memberService;

	@RequestMapping("login.do")// /member/login.do
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(@ModelAttribute MemberDTO dto,
			HttpSession session) {
		//로그인 성공=> 이름이 넘어옴, 실패=>null이 넘어옴
		String name=memberService.loginCheck(dto, session);
		ModelAndView mav=new ModelAndView();
		if(name != null) { //로그인 성공하면 시작 페이지로 이동
			mav.setViewName("home");
		}else { //로그인 실패하면 login 페이지로 다시 되돌아감
			mav.setViewName("member/login");
			mav.addObject("message", "error");
		}
		return mav;
	}
}
