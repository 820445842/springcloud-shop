package com.oracle.shop.common.feign;

import com.oracle.shop.common.dto.OrdersUserDto;
import com.oracle.shop.common.rollback.UserFeignServiceRollBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Tu Xu
 * @CreateDate: 2021/11/30 20:57
 * @Version: 1.0
 **/
@FeignClient(value = "microservice-user",fallback = UserFeignServiceRollBack.class)
public interface UserFeignService {
    @RequestMapping("/user/detail/{id}")
    public OrdersUserDto detail(@PathVariable("id") String id);
}
