package com.servlet.goodsClass;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.GoodsClass;
import com.dao.GoodsClassDao;
import com.dao.NoticeDao;
import com.daoFactory.GoodsClassDaoFactory;
import com.daoFactory.NoticeDaoFactory;

/**
 * 获取商品种类信息的控制类
 * @version 1.0.0
 */
public class GetGoodsClassServlet extends HttpServlet {

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
		
		ArrayList<GoodsClass> list=new ArrayList<GoodsClass>();
		
		GoodsClassDao dao=new GoodsClassDaoFactory().getGoodsClassDaoInstance();
		
		
		list=dao.getGoodsClass();
		
		HttpSession session=request.getSession();
		session.setAttribute("goodsClass", list);
		
		response.sendRedirect("/client/view/frame/left.jsp");
				
		
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
