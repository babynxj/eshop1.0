package com.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	 * 用户注册
	 */
	public boolean register(User u) {
		boolean flag=false;
		conn=new DBConnection().getConnection();
		
		String sql="insert into users value(?,?,?,?,?,?,?,?,?)";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(u.getUserID()));
			sta.setString(2, u.getUserName());
			sta.setString(3, u.getUserSex());
			sta.setString(4, u.getPassword());
			sta.setString(5, u.getAddress());
			sta.setString(6, u.getPhone());
			sta.setString(7, u.getEmail());
			sta.setDate(8, Date.valueOf(u.getRegTime()));
			sta.setInt(9, Integer.parseInt(u.getPostcode()));
	
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
	 * 用户登录验证
	 */
	public boolean checkLogin(String id,String pwd) {
		boolean flag=false;
		conn=new DBConnection().getConnection();
		String sql="select * from users where userID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			res=sta.executeQuery();
			if(res.next()){
				String userID=String.valueOf(res.getInt("userID"));
				String userPwd=res.getString("password");
				if(id.equals(userID)&&pwd.equals(userPwd)){
					flag=true;
				}else{
					flag=false;
				}
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
	 * 通过账号获取用户信息
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
				u.setEmail(res.getString("email"));
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
	 * 判断用户账号是否被注册过
	 */
	public boolean isUserIdExist(String id) {
		boolean flag=false;
		conn=new DBConnection().getConnection();
		
		String sql="select * from users where userID=?";
		
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

}
