package com.servlet.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.daoFactory.UserDaoFactory;
/**
 * 删除用户信息的控制类
 * @version 1.0.0
 */
public class DeleteUserInfoServlet extends HttpServlet {

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
		
		HttpSession session=request.getSession();
		
		String id=request.getParameter("id");
		
		UserDao dao=new UserDaoFactory().getUserDaoInstance();
		
		boolean flag=dao.deleteUserInfo(id);
		
		if(flag){
			request.getSession().setAttribute("delete", "删除成功!");
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
