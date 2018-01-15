package com.emed.shopping.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: 周润斌
 * @Date: create in 上午 16:34 2018/1/15 0015
 * @Description:
 */
public interface CommonMapper <T> extends Mapper<T>, MySqlMapper<T> {
}
