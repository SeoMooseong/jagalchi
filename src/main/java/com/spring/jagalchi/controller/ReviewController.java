package com.spring.jagalchi.controller;

import java.sql.Date;
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

import com.spring.jagalchi.dao.ReviewDAO;
import com.spring.jagalchi.model.MemberModel;
import com.spring.jagalchi.model.ReviewModel;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewDAO reviewDAO;
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public @ResponseBody List<ReviewModel> selectAllReview(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		response.setCharacterEncoding("utf-8");
		ArrayList<ReviewModel> reviews = null;
		System.out.println("selectAllReview");
		reviews = reviewDAO.selectAllReview();
		
		return reviews;
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public @ResponseBody List<ReviewModel> insertReview(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		response.setCharacterEncoding("utf-8");
		System.out.println("insertReview");
		ArrayList<ReviewModel> reviews = null;
		
		String rjmcd = request.getParameter("rjmcd");
		String rcontent = request.getParameter("rcontent");
		Date rdate = Date.valueOf(request.getParameter("rdate"));
		
		MemberModel member = (MemberModel) session.getAttribute("isLogin");
		String rid = member.getId();
		
		int result = reviewDAO.insertReview(new ReviewModel(rjmcd, rid, rcontent, rdate));

		if(result != 0) {
			reviews = reviewDAO.selectAllReview();
		}
		
		return reviews;
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.PUT)
	public @ResponseBody List<ReviewModel> updateReview(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		response.setCharacterEncoding("utf-8");
		ArrayList<ReviewModel> reviews = null;
		System.out.println("updateReview");
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		String rcontent = request.getParameter("rcontent");
		
		int result = reviewDAO.updateReview(rno, rcontent);

		if(result != 0) {
			reviews = reviewDAO.selectAllReview();
		}
		
		return reviews;
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.DELETE)
	public @ResponseBody List<ReviewModel> deleteReview(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		response.setCharacterEncoding("utf-8");
		ArrayList<ReviewModel> reviews = null;
		System.out.println("deleteReview");
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		int result = reviewDAO.deleteReview(rno);

		if(result != 0) {
			reviews = reviewDAO.selectAllReview();
		}
		
		return reviews;
	}
}
