package dev.archety.autenticazione.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("biscotti")
@EnableWebMvc
public class CookieController {

	@GetMapping("dammi-cookie")
	public String emettiCookie(HttpServletResponse response) {
		Cookie linguaggio = new Cookie("lang", "ENG");
		Cookie modalita = new Cookie("mode", "DARK");
		linguaggio.setMaxAge(3600);
		modalita.setMaxAge(3600);
		
		response.addCookie(linguaggio);
		response.addCookie(modalita);
		
		return "nuovocookie";
	}
	
	@GetMapping("saluta")
	public String leggiCookie(HttpServletRequest request) {
		Cookie[] elenco = request.getCookies();
		
		String linguaSelezionata = "ITA";
		
		if(elenco != null) {
			for(Cookie c: elenco) {
				if(c.getName().equals("lang") && c.getValue().equals("ENG"))
					linguaSelezionata = "ENG";
			}
		}
		
		switch(linguaSelezionata) {
		case "ITA": 
			return "salutaita";
		case "ENG": 
			return "salutaeng";
		default:
			return "salutaita";
		}
	}
	
}
