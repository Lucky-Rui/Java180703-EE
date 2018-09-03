package com.situ.student.entity;

import java.util.List;

public class Student_PageBean {
	//当前是第几页
	private Integer pageNo;
	//一页有多少数据
	private Integer pageSize;
	//总记录数	
	private Integer totalCount;
	//一共有多少页		totalPage = Math.ceil(totalCount/pageSize)
	private Integer totalPage;
	//当前页的数据
	private List<Student> list;
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", list=" + list + "]";
	}
	
	
	
}
