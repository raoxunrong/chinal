package com.chinal.controller.front;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front/*")
public class DashboardController {

	@RequestMapping(value = "/dashboardPage")
	public String showDashboardPage(Map<String, Object> model) {
		model.put("userCount", 100456);
		model.put("companyCount", 106);
		return "/front/dashboard";
	}
}
