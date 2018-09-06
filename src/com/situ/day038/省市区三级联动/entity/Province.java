package com.situ.day038.省市区三级联动.entity;

public class Province {
	private Integer id;
	private String province;
	private Integer sort;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Province(Integer id, String province, Integer sort) {
		super();
		this.id = id;
		this.province = province;
		this.sort = sort;
	}
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", province=" + province + ", sort=" + sort + "]";
	}
	
}
