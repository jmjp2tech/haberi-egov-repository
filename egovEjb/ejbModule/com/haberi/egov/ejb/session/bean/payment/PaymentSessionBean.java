package com.haberi.egov.ejb.session.bean.payment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.haberi.egov.ejb.entities.PaymentEntity;
import com.haberi.egov.ejb.entities.dto.PaymentDTO;
import com.haberi.egov.ejb.entities.dto.payment.PaymentResultDTO;
import com.haberi.egov.ejb.enums.ResultTypeEnum;
import com.haberi.egov.ejb.populator.PaymentPopulator;
import com.haberi.egov.ejb.session.payment.PaymentSessionLocal;

@Stateless(name="PaymentSession")
public class PaymentSessionBean implements PaymentSessionLocal {

	@PersistenceContext(unitName="EgovPersistenceUnit")
	EntityManager em ; 
	
	@Override
	public PaymentResultDTO makePayment(PaymentDTO paymentDTO) {
		PaymentEntity paymentEntity = PaymentPopulator.getInstance().toEntity(paymentDTO);
		PaymentResultDTO paymentResultDTO = new PaymentResultDTO();
		
		try{
			PaymentEntity resultEntity = em.merge(paymentEntity);
			paymentResultDTO.setResultTypeEnum(ResultTypeEnum.SUCCESS);
			paymentResultDTO.getErrors().clear();
			paymentDTO.setTransactionId(resultEntity.getTransactionId());
			paymentResultDTO.setPaymentDTO(paymentDTO);
		}catch(Exception exception){
			paymentResultDTO.setResultTypeEnum(ResultTypeEnum.FAILURE);
			paymentResultDTO.getErrors().add("An error occured in the process of persisting the payment information to database");
			paymentDTO.setTransactionId(null);
			paymentResultDTO.setPaymentDTO(paymentDTO);
		}
		
		return paymentResultDTO;
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
