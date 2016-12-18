package com.dao;

import java.util.ArrayList;
import java.util.Vector;
/**
 * 订单信息的实体类
 * @version 1.0.0
 */
public interface OrderFormDao {

	/**
	 * 获取所有订单信息
	 */
	public ArrayList getAllInfo();
	
	/**
	 * 通过订单编号获取订单信息
	 */
	public Vector getOrderFormInfoById(String id);
	
    /**
     * 删除订单
     */
	public boolean deleteOrderFormOnfo(String id);
	
	/**
	 * 发货
	 */
	public boolean deliverGoods(String id);
	
}
