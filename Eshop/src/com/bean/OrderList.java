package com.bean;

/**
 * 订单列表类
 * @version 1.0.0
 */
public class OrderList {

	/**
	 * 订单列表ID号
	 */
	private String orderListID;
	
	/**
	 * 订单ID号
	 */
	private String orderFormID;
	
	/**
	 * 商品ID号
	 */
	private String goodsID;
	
	/**
	 * 商品数量
	 */
	private String amount;
	
	public OrderList(){
		
	}

	public String getOrderListID() {
		return orderListID;
	}

	public void setOrderListID(String orderListID) {
		this.orderListID = orderListID;
	}

	public String getOrderFormID() {
		return orderFormID;
	}

	public void setOrderFormID(String orderFormID) {
		this.orderFormID = orderFormID;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
