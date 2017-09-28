package com.pactera.business.service;

import com.pactera.business.domain.City;

/**
 * @ClassName: CityService
 * @date 2017年9月27日 下午3:20:12
 * @author ToniR
 * @Description: 城市service（测试redis）
 */
public interface CityService {

	/**
	 * @author ToniR
	 * @since 2017年9月27日 下午3:20:42
	 * @title getCityByName
	 * @description 获取城市
	 * @return City
	 */
	City getCityByName(String cityName);

	/**
	 * @author ToniR
	 * @since 2017年9月27日 下午3:21:18
	 * @title saveCity
	 * @description 获取城市信息
	 * @return void
	 */
	void saveCity(City city);

	/**
	 * @author ToniR
	 * @since 2017年9月27日 下午3:21:38
	 * @title updateCityDescription
	 * @description 更新城市信息
	 * @return void
	 */
	void updateCityDescription(String cityName, String description);

	/**
	 * @author ToniR
	 * @since 2017年9月28日 下午3:33:31
	 * @title findByName
	 * @description 根据名称查询城市信息
	 * @return City
	 */
	City findByName(String name);

}
