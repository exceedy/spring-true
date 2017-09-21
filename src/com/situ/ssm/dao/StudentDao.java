package com.situ.ssm.dao;

import java.util.List;

import com.situ.ssm.pojo.Student;
import com.situ.ssm.vo.SearchCondition;

public interface StudentDao {
	/**
	 * 查询所有学生
	 * @return
	 */
	List<Student> findAll();
	
	/**
	 * 获取分页集合
	 * @param searchCondition
	 * @return
	 */
	List<Student> pageList(SearchCondition searchCondition);
	
	/**
	 * 获取总数
	 * @param searchCondition
	 * @return
	 */
	Integer getCount(SearchCondition searchCondition);
	
	/**
	 * 添加学生
	 * @param student
	 */
	
	void addStudent(Student student);
	
	/**删除学生
	 * 
	 * @param id
	 */
	void deleteStudent(Integer id);
	
	/**
	 * 修改学生信息
	 * @param student
	 */
	void updateStudent(Student student);
	
	/**
	 * 根据id 查询学生
	 * @param id
	 * @return
	 */
	Student findById(Integer id);
}
