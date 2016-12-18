package com.daoFactory;

import com.dao.OrderFormDao;
import com.daoImpl.OrderFormDaoImpl;

/**
 * 订单信息的DaoFactory类
 * @version 1.0.0
 */
public class OrderFormDaoFactory {

	public OrderFormDao getOrderFormDaoInstance(){
		return new OrderFormDaoImpl();
	}
}
