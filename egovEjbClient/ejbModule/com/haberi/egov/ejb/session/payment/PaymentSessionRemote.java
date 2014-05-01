package com.haberi.egov.ejb.session.payment;

import javax.ejb.Remote;

import com.haberi.egov.ejb.entities.dto.PaymentDTO;
import com.haberi.egov.ejb.entities.dto.payment.PaymentResultDTO;

@Remote
public interface PaymentSessionRemote {
	
	public PaymentResultDTO makePayment(PaymentDTO paymentInfo);
	public PaymentResultDTO reversePayment(PaymentDTO paymentInfo);
	public PaymentResultDTO checkPayment(PaymentDTO paymentInfo);

}
