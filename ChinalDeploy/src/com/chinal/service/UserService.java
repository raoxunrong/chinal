package com.chinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinal.dao.UserDao;
import com.chinal.domain.City;
import com.chinal.domain.User;
import com.chinal.exception.DomainObjectNotExistException;
import com.chinal.service.base.PageSplitService;
import com.chinal.util.param.Parameters;
import com.chinal.vo.UserVO;

@Service
public class UserService implements PageSplitService<UserVO>{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserVO> getByPageSplit(int curPage, int pageSize){
		Parameters parameters = new Parameters();
		List<User> userList = userDao.find(parameters, curPage, pageSize);
		
		List<UserVO> userVOList = new ArrayList<UserVO>();
		
		for(User user : userList){
			userVOList.add(convertToUserVO(user));
		}
		
		return userVOList;
	}
	
	@Override
	public long getTotalCount() {
		return userDao.getCount(new Parameters());
	}
	
	@Override
	public void add(UserVO userVO) {
		userDao.save(convertToUser(userVO));
	}
	
	@Override
	public UserVO getByID(long id) throws DomainObjectNotExistException{
		return convertToUserVO(userDao.getByID(id));
	}
	
	@Override
	public void update(UserVO user) {
		userDao.update(convertToUser(user));
		
	}
	
	@Override
	public void deleteByID(long id) {
		userDao.delete(new User(id));
		
	}

	private User convertToUser(UserVO userVO) {
		User user = new User();
		user.setId(userVO.getId());
		user.setName(userVO.getName());
		user.setLoginName(userVO.getLoginName());
		user.setPlainPassword(userVO.getPlainPassword());
		user.setEncrytedPassword(userVO.getEncrytedPassword());
		user.setEmail(userVO.getEmail());
		user.setIdCard(userVO.getIdCard());
		user.setPhone(userVO.getPhone());
		
		user.setCity(new City(userVO.getCityId()));
		return user;
	}

	private UserVO convertToUserVO(User user) {
		UserVO userVO = new UserVO();
		userVO.setId(user.getId());
		userVO.setName(user.getName());
		userVO.setLoginName(user.getLoginName());
		userVO.setPlainPassword(user.getPlainPassword());
		userVO.setEncrytedPassword(user.getEncrytedPassword());
		userVO.setEmail(user.getEmail());
		userVO.setIdCard(user.getIdCard());
		userVO.setPhone(user.getPhone());
		
		userVO.setCityId(user.getCity().getId());
		return userVO;
	}

}
