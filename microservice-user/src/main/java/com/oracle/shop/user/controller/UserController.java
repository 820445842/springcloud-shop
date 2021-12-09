package com.oracle.shop.user.controller;

import com.oracle.shop.common.dto.OrdersUserDto;
import com.oracle.shop.common.feign.UserFeignService;
import com.oracle.shop.user.po.SysUser;
import com.oracle.shop.user.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Tu Xu
 * @CreateDate: 2021/11/30 4:37
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController implements UserFeignService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SysUserService sysUserService;

    @Override
    @RequestMapping("/detail/{id}")
    public OrdersUserDto detail(@PathVariable("id") String id){
        System.out.println(6662);
        SysUser sysUser=sysUserService.selectByPrimaryKey(id);
        OrdersUserDto ordersUserDto=new OrdersUserDto();
        BeanUtils.copyProperties(sysUser, ordersUserDto);
        return ordersUserDto;
    }
}
