package com.situ.ssm.vo;

import com.situ.ssm.pojo.Banji;
import com.situ.ssm.pojo.Student;

public class SearchCondition {
	private Integer pageIndex;
	private Integer pageSize;
	private Student student;
	private Banji banji;
	
	public SearchCondition(Integer pageIndex, Integer pageSize, Student student) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.student = student;
	}
	public SearchCondition() {
		super();
	}
	
	
	public SearchCondition(Integer pageIndex, Integer pageSize, Banji banji) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.banji = banji;
	}
	public Banji getBanji() {
		return banji;
	}
	public void setBanji(Banji banji) {
		this.banji = banji;
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
		return "SearchCondition [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", student=" + student
				+ ", banji=" + banji + "]";
	}
	
	
	
}
