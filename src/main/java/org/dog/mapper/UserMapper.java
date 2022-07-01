package org.dog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.dog.entity.User;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/01/2:13 PM
 */

public interface UserMapper extends BaseMapper<User> {

  Map<String, Object> selectMapById(Long id);
}
