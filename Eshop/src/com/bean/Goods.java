package com.bean;

/**
 * 商品信息类
 * @version 1.0.0
 */
public class Goods {

	/**
	 * 商品号
	 */
	private String goodsID;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品类别号
	 */
	private String goodsClassID;
	
	/**
	 * 商品图片
	 */
	private String goodsImg;
	
	/**
	 * 商品描述
	 */
	private String goodsDepict;
	
	/**
	 * 商品价格
	 */
	private String goodsPrice;
	
	/**
	 * 商品总数量
	 */
	private String goodsAmount;
	
	/**
	 * 商品剩余数量
	 */
	private String goodsLeaveNum;
	
	/**
	 * 商品上架时间
	 */
	private String regTime;
	
	/**
	 * 供应商
	 */
	private String manufacturer;
	
	public Goods(){
		
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsClassID() {
		return goodsClassID;
	}

	public void setGoodsClassID(String goodsClassID) {
		this.goodsClassID = goodsClassID;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public String getGoodsDepict() {
		return goodsDepict;
	}

	public void setGoodsDepict(String goodsDepict) {
		this.goodsDepict = goodsDepict;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(String goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public String getGoodsLeaveNum() {
		return goodsLeaveNum;
	}

	public void setGoodsLeaveNum(String goodsLeaveNum) {
		this.goodsLeaveNum = goodsLeaveNum;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
}
