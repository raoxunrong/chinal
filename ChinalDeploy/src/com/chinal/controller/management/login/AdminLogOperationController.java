package com.chinal.controller.management.login;

import static com.chinal.util.session.SessionUtil.putAdminToSession;
import static com.chinal.util.session.SessionUtil.removeAdminFromSession;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.chinal.exception.DomainObjectNotExistException;
import com.chinal.service.AdminService;
import com.chinal.vo.AdminVO;

@Controller
@RequestMapping("/management/admin/*")
public class AdminLogOperationController {

	private static final String loginPage = "management/login";
	private static final String mainPage = "management/frame/main";

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(Map<String, Object> model) {
		initAdminOnPage(model);
		return loginPage;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid AdminVO admin, BindingResult result,
			WebRequest request) {

		if (result.hasErrors()) {
			return loginPage;
		}

		try {
			AdminVO adminVO = adminService.getAdmin(admin.getLoginName(),
					admin.getPassword());
			putAdminToSession(request, adminVO);
		} catch (DomainObjectNotExistException e) {
			request.setAttribute("loginError", "输入的用户名或密码错误！",
					WebRequest.SCOPE_REQUEST);
			return loginPage;
		}

		return mainPage;
	}

	@RequestMapping(value = {"/admin/logout", "management/admin/logout"})
	public String logout(WebRequest request, Map<String, Object> model) {
		removeAdminFromSession(request);
		initAdminOnPage(model);
		return loginPage;
	}

	private void initAdminOnPage(Map<String, Object> model) {
		model.put("adminVO", new AdminVO());
	}
}
