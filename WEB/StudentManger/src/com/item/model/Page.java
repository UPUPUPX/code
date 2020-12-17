package com.item.model;

public class Page {
	private int start;//起始页
	private int currentPage;//当前页
	private int pageSize;//每页显示数量
	public Page(int currentpage,int pageSize) {
		this.start=(currentpage-1)*pageSize;
		this.currentPage=currentpage;
		this.pageSize=pageSize;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}