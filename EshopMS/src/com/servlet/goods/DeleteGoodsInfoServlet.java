package com.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDao;
import com.daoFactory.GoodsDaoFactory;
/**
 * 生成商品信息的控制类
 * @version 1.0.0
 */
public class DeleteGoodsInfoServlet extends HttpServlet {

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
		
		String id=request.getParameter("id");
		
		GoodsDao dao=new GoodsDaoFactory().getGoodsDaoInstance();
		
		boolean flag=dao.clearGoodsInfo(id);
		
		if(flag){
			response.sendRedirect("/server/servlet/GetGoodsInfoServlet");
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}

	/**
	 *
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
