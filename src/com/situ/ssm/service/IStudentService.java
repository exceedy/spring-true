package com.situ.ssm.service;

import java.util.List;

import com.situ.ssm.pojo.Student;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

public interface IStudentService {
		List<Student> findAll();
		PageBean<Student> pageList(SearchCondition searchCondition);
		void deleteStudent(Integer id);
		void addStudent(Student student);
}
