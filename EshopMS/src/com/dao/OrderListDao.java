package com.dao;

import java.util.ArrayList;
/**
 * 订单列表信息的实体类
 * @version 1.0.0
 */
public interface OrderListDao {

	/**
	 * 通过订单号获取订单列表信息
	 */
	public ArrayList getOrderList(String id);
}
