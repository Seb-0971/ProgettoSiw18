package progetto.controller;




import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import progetto.service.ResponsabileService;

;

@Controller
public class MainController {
	
	ResponsabileService responsabileService;


	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value= "/")
	protected String showDashboard(Model model) {
		
		Collection<? extends GrantedAuthority> authorities= SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	    for (GrantedAuthority grantedAuthority : authorities){
	        if (grantedAuthority.getAuthority().equals("ROLE_RESPONSABILE")) 
	        	return "dashboardResponsabile";
	        
	        if (grantedAuthority.getAuthority().equals("ROLE_DIRETTORE")) 
		        	return "dashboardDirettore";
	        
	        else 
	        	return "login";
		
	    }
	
	    
	    	return "login";
	}
	}
	
