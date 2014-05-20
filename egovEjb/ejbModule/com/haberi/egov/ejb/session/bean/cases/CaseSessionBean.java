package com.haberi.egov.ejb.session.bean.cases;

import com.haberi.egov.ejb.entities.dto.CaseDTO;
import com.haberi.egov.ejb.session.cases.CaseSessionLocal;
import com.haberi.egov.ejb.session.cases.CaseSessionRemote;

public class CaseSessionBean implements CaseSessionLocal, CaseSessionRemote{

	@Override
	public String createCase(CaseDTO caseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CaseDTO findCase(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CaseDTO findCase(String caseId, int version) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCase(String caseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCase(String caseId, int version) {
		// TODO Auto-generated method stub
		return false;
	}

}
