package com.oracle.shop.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Tu Xu
 * @CreateDate: 2021/11/30 21:14
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersUserDto implements Serializable {
    private String status;
    private String loginName;
    private String message;


    public static OrdersUserDto getFail(){
        OrdersUserDto ordersUserDto=new OrdersUserDto();
        ordersUserDto.setStatus("500");
        ordersUserDto.setMessage("此次服务调用失败，请稍后再试");
        return ordersUserDto;
    }
}
