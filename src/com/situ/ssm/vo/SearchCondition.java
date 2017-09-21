package com.situ.ssm.vo;

import com.situ.ssm.pojo.Banji;
import com.situ.ssm.pojo.Coures;
import com.situ.ssm.pojo.Student;

public class SearchCondition {
	private Integer pageIndex;
	private Integer pageSize;
	private Student student;
	private Banji banji;
	private Coures coures;
	
	/**
	 * 包装学生
	 * @param pageIndex
	 * @param pageSize
	 * @param student
	 */
	public SearchCondition(Integer pageIndex, Integer pageSize, Student student) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.student = student;
	}
	/**
	 * 无参构造方法
	 */
	public SearchCondition() {
		super();
	}
	/**
	 * 包装课程
	 * @param pageIndex
	 * @param pageSize
	 * @param coures
	 */
	public SearchCondition(Integer pageIndex, Integer pageSize, Coures coures) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.coures = coures;
	}
	
	/**
	 * 包装班级和课程
	 * @param pageIndex
	 * @param pageSize
	 * @param banji
	 * @param coures
	 */
	public SearchCondition(Integer pageIndex, Integer pageSize, Banji banji, Coures coures) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.banji = banji;
		this.coures = coures;
	}
	/**
	 * 包装学生、班级和课程
	 * @param pageIndex
	 * @param pageSize
	 * @param student
	 * @param banji
	 * @param coures
	 */
	public SearchCondition(Integer pageIndex, Integer pageSize, Student student, Banji banji, Coures coures) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.student = student;
		this.banji = banji;
		this.coures = coures;
	}
	/**
	 * 包装班级
	 * @param pageIndex
	 * @param pageSize
	 * @param banji
	 */
	public SearchCondition(Integer pageIndex, Integer pageSize, Banji banji) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.banji = banji;
	}
	public Coures getCoures() {
		return coures;
	}
	public void setCoures(Coures coures) {
		this.coures = coures;
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
				+ ", banji=" + banji + ", coures=" + coures + "]";
	}
	
	
	
}
