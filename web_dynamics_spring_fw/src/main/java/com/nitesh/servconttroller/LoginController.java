package com.nitesh.servconttroller;

import java.util.logging.Logger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Servlet implementation class LoginServlet
 */
@Component
@Controller
class LoginController {
	//private static final long serialVersionUID = 1L;
    Logger lgr = Logger.getLogger("com.nitesh.servconttroller.LoginController");   
    @RequestMapping("/login")
	public String login() {
		lgr.info("Inside Login Controller");
		return "tologin";
	}
	
	@RequestMapping(value="/processlogin", method=RequestMethod.POST)
	public String redirectToLogin(){
		lgr.info("Inside Login Controller");
		return "/finalpage";
	}
}



