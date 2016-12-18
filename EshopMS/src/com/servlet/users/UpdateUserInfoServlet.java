package com.servlet.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UserDao;
import com.daoFactory.UserDaoFactory;
/**
 * 修改用户信息的控制类
 * @version 1.0.0
 */
public class UpdateUserInfoServlet extends HttpServlet {

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("userID");
		String password=request.getParameter("password");
	
		User u=new User();
		
		u.setUserID(id);
		u.setPassword(password);
		
		HttpSession session=request.getSession();
	
		UserDao dao=new UserDaoFactory().getUserDaoInstance();
			
		boolean flag=dao.updateUserPwd(u);
			
		if(flag){
		 request.getSession().setAttribute("update", "修改成功!");
		 response.sendRedirect("/server/servlet/GetUsersInfoServlet");
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
