package com.bean;
/**
 * 订单类
 * @version 1.0.0
 */
public class OrderForm {

	/**
	 * 订单ID号
	 */
	private String orderFormID;
	
	/**
	 * 用户号
	 */
	private String userID;
	
	/**
	 * 商品号
	 */
	private String goodsID;
	
	/**
	 * 提交订单时间
	 */
	private String submitTime;
	
	/**
	 * 发货时间
	 */
	private String consignmentTime;
	
	/**
	 * 总金额
	 */
	private String totalPrice;
	
	/**
	 * 是否付款
	 */
	private String isPayoff;
	
	/**
	 * 是否发货
	 */
	private String isConsignmenet;
	
	public OrderForm(){
		
	}

	public String getOrderFormID() {
		return orderFormID;
	}

	public void setOrderFormID(String orderFormID) {
		this.orderFormID = orderFormID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getConsignmentTime() {
		return consignmentTime;
	}

	public void setConsignmentTime(String consignmentTime) {
		this.consignmentTime = consignmentTime;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getIsPayoff() {
		return isPayoff;
	}

	public void setIsPayoff(String isPayoff) {
		this.isPayoff = isPayoff;
	}

	public String getIsConsignmenet() {
		return isConsignmenet;
	}

	public void setIsConsignmenet(String isConsignmenet) {
		this.isConsignmenet = isConsignmenet;
	}
	
	
}


