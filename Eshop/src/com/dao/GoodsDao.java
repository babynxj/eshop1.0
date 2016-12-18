package com.dao;

import java.util.ArrayList;

import com.bean.Goods;

/**
 * 商品信息的实体类
 * @version 1.0.0
 */
public interface GoodsDao {

	/**
	 * 获取某类商品的所有商品信息
	 */
	public ArrayList<Goods> getGoodsInfo(String goodsClassID);
	
	/**
	 * 通过商品号获取商品信息
	 */
	public Goods getGoodsInfoById(String id);
	
	
}
