package com.spring.jagalchi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.jagalchi.dao.CertificateDAO;
import com.spring.jagalchi.model.CDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CertificateController {
	
	@Autowired
	CertificateDAO cdao;
	
	private static final Logger logger = LoggerFactory.getLogger(CertificateController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/selectCertiByDate", method = RequestMethod.GET)
	public @ResponseBody List<CDTO> certificate(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		String flag = request.getParameter("flag");
		
		if(flag == null) return null;
		
		response.setCharacterEncoding("utf-8");
		ArrayList<CDTO> cdtos = null;
		
		if(flag.equals("1")) {
			cdtos = cdao.selectCertiByDate(sdate, edate);
		}
		else {
			cdtos = cdao.selectCertiByRegDate(sdate, edate);
		}
		
		return cdtos;
	}
	
	@RequestMapping(value = "/selectCertiByCode", method = RequestMethod.GET)
	public @ResponseBody List<CDTO> selectCertiByCode(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		System.out.println("selectCertiByCode");
		String code = request.getParameter("code");
		response.setCharacterEncoding("utf-8");
		ArrayList<CDTO> cdtos = null;
		cdtos = cdao.selectCertiByCode(code);
		
		for(int i = 0 ; i < cdtos.size() ; i++) {
			System.out.println(cdtos.get(i));
		}
		return cdtos;
	}
	
	@RequestMapping(value = "/selectStatistics", method = RequestMethod.GET)
	public @ResponseBody List<CDTO> selectStatistics(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		System.out.println("selectCertiByCode");
		String code = request.getParameter("code");
		response.setCharacterEncoding("utf-8");
		ArrayList<CDTO> cdtos = null;
		cdtos = cdao.selectStatistics(code);
		
		for(int i = 0 ; i < cdtos.size() ; i++) {
			System.out.println(cdtos.get(i));
		}
		return cdtos;
	}
}
