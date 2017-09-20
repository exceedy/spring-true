package com.situ.ssm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.joda.DateTimeFormatterFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.situ.ssm.pojo.Banji;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

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
	@RequestMapping(value="pageList")
	public String pageList(String name, String gender, String age,String address,
			String birthday,String pageIndex, String pageSize, String banji, Model model) {
		SearchCondition searchCondition = new SearchCondition();
		int index = 1;
		if (pageIndex != null && !"".equals(pageIndex.trim())) {
			index = Integer.parseInt(pageIndex);
		}
		searchCondition.setPageIndex(index);
		Integer size = 3;
		if (pageSize != null && !"".equals(pageSize.trim())) {
			size = Integer.parseInt(pageSize);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (birthday != null && !"".equals(birthday.trim())){
		try {
			date = simpleDateFormat.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		searchCondition.setPageSize(size);
		Banji banjiName = new Banji(banji);
		Student student = new Student(name, address, gender, Integer.getInteger(age), date, banjiName);
		searchCondition.setStudent(student);
		PageBean<Student> pageBean = studentService.pageList(searchCondition);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("searchCondition", searchCondition);
		return "student_show";
	}
	
	@RequestMapping(value="deleteStudent")
	public String deleteStudent(Integer id) {
		studentService.deleteStudent(id);
		return "redirect:/student/pageList.action";
	}
	
	
}
