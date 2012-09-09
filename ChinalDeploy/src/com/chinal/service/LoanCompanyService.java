package com.chinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinal.dao.LoanCompanyDao;
import com.chinal.domain.City;
import com.chinal.domain.LoanCompany;
import com.chinal.service.base.PageSplitService;
import com.chinal.util.param.Parameters;
import com.chinal.vo.LoanCompanyVO;

@Service
public class LoanCompanyService implements PageSplitService<LoanCompanyVO> {

	@Autowired
	private LoanCompanyDao loanCompanyDao;

	@Override
	public LoanCompanyVO getByID(long id) {
		return convertToLoanCompanyVO(loanCompanyDao.getByID(id));
	}

	@Override
	public void deleteByID(long id) {
		loanCompanyDao.delete(new LoanCompany(id));
	}

	@Override
	public long getTotalCount() {
		return loanCompanyDao.getCount(new Parameters());
	}

	@Override
	public void add(LoanCompanyVO loanCompanyVO) {
		loanCompanyDao.save(convertToLoanCompany(loanCompanyVO));
	}

	@Override
	public void update(LoanCompanyVO valueObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<LoanCompanyVO> getByPageSplit(int curPage, int pageSize) {
		List<LoanCompany> loanCompanyList = loanCompanyDao.find(
				new Parameters(), curPage, pageSize);
		List<LoanCompanyVO> loanCompanyVOList = new ArrayList<LoanCompanyVO>();
		for (LoanCompany company : loanCompanyList) {
			loanCompanyVOList.add(convertToLoanCompanyVO(company));
		}
		return loanCompanyVOList;
	}

	private LoanCompanyVO convertToLoanCompanyVO(LoanCompany loanCompany) {
		LoanCompanyVO loanCompanyVO = new LoanCompanyVO();
		loanCompanyVO.setId(loanCompany.getId());
		loanCompanyVO.setName(loanCompany.getName());
		loanCompanyVO.setDescription(loanCompany.getDescription());
		loanCompanyVO.setCityId(loanCompany.getCity().getId());
		loanCompanyVO.setCityName(loanCompany.getCity().getName());
		return loanCompanyVO;
	}
	
	private LoanCompany convertToLoanCompany(LoanCompanyVO loanCompanyVO){
		LoanCompany loanCompany = new LoanCompany();
		loanCompany.setId(loanCompanyVO.getId());
		loanCompany.setName(loanCompanyVO.getName());
		loanCompany.setDescription(loanCompanyVO.getDescription());
		City city = new City(loanCompanyVO.getCityId());
		city.setName(loanCompanyVO.getCityName());
		loanCompany.setCity(city);
		return loanCompany;
	}
}
