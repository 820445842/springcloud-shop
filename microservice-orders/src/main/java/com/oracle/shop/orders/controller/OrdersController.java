package com.oracle.shop.orders.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oracle.shop.common.dto.OrdersUserDto;
import com.oracle.shop.common.feign.UserFeignService;
import com.oracle.shop.orders.OrdersServer;
import com.oracle.shop.orders.po.Orders;
import com.oracle.shop.orders.service.OrdersService;
import com.oracle.shop.orders.vo.OrdersUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 restTemplate 负载均衡 底层使用的是ribbon组件
 ribbon组件 各个组件之间 网关 注册中心 具体的微服务
 ribbon 轮询 随机 权重等，默认是轮询
 缺点：
 1：硬编码 在进行服务消费的时候，需要写死调用哪一个服务的哪一个地址
 2: 数据转换需要自己手动完成(json和java对象的转换工作需要自己完成)
 主流都是使用feign(open-feign)组件进行服务调用(底层基于restTemplate),基于动态代理生成feign客户端，调用远程服务接口的时候，感觉就像调用本地一样
 springcloud Alibaba版本
 Nacos
 dubbo

 **/
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignService userFeignService;

    @RequestMapping("/detail/{id}")
    public OrdersUserVo detail(@PathVariable("id") String id){
        //1：查到订单信息
        Orders orders=ordersService.selectByPrimaryKey(id);
        //基于openFeign进行服务消费
        OrdersUserDto ordersUserDto=userFeignService.detail(orders.getUserId());
     /*   //2：发起服务调用，消费用户服务的接口，并获取数据
        //2.1 指定服务名称
        String serviceName="microservice-user";
        //2.2 拼接目标url
        String url="http://"+serviceName+"/user/detail/"+orders.getUserId();
        String json=restTemplate.getForEntity(url, String.class).getBody();
        //解析json，取到json中的loginName属性
        JSONObject obj= JSON.parseObject(json);
        String loginName=obj.getString("loginName");*/
        OrdersUserVo ordersUserVo=new OrdersUserVo();
        BeanUtils.copyProperties(orders, ordersUserVo);
        ordersUserVo.setLoginName(ordersUserDto.getLoginName());
        return ordersUserVo;
    }
}
