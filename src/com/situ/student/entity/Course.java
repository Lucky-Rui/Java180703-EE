package com.situ.student.entity;

/**
 * 课程表
 * 
 * @author WANGRUI
 *
 */
public class Course {
	private Integer id;
	private String name;

	public Course(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
