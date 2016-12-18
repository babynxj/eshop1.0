package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import com.bean.Goods;
/**
 * 商品信息的实体类
 * @version 1.0.0
 */
public interface GoodsDao {

	/**
	 * 获取所有商品信息
	 */
	public ArrayList getAllInfo();
	
	/**
	 * 商品上架
	 */
	public boolean itemUpshelf(Goods g,String goodsClassName);
	
	/**
	 * 修改商品信息
	 */
	public boolean updateGoodsInfo(Goods g,String goodsClassName);
	
	/**
	 * 商品下架
	 */
	public boolean clearGoodsInfo(String id);
	
	/**
	 * 通过商品号获取商品信息
	 */
	public Vector getGoodsInfoById(String id);
	
	/**
	 * 判断商品号是否已经存在
	 */
	public boolean isIdExist(String id);
	
	/**
	 * 将图片的路径写入数据库
	 */
	public boolean getImgPath(String id,String path);
}
