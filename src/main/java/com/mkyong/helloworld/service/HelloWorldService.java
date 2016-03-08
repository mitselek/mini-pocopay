package com.mkyong.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloWorldService {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

	public String getDesc() {
		logger.debug("getDesc() should ont get executed!");
		return "foo!";
	}

	public String getTitle() {
		logger.debug("getTitle() should ont get executed!");
		return "foo!";
	}

}
