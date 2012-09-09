package com.chinal.controller.management.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/management/system/*")
public class SystemController {

	@RequestMapping(value = "/maintain")
	public String showSystemMaintainPage(){
		return "errors/systemMaintain";
	}
}
