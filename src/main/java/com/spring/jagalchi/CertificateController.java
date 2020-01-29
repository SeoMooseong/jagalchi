package com.spring.jagalchi;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CertificateController {
	
	private static final Logger logger = LoggerFactory.getLogger(CertificateController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/certificate", method = RequestMethod.GET)
	public String certificate(Locale locale, Model model) {
		
		model.addAttribute("serverTime", "call certificate" );
		
		return "home";
	}
	
}
