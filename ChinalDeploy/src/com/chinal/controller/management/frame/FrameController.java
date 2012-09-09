package com.chinal.controller.management.frame;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrameController {

	@RequestMapping(value="/management/topmenu")
	public String showTopMenu() {
		return "management/frame/topmenu";
	}
	
	@RequestMapping(value="/management/menu")
	public String showLeftMenu() {
		return "management/frame/menu";
	}
}
