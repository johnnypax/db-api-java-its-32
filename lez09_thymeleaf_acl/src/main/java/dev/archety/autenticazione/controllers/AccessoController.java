package dev.archety.autenticazione.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import dev.archety.autenticazione.models.Utente;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
@EnableWebMvc
public class AccessoController {

	@GetMapping
	public String login() {
		return "login";
	}
	
	@GetMapping("verifica")
	public String verifica(HttpServletResponse response, @RequestParam String user, @RequestParam String pass) {
		
		if(user.equals("giovanni") && pass.equals("1234")) {
			Cookie autenticazione = new Cookie("loggato", "USER");
			response.addCookie(autenticazione);
			
			return "redirect:/profilo";
		}
		
		if(user.equals("admin") && pass.equals("toor")) {
			Cookie autenticazione = new Cookie("loggato", "ADMIN");
			response.addCookie(autenticazione);
			
			return "redirect:/dashboard";
		}
		
		return "redirect:/errore";		
	}
	
	@GetMapping("errore")
	public String errore() {
		return "errore";
	}

	@GetMapping("profilo")
	public String profilo(HttpServletRequest request) {
		
		Cookie[] elenco = request.getCookies();
		
		if(elenco != null)
			for(Cookie c: elenco)
				if(c.getName().equals("loggato") && c.getValue().equals("USER"))
					return "profilo";
		
		return "redirect:/";
		
	}

	@GetMapping("dashboard")
	public String dashboard(HttpServletRequest request) {
		
		Cookie[] elenco = request.getCookies();
		
		if(elenco != null)
			for(Cookie c: elenco)
				if(c.getName().equals("loggato") && c.getValue().equals("ADMIN"))
					return "dashboard";
		
		return "redirect:/";
		
	}
}
