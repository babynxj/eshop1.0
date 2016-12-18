package com.servlet.orderForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderFormDao;
import com.daoFactory.OrderFormDaoFactory;

/**
 * 删除订单的控制类
 * @version 1.0.0
 */
public class DeleteOrderFormInfoServlet extends HttpServlet {

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
		
		String id=request.getParameter("id");
		
		OrderFormDao dao1=new OrderFormDaoFactory().getOrderFormDaoInstance();
		
		
		boolean flag1=dao1.deleteOrderListInfo(id);
		
		boolean flag2=dao1.deleteOrderFormInfo(id);
		
		if(flag1&flag2){
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
