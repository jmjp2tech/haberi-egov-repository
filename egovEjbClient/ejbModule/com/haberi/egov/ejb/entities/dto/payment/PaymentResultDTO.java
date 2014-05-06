package com.haberi.egov.ejb.entities.dto.payment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.haberi.egov.ejb.entities.dto.PaymentDTO;
import com.haberi.egov.ejb.enums.ResultTypeEnum;

public class PaymentResultDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8770219348456340645L;
	private PaymentDTO paymentDTO  ; 
	private ResultTypeEnum resultType; 
	private List<String> errors;
	/**
	 * @return the paymentDTO
	 */
	public PaymentDTO getPaymentDTO() {
		return paymentDTO;
	}
	/**
	 * @param paymentDTO the paymentDTO to set
	 */
	public void setPaymentDTO(PaymentDTO paymentDTO) {
		this.paymentDTO = paymentDTO;
	}
	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		if(errors== null){
			errors= new ArrayList<String>();
		}
		return errors;
	}
	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	/**
	 * @return the resultType
	 */
	public ResultTypeEnum getResultType() {
		return resultType;
	}
	/**
	 * @param resultType the resultType to set
	 */
	public void setResultType(ResultTypeEnum resultType) {
		this.resultType = resultType;
	}
}
