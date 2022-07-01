package org.dog;

import org.dog.entity.User;
import org.dog.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/01/3:50 PM
 */

@SpringBootTest
public class TestService {

  @Resource
  private UserService userService;

  @Test
  public void testGetCount() {

    /**
     * 查询表中总记录数
     */
    System.out.println(userService.count());

  }

  @Test
  public void testInsert() {

    /**
     * 批量添加用户信息
     */
    List<User> userList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      User user = new User();
      user.setName("zhj" + i);
      user.setAge(20 + i);
      userList.add(user);
    }
    userService.saveBatch(userList);
  }

}
