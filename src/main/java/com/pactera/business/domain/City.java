package com.pactera.business.domain;

import com.pactera.base.domain.BaseDomain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class City extends BaseDomain {

	private static final long serialVersionUID = 5079080163963218084L;

	/**
	 * 省id
	 */
	@ApiModelProperty(value = "省id")
	@Column(name = "province_id")
	private Long provinceId;

	/**
	 * 城市名称
	 */
	@ApiModelProperty(value = "城市名称")
	@Column(name = "city_name")
	private String cityName;

	/**
	 * 城市描述
	 */
	@ApiModelProperty(value = "城市描述")
	private String decription;
}