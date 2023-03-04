package com.amazin.nayra.service;

import javax.servlet.http.HttpServletRequest;

import com.amazin.nayra.common.DataContainer;

public interface LoginService {

	DataContainer LoginbyUserName(String username, String password, HttpServletRequest httpServletRequest);

	DataContainer LoginByEmail(String email, String password, HttpServletRequest httpServletRequest);

	DataContainer LoginbyContactNumber(String contact, String password, HttpServletRequest httpServletRequest);

}
