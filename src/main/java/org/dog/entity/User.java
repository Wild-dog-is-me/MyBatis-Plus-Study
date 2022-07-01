package org.dog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/01/2:10 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_user")
public class User {


  private Long id;

  @TableField("username")
  private String name;

  private Integer age;

  private String email;

}
