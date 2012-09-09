package com.chinal.controller.management;

import static com.chinal.util.session.SessionUtil.getPageSplitFromSession;
import static com.chinal.util.session.SessionUtil.updatePageSplitInSession;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinal.service.LoanCompanyService;
import com.chinal.service.ProvinceService;
import com.chinal.util.page.PageRedirectUtil;
import com.chinal.util.page.PageSplit;
import com.chinal.vo.LoanCompanyVO;
import com.chinal.vo.ProvinceVO;

@Controller
@RequestMapping("/management/loanCompany/*")
public class LoanCompanyController {

	private static final String SHOW_MANAGE_LOANCOMPANY = "management/loanCompany/manageLoanCompany";
	private static final String ADD_LOANCOMPANY = "management/loanCompany/addLoanCompany";

	@Autowired
	private LoanCompanyService loanCompanyService;
	
	@Autowired
	private ProvinceService provinceService;

	@RequestMapping(value = "/manageLoanCompany")
	public String showManageLoanCompanyPage(HttpServletRequest request,
			Map<String, Object> model) {
		initShowUserPageWithParamaters(request, model);
		return SHOW_MANAGE_LOANCOMPANY;
	}
	
	@RequestMapping(value = "/addLoanCompany", method = RequestMethod.GET)
	public String showAddLoanCompanyPage(Map<String, Object> model){
		LoanCompanyVO loanCompanyVO = new LoanCompanyVO();
		List<ProvinceVO> allProvince = provinceService.getAllProvince();
		model.put("loanCompanyVO", loanCompanyVO);
		model.put("allProvince", allProvince);
		return ADD_LOANCOMPANY;
	}
	
	@RequestMapping(value = "/addLoanCompany", method = RequestMethod.POST)
	public String addLoanCompany(@Valid LoanCompanyVO loanCompany, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return ADD_LOANCOMPANY;
		}
		
		loanCompanyService.add(loanCompany);
		
		return PageRedirectUtil.buildSuccessPage("/management/loanCompany/manageLoanCompany", model);
	}

	private void initShowUserPageWithParamaters(HttpServletRequest request,
			Map<String, Object> model) {
		PageSplit pageSplitFromSession = getPageSplitFromSession(request);

		long count = loanCompanyService.getTotalCount();
		List<LoanCompanyVO> loanCompanyList = loanCompanyService.getByPageSplit(
				pageSplitFromSession.getCurPage(),
				pageSplitFromSession.getPageSize());

		model.put("loanCompanyList", loanCompanyList);
		model.put("count", count);

		pageSplitFromSession.splitPage((int) count);
		updatePageSplitInSession(request, pageSplitFromSession);
	}
}
