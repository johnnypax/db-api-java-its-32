package dev.archety.sicurezza.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/biscotti")
public class CookieController {

	@GetMapping("/dammi-biscotto")
	public String GeneraCooke(HttpServletResponse response) {
		
		Cookie lingua = new Cookie("lang", "ENG");
		Cookie mode = new Cookie("mode", "DARK");
		
		response.addCookie(lingua);
		response.addCookie(mode);
		
		return "Hey Joe!";
	}
	
	@GetMapping("/elenca-biscotti")
	public String ElencaCookies(HttpServletRequest request) {
		Cookie[] elenco = request.getCookies();
		
		if(elenco != null) {
			for(Cookie c: elenco){
				System.out.println(c.getName() + " " + c.getValue());
			}
		}
		
		return "Vai a controllare il server";
		
		
	}
	
}
