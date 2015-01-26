package com.nitesh.start_serv;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Front Controller implementation class instead of FrontServlet
 */
@Controller
public class FrontController {
	private static final long serialVersionUID = 1L;

	@RequestMapping("/front")
	public @ResponseBody String front() {
		return "redirect:index";
	}
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/*
	 * public FrontController() {
	 * 
	 * super(); System.out.println("I am inside"); // TODO Auto-generated
	 * constructor stub }
	 * 
	 * 
	 * private String dbName=""; private String dbPassword="";
	 * 
	 * public void init(ServletConfig config) throws ServletException {
	 * super.init(config); ServletContext context = getServletContext(); dbName
	 * = context.getInitParameter("name"); dbPassword =
	 * context.getInitParameter("password"); }
	 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * System.out.println("sending to home page");
	 * response.sendRedirect("./resources/jsp/index.jsp"); }
	 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * }
	 */

}
