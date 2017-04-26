package com.library.model;

import java.io.Serializable;

import com.library.dao.LoginDao;
import com.library.dao.LoginDaoImpl;

public class LoginBean   implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String memberId;
private String password;
private String type;

private LoginDao ld=new LoginDaoImpl();
public LoginBean() {
System.out.println("Login Bean created..");
}


public String getPassword() {
	System.out.println("In getPassword :"+password);
	return password;
}

public void setPassword(String password) {
	this.password = password;
	System.out.println("In setPassword  :"+password);
}

public String getMemberId() {
	return memberId;
}

public void setMemberId(String memberId) {
	this.memberId = memberId;
	System.out.println("In SetMemeberId  : "+memberId);
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
	System.out.println("In SetType  : "+type);
}


//business method
public boolean isValid(){
	
	return  ld.isValid(this);
}
}
