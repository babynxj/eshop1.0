package com.daoFactory;

import com.dao.OrderListDao;
import com.daoImpl.OrderListDaoImpl;
/**
 * 订单列表信息的DaoFactory类
 * @version 1.0.0
 */
public class OrderListDaoFactory {

	public OrderListDao getOrderListDaoInstance(){
		return new OrderListDaoImpl();
	}
}
