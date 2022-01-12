package com.test.springboottest.springrestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping(path = "/hello")
	public String helloWorld() {
		System.out.println("---Hellloooo----");
		
		return "HelloWorld SpringRestful Webservices";
	}
	
	@GetMapping(path = "/hello/{name}")
	public String helloWorldPath(@PathVariable String name) {
		System.out.println("---Hellloooo----");
		
		return "HelloWorld -----"+ name;
	}
	
	@GetMapping(path = "/helloIntern")
	public String helloWorldInter(/* @RequestHeader(name = "Accept-Language",required = false) Locale locale */ ) {
		
		
		return messageSource.getMessage("good.morning.message", null, /*locale*/ LocaleContextHolder.getLocale() );
	}

}
