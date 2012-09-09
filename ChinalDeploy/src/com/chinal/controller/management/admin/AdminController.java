package com.chinal.controller.management.admin;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.chinal.exception.DomainObjectNotExistException;
import com.chinal.service.AdminService;
import com.chinal.util.page.PageRedirectUtil;
import com.chinal.util.page.PageSplit;
import com.chinal.vo.AdminVO;

@Controller
@RequestMapping("/management/admin/*")
public class AdminController {
	
	private static final String SHOW_MANAGE_ADMINS = "management/admin/showManageAdmins";
	private static final String EDIT_ADMIN = "management/admin/editAdmin";
	private static final String ADD_ADMIN = "management/admin/addAdmin";
	private static final String VIEW_ADMIN = "management/admin/viewAdmin";
	
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/showManageAdmin")
	public String showManageAdminPage(HttpServletRequest request, Map<String, Object> model){
		initShowAdminPageWithParamaters(request, model);
		return SHOW_MANAGE_ADMINS;
	}

	
	@RequestMapping(value = "/delAdmin", params="id")
	public String deleteAdmin(HttpServletRequest request, Map<String, Object> model, @RequestParam String id){
		adminService.deleteByID(Long.parseLong(id));
		
		initShowAdminPageWithParamaters(request, model);
		return SHOW_MANAGE_ADMINS;
	}
	
	@RequestMapping(value = "/editAdmin", params="id", method = RequestMethod.GET)
	public String showEditAdminPage(Map<String, Object> model, @RequestParam String id){
		try {
			AdminVO admin = adminService.getByID(Long.parseLong(id));
			model.put("adminVO", admin);
		} catch (NumberFormatException e) {
			// TODO need handle exception
		} catch (DomainObjectNotExistException e) {
			// TODO need handle exception
		}
		
		return EDIT_ADMIN;
	}
	
	@RequestMapping(value = "/editAdmin", method = RequestMethod.POST)
	public String editAdmin(@Valid AdminVO admin, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return EDIT_ADMIN;
		}
		
		adminService.update(admin);
		
		return PageRedirectUtil.buildSuccessPage("/management/admin/showManageAdmin", model);
	}
	
	@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
	public String showAddAdminPage(Map<String, Object> model){
		AdminVO adminVO = new AdminVO();
		adminVO.setPassword("admin123");
		model.put("adminVO", adminVO);
		
		return ADD_ADMIN;
	}
	
	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public String addAdmin(@Valid AdminVO admin, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return ADD_ADMIN;
		}
		
		adminService.add(admin);
		
		return PageRedirectUtil.buildSuccessPage("/management/admin/showManageAdmin", model);
	}
	
	@RequestMapping(value = "/viewAdmin", params="id")
	public String viewAdmin(@RequestParam String id, Map<String, Object> model){
		try {
			AdminVO admin = adminService.getByID(Long.parseLong(id));
			model.put("admin", admin);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		} catch (DomainObjectNotExistException e) {
			// TODO Auto-generated catch block
		}
		return VIEW_ADMIN;
	}
	
	private void initShowAdminPageWithParamaters(HttpServletRequest request,
			Map<String, Object> model) {
		PageSplit pageSplitFromSession = getPageSplitFromSession(request);
		
		long count = adminService.getTotalCount();
		List<AdminVO> adminList = adminService.getByPageSplit(pageSplitFromSession.getCurPage(), pageSplitFromSession.getPageSize());
		
		model.put("adminList", adminList);
		
		pageSplitFromSession.splitPage((int)count);
		updatePageSplitInSession(request, pageSplitFromSession);
	}
}
