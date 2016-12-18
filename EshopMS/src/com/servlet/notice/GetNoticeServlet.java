package com.servlet.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Notice;
import com.dao.NoticeDao;
import com.daoFactory.NoticeDaoFactory;
/**
 * 获取所有商城公告信息的控制类
 * @version 1.0.0
 */
public class GetNoticeServlet extends HttpServlet {


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
		
		ArrayList<Notice> list=new ArrayList<Notice>();
		
		NoticeDao dao=new NoticeDaoFactory().getNoticeDaoInstance();
		list=dao.getAllInfo();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("notice",list);
		
		response.sendRedirect("/server/view/notice/notice.jsp");
		
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
