package net.nilsghesquiere.controllers;

import java.util.List;
import java.util.logging.Logger;

import net.nilsghesquiere.entities.Jeugdhuis;
import net.nilsghesquiere.services.JeugdhuisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jeugdhuis")
public class JeugdhuisController {
	private static final Logger logger = Logger.getLogger(JeugdhuisController.class.getSimpleName());
	private static final String VIEW = "jeugdhuis";

	private final JeugdhuisService jeugdhuisService ;

	@Autowired
	public JeugdhuisController(JeugdhuisService jeugdhuisService) {
		this.jeugdhuisService = jeugdhuisService;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView Jeugdhuis() {
		logger.info("Loading jeugdhuis page.");
		List<Jeugdhuis> jeugdhuizen = jeugdhuisService.findaAll();
		return new ModelAndView(VIEW).addObject("jeugdhuizen", jeugdhuizen);
	}
}