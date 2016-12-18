package com.dao;

import java.util.ArrayList;

import com.bean.GoodsClass;
/**
 * 商品种类信息的实体类
 * @version 1.0.0
 */
public interface GoodsClassDao {
	
	/**
	 * 获取商品种类的所有信息
	 */
	public ArrayList<GoodsClass> getAllInfo();

	/**
	 * 添加商品种类信息
	 */
	public boolean addGoodsClass(GoodsClass g);
	
	/**
	 * 修改商品种类信息
	 */
	public boolean updateGoodsClass(GoodsClass g);
	
	/**
	 * 删除商品种类信息
	 */
	public boolean clearGoodsClass(String id);
	
	
	/**
	 * 通过商品种类号获取商品种类信息
	 */
	public GoodsClass getGoodsClassInfoById(String id);
	
	/**
	 * 获取商品种类表里的数据行数
	 */
	public int getCount();
	
	/**
	 * 验证商品种类号是否被已经存在
	 */
	public boolean isIdExist(String id);
	
	/**
	 * 获取商品种类名
	 */
	public ArrayList<GoodsClass> getGoodsClassName();
	
	
	/**
	 * 通过商品种类名获取商品种类号
	 */
	public String getGoodsClassID(String goodsClassName);
}
