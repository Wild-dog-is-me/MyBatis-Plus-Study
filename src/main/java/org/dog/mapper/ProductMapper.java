package org.dog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dog.entity.Product;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/02/11:27 AM
 */

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
