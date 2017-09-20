package com.situ.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.ssm.pojo.Student;
import com.situ.ssm.service.IStudentService;

@Controller
@RequestMapping(value="student")
public class StudentController {
	@Resource(name="studentService")
	private IStudentService studentService;	
	
	@RequestMapping(value="findAll")
	public void findAll() {
		List<Student> list = studentService.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
