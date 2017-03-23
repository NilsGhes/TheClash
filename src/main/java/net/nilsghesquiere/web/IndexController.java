package net.nilsghesquiere.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import net.nilsghesquiere.entities.Jeugdhuis;
import net.nilsghesquiere.entities.Role;
import net.nilsghesquiere.entities.User;
import net.nilsghesquiere.services.JeugdhuisService;
import net.nilsghesquiere.services.RoleService;
import net.nilsghesquiere.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
	private static final Logger logger = Logger.getLogger(IndexController.class.getSimpleName());
	private static final String VIEW = "index";
	private static final String REDIRECT_NA_INCREMENT = "redirect:/";
	private final JeugdhuisService jeugdhuisService ;

	@Autowired
	public IndexController(JeugdhuisService jeugdhuisService) {
		this.jeugdhuisService = jeugdhuisService;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView Jeugdhuis() {
		//Change this to get the user object instead
		String currentUser = "";
		if (SecurityContextHolder.getContext().getAuthentication() != null &&
				 SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
			currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		} 

		logger.info("Loading index page.");
		List<Jeugdhuis> jeugdhuizen = jeugdhuisService.findAllByOrderByIdAsc();
		return new ModelAndView(VIEW).addObject("jeugdhuizen", jeugdhuizen).addObject("currentUser", currentUser);
	}
	
	@PreAuthorize("hasAnyAuthority('appadmin','jhadmin')")
	@RequestMapping(method = RequestMethod.POST)
	ModelAndView IncreaseDranken(@RequestParam Long jhId, @RequestParam Integer aantDr) {
		Jeugdhuis jeugdhuis = jeugdhuisService.read(jhId);
		logger.info("Increasing dranken voor " + jeugdhuis.getName());
		jeugdhuis.incrementAantalDranken(aantDr);
		jeugdhuisService.update(jeugdhuis);
		return new ModelAndView(REDIRECT_NA_INCREMENT);
	}
	
	  // Login form
	  @RequestMapping("/login.html")
	  public String login() {
	    return "login";
	  }

	  // Login form with error
	  @RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login";
	  }
}