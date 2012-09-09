package com.chinal.controller.management.location;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinal.service.CityService;
import com.chinal.service.ProvinceService;
import com.chinal.util.JsonUtil;
import com.chinal.util.page.PageRedirectUtil;
import com.chinal.vo.CityVO;
import com.chinal.vo.ProvinceVO;

@Controller
@RequestMapping("/management/location/*")
public class LocationController {
	
	private static final String SHOW_MANAGE_PROVINCE = "management/location/manageProvince";
	private static final String SHOW_ADD_PROVINCE = "management/location/addProvince";
	private static final String SHOW_EDIT_PROVINCE = "management/location/editProvince";
	
	private static final String SHOW_MANAGE_CITY = "management/location/manageCity";
	private static final String SHOW_ADD_CITY = "management/location/addCity";
	private static final String SHOW_EDIT_CITY = "management/location/editCity";
	
	@Autowired
	private ProvinceService provinceService; 
	
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/manageProvince")
	public String showManageProvincePage(Map<String, Object> model){
		List<ProvinceVO> allProvince = provinceService.getAllProvince();
		model.put("allProvince", allProvince);
		model.put("count", allProvince.size());
		return SHOW_MANAGE_PROVINCE;
	}
	
	@RequestMapping(value = "/addProvince", method = RequestMethod.GET)
	public String showAddProvincePage(Map<String, Object> model){
		model.put("provinceVO", new ProvinceVO());
		return SHOW_ADD_PROVINCE;
	}
	
	@RequestMapping(value = "/addProvince", method = RequestMethod.POST)
	public String addProvince(@Valid ProvinceVO province, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return SHOW_ADD_PROVINCE;
		}
		
		provinceService.add(province);
		
		return PageRedirectUtil.buildSuccessPage("/management/location/manageProvince", model);
	}
	
	@RequestMapping(value = "/editProvince", method = RequestMethod.GET, params="id")
	public String showEditProvincePage(Map<String, Object> model, @RequestParam String id){
		
		ProvinceVO province = provinceService.getByID(Long.parseLong(id));
		model.put("provinceVO", province);
		return SHOW_EDIT_PROVINCE;
	}
	
	@RequestMapping(value = "/editProvince", method = RequestMethod.POST)
	public String editProvince(@Valid ProvinceVO province, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return SHOW_EDIT_PROVINCE;
		}
		
		provinceService.update(province);
		
		return PageRedirectUtil.buildSuccessPage("/management/location/manageProvince", model);
	}
	
	@RequestMapping(value = "/delProvince", params="id")
	public String deleteProvince(Map<String, Object> model, @RequestParam String id){
		provinceService.deleteByID(Long.parseLong(id));
		
		return PageRedirectUtil.buildSuccessPage("/management/location/manageProvince", model);
	}
	
	@RequestMapping(value = "/manageCity", params="provinceid")
	public String showManageCityPage(Map<String, Object> model, @RequestParam String provinceid){
		long provinceId = Long.parseLong(provinceid);
		ProvinceVO province = provinceService.getByID(provinceId);
		
		List<CityVO> cities = cityService.getCitiesByProvince(provinceId);
		
		model.put("cities", cities);
		model.put("count", cities.size());
		model.put("province", province);
		return SHOW_MANAGE_CITY;
	}
	
	@RequestMapping(value="/getCitiesByProvince", method=RequestMethod.GET, params="provinceId", produces="application/json")
	public void getCitisByProvinceId(@RequestParam String provinceId, HttpServletResponse response) throws IOException{
		List<CityVO> cityList = cityService.getCitiesByProvince(Long.parseLong(provinceId));
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(JsonUtil.getJsonString(cityList));
	}
	
	@RequestMapping(value = "/addCity", method = RequestMethod.GET, params="provinceId")
	public String showAddCityPage(Map<String, Object> model, @RequestParam String provinceId){
		ProvinceVO province = provinceService.getByID(Long.parseLong(provinceId));
		
		CityVO city = new CityVO();
		city.setProvinceId(Long.parseLong(provinceId));
		model.put("cityVO", city);
		model.put("province", province);
		return SHOW_ADD_CITY;
	}
	
	@RequestMapping(value = "/addCity", method = RequestMethod.POST)
	public String addCity(@Valid CityVO city, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return SHOW_ADD_CITY;
		}
		
		cityService.add(city);
		
		return PageRedirectUtil.buildSuccessPage("/management/location/manageCity?provinceid=" + city.getProvinceId(), model);
	}
	
	@RequestMapping(value = "/editCity", method = RequestMethod.GET, params="id")
	public String showEditCityPage(Map<String, Object> model, @RequestParam String id){
		CityVO city = cityService.getByID(Long.parseLong(id));
		ProvinceVO province = provinceService.getByID(city.getProvinceId());
		model.put("province", province);
		model.put("cityVO", city);
		return SHOW_EDIT_CITY;
	}
	
	@RequestMapping(value = "/editCity", method = RequestMethod.POST)
	public String editCity(@Valid CityVO city, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return SHOW_EDIT_CITY;
		}
		
		cityService.update(city);
		
		return PageRedirectUtil.buildSuccessPage("/management/location/manageCity?provinceid=" + city.getProvinceId(), model);
	}
	
	@RequestMapping(value = "/delCity", params={"id", "provinceId"})
	public String deleteCity(Map<String, Object> model, @RequestParam String id, @RequestParam String provinceId){
		cityService.deleteByID(Long.parseLong(id));
		return PageRedirectUtil.buildSuccessPage("/management/location/manageCity?provinceid=" + provinceId, model);
	}
}
