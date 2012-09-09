package com.chinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.chinal.dao.CityDao;
import com.chinal.domain.City;
import com.chinal.domain.Province;
import com.chinal.service.base.BaseService;
import com.chinal.util.param.Parameter;
import com.chinal.util.param.ParameterType;
import com.chinal.util.param.Parameters;
import com.chinal.vo.CityVO;

@Controller
public class CityService implements BaseService<CityVO>{

	@Autowired
	private CityDao cityDao;

	public List<CityVO> getCitiesByProvince(long provinceid) {
		
		Parameters parameters = new Parameters();
		parameters.add(new Parameter("province.id", String.valueOf(provinceid), ParameterType.pLong));
		List<City> cities = cityDao.find(parameters);
		List<CityVO> citiesVO = new ArrayList<CityVO>();
		for(City city : cities){
			citiesVO.add(convertToCityVO(city));
		}
		return citiesVO;
	}
	
	@Override
	public void add(CityVO cityVO) {
		cityDao.save(convertToCity(cityVO));
	}
	
	@Override
	public CityVO getByID(long id) {
		return convertToCityVO(cityDao.getByID(id));
	}
	
	@Override
	public void update(CityVO city) {
		cityDao.update(convertToCity(city));
	}
	
	@Override
	public void deleteByID(long id) {
		City city = new City(id);
		cityDao.delete(city);
		
	}
	
	@Override
	public long getTotalCount() {
		return cityDao.getCount(new Parameters());
	}

	public CityVO convertToCityVO(City city){
		CityVO cityVO = new CityVO();
		cityVO.setId(city.getId());
		cityVO.setName(city.getName());
		cityVO.setDescription(city.getDescription());
		
		cityVO.setProvinceId(city.getProvince().getId());
		
		return cityVO;
	}
	
	public City convertToCity(CityVO cityVO){
		City city = new City();
		city.setId(cityVO.getId());
		city.setName(cityVO.getName());
		city.setDescription(cityVO.getDescription());
		
		Province province = new Province();
		province.setId(cityVO.getProvinceId());
		
		city.setProvince(province);
		
		return city;
	}

}
