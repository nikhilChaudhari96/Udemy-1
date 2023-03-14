package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController

public class UserController {
@Autowired
private UserService userService;
@GetMapping("/users")
public List<User>retrieveAll(){
	return userService.findAll();
}
@GetMapping("/user/{id}")
public User retrieveById(@PathVariable int id) {
	User user=userService.findById(id);
	if(user==null) 
		throw new UserNotFoundException("id not present"+id);
	
	return user;
}
@DeleteMapping("/user/{id}")
public ResponseEntity<User> deleteById(@PathVariable int id) {
	userService.deleteById(id);
	return ResponseEntity.ok().body(null);
}
@PostMapping("/save")
public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
	userService.save(user);
	URI locator=ServletUriComponentsBuilder.fromCurrentRequestUri()
			.path("{id}").buildAndExpand(user.getId()).toUri();
	return ResponseEntity.created(locator).build();
}
}
