package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.GoodsClass;
import com.dao.GoodsClassDao;
import com.util.DBConnection;

/**
 * 商品种类信息的实现类
 * @version 1.0.0
 */
public class GoodsClassDaoImpl implements GoodsClassDao{

	Connection conn;
	PreparedStatement sta;
	ResultSet res;
	/**
	 * 获取商品种类名
	 */
	public ArrayList<GoodsClass> getGoodsClass() {
		ArrayList<GoodsClass> list=new ArrayList<GoodsClass>();
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from goodsClass";
		
		try {
			sta=conn.prepareStatement(sql);
			
			res=sta.executeQuery();
			
			while(res.next()){
				GoodsClass g=new GoodsClass();
				g.setGoodsClassID(String.valueOf(res.getInt("goodsClassID")));
				g.setGoodsClassName(res.getString("goodsClassName"));
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
	 * 通过商品种类名获取商品种类号
	 */
	public String getGoodsClassID(String goodsClassName) {
		String goodsClassID="";
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from goodsClass where goodsClassName=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setString(1, goodsClassName);
			
			res=sta.executeQuery();
			
			if(res.next()){
				goodsClassID=String.valueOf(res.getInt("goodsClassID"));
			}else{
				goodsClassID="";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		
		return goodsClassID;
	}
	
}
