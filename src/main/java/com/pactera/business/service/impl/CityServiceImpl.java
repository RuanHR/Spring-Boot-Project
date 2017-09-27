package com.pactera.business.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pactera.business.domain.City;
import com.pactera.business.service.CityService;

@Service
public class CityServiceImpl implements CityService {

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
		city.setDescription(description);
		// 模拟更新数据库
		cityMap.put(cityName, city);
	}

}
