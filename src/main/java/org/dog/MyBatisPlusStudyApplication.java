package org.dog;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.dog.mapper")
public class MyBatisPlusStudyApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyBatisPlusStudyApplication.class, args);
  }

}
