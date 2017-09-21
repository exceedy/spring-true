package com.situ.ssm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.ssm.pojo.Banji;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.service.IBanjiService;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

@Controller
@RequestMapping(value = "student")
public class StudentController {
	@Resource(name = "studentService")
	private IStudentService studentService;

	@Resource(name = "banjiService")
	private IBanjiService banjiService;

	@RequestMapping(value = "findAll")
	public void findAll() {
		List<Student> list = studentService.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@RequestMapping(value = "pageList")
	public String pageList(String name, String gender, String age, String address, String birthday, String pageIndex,
			String pageSize, String banji, Model model) {
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
		if (birthday != null && !"".equals(birthday.trim())) {
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

	@RequestMapping(value = "deleteStudent")
	public String deleteStudent(Integer id) {
		studentService.deleteStudent(id);
		return "redirect:/student/pageList.action";
	}

	@RequestMapping(value = "deleteAll")
	public String deleteAll(Integer[] selectIds) {
		for (Integer id : selectIds) {
			studentService.deleteStudent(id);
		}
		return "redirect:/student/pageList.action";
	}

	@RequestMapping(value = "toAddStudent")
	public String toAddStudent(Model model) {
		List<Banji> banjiList = banjiService.banjiList();
		model.addAttribute("banjiList", banjiList);
		return "add_student";
	}

	@RequestMapping(value = "addStudent")
	public String addStudent(String name, String address, String gender, Integer age, String birthday, Integer banjiId,
			Model model) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (birthday != null && !"".equals(birthday.trim())) {
			try {
				date = simpleDateFormat.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Banji banji = new Banji();
		banji.setId(banjiId);
		Student student = new Student(name, address, gender, age, date, banji);
		System.out.println(student);
		studentService.addStudent(student);
		return "redirect:/student/pageList.action";
	}
	
	@RequestMapping(value="toUpdateStudent")
	public String toUpdateStudent(Integer id,Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("student", student);
		
		
		List<Banji> banjiList = banjiService.banjiList();
		model.addAttribute("banjiList", banjiList);
		return "update_student";
	}
	
	public String updateStudent(String name, String address, String gender, Integer age, String birthday, Integer banjiId) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Banji banji = new Banji();
		banji.setId(banjiId);
		Student student = new Student(name, address, gender, age, date, banji);
		studentService.updateStudent(student);
		return "redirect:/student/pageList.action";
	}

}
