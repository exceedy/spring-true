package com.situ.ssm.dao;

import java.util.List;

import com.situ.ssm.pojo.Student;
import com.situ.ssm.vo.SearchCondition;

public interface StudentDao {
	List<Student> findAll();
	List<Student> pageList(SearchCondition searchCondition);
	Integer getCount(SearchCondition searchCondition);
	void addStudent(Student student);
	void deleteStudent(Integer id);
	void updateStudent(Student student);
	Student selectById(Integer id);
}
