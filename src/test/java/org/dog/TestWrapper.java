package org.dog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * @Date: 2022/07/01/10:31 PM
 */

@SpringBootTest
public class TestWrapper {

  @Resource
  private UserMapper userMapper;

  @Test
  public void testQueryWrapper() {

    /**
     * QueryWrapper 查询条件封装
     *
     * like 模糊查询 ｜ between ｜ isNotNull
     */
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.like("username", "a").between("age", 20, 30).isNotNull("email");
    List<User> list = userMapper.selectList(queryWrapper);
    list.forEach(System.out::println);
  }
}
