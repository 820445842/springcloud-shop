package com.oracle.shop.orders.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-oracle-shop-orders-po-Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
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

    private static final long serialVersionUID = 1L;
}