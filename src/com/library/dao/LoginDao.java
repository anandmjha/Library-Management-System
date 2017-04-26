package com.library.dao;

import com.library.model.LoginBean;

public interface LoginDao {
	boolean isValid(LoginBean loginBean);
}
