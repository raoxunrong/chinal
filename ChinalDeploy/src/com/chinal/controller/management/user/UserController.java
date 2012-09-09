package com.chinal.controller.management.user;

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
import com.chinal.service.CityService;
import com.chinal.service.ProvinceService;
import com.chinal.service.UserService;
import com.chinal.util.page.PageRedirectUtil;
import com.chinal.util.page.PageSplit;
import com.chinal.vo.CityVO;
import com.chinal.vo.ProvinceVO;
import com.chinal.vo.UserVO;

@Controller
@RequestMapping("/management/user/*")
public class UserController {

	private static final String SHOW_MANAGE_USER = "management/user/manageUser";
	private static final String SHOW_ADD_USER = "management/user/addUser";
	private static final String VIEW_USER = "management/user/viewUser";
	private static final String EDIT_USER = "management/user/editUser";

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProvinceService provinceService;
	
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/manageUser")
	public String showManageUserPage(HttpServletRequest request,
			Map<String, Object> model) {
		initShowUserPageWithParamaters(request, model);
		return SHOW_MANAGE_USER;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String showAddUserPage(Map<String, Object> model){
		List<ProvinceVO> allProvince = provinceService.getAllProvince();
		UserVO userVO = new UserVO();
		model.put("userVO", userVO);
		model.put("allProvince", allProvince);
		return SHOW_ADD_USER;
	}
	
	@RequestMapping(value = "/delUser", params="id")
	public String deleteUser(HttpServletRequest request, Map<String, Object> model, @RequestParam String id){
		userService.deleteByID(Long.parseLong(id));
		
		initShowUserPageWithParamaters(request, model);
		return SHOW_MANAGE_USER;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@Valid UserVO userVO, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return SHOW_ADD_USER;
		}
		
		userService.add(userVO);
		
		return PageRedirectUtil.buildSuccessPage("/management/user/manageUser", model);
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.GET, params="id")
	public String showEditUserPage(@RequestParam String id, Map<String, Object> model) throws NumberFormatException, DomainObjectNotExistException{
		List<ProvinceVO> allProvince = provinceService.getAllProvince();
		UserVO userVO = userService.getByID(Long.parseLong(id));
		model.put("userVO", userVO);
		model.put("allProvince", allProvince);
		ProvinceVO province = provinceService.getProvinceByCityId(userVO.getCityId());
		model.put("defaultProvince", province);
		List<CityVO> citiesByProvince = cityService.getCitiesByProvince(province.getId());
		model.put("cities", citiesByProvince);
		return EDIT_USER;
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String editUser(@Valid UserVO user, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return EDIT_USER;
		}
		
		userService.update(user);
		
		return PageRedirectUtil.buildSuccessPage("/management/user/manageUser", model);
	}
	
	@RequestMapping(value = "/viewUser", params="id")
	public String viewUser(@RequestParam String id, Map<String, Object> model){
		try {
			UserVO user = userService.getByID(Long.parseLong(id));
			CityVO city = cityService.getByID(user.getCityId());
			model.put("user", user);
			model.put("city", city);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		} catch (DomainObjectNotExistException e) {
			// TODO Auto-generated catch block
		}
		return VIEW_USER;
	}

	private void initShowUserPageWithParamaters(HttpServletRequest request,
			Map<String, Object> model) {
		PageSplit pageSplitFromSession = getPageSplitFromSession(request);

		long count = userService.getTotalCount();
		List<UserVO> userList = userService.getByPageSplit(
				pageSplitFromSession.getCurPage(),
				pageSplitFromSession.getPageSize());

		model.put("userList", userList);

		pageSplitFromSession.splitPage((int) count);
		updatePageSplitInSession(request, pageSplitFromSession);
	}
}
