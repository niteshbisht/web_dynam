package com.nitesh.servconttroller;

import java.util.logging.Logger;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nitesh.account.service.Account;
import com.nitesh.account.service.AccountService;

/**
 * Servlet implementation class LoginServlet
 */
@Component
@Controller
class LoginController {
	// private static final long serialVersionUID = 1L;
	Logger lgr = Logger.getLogger("com.nitesh.servconttroller.LoginController");
	private AccountService accountService;
	private String ACCOUNT_ATTRIBUTE = "userAcnt";

	@RequestMapping("/login")
	public String login() {
		lgr.info("Inside Login Controller");
		return "tologin";
	}

	@RequestMapping(value = "/processlogin", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String username,
			@RequestParam String password, HttpServletRequest request,
			HttpSession session) throws AuthenticationException {
		Account account = this.accountService.login(username, password);
		if (account != null) {
			session.setAttribute(ACCOUNT_ATTRIBUTE, account);
		} else {
			return "/login";
		}
		return "/home";
	}
}
