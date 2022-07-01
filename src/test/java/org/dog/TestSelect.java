package org.dog;

import org.dog.entity.User;
import org.dog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/01/2:56 PM
 */

@SpringBootTest
public class TestSelect {

  @Resource
  private UserMapper userMapper;

  @Test
  public void testSelectOne() {

    /**
     * 通过条件构造器查询一个List集合
     * 若没有条件，则设置null为参数
     */
    List<User> users = userMapper.selectList(null);
    users.forEach(System.out::println);

  }

  @Test
  public void testSelectTwo() {

    /**
     * 根据id查询用户
     */
    User res = userMapper.selectById(1l);
    System.out.println("result:" + res);
  }

  @Test
  public void testSelectThree() {

  }

}
