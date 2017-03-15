package net.nilsghesquiere.web;

import java.util.logging.Logger;

import net.nilsghesquiere.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = Logger.getLogger(AccountController.class.getSimpleName());
	private static final String VIEW = "account";

	private final AccountService accountService ;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView Account() {
		logger.info("Loading account page.");
		return new ModelAndView(VIEW).addObject("accounts", accountService.findAll());
	}
}