package net.nilsghesquiere.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.logging.Logger;

@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = Logger.getLogger(AccountController.class.getSimpleName());
	private static final String VIEW = "account";

	@RequestMapping(method = RequestMethod.GET)
	String Account() {
		logger.info("Loading account page.");
		return VIEW;
	}
}