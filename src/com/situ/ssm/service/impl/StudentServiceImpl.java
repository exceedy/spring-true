package com.situ.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.ssm.dao.StudentDao;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

@Service("studentService")
public class StudentServiceImpl implements IStudentService{
		@Resource(name="studentDao")
		private StudentDao studentDao;

		public List<Student> findAll() {
			return studentDao.findAll();
		}

		public PageBean<Student> pageList(SearchCondition searchCondition) {
			PageBean<Student> pageBean = new PageBean<Student>();
			Integer pageIndex = searchCondition.getPageIndex();
			
			pageBean.setPageIndex(pageIndex);
			Integer pageSize = searchCondition.getPageSize();
			
			pageBean.setPageSize(pageSize);
			searchCondition.setPageIndex((pageIndex - 1) * pageSize);
			Integer totalCount = studentDao.getCount(searchCondition);
			
			pageBean.setTotalCount(totalCount);

			Integer totalPage = (int)Math.ceil(1.0 * totalCount / pageSize);
			
			pageBean.setTotalPage(totalPage);
			
			List<Student> list = studentDao.pageList(searchCondition);
			pageBean.setList(list);
			return pageBean;
		}

		public void deleteStudent(Integer id) {
			studentDao.deleteStudent(id);
		}

		public void addStudent(Student student) {
				studentDao.addStudent(student);
		}

		public Student findById(Integer id) {
			return studentDao.findById(id);
		}

		public void updateStudent(Student student) {
			studentDao.updateStudent(student);
		}
}
