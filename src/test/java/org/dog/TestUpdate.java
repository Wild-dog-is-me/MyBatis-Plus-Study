package org.dog;

import org.dog.entity.User;
import org.dog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/01/2:59 PM
 */

@SpringBootTest
public class TestUpdate {

  @Resource
  private UserMapper userMapper;

  @Test
  public void testUpdateOne() {

    /**
     * 根据id修改用户
     */
    User user = new User();
    user.setId(4l);
    user.setName("里斯");
    int res = userMapper.updateById(user);
    System.out.println("result:" + res);
  }

}
