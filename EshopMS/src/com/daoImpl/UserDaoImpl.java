package com.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.User;
import com.dao.UserDao;
import com.util.DBConnection;

/**
 * 用户信息的实现类
 * @version 1.0.0
 */
public class UserDaoImpl implements UserDao{

	Connection conn;
	PreparedStatement sta;
	ResultSet res;
	
	/**
	 * 获取会员的所有信息
	 */
	public ArrayList<User> getAllInfo() {
		ArrayList<User> list = new ArrayList<User>();
		conn = new DBConnection().getConnection();
		String sql = "select * from users";
		try {
			sta = conn.prepareStatement(sql);
			res = sta.executeQuery();	
			while(res.next()){
				User u = new User();
				u.setUserID(String.valueOf(res.getInt("userID")));
				u.setUserName(res.getString("userName"));
				u.setUserSex(res.getString("userSex"));
				u.setPassword(res.getString("password"));
				u.setAddress(res.getString("address"));
				u.setPhone(res.getString("phone"));
				u.setEmial(res.getString("email"));
				u.setRegTime(res.getString("regTime"));
				u.setPostcode(String.valueOf(res.getInt("postcode")));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return list;
	}
	
	/**
	 * 通过会员号查找会员的信息
	 */
	public User getUserInfoById(String id) {
		User u=new User();
		conn=new DBConnection().getConnection();
		String sql="select * from users where userID=?";
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			res=sta.executeQuery();
			while(res.next()){
				u.setUserID(String.valueOf(res.getInt("userID")));
				u.setUserName(res.getString("userName"));
				u.setUserSex(res.getString("userSex"));
				u.setPassword(res.getString("password"));
				u.setAddress(res.getString("address"));
				u.setPhone(res.getString("phone"));
				u.setEmial(res.getString("email"));
				u.setRegTime(String.valueOf(res.getDate("regTime")));
				u.setPostcode(String.valueOf(res.getInt("postcode")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return u;
	}
	
	/**
	 * 修改会员信息
	 */
	public boolean updateUserPwd(User u) {
		boolean flag=false;
		conn=new DBConnection().getConnection();
		
		String sql="update users set password=? where userID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setString(1, u.getPassword());
			sta.setInt(2, Integer.parseInt(u.getUserID()));
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
	 * 删除会员信息
	 */
	public boolean deleteUserInfo(String id) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="delete from users where userID=?";
		
		try {
			sta=conn.prepareStatement(sql);
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
	
}
