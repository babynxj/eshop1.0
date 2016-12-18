package com.dao;

import java.util.ArrayList;

import com.bean.GoodsClass;

/**
 * 商品种类信息的实体类
 * @version 1.0.0
 */
public interface GoodsClassDao {

	/**
	 * 获取商品种类名
	 */
	public ArrayList<GoodsClass> getGoodsClass();
	
	/**
	 * 通过商品种类名获取商品种类编号
	 */
	public String getGoodsClassID(String goodsClassName);
}
