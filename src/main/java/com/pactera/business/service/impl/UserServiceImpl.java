package com.pactera.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pactera.base.core.AbstractService;
import com.pactera.business.domain.User;
import com.pactera.business.mapper.master.UserMapper;
import com.pactera.business.service.UserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public PageInfo<User> findByName(String name, Integer page, Integer size) {
		// 分页
		PageHelper.startPage(page, size);
		// 开启查询
		Example example = new Example(User.class);
		Criteria or = example.or();
		or.andEqualTo("name", name);
		List<User> users = userMapper.selectByCondition(example);
		return new PageInfo<>(users);
	}

}
