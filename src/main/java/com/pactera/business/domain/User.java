package com.pactera.business.domain;

import com.pactera.base.domain.BaseDomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel("用户实体类")
public class User extends BaseDomain {

	private static final long serialVersionUID = 3936839550983981694L;

	/**
	 * 名称
	 */
	@ApiModelProperty(value = "名称")
	private String name;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	private String password;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String username;

	/**
	 * 业务线id
	 */
	@Column(name = "org_id")
	@ApiModelProperty(value = "业务线id")
	private Long orgId;

	/**
	 * 角色id
	 */
	@Transient
	@ApiModelProperty(value = "角色id")
	private Long roleId;
}