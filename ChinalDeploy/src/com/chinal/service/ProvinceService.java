package com.chinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinal.dao.CityDao;
import com.chinal.dao.ProvinceDao;
import com.chinal.domain.City;
import com.chinal.domain.Province;
import com.chinal.service.base.BaseService;
import com.chinal.util.param.Parameters;
import com.chinal.vo.ProvinceVO;

@Service
public class ProvinceService implements BaseService<ProvinceVO>{
	
	@Autowired
	private ProvinceDao provinceDao;
	
	@Autowired
	private CityDao cityDao;

	public List<ProvinceVO> getAllProvince(){
		
		List<Province> provinceList = provinceDao.find(new Parameters());
		List<ProvinceVO> provinceVOList = new ArrayList<ProvinceVO>();
		for(Province province : provinceList){
			provinceVOList.add(convertToProvinceVO(province));
		}
		return provinceVOList;
	}
	
	@Override
	public void add(ProvinceVO province) {
		provinceDao.save(convertToProvince(province));
	}
	
	@Override
	public void deleteByID(long parseLong) {
		Province province = new Province();
		province.setId(parseLong);
		provinceDao.delete(province);
		
	}
	
	@Override
	public ProvinceVO getByID(long id) {
		return convertToProvinceVO(provinceDao.getByID(id));
	}
	
	@Override
	public void update(ProvinceVO provinceVO) {
		provinceDao.update(convertToProvince(provinceVO));
	}
	
	@Override
	public long getTotalCount() {
		return provinceDao.getCount(new Parameters());
	}
	
	public ProvinceVO getProvinceByCityId(long cityId) {
		City city = cityDao.getByID(cityId);
		return getByID(city.getProvince().getId());
	}
	
	private ProvinceVO convertToProvinceVO(Province province){
		ProvinceVO provinceVO = new ProvinceVO();
		provinceVO.setId(province.getId());
		provinceVO.setName(province.getName());
		provinceVO.setDescription(province.getDescription());
		return provinceVO;
	}
	
	private Province convertToProvince(ProvinceVO provinceVO){
		Province province = new Province();
		province.setId(provinceVO.getId());
		province.setName(provinceVO.getName());
		province.setDescription(provinceVO.getDescription());
		
		return province;
	}

}
