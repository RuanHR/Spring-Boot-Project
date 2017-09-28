package com.pactera.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pactera.business.domain.City;
import com.pactera.business.mapper.cluster.CityMapper;
import com.pactera.business.service.CityService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	private Map<String, City> cityMap = new HashMap<String, City>();

	@Override
	@Cacheable(value = "baseCityInfo", key = "#cityName")
	public City getCityByName(String cityName) {
		// 模拟数据库查询并返回
		return cityMap.get(cityName);
	}

	@Override
	public void saveCity(City city) {
		// 模拟数据库插入操作
		cityMap.put(city.getCityName(), city);
	}

	@Override
	public void updateCityDescription(String cityName, String description) {
		City city = cityMap.get(cityName);
		city.setDecription(description);
		// 模拟更新数据库
		cityMap.put(cityName, city);
	}

	@Override
	public City findByName(String name) {
		Example example = new Example(City.class);
		Criteria or = example.or();
		or.andEqualTo("cityName", name);
		List<City> citys = cityMapper.selectByCondition(example);
		return citys.size() > 0 ? citys.get(0) : null;
	}

}
