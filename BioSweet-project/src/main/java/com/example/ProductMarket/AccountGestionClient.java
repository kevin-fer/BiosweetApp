package com.example.ProductMarket;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class AccountGestionClient {
	
	private static final Logger log = LoggerFactory.getLogger(AccountGestionClient.class);

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<Account> request;
		request = new HttpEntity<>(new Account("luca@biosweet.com", "Emilia2565", "565654"));
		//request = new HttpEntity<>(new Account("luca@biosweet.com", "Emilia2565"));
		restTemplate.postForObject("http://localhost:8080/comptes", request, Account.class);
		
        List comptes = restTemplate.getForObject("http://localhost:8080/comptes", List.class);
        log.info(comptes.toString());

        
	}

}