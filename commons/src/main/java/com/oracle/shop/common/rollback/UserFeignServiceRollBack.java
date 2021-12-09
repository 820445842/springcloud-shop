package com.oracle.shop.common.rollback;

import com.oracle.shop.common.dto.OrdersUserDto;
import com.oracle.shop.common.feign.UserFeignService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Tu Xu
 * @CreateDate: 2021/11/30 22:06
 * @Version: 1.0
 **/
@Component
public class UserFeignServiceRollBack implements UserFeignService {
    @Override
    public OrdersUserDto detail(String id) {
        return OrdersUserDto.getFail();
    }
}
