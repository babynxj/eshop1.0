package com.bean;

/**
 * 商品种类类
 * @version 1.0.0
 */
public class GoodsClass {

	/**
	 * 商品类别号
	 */
	private String goodsClassID;
	
	/**
	 * 商品类型名
	 */
	private String goodsClassName;
	
	public GoodsClass(){
		
	}

	public String getGoodsClassID() {
		return goodsClassID;
	}

	public void setGoodsClassID(String goodsClassID) {
		this.goodsClassID = goodsClassID;
	}

	public String getGoodsClassName() {
		return goodsClassName;
	}

	public void setGoodsClassName(String goodsClassName) {
		this.goodsClassName = goodsClassName;
	}
	
}
