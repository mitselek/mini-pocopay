package com.mkyong.helloworld.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.helloworld.service.HelloWorldService;
import com.mkyong.helloworld.service.AccountService;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	private final HelloWorldService helloWorldService;

	@Autowired
	public WelcomeController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", "Hello World");
		model.put("msg", "Choose an account or create a new one");

		return "index";
	}


	@RequestMapping(value = "/newaccount", method = RequestMethod.GET)
	public ModelAndView newaccount() {

		logger.debug("newaccount() is executed!");

		String uuid = AccountService.newUUID();
		logger.debug("new account is created - {}!", uuid);
		ModelAndView model = new ModelAndView();
		model.setViewName("index");

		model.addObject("title", helloWorldService.getTitle());
		model.addObject("uuid", uuid);
		// model.addObject("msg", "");

		return model;

	}

	@RequestMapping(value = "/hello/{uuid:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("uuid") String uuid) {

		logger.debug("hello() is executed - $uuid: {}", uuid);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");

		model.addObject("uuid", uuid);
		model.addObject("msg", "Make a transaction");

		return model;

	}

}
