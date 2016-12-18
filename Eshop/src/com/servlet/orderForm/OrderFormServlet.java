package com.servlet.orderForm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderFormDao;
import com.daoFactory.OrderFormDaoFactory;

/**
 * 用户提交订单的控制类
 * @version 1.0.0
 */
public class OrderFormServlet extends HttpServlet {

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
		
		OrderFormDao dao=new OrderFormDaoFactory().getOrderFormDaoInstance();
		
		ArrayList list=new ArrayList();
		
		list=dao.getShoppingCarInfo(id);
		
		HttpSession session=request.getSession();
		session.setAttribute("shoppingCarInfo", list);
		
		
		response.sendRedirect("/client/view/shopping/showShoppingCar.jsp");
		
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
