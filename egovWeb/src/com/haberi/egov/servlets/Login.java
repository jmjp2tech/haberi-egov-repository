package com.haberi.egov.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.weld.context.ejb.Ejb;

import com.google.gson.JsonObject;
import com.haberi.egov.ejb.entities.dto.UserDTO;
import com.haberi.egov.ejb.enums.UserStatusEnum;
import com.haberi.egov.ejb.session.AuthenticationSessionLocal;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private AuthenticationSessionLocal authenticationSessionLocal;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		final String userName = request.getParameter("username");
		final String password = request.getParameter("password");
		System.out.println(userName + " **** " + password);

		if (userName != null && password != null) {
			response.setContentType("application/json");

			final JsonObject jsonResponse = new JsonObject();
			
			try {
				if (authenticationSessionLocal.login(userName, password)) {
					jsonResponse.addProperty("status", "Success");
				} else {
					jsonResponse.addProperty("status", "Failure");
				}
			} catch (Exception e) {
			}finally{
				PrintWriter out = response.getWriter();
				out.print(jsonResponse);
				out.flush();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
