package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Goods;
import com.dao.GoodsClassDao;
import com.dao.GoodsDao;
import com.daoFactory.GoodsClassDaoFactory;
import com.util.DBConnection;
/**
 * 商品信息的实现类
 * @version 1.0.0
 */
public class GoodsDaoImpl implements GoodsDao{

	Connection conn;
	PreparedStatement sta;
	ResultSet res;
	
	/**
	 * 通过商品种类号获取该类商品的所有信息
	 */
	public ArrayList<Goods> getGoodsInfo(String goodsClassID) {
		
		ArrayList<Goods> list=new ArrayList<Goods>();
		
		conn=new DBConnection().getConnection();
		//两个表的SQL查询
		String sql="select * from goods,goodsClass where goods.goodsClassID=? " +
				"and goods.goodsClassID=goodsClass.goodsClassID";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(goodsClassID));
			
			res=sta.executeQuery();
			
			while(res.next()){
				Goods g=new Goods();
				g.setGoodsID(String.valueOf(res.getInt("goodsID")));
				g.setGoodsName(res.getString("goodsName"));
				g.setGoodsImg(res.getString("goodsImg"));
				g.setGoodsPrice(String.valueOf(res.getFloat("goodsPrice")));
				list.add(g);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return list;
	}

	/**
	 * 通过商品号获取商品信息
	 */
	public Goods getGoodsInfoById(String id) {
		Goods goods=new Goods();
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from goods where goodsID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			res=sta.executeQuery();
			
			while(res.next()){
				goods.setGoodsID(String.valueOf(res.getInt("goodsID")));
				goods.setGoodsName(res.getString("goodsName"));
				goods.setGoodsDepict(res.getString("goodsDepict"));
				goods.setGoodsImg(res.getString("goodsImg"));
				goods.setGoodsLeaveNum(String.valueOf(res.getInt("goodsLeaveNum")));
				goods.setGoodsPrice(String.valueOf(res.getFloat("goodsPrice")));
				goods.setManufacturer(res.getString("manufacturer"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return goods;
	}

}
