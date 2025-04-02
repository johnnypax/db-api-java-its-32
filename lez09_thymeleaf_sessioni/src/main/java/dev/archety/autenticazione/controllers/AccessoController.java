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
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@EnableWebMvc
public class AccessoController {

	@GetMapping
	public String login() {
		return "login";
	}
	
	@GetMapping("verifica")
	public String verifica(HttpServletRequest request, @RequestParam String user, @RequestParam String pass) {
		
		HttpSession sessione = request.getSession();
		
		if(user.equals("giovanni") && pass.equals("1234")) {
			sessione.setAttribute("loggato", "USER");
			
			return "redirect:/profilo";
		}
		
		if(user.equals("admin") && pass.equals("toor")) {
			sessione.setAttribute("loggato", "ADMIN");
			
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
		
		HttpSession sessione = request.getSession();
		String ruolo = (String)sessione.getAttribute("loggato");
		
		if(ruolo != null && ruolo.equals("USER"))
			return "profilo";
		
		return "redirect:/";
		
	}

	@GetMapping("dashboard")
	public String dashboard(HttpServletRequest request) {
		
		HttpSession sessione = request.getSession();
		String ruolo = (String)sessione.getAttribute("loggato");
		
		if(ruolo != null && ruolo.equals("ADMIN"))
			return "dashboard";
		
		return "redirect:/";
		
	}
}
