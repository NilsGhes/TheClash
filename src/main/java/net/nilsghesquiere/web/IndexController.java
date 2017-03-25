package net.nilsghesquiere.web;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Logger;

import net.nilsghesquiere.entities.Jeugdhuis;
import net.nilsghesquiere.services.JeugdhuisService;

import org.springframework.beans.factory.annotation.Autowired;
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
	//datums
	static ZoneId zone = ZoneId.of("Europe/Paris");
	private static final ZonedDateTime timeStart = ZonedDateTime.parse("2017-03-25T21:00:00+01:00[Europe/Paris]");
	private static final ZonedDateTime timeEnd = ZonedDateTime.parse("2017-03-26T02:00:00+01:00[Europe/Paris]");
	
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
		
		List<Jeugdhuis> jeugdhuizen = jeugdhuisService.findAllByOrderByIdAsc();
		return new ModelAndView(VIEW).addObject("jeugdhuizen", jeugdhuizen).addObject("currentUser", currentUser);
	}
	
	@PreAuthorize("hasAnyAuthority('appadmin','jhadmin')")
	@RequestMapping(method = RequestMethod.POST)
	ModelAndView IncreaseDranken(@RequestParam Long jhId, @RequestParam Integer aantDr) {
		boolean kanToevoegen;
		String message = "";
		ZonedDateTime timeNow = ZonedDateTime.now(zone);
		
		if (timeNow.isAfter(timeStart)){
			if (timeNow.isBefore(timeEnd)){
				kanToevoegen = true;
			} else {
				kanToevoegen = false;
				message = "De clash der jeugdhuizen is reeds afgelopen";
			}
		} else {
			kanToevoegen = false;
			message = "De clash der jeugdhuizen is nog niet begonnen";
		}
		
		if (kanToevoegen){
			Jeugdhuis jeugdhuis = jeugdhuisService.read(jhId);
			logger.info("Increasing dranken voor " + jeugdhuis.getName());
			jeugdhuis.incrementAantalDranken(aantDr);
			jeugdhuisService.update(jeugdhuis);
			return new ModelAndView(REDIRECT_NA_INCREMENT);
		} else {
			//Change this to get the user object instead
			String currentUser = "";
			if (SecurityContextHolder.getContext().getAuthentication() != null &&
					 SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
				currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
			} 
			
			logger.info("Loading index page.");
			List<Jeugdhuis> jeugdhuizen = jeugdhuisService.findAllByOrderByIdAsc();
			return new ModelAndView(VIEW).addObject("jeugdhuizen", jeugdhuizen).addObject("currentUser", currentUser).addObject("failMessage",message);
		}
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