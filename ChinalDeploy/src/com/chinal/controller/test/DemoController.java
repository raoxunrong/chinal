package com.chinal.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinal.dao.AdminDao;
import com.chinal.domain.Admin;
import com.chinal.service.AdminService;

@Controller
public class DemoController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminDao adminDao;

	@RequestMapping("/demo")
	public String simple() {
		
		for(int i=1;i<30;i++){
			Admin admin = new Admin();
			
			admin.setLoginName("loginName" + i);
			admin.setName("name" + i);
			admin.setPlainPassword("plainPassword");
			admin.setEncrytedPassword("encrytedPassword");
			admin.setEmail("email");
			adminDao.save(admin);
		}
		
		return "demo";
	}
}
