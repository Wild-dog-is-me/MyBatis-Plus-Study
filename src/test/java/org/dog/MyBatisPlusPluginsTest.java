package org.dog;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.dog.entity.User;
import org.dog.enums.SexEnum;
import org.dog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/02/12:48 AM
 */

@SpringBootTest
public class MyBatisPlusPluginsTest {

  @Resource
  private UserMapper userMapper;

  @Test
  public void testPage() {

    Page<User> page = new Page<>(1, 3);
    userMapper.selectPage(page, null);
    System.out.println(page);

  }

  @Test
  public void testPageVo() {
    Page<User> page = new Page<>(1, 3);
    userMapper.selectPageVo(page, 20);
    System.out.println(page.getRecords());
  }

  @Test
  public void test() {
    User user = new User();
    user.setName("张三");
    user.setAge(13);
    user.setSexEnum(SexEnum.MALE);
    int res = userMapper.insert(user);
    System.out.println(res > 0 ? "添加成功" : "添加失败");
  }
}
