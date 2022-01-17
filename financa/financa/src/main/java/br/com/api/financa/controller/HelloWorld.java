package br.com.api.financa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
	
	@RequestMapping("/")
	@ResponseBody
	public String Hello() {
		return "Hello, World!";
	}
}
