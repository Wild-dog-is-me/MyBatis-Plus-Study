package org.dog;

import org.dog.entity.Product;
import org.dog.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/02/11:27 AM
 */

@SpringBootTest
public class TestProduct {

  @Resource
  private ProductMapper productMapper;

  @Test
  public void testProductOne() {

    //1.小李获取商品价格
    Product productLi = productMapper.selectById(1);
    System.out.println("小李获取的商品价格为：" + productLi.getPrice());

    //2.小王获取商品价格
    Product productWang = productMapper.selectById(1);
    System.out.println("小李获取的商品价格为：" + productWang.getPrice());

    //3.小李修改商品价格+50
    productLi.setPrice(productLi.getPrice()+50);
    productMapper.updateById(productLi);

    //4.小王修改商品价格-30
    productWang.setPrice(productWang.getPrice()-30);
    int result = productMapper.updateById(productWang);
    if(result == 0){
      //操作失败，重试
      Product productNew = productMapper.selectById(1);
      productNew.setPrice(productNew.getPrice()-30);
      productMapper.updateById(productNew);
    }

    //5.老板查询商品价格
    Product productBoss = productMapper.selectById(1);
    System.out.println("老板获取的商品价格为：" + productBoss.getPrice());
  }

}
