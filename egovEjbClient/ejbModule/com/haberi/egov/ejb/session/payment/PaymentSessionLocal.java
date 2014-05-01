package com.haberi.egov.ejb.session.payment;

import javax.ejb.Local;

import com.haberi.egov.ejb.entities.dto.PaymentDTO;
import com.haberi.egov.ejb.entities.dto.payment.PaymentResultDTO;

@Local
public interface PaymentSessionLocal {
	
	public PaymentResultDTO makePayment(PaymentDTO paymentInfo);
	public PaymentResultDTO reversePayment(PaymentDTO paymentInfo);
	public PaymentResultDTO checkPayment(PaymentDTO paymentInfo);

}
