package com.daoFactory;

import com.dao.OrderListDao;
import com.daoImpl.OrderListDaoImpl;

public class OrderListDaoFactory {

	public OrderListDao getOrderLsitDaoInstance(){
		return new OrderListDaoImpl();
	}
}
