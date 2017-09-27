package com.pactera;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pactera.business.domain.City;
import com.pactera.business.service.CityService;
import com.pactera.business.service.impl.CityServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	@Qualifier("city2ServiceImpl")
	private CityService city2ServiceImpl;

	@Autowired
	@Qualifier("cityServiceImpl")
	private CityService cityServiceImpl;

	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

	private City getShanghai() {
		City city = new City();
		city.setId(1L);
		city.setProvinceId(10L);
		city.setCityName("上海");
		city.setDescription("人称魔都的地方");
		return city;
	}

	private City getBeijing() {
		City city = new City();
		city.setId(2L);
		city.setProvinceId(20L);
		city.setCityName("北京");
		city.setDescription("中国帝都");
		return city;
	}

	@Test
	public void testRedis() {
		City city = getShanghai();
		// 向 redis 中存入数据
		city2ServiceImpl.saveCity(city);

		// 从 redis 中取数据
		City cityInfo = city2ServiceImpl.getCityByName("上海");

		LOGGER.info(cityInfo.toString());

	}

	@Test
	public void testRedisCache() {
		City city = getBeijing();
		// 向 redis 中存入数据
		cityServiceImpl.saveCity(city);

		// 从 redis 中取数据, 第一次查询
		City cityInfo = cityServiceImpl.getCityByName("北京");
		LOGGER.info("第一次查询：" + cityInfo.toString());

		// 从 redis 中取数据, 第二次查询
		cityInfo = cityServiceImpl.getCityByName("北京");
		LOGGER.info("第二次查询：" + cityInfo.toString());

		// 更新 city 的描述信息后查询
		city2ServiceImpl.updateCityDescription("北京", "想不想去北京玩玩呢？");
		cityInfo = cityServiceImpl.getCityByName("北京");
		LOGGER.info("更新描述后查询：" + cityInfo.toString());

	}

}
