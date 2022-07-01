package org.dog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.entity.User;
import org.dog.mapper.UserMapper;
import org.dog.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/07/01/3:42 PM
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{}
