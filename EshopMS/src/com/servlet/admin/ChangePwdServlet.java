package com.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Admin;
import com.dao.AdminDao;
import com.daoFactory.AdminDaoFactory;

/**
 * 修改管理员密码的控制类
 * @version 1.0.0
 */
public class ChangePwdServlet extends HttpServlet {

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
		
		String id=request.getParameter("adminID");
		String pwd=request.getParameter("password");
		
		Admin a=new Admin();
		a.setAdminID(id);
		a.setPassword(pwd);
		
		AdminDao dao=new AdminDaoFactory().getAdminDaoInstance();
		
		boolean flag=dao.changePassword(a);
		
		if(flag){
			response.sendRedirect("/server/servlet/GetManagerInfoServlet");
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
