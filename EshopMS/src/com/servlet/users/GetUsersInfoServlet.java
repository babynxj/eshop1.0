package com.servlet.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.daoFactory.UserDaoFactory;
/**
 * 获取所有用户信息的控制类
 * @version 1.0.0
 */
public class GetUsersInfoServlet extends HttpServlet {

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
	
		String id=request.getParameter("account");
		ArrayList<User> list = new ArrayList<User>();
		
		UserDaoFactory df=new UserDaoFactory();
		
		list=df.getUserDaoInstance().getAllInfo();
		
		HttpSession session=request.getSession();
		session.setAttribute("usersInfo", list);
		
		response.sendRedirect("/server/view/users/usersInfo.jsp");
		
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
