package com.haberi.egov.ejb.session.cases;

import javax.ejb.Remote;

import com.haberi.egov.ejb.entities.dto.CaseDTO;

@Remote
public interface CaseSessionRemote {
	
	public String createCase(CaseDTO caseDTO);
	
	//returns the last version whose caseId is input. 
	public CaseDTO findCase(String caseId);
	//returns the specific version of the speficied caseIds
	public CaseDTO findCase(String caseId , int version);
	
	//deletes the last version whose caseId is input.
	public boolean deleteCase(String caseId);
	//deletes the specific version of the speficied caseIds
	public boolean deleteCase(String caseId , int version);
}
