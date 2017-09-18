package com.pactera.business.service;

import com.github.pagehelper.PageInfo;
import com.pactera.base.core.Service;
import com.pactera.business.domain.User;

public interface UserService extends Service<User> {

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午6:08:57
	 * @title findByName
	 * @description 根据用户id查询用户
	 * @return PageInfo<User>
	 */
	public PageInfo<User> findByName(String name, Integer page, Integer size);

}
