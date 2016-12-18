package com.bean;

/**
 * 商城公告类
 * @version 1.0.0
 */
public class Notice {
	
	/**
	 * 公告号
	 */
	private String noticeID;
	
	/**
	 * 公告内容
	 */
	private String noticeContent;

	public Notice(){
		
	}

	public String getNoticeID() {
		return noticeID;
	}

	public void setNoticeID(String noticeID) {
		this.noticeID = noticeID;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
}
