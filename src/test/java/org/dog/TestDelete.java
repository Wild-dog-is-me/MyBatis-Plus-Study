package org.dog;

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
 * @Date: 2022/07/01/2:59 PM
 */

@SpringBootTest
public class TestDelete {

  @Resource
  private UserMapper userMapper;

  @Test
  public void testDeleteOne() {

    /**
     * 根据id删除用户
     */
    int res = userMapper.deleteById(1542787890730270721L);
    System.out.println("result:" + res);
  }

  @Test
  public void testDeleteTwo() {

    /**
     * map集合中存放删除条件
     * 根据map提供的条件删除
     */
    Map<String, Object> map = new HashMap<>();
    map.put("name", "张三");
    map.put("age", 23);
    int res = userMapper.deleteByMap(map);
    System.out.println("result:" + res);
  }

  @Test
  public void testDeleteThree() {

    /**
     * 多个id批量删除
     */
    List<Long> idList = Arrays.asList(1l, 2l);
    int res = userMapper.deleteBatchIds(idList);
    System.out.println("result:" + res);
  }

}
