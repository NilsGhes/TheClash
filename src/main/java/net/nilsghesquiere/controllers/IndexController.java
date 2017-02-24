package net.nilsghesquiere.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class IndexController {
	private static final Logger logger = Logger.getLogger(IndexController.class.getSimpleName());
	private static final String VIEW = "index";

	@RequestMapping(method = RequestMethod.GET)
	String index() {
		logger.info("Loading index.");
		return VIEW;
	}
}