package com.haberi.egov.ejb.entities;

import org.apache.commons.lang3.StringUtils;

public enum CaseStatusEnum {

	//case created but not paid, while payment is required
	NOT_PAID ,
	// case opened and assigned to an available agent.
	OPEN , 
	//agent has started processing the case
	IN_PROGRESS,
	//case transfered from other department. From here, the status changed for "IN_PROGRESS"
	TRANSFERED,
	//processing stopped while waiting  for supporting document , or deeper investigations, fraud suspicions.. 
	BLOCKED,
	//case cancelled or dismissed on request of a user (client or case agent). In this case the agent can close it
	CANCELLED , 
	//case closed on request of agent(because he/she considers it resolved)
	CLOSED, 
	//case reopened at the request of user (client or case agent). Status changed from CLOSED to REOPEN. No payment required
	REOPEN;
	
	public static CaseStatusEnum getEnum(String caseStatusEnumStr){
		
		CaseStatusEnum enumValue = null ; 
		for(CaseStatusEnum currentValue : CaseStatusEnum.values()){
			if(StringUtils.equalsIgnoreCase(currentValue.name(), caseStatusEnumStr)){
				enumValue = currentValue ; 
				break ; 
			}
		}
		return enumValue; 
	}
	
}
