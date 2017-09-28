package com.pactera.business.service.impl;

import org.springframework.stereotype.Service;

import com.pactera.business.domain.City;
import com.pactera.business.service.CityService;

@Service
public class City2ServiceImpl implements CityService {

	@Override
	public City getCityByName(String cityName) {
		// TODO Auto-generated method stub
		return new City();
	}

	@Override
	public void saveCity(City city) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCityDescription(String cityName, String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public City findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
