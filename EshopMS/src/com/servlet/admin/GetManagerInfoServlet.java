package com.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Admin;
import com.dao.AdminDao;
import com.daoFactory.AdminDaoFactory;
/**
 * 获取管理员信息的控制类
 * @version 1.0.0
 */
public class GetManagerInfoServlet extends HttpServlet {

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
		
		HttpSession session=request.getSession();
		
		String id=(String)session.getAttribute("adminID");
		
		AdminDao dao=new AdminDaoFactory().getAdminDaoInstance();
		
		Admin a=dao.getManagerInfo(id);
		
		session.setAttribute("managerInfo", a);
		
		response.sendRedirect("/server/view/admin/personalInfo.jsp");
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
