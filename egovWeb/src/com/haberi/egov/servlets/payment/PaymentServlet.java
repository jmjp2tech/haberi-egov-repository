package com.haberi.egov.servlets.payment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.haberi.egov.ejb.entities.dto.PaymentDTO;
import com.haberi.egov.ejb.entities.dto.payment.PaymentResultDTO;
import com.haberi.egov.ejb.session.payment.PaymentSessionLocal;
import com.haberi.egov.servlets.JsonHelper;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	PaymentSessionLocal paymentSessionLocal ; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		final String paymentType = request.getParameter("paymentType");
//		final String paymentAmount = request.getParameter("paymentAmount");
		
		final String paymentInfoStr = request.getParameter("paymentInfo");
		System.out.println(request.getParameter("paymentInfo"));
		
		if(StringUtils.isNotBlank(paymentInfoStr)){
			JsonObject paymentInfo =  JsonHelper.getInstance().toJsonObject(paymentInfoStr);
			PaymentDTO paymentDTO = JsonHelper.getInstance().toPaymentDTO(paymentInfo);
			PaymentResultDTO paymentResultDTO = paymentSessionLocal.makePayment(paymentDTO); 
			
		}
		
		JsonObject jsonResponse = new JsonObject();
		jsonResponse.addProperty("status", "success");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter(); 
		out.print(jsonResponse);
		out.flush();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
