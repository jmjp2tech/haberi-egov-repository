package com.haberi.egov.ejb.entities.dto.payment;

import java.io.Serializable;
import java.util.List;

import com.haberi.egov.ejb.entities.dto.PaymentDTO;
import com.haberi.egov.ejb.enums.ResultTypeEnum;

public class PaymentResultDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8770219348456340645L;
	private PaymentDTO paymentDTO  ; 
	private ResultTypeEnum ResultTypeEnum; 
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
	 * @return the resultTypeEnum
	 */
	public ResultTypeEnum getResultTypeEnum() {
		return ResultTypeEnum;
	}
	/**
	 * @param resultTypeEnum the resultTypeEnum to set
	 */
	public void setResultTypeEnum(ResultTypeEnum resultTypeEnum) {
		ResultTypeEnum = resultTypeEnum;
	}
	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}
	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
