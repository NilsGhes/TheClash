package net.nilsghesquiere.controllers;

import net.nilsghesquiere.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = Logger.getLogger(AdminController.class.getSimpleName());
	private static final String VIEW = "admin";
	
	@Autowired
	AdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	String Admin() {
		adminService.ensureAdmin();
		logger.info("Loading admin page.");
		return VIEW;
	}
}