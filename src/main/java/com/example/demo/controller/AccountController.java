package com.example.demo.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;

@RestController

public class AccountController {
@GetMapping("/hello")
public String helloWorld(){
	return "hello world";
}

@GetMapping("/w")
public Account getMessage() {
	return new Account("welcome to hinganghat");
}
@GetMapping("/w/{name}")
public Account getMessage(@PathVariable String name) {
	return new Account("welcome to hinganghat "+name);
}
}
