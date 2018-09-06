package com.situ.day038.省市区三级联动.entity;

public class Area {
	private Integer id;
	private String area;
	private Integer city_id;

	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Area(Integer id, String area) {
		super();
		this.id = id;
		this.area = area;
	}

	public Area(Integer id, String area, Integer city_id) {
		super();
		this.id = id;
		this.area = area;
		this.city_id = city_id;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", area=" + area + ", city_id=" + city_id + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

}
