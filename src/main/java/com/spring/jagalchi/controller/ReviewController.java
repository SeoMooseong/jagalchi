package com.spring.jagalchi.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
		String rjmcd = request.getParameter("rjmcd");
		ArrayList<ReviewModel> reviews = null;
		System.out.println("selectAllReview");
		reviews = reviewDAO.selectAllReview(rjmcd);
		
		return reviews;
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public @ResponseBody List<ReviewModel> insertReview(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		response.setCharacterEncoding("utf-8");
		System.out.println("insertReview");
		ArrayList<ReviewModel> reviews = null;
		
		String rjmcd = request.getParameter("rjmcd");
		String rcontent = request.getParameter("rcontent");
		String rdate = String.valueOf(request.getParameter("rdate"));
		
		MemberModel member = (MemberModel) session.getAttribute("isLogin");
		String rid = member.getId();
		
		int result = reviewDAO.insertReview(new ReviewModel(rjmcd, rid, rcontent, rdate));

		if(result != 0) {
			reviews = reviewDAO.selectAllReview(rjmcd);
		}
		
		return reviews;
	}
	
	@RequestMapping(value = "/updateReview", method = RequestMethod.POST)
	public @ResponseBody List<ReviewModel> updateReview(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		response.setCharacterEncoding("utf-8");
		ArrayList<ReviewModel> reviews = null;
		System.out.println("updateReview");

		String rjmcd = request.getParameter("rjmcd");
		int rno = Integer.parseInt(request.getParameter("rno"));
		String rcontent = request.getParameter("rcontent");
		
		int result = reviewDAO.updateReview(rno, rcontent);
		
		if(result != 0) {
			reviews = reviewDAO.selectAllReview(rjmcd);
		}
		
		return reviews;
	}
	
	@RequestMapping(value = "/deleteReview", method = RequestMethod.POST)
	public @ResponseBody List<ReviewModel> deleteReview(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		response.setCharacterEncoding("utf-8");
		ArrayList<ReviewModel> reviews = null;
		System.out.println("deleteReview");
		String rjmcd = request.getParameter("rjmcd");
		System.out.println(rjmcd +" " + request.getParameter("rno"));
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		int result = reviewDAO.deleteReview(rno);

		if(result != 0) {
			reviews = reviewDAO.selectAllReview(rjmcd);
		}
		
		return reviews;
	}
	
	
	@RequestMapping(value = "/review_sse", method = RequestMethod.GET)
	public String review_sse(HttpServletRequest request, Model model) {
		
		String rjmcd = request.getParameter("rjmcd");
		System.out.println("review_sse : " + rjmcd);
		
		ArrayList<ReviewModel> list = reviewDAO.selectAllReview(rjmcd);
		
		JSONArray jarr = new JSONArray();
		
		for(int i = 0 ; i < list.size() ; i++) {
			JSONObject jo = new JSONObject();
			jo.put("rjmcd", list.get(i).getRjmcd());
			jo.put("rid", list.get(i).getRid());
			jo.put("rno", list.get(i).getRno());
			jo.put("rcontent", list.get(i).getRcontent());
			jo.put("rdate", list.get(i).getRdate());
			jarr.add(jo);
		}
		
		model.addAttribute("jarr", jarr);
		return "review_sse";
	}
}
