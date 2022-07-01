package org.dog;

import org.dog.entity.User;
import org.dog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/01/2:15 PM
 */

@SpringBootTest
public class TestInsert {

  @Resource
  private UserMapper userMapper;

  @Test
  public void testInsert() {

    /**
     * 添加用户
     */
    User user = new User();
    user.setName("张三");
    user.setAge(23);
    user.setEmail("123456@qq.com");

    int res = userMapper.insert(user);
    System.out.println("result:" + res);

  }
}

