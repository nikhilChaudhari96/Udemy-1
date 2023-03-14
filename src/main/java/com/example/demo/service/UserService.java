package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
@Service

public class UserService {

private static List<User>users=new ArrayList<>();
 static int a=0;
static {
	users.add(new User(a++,"nikhil", LocalDate.now().minusYears(28)));
	users.add(new User(a++,"aaditya", LocalDate.now().minusYears(4)));
	users.add(new User(a++,"shree", LocalDate.now().minusYears(2)));
}
public List<User> findAll() {
	return users;
}
public User findById(int id) {
	
	Predicate<? super User> predicate=user->user.getId().equals(id);
	return users.stream().filter(predicate).findFirst().orElse(null);
	
}
public void save(User user) {
	user.setId(a++);
	users.add(user);
}
public void deleteById(int id) {
	Predicate<?super User>predicate=user->user.getId().equals(id);
	users.removeIf(predicate);
	
}
}
