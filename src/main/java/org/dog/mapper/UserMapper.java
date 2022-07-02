package org.dog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dog.entity.User;

import java.util.Arrays;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/01/2:13 PM
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

  Map<String, Object> selectMapById(Long id);

  /**
   * 通过年龄查询用户信息并分页
   * 自定义分页插件
   */
  Page<User> selectPageVo(@Param("page") Page<User> page,@Param("age") Integer age);
}
