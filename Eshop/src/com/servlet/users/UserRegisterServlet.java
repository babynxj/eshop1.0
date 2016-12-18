package com.servlet.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;
import com.daoFactory.UserDaoFactory;
/**
 * 用户注册的控制类
 * @version 1.0.0
 */
public class UserRegisterServlet extends HttpServlet {

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String userID=request.getParameter("userID");
		String userName=request.getParameter("userName");
		String userSex=request.getParameter("userSex");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String phone=request.getParameter("address");
		String email=request.getParameter("email");
		
		Calendar cal=new GregorianCalendar();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		int day=cal.get(Calendar.DAY_OF_MONTH);
			
		String yearStr=String.valueOf(year);
		String monthStr=String.valueOf(month);
		String dayStr=String.valueOf(day);
			
		String regTime=yearStr+"-"+monthStr+"-"+dayStr;
		
		String postcode=request.getParameter("postcode");
		
		User u=new User();
		u.setUserID(userID);
		u.setUserName(userName);
		u.setUserSex(userSex);
		u.setPassword(password);
		u.setAddress(address);
		u.setPhone(phone);
		u.setEmail(email);
		u.setRegTime(regTime);
		u.setPostcode(postcode);
		
		UserDao dao=new UserDaoFactory().getUserDaoInstance();
		
		if(dao.isUserIdExist(userID)){
			response.sendRedirect("/client/view/users/userIdIsExist.jsp");
		}else{
			dao.register(u);
			response.sendRedirect("/client/view/goods/ad.jsp");
		}
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
