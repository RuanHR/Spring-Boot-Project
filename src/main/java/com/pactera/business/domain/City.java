package com.pactera.business.domain;

import com.pactera.base.domain.BaseDomain;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel("城市实体类")
public class City extends BaseDomain {

	private static final long serialVersionUID = -3875105464962061090L;

	/**
	 * 省id
	 */
	private Long provinceId;

	/**
	 * 城市名称
	 */
	private String cityName;

	/**
	 * 描述
	 */
	private String description;

}
