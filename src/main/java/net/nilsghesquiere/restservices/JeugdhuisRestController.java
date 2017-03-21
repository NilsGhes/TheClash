package net.nilsghesquiere.restservices;

import java.util.logging.Logger;

import net.nilsghesquiere.entities.Jeugdhuis;
import net.nilsghesquiere.services.JeugdhuisService;
import net.nilsghesquiere.web.IndexController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jh")
public class JeugdhuisRestController {
	private final JeugdhuisService jeugdhuisService;
	private static final Logger logger = Logger.getLogger(JeugdhuisRestController.class.getSimpleName());

	
	@Autowired
	JeugdhuisRestController(JeugdhuisService jeugdhuisService){
		this.jeugdhuisService = jeugdhuisService;
	}
	
	@RequestMapping(path = "{jeugdhuis}", method = RequestMethod.GET)
	Jeugdhuis read(@PathVariable Jeugdhuis jeugdhuis) { 
		logger.info("REST get request voor jh" + jeugdhuis.getName());
		return jeugdhuis;
	}
}
