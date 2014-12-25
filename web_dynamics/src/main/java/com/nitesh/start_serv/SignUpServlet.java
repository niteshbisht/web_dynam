package com.nitesh.start_serv;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.authenticate_user.ElastDbUserSignStore;
import com.web.authenticate_user.SignUpAuthenticationService;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Enumeration<String> attrib = request.getParameterNames();
		System.out.println(attrib);
		String userid = (String) request.getParameter("userName");
		String userPass = (String) request.getParameter("passWord");
		System.out.println("Got user Params");
		SignUpAuthenticationService signup = SignUpAuthenticationService.getAuthenticated(userid, userPass);
		
		boolean var=ElastDbUserSignStore.getUserid(userid, userPass);
		System.out.println(var);
	}

}
