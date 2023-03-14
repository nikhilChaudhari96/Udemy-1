package com.example.demo.model;




public class Account {
private String message;
public Account(String message) {
	this.message=message;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@Override
public String toString() {
	return "Account [message=" + message + "]";
}
}
