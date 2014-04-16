package com.haberi.egov.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haberi.egov.ejb.entities.dto.UserDTO;
import com.haberi.egov.ejb.enums.UserStatusEnum;
import com.haberi.egov.ejb.session.AuthenticationSessionLocal;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private AuthenticationSessionLocal authenticationSession ;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO user = new UserDTO(); 
		user.setPassword("abcdefg");
		user.setUserName("user@gmail.com");
		user.setStatus(UserStatusEnum.OFFLINE);
		
		boolean userCreated = authenticationSession.createUser(user);
		
		System.out.println("User created ????? " + userCreated);
	}

}
