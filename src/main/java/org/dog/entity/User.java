package org.dog.entity;

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
public class User {

  private Long id;

  private String name;

  private Integer age;

  private String email;

}
