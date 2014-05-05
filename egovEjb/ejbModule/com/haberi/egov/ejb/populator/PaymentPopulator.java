package com.haberi.egov.ejb.populator;

import com.haberi.egov.ejb.entities.PaymentEntity;
import com.haberi.egov.ejb.entities.dto.PaymentDTO;


public class PaymentPopulator {

	private static PaymentPopulator instance ; 
	
	private PaymentPopulator() {
		
	}
	
	public static PaymentPopulator getInstance(){
		if(instance == null){
			instance = new PaymentPopulator();
		}
		return instance ; 
	}
	
	public PaymentEntity toEntity(PaymentDTO paymentDTO){
		PaymentEntity paymentEntity = null ; 
		if(paymentDTO != null){
			paymentEntity = new PaymentEntity(); 
			paymentEntity.setPaymentType(paymentDTO.getPaymentType());
			paymentEntity.setPaymentDate(paymentDTO.getPaymentDate());
			paymentEntity.setCreditCardHolderName(paymentDTO.getCreditCardHolderName());
			paymentEntity.setCreditCardNumber(paymentDTO.getCreditCardNumber());
			paymentEntity.setCreditCardPassword(paymentDTO.getCreditCardPassword());
			paymentEntity.setCreditCardType(paymentDTO.getCreditCardType());
			paymentEntity.setExpiryDate(paymentDTO.getExpiryDate());
			
			paymentEntity.setBankAccountHolderName(paymentDTO.getBankAccountHolderName());
			paymentEntity.setBankAccountNumber(paymentDTO.getBankAccountNumber());
			paymentEntity.setBankAccountPassword(paymentDTO.getBankAccountPassword());
			paymentEntity.setBankName(paymentDTO.getBankName());
			paymentEntity.setBranchName(paymentDTO.getBranchName());
			
			paymentEntity.setMobileAccountHolderName(paymentDTO.getMobileAccountHolderName());
			paymentEntity.setMobileNumber(paymentDTO.getMobileNumber());
			paymentEntity.setMobileAccountPassword(paymentDTO.getMobileAccountPassword());
			paymentEntity.setMobileProvider(paymentDTO.getMobileProvider());
			
			paymentEntity.setTransactionId(paymentDTO.getTransactionId());
			
		}
		
		return paymentEntity;
	}
	
	
	
	
}
