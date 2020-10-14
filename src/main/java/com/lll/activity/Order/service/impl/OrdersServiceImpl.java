package com.lll.activity.Order.service.impl;

import com.lll.activity.Order.entity.Orders;
import com.lll.activity.Order.mapper.OrdersMapper;
import com.lll.activity.Order.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
