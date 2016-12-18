package com.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

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
	 * 商品上架
	 */
	public boolean itemUpshelf(Goods g,String goodsClassName) {
		boolean flag = false;
		conn=new DBConnection().getConnection();
		
		GoodsClassDao dao=new GoodsClassDaoFactory().getGoodsClassDaoInstance();
		
		String sql="insert into goods(goodsID,goodsName,goodsClassID,goodsDepict,goodsPrice," +
				"goodsAmount,goodsLeaveNum,regTime,manufacturer) values(?,?,?,?,?,?,?,?,?)";
		
		try {
			sta = conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(g.getGoodsID()));
			sta.setString(2, g.getGoodsName());
			sta.setInt(3, Integer.parseInt(dao.getGoodsClassID(goodsClassName)));
			//sta.setString(4, g.getGoodsImg());
			sta.setString(4, g.getGoodsDepict());
			sta.setFloat(5, Float.parseFloat(g.getGoodsPrice()));
			sta.setInt(6, Integer.parseInt(g.getGoodsAmount()));
			sta.setInt(7, Integer.parseInt(g.getGoodsLeaveNum()));
			sta.setDate(8, Date.valueOf(g.getRegTime()));
			sta.setString(9, g.getManufacturer());			
			
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
	 * 商品下架
	 */
	public boolean clearGoodsInfo(String id) {
		boolean flag = false;
		conn=new DBConnection().getConnection();
		
		String sql="delete from goods where goodsID=?";
		
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
	 * 修改商品信息
	 */
	public boolean updateGoodsInfo(Goods g,String goodsClassName) {
		
		boolean flag = false;
		conn=new DBConnection().getConnection();
		
		String sql="update goods set goodsName=?,goodsClassID=?,goodsDepict=?," +
				"goodsPrice=? where goodsID=?";
		GoodsClassDao dao=new GoodsClassDaoFactory().getGoodsClassDaoInstance();
		
		try {
			sta = conn.prepareStatement(sql);
			sta.setString(1, g.getGoodsName());
			sta.setInt(2, Integer.parseInt(dao.getGoodsClassID(goodsClassName)));
			sta.setString(3, g.getGoodsDepict());
			sta.setFloat(4, Float.parseFloat(g.getGoodsPrice()));
			sta.setInt(5, Integer.parseInt(g.getGoodsID()));
			
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
	 * 获取所有商品的信息
	 */
	public ArrayList getAllInfo() {
		ArrayList list=new ArrayList();
		
		conn=new DBConnection().getConnection();
		
		String sql="select goodsID,goodsName,goodsClassName,goodsDepict,goodsPrice," +
				"goodsAmount,goodsLeaveNum,regTime,manufacturer from goods,goodsClass where goodsClass.goodsClassID=goods.goodsClassID";
		
		try {
			sta=conn.prepareStatement(sql);
			
			res=sta.executeQuery();
			
			while(res.next()){
				Vector v=new Vector();
				v.add(res.getInt("goodsID"));
				v.add(res.getString("goodsName"));
				v.add(res.getString("goodsClassName"));
				v.add(res.getString("goodsDepict"));
				v.add(res.getFloat("goodsPrice"));
				v.add(res.getInt("goodsAmount"));
				v.add(res.getInt("goodsLeaveNum"));
				v.add(res.getDate("regTime"));
				v.add(res.getString("manufacturer"));
				list.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return list;
	}

	/**
	 * 通过商品号获取商品的信息
	 */
	public Vector getGoodsInfoById(String id) {
		Vector v=new Vector();
		
		conn=new DBConnection().getConnection();
		
		String sql="select goodsID,goodsName,goodsClassName,goodsDepict,goodsPrice " +
				"from goods,goodsClass where goodsID=? and goodsClass.goodsClassID=goods.goodsClassID";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			res=sta.executeQuery();
			
			while(res.next()){
				v.add(res.getInt("goodsID"));
				v.add(res.getString("goodsName"));
				v.add(res.getFloat("goodsPrice"));
				v.add(res.getString("goodsClassName"));
				v.add(res.getString("goodsDepict"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return v;
	}

	/**
	 * 验证商品号是否存在
	 */
	public boolean isIdExist(String id) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from goods where goodsID=?";
		
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
	 * 将图片的路径写入数据库
	 */
	public boolean getImgPath(String id,String path) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="update goods set goodsImg=? where goodsID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setString(1, path);
			sta.setInt(2, Integer.parseInt(id));
			
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

}
