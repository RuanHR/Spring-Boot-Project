package com.pactera.business.domain;

import com.pactera.base.domain.BaseDomain;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User extends BaseDomain {

	private static final long serialVersionUID = 3936839550983981694L;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 业务线id
	 */
	@Column(name = "org_id")
	private Long orgId;
	
	/**
	 * 角色id
	 */
	@Transient
	private Long roleId;
}