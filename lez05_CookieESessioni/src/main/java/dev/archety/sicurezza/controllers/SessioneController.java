package dev.archety.sicurezza.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/sessioni")
public class SessioneController {

	@GetMapping("/dammi-sessione")
	public String CreaSessione(HttpServletRequest request) {
		HttpSession sessione = request.getSession();
		
		sessione.setAttribute("lang", "ENG");
		sessione.setAttribute("mode", "DARK");
		
		return "Ciao Giovanni";
	}
	
	@GetMapping("/elenca-sessione")
	public String ElencaSessione(HttpServletRequest request) {
		HttpSession sessione = request.getSession();
		
		String lang = (String)sessione.getAttribute("lang");
		String mode = (String)sessione.getAttribute("mode");
		
		System.out.println(lang + " - " + mode);
		
		return "Vai a vedere il servere";
	}
	
}
