package com.spring.jagalchi.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String certificate(Locale locale, Model model) {
		
		ArrayList<CDTO> cdto = cdao.selectCertiByDate("20200101", "20200231");
		
		for(int i = 0 ; i < cdto.size() ; i++) {
			System.out.println(cdto.get(i));
		}
		//System.out.println(cdto);
		model.addAttribute("serverTime", "call certificate" );
		
		return "home";
	}
	
}
