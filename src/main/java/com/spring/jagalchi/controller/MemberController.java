package com.spring.jagalchi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.jagalchi.dao.MemberDAO;
import com.spring.jagalchi.model.MemberModel;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO memberDAO;
	
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public @ResponseBody List<MemberModel> selectAllMember(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		response.setCharacterEncoding("utf-8");
		ArrayList<MemberModel> members = null;
		
		members = memberDAO.selectAllMember();
		
		return members;
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public @ResponseBody MemberModel selectMemberById(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		MemberModel member = memberDAO.selectMemberById(id);
		
		return member;
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String insertMember(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println(id + " " + password + " " + name + " " + major + " " + age);
		int result = memberDAO.insertMember(new MemberModel(id, password, name, major, age));
		
		if(result != 0) { //성공
			return "redirect:login";
		}else {
			model.addAttribute("isError", true);
			return "register";
		}
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.DELETE)
	public String deleteMember(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		int result = memberDAO.deleteMember(id);
		
		if(result != 0) { //성공
			return "redirect:login";
		}else {
			return "myinfo";
		}
		
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.PUT)
	public String updateMember(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		int age = Integer.parseInt(request.getParameter("age"));
		
		int result = memberDAO.updateMember(new MemberModel(id, password, name, major, age));
		
		if(result != 0) {
			
		}else {
			
		}
		
		return "myinfo";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberModel member =  memberDAO.loginMember(id, password);
		
		if(member != null) {
			session.setAttribute("isLogin", member);
			return "redirect:calendar";
		}else {
			model.addAttribute("isError", true);
			return "login";
		}

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		
		session.invalidate();
		
		return "redirect:login";

	}

	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public @ResponseBody Boolean idCheck(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		MemberModel member = memberDAO.selectMemberById(id);
		
		if(member == null) { //성공
			return true;
		}else {
			return false;
		}
	}
}
