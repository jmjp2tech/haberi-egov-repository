package com.haberi.egov.ejb.session.bean.payment;

import javax.ejb.Stateless;

import com.haberi.egov.ejb.entities.dto.PaymentDTO;
import com.haberi.egov.ejb.entities.dto.payment.PaymentResultDTO;
import com.haberi.egov.ejb.session.payment.PaymentSessionLocal;

@Stateless(name="PaymentSession")
public class PaymentSessionBean implements PaymentSessionLocal {

	@Override
	public PaymentResultDTO makePayment(PaymentDTO paymentInfo) {
		//create the mock .
		// do the payment
		
		return null;
	}

	@Override
	public PaymentResultDTO reversePayment(PaymentDTO paymentInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentResultDTO checkPayment(PaymentDTO paymentInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
