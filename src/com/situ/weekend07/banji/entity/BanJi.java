package com.situ.weekend07.banji.entity;

public class BanJi {
	private Integer classId;
	private String className;

	public BanJi() {
		// TODO Auto-generated constructor stub
	}

	public BanJi(String className) {
		super();
		this.className = className;
	}

	public BanJi(Integer classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "banji [classId=" + classId + ", className=" + className + "]";
	}
}
