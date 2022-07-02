package org.dog.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/02/9:24 PM
 */

@Getter
public enum SexEnum {
  MALE(1, "男"),
  FEMALE(2, "女");

  @EnumValue //将注解所标识的属性的值存储到数据库中
  private int sex;
  private String sexName;

  SexEnum(Integer sex, String sexName) {
    this.sex = sex;
    this.sexName = sexName;
  }
}
