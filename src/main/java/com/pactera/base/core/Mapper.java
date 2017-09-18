package com.pactera.base.core;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @ClassName: Mapper
 * @date 2017年9月18日 下午12:25:25
 * @author ToniR
 * @Description: 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加
 */
public interface Mapper<T> extends BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {
}
