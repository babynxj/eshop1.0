package com.servlet.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.GoodsClass;
import com.bean.Notice;
import com.dao.GoodsClassDao;
import com.dao.NoticeDao;
import com.daoFactory.GoodsClassDaoFactory;
import com.daoFactory.NoticeDaoFactory;
/**
 * 添加商城公告信息的控制类
 * @version 1.0.0
 */
public class AddNoticeServlet extends HttpServlet {


	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String noticeID=request.getParameter("noticeID");
		String noticeContent=request.getParameter("noticeContent");
		
		Notice notice=new Notice();
		notice.setNoticeID(noticeID);
		notice.setNoticeContent(noticeContent);
		
		NoticeDao dao=new NoticeDaoFactory().getNoticeDaoInstance();
		
		if(dao.isIdExist(noticeID)){
			response.sendRedirect("/server/view/notice/addNotice.jsp");
		}else{
			boolean flag=dao.addNotice(notice);
			response.sendRedirect("/server/servlet/GetNoticeServlet");
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
