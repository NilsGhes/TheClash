package net.nilsghesquiere.web;

import java.util.logging.Logger;

import javax.validation.Valid;

import net.nilsghesquiere.entities.Account;
import net.nilsghesquiere.entities.Jeugdhuis;
import net.nilsghesquiere.services.AccountService;
import net.nilsghesquiere.services.JeugdhuisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = Logger.getLogger(AdminController.class.getSimpleName());
	private static final String VIEW = "admin/panel";
	private static final String JEUGDHUIS_ADMIN_VIEW = "admin/jeugdhuizen";
	private static final String ACCOUNT_ADMIN_VIEW = "admin/accounts";
	private static final String REDIRECT_NA_TOEVOEGEN = "redirect:/";
	
	private final JeugdhuisService jeugdhuisService ;
	private final AccountService accountService ;

	@Autowired
	public AdminController(JeugdhuisService jeugdhuisService, AccountService accountService) {
		this.jeugdhuisService = jeugdhuisService;
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.GET)
	String Admin() {
		logger.info("Loading admin page.");
		return VIEW;
	}
	
	@RequestMapping(path="test", method = RequestMethod.GET)
	String AdminTest() {
    	Account acc1 = new Account("Nils");
    	Account acc2 = new Account("Lukas");
    	Jeugdhuis jgh1 = new Jeugdhuis("Traveir",313,acc1);
    	Jeugdhuis jgh2 = new Jeugdhuis("Traveir",17,acc2);
    	accountService.create(acc1);
    	accountService.create(acc2);
    	jeugdhuisService.create(jgh1);
    	jeugdhuisService.create(jgh2);
		logger.info("filled database with test.");
		return VIEW;
	}
	
	@RequestMapping(path="jeugdhuizen", method = RequestMethod.GET)
	ModelAndView JeugdhuizenAdmin() {
		logger.info("Loading jeugdhuis admin page.");
		return new ModelAndView(JEUGDHUIS_ADMIN_VIEW).addObject(new Jeugdhuis()).addObject("accounts",accountService.findAll());
	}
	
	@RequestMapping(path="jeugdhuizen", method = RequestMethod.POST)
	ModelAndView CreateJeugdhuis(@Valid Jeugdhuis jeugdhuis, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(JEUGDHUIS_ADMIN_VIEW).addObject(new Jeugdhuis()).addObject("accounts",accountService.findAll()).addObject("errors",bindingResult.getAllErrors());
		}
		logger.info("Creating new jeugdhuis.");
		jeugdhuisService.create(jeugdhuis);
		return new ModelAndView(REDIRECT_NA_TOEVOEGEN);
	}
	
	@RequestMapping(path="accounts", method = RequestMethod.GET)
	ModelAndView AccountsAdmin() {
		logger.info("Loading accounts admin page.");
		return new ModelAndView(ACCOUNT_ADMIN_VIEW).addObject(new Account());
	}
	
	@RequestMapping(path="accounts", method = RequestMethod.POST)
	ModelAndView CreateAccount(@Valid Account account, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(ACCOUNT_ADMIN_VIEW).addObject(new Account()).addObject("errors",bindingResult.getAllErrors());
		}
		logger.info("Creating new jeugdhuis.");
		accountService.create(account);
		return new ModelAndView(REDIRECT_NA_TOEVOEGEN);
	}
}