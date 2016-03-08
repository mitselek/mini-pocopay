package com.mkyong.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.UUID;

@Service
public class AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	public static String newUUID() {

		UUID uuid = UUID.randomUUID();
		logger.debug("newUUID() generated - {}!", uuid);

		return uuid.toString();
	}

}
