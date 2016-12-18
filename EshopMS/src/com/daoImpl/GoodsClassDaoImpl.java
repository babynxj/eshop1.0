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
	 * 添加商品种类信息
	 */
	public boolean addGoodsClass(GoodsClass g) {
		boolean flag = false;
		conn=new DBConnection().getConnection();
		
		String sql="insert into goodsClass values(?,?)";
		
		try {
			sta = conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(g.getGoodsClassID()));
			sta.setString(2, g.getGoodsClassName());
			
			int i=sta.executeUpdate();
			
			if(i>0){
				flag=true;
			}else{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return flag;
	}

	/**
	 * 删除商品种类信息
	 */
	public boolean clearGoodsClass(String id) {
		boolean flag = false;
		conn=new DBConnection().getConnection();
		
		String sql="delete from goodsclass where goodsClassID=?";
		
		try {
			sta = conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			int i=sta.executeUpdate();
			
			if(i>0){
				flag=true;
			}else{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return flag;
	}

	/**
	 * 修改商品种类信息
	 */
	public boolean updateGoodsClass(GoodsClass g) {
		boolean flag = false;
		conn=new DBConnection().getConnection();
		
		String sql="update goodsclass set goodsClassName=? where goodsClassID=?";
		
		try {
			sta = conn.prepareStatement(sql);
			sta.setString(1, g.getGoodsClassName());
			sta.setInt(2, Integer.parseInt(g.getGoodsClassID()));
			
			int i=sta.executeUpdate();
			
			if(i>0){
				flag=true;
			}else{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return flag;
	}

	/**
	 * 获取商品种类的所有信息
	 */
	public ArrayList<GoodsClass> getAllInfo() {
		ArrayList<GoodsClass> list=new ArrayList<GoodsClass>();
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from goodsclass";
		
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
	 * 通过商品种类号获取商品种类信息
	 */
	public GoodsClass getGoodsClassInfoById(String id) {
		GoodsClass g=new GoodsClass();
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from goodsclass where goodsClassID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
				
			res=sta.executeQuery();
			
			while(res.next()){
				g.setGoodsClassID(String.valueOf(res.getInt("goodsClassID")));
				g.setGoodsClassName(res.getString("goodsClassName"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return g;
	}

	/**
	 * 获取商品种类表里的数据行数
	 */
	public int getCount() {
		int count=0;
		
		conn=new DBConnection().getConnection();
		
		String sql="select count(*) from goodsclass";
		
		try {
			sta=conn.prepareStatement(sql);
			
			res=sta.executeQuery();
			
			while(res.next()){
				count=res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return count;
	}
	
	/**
	 * 验证商品种类号是否已经存在
	 */
	public boolean isIdExist(String id){
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from goodsclass where goodsClassID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			res=sta.executeQuery();
			
			if(res.next()){
				flag=true;
			}else{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return flag;
	}

	/**
	 * 获取商品种类名
	 */
	public ArrayList<GoodsClass> getGoodsClassName() {
		ArrayList<GoodsClass> list=new ArrayList<GoodsClass>();
		
		conn=new DBConnection().getConnection();
		
		String sql="select goodsClassName from goodsClass";
		
		try {
			sta=conn.prepareStatement(sql);
			
			res=sta.executeQuery();
			
			while(res.next()){
				GoodsClass g=new GoodsClass();
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
