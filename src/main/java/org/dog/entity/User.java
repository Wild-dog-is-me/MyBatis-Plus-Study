package org.dog.entity;

import com.baomidou.mybatisplus.annotation.*;
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

  /**
   * 设置数据库id策略
   * type
   * 1、IdType.AUTO (需在表中设置自增长，且设置为主键）
   * 2、IdType.ASSIGN_ID（默认）
   *   (基于雪花算法策略生成id 与数据库id设置无关)
   */
  @TableId(type = IdType.AUTO)
  private Long id;

  @TableField("username")
  private String name;

  private Integer age;

  private String email;

  /**
   * 逻辑删除 : 需要在数据库中添加标记字段，且设置默认值为0
   * 假删除 : 使数据库中对应字段修改为删除状态
   *         在数据库中仍能看到此条数据，但查询时不显示
   */
  @TableLogic
  private int isDelete;

}
