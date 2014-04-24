package com.haberi.egov.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.haberi.egov.ejb.entities.dto.AccountDTO;
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
	private AuthenticationSessionLocal authenticationSession;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		final String userName = request.getParameter("username");
		final String password = request.getParameter("password");
		final String accountData = request.getParameter("accountData"); 
		System.out.println(userName + " **** " + password);
		System.out.println("Account Data: "+ request.getParameter("accountData"));

		if (userName != null && password != null) {

			JsonObject accountInfo = JsonHelper.getInstance().toJsonObject(accountData);
			if(accountInfo != null){
				AccountDTO accountDTO = JsonHelper.getInstance().toAccountDTO(accountInfo); 
			}
			
			UserDTO user = new UserDTO();
			user.setPassword(password);
			user.setUserName(userName);
			user.setStatus(UserStatusEnum.OFFLINE);

			response.setContentType("application/json");
			JsonObject jsonResponse = new JsonObject();
			try {
				boolean userCreated = authenticationSession.createUser(user);
				if (userCreated) {
					jsonResponse.addProperty("status", "Success");
				} else {
					jsonResponse.addProperty("status", "Failure");
				}
			} catch (Exception e) {
				System.out.println("An error has occured");
				jsonResponse.addProperty("status", "Exception");				
				e.printStackTrace();
			} finally {
				PrintWriter out = response.getWriter();
				out.print(jsonResponse);
				out.flush();
			}
		}
	}
}
