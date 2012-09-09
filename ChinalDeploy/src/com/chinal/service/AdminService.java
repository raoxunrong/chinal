package com.chinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinal.dao.AdminDao;
import com.chinal.domain.Admin;
import com.chinal.exception.DomainObjectNotExistException;
import com.chinal.service.base.PageSplitService;
import com.chinal.util.CollectionUtil;
import com.chinal.util.param.Parameter;
import com.chinal.util.param.Parameters;
import com.chinal.vo.AdminVO;

@Service
public class AdminService implements PageSplitService<AdminVO>{

	@Autowired
	private AdminDao adminDao;

	@Override
	public void add(AdminVO admin) {
		adminDao.saveObject(convert2Admin(admin));
	}
	
	@Override
	public void update(AdminVO admin){
		adminDao.update(convert2Admin(admin));
	}

	@Override
	public AdminVO getByID(long id) throws DomainObjectNotExistException {
		Admin admin = adminDao.getByID(id);
		if (admin == null) {
			throw new DomainObjectNotExistException(Admin.class);
		}
		return convert2AdminVO(admin);
	}
	
	@Override
	public long getTotalCount() {
		return adminDao.getCount(new Parameters());
	}
	
	@Override
	public List<AdminVO> getByPageSplit(int curPage, int pageSize) {
		List<Admin> adminList = adminDao.find(new Parameters(), curPage, pageSize);

		List<AdminVO> adminVOList = new ArrayList<AdminVO>(pageSize);
		for (Admin admin : adminList) {
			adminVOList.add(convert2AdminVO(admin));
		}

		return adminVOList;
	}
	
	@Override
	public void deleteByID(long id) {
		Admin admin = new Admin();
		admin.setId(id);
		adminDao.delete(admin);

	}
	
	public AdminVO getAdmin(String loginName, String password)
			throws DomainObjectNotExistException {
		Parameters parameters = new Parameters();
		parameters.add(new Parameter("loginName", loginName));
		parameters.add(new Parameter("plainPassword", password));

		List<Admin> adminList = adminDao.find(parameters);

		if (CollectionUtil.isCollectionEmpty(adminList)) {
			throw new DomainObjectNotExistException(Admin.class);
		}
		return convert2AdminVO(adminList.get(0));
	}

	private Admin convert2Admin(AdminVO adminVO) {
		Admin admin = new Admin();

		admin.setId(adminVO.getId());
		admin.setLoginName(adminVO.getLoginName());
		admin.setPlainPassword(adminVO.getPassword());
		admin.setName(adminVO.getName());
		admin.setEmail(adminVO.getEmail());
		admin.setPhone(adminVO.getPhone());
		admin.setSuperAdmin(adminVO.isSuperAdmin());
		return admin;
	}

	private AdminVO convert2AdminVO(Admin admin) {
		AdminVO adminVO = new AdminVO();
		adminVO.setId(admin.getId());
		adminVO.setLoginName(admin.getLoginName());
		adminVO.setPassword(admin.getPlainPassword());
		adminVO.setName(admin.getName());
		adminVO.setEmail(admin.getEmail());
		adminVO.setPhone(admin.getPhone());
		adminVO.setSuperAdmin(admin.isSuperAdmin());
		return adminVO;
	}

}
