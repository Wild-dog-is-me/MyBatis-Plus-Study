package org.dog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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
  public void testQueryWrapperOne() {

    /**
     * 查询条件组装
     *
     * like 模糊查询 ｜ between ｜ isNotNull
     */
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.like("username", "a").between("age", 20, 30).isNotNull("email");
    List<User> list = userMapper.selectList(queryWrapper);
    list.forEach(System.out::println);
  }

  @Test
  public void testQueryWrapperTwo() {

    /**
     * 排序条件组装
     *
     * orderByDesc(Asc) 升序 ｜ 降序排序
     */
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.orderByDesc("age").orderByAsc("id");
    List<User> userList = userMapper.selectList(queryWrapper);
    userList.forEach(System.out::println);
  }

  @Test
  public void testQueryWrapperThree() {

    /**
     * 删除条件组装
     *
     * 删除邮箱地址为空的用户
     * 实际上 由于设置了假删除 所以本质是一个更新操作 sql语句如下
     * UPDATE t_user SET is_delete=1 WHERE is_delete=0 AND (email IS NULL)
     */
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.isNull("email");
    int res = userMapper.delete(queryWrapper);
    System.out.println(res > 0 ? "删除成功" : "删除失败");
    System.out.println("result" + res);
  }

  @Test
  public void testQueryWrapperFour() {

    /**
     * 更新操作组装（条件优先级）
     *
     * 将年龄大于20 且用户名中包含a
     * 或用户邮箱为空的用户信息修改
     */
    UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
    userUpdateWrapper.gt("age", 20)
      .like("username", "a")
      .or()
      .isNull("email");
    User user = new User();
    user.setName("zhj");
    user.setEmail("123456@qq.com");
    int res = userMapper.update(user, userUpdateWrapper);
    System.out.println(res > 0 ? "修改成功" : "删除成功");
    System.out.println("result:" + res);
  }

  @Test
  public void testQueryWrapperFive() {

    /**
     * 更新操作组装（条件优先级）
     *
     * 将年龄大于20
     * 且用户名中包含a或用户邮箱为空的用户信息修改
     */
    UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
    userUpdateWrapper.like("username", "a").and(i -> i.gt("age", 20).or().isNull("email"));
    User user = new User();
    user.setName("zhj");
    user.setEmail("123456@qq.com");
    int res = userMapper.update(user, userUpdateWrapper);
    System.out.println(res > 0 ? "修改成功" : "修改失败");
    System.out.println("result:" + res);
  }

  @Test
  public void testQueryWrapperSix() {

    /**
     * 组装select语句
     *
     * 查询用户 name age email信息
     */
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.select("username", "age", "email");
    List<User> userList = userMapper.selectList(queryWrapper);
    userList.forEach(System.out::println);
  }

  @Test
  public void testQueryWrapperSeven() {
    /**
     * 自查询实现
     */
    QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
    userQueryWrapper.inSql("id", "select id from t_user where id <= 100");
    List<User> list = userMapper.selectList(userQueryWrapper);
    list.forEach(System.out::println);
  }

  @Test
  public void testQueryWrapperEight() {

    /**
     * 通过UpdateWrapper自带的功能实现修改
     */
    UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
    updateWrapper.like("username", "z").and(i -> i.gt("age", 20).or().isNull("email")).set("email", "svip@qq.com");
    int result = userMapper.update(null, updateWrapper);
    System.out.println(result > 0 ? "修改成功！" : "修改失败！");
    System.out.println("受影响的行数为：" + result);
  }

  /**
   * 在真正开发的过程中，组装条件是常见的功能，而这些条件数据来源于用户输入，
   * 是可选的，因此我们在组装这些条件时，必须先判断用户是否选择了这些条件，
   * 若选择则需要组装该条件，若没有选择则一定不能组装，以免影响SQL执行的结果
   */
  @Test
  public void testQueryWrapperConditionOne(){

    /**
     * condition参数的重载方法构建查询条件，
     * 简化代码的编写
     */
    String username = "a";
    Integer ageBegin = null;
    Integer ageEnd = 30;
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.like(StringUtils.isNotBlank(username), "user_name", username)
      .ge(ageBegin != null, "age", ageBegin)
      .le(ageEnd != null, "age", ageEnd);
    List<User> list = userMapper.selectList(queryWrapper);
    list.forEach(System.out::println);
  }

  @Test
  public void testQueryWrapperConditionTwo() {

    /**
     * 功能等同于QueryWrapper，提供了Lambda表达式的语法可以避免填错列名。
     */
    String username = "a";
    Integer ageBegin = null;
    Integer ageEnd = 30;
    LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
      .ge(ageBegin != null, User::getAge, ageBegin)
      .le(ageEnd != null, User::getAge, ageEnd);
    List<User> list = userMapper.selectList(queryWrapper);
    list.forEach(System.out::println);
  }


}
