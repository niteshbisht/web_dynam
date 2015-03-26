package com.nitesh.servconttroller;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Controller
class LoginController {
	// private static final long serialVersionUID = 1L;
	Logger lgr = Logger.getLogger("com.nitesh.servconttroller.LoginController");
	//private AccountService accountService;
	private String ACCOUNT_ATTRIBUTE = "userAcnt";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		lgr.info("Inside Login Controller");
		return "/loginc";
	}

	/*@RequestMapping(value = "/processlogin", method = RequestMethod.POST)
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
	}*/
}
