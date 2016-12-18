package com.dao;

import java.util.ArrayList;

import com.bean.OrderForm;
import com.bean.OrderList;

/**
 * 订单信息的实体类
 * @version 1.0.0
 */
public interface OrderFormDao {

	/**
	 * 生成订单
	 */
	public boolean orderForm(OrderForm o);
	
	/**
	 * 订单列表
	 */
	public boolean orderList(OrderList o);
	
	/**
	 * 获取订单表的记录数
	 */
	public int getCount();
	
	/**
	 * 获取订单列表的记录数
	 */
	public int getOrderListCount();
	
	/**
	 * 查看购物车
	 */
	public ArrayList getShoppingCarInfo(String id);
	
	/**
	 * 删除订单信息
	 */
	public boolean deleteOrderFormInfo(String id);
	
	/**
	 * 删除订单列表信息
	 */
	public boolean deleteOrderListInfo(String id);
}
