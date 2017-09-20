package com.situ.ssm.vo;

import com.situ.ssm.pojo.Student;

public class SearchCondition {
	private Integer pageIndex;
	private Integer pageSize;
	private Student student;
	
	public SearchCondition(Integer pageIndex, Integer pageSize, Student student) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.student = student;
	}
	public SearchCondition() {
		super();
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "SearchCondition [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", student=" + student + "]";
	}
	
	
	
}
