package com.haberi.egov.ejb.session.cases;

import javax.ejb.Local;

import com.haberi.egov.ejb.entities.dto.CaseDTO;

@Local
public interface CaseSessionLocal {

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
