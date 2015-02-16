package com.nitesh.servconttroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Servlet implementation class LoginServlet
 */
@Controller
public class LoginController {
	private static final long serialVersionUID = 1L;
       
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String login() {
		return "redirect:/loginc";
	}
}
