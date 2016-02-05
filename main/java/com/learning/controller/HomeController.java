/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learining.data.EditProfileData;
import com.learining.data.LoginData;
import com.learining.data.RegisterFormData;
import com.learning.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/** The login service. */
	@Autowired
	private LoginService loginService;

	/**
	 * Check email.
	 *
	 * @param email
	 *            the email
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(
			value = "/checkemail", method = RequestMethod.GET)
	public @ResponseBody String checkEmail(@RequestParam(
			value = "email") String email, Model model)
	{
		final boolean regFlag = loginService.checkEmail(email);
		if (regFlag)
		{
			logger.info("email exists");
			return "true";
		}
		else
		{
			logger.info("email does not exists");
			return "false";
		}
	}

	/**
	 * Do login.
	 *
	 * @param userName
	 *            the user name
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@RequestMapping(
			value = "/login", method = RequestMethod.GET)
	public String doLogin(@RequestParam(
			value = "userName") String userName, Model model,
			HttpSession session)
	{
		if (null != session.getAttribute("loggedin")
				&& (Boolean) session.getAttribute("loggedin"))
		{
			final RegisterFormData currentUser = loginService
					.getUserData(userName);
			session.setAttribute("currentUser", currentUser);
		}
		logger.info("user has been logged in");
		return "homepage";
	}

	/**
	 * Do register.
	 *
	 * @param registerFormData
	 *            the register form data
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@RequestMapping(
			value = "/register", method = RequestMethod.POST)
	public String doRegister(RegisterFormData registerFormData, Model model,
			HttpSession session)
	{
		final boolean regFlag = loginService.register(registerFormData);
		if (regFlag)
		{
			logger.info("user has been registered");
			session.setAttribute("currentUser", registerFormData);
			return "redirect:/login?userName=" + registerFormData.getEmail();
		}
		else
		{
			return "homepage";
		}
	}

	/**
	 * Edits the profile.
	 *
	 * @param image
	 *            the image
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(
			value = "/editprofileimagevalidation", method = RequestMethod.POST)
	public String editProfile(EditProfileData image, Model model,
			HttpSession session, HttpServletRequest request)
	{
		logger.info("editing user profile");
		boolean updateFlag = false;
		RegisterFormData currentUser = (RegisterFormData) session
				.getAttribute("currentUser");
		updateFlag = loginService.updateProfile(image, currentUser.getEmail());
		currentUser = loginService.getUserData(image.getEmail());
		session.setAttribute("currentUser", currentUser);

		if (!updateFlag)
		{
			model.addAttribute("updateError", true);
		}

		return "redirect:/";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@RequestMapping(
			value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session)
	{
		logger.info("in home page");
		return "homepage";
	}

	/**
	 * Logout.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@RequestMapping(
			value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session)
	{
		logger.info("invalidating session and logging out the user");
		session.invalidate();
		return "homepage";
	}

	/**
	 * User login.
	 *
	 * @param loginData
	 *            the login data
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@RequestMapping(
			value = "/userLogin", method = RequestMethod.POST)
	public String userLogin(LoginData loginData, Model model,
			HttpSession session)
	{
		final boolean flag = loginService.verifyUser(loginData);
		if (!flag)
		{
			logger.info("user not verified");
			return "homepage";
		}
		else
		{
			logger.info("user redirecting to login");
			session.setAttribute("loggedin", true);
			return "redirect:/login?userName=" + loginData.getUserName();
		}
	}

	/**
	 * Verify user.
	 *
	 * @param loginData
	 *            the login data
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@RequestMapping(
			value = "/verifyuser", method = RequestMethod.POST)
	public @ResponseBody String verifyUser(LoginData loginData, Model model,
			HttpSession session)
	{
		final boolean flag = loginService.verifyUser(loginData);
		if (!flag)
		{
			logger.info("user not verified");
			return "true";
		}
		else
		{
			logger.info("user verified");
			return "false";
		}
	}
}
