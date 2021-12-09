package com.oracle.shop.orders.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: Tu Xu
 * @CreateDate: 2021/11/30 4:40
 * @Version: 1.0
 **/
@ApiModel(value="com-oracle-shop-orders-vo-OrdersUserVo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersUserVo implements Serializable {

    /**
     * 订单号
     */
    @ApiModelProperty(value="订单号")
    private String id;

    /**
     * 金额
     */
    @ApiModelProperty(value="金额")
    private Long ordersMoney;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 订单状态
     */
    @ApiModelProperty(value="订单状态")
    private String ordersStatus;

    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    private String userId;

    @ApiModelProperty(value="用户账号")
    private String loginName;

    private static final long serialVersionUID = 1L;
}
