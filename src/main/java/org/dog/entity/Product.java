package org.dog.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/02/11:26 AM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

  private Long id;

  private String name;

  private Integer price;

  @Version
  private Integer version;
}
