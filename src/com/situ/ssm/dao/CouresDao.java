package com.situ.ssm.dao;

import java.util.List;

import com.situ.ssm.pojo.Coures;
import com.situ.ssm.vo.SearchCondition;

public interface CouresDao {
		/**
		 * 获取分页列表
		 * @param searchCondition
		 * @return
		 */
		List<Coures> pageList(SearchCondition searchCondition);
		
		/**
		 * 获取全部课程列表
		 * @return
		 */
		List<Coures> findAll();
		
		/**
		 * 根据id获取课程
		 * @param id
		 * @return
		 */
		Coures findById(int id);
		
		/**
		 * 获取总数
		 * @param searchCondition
		 * @return
		 */
		int getCount(SearchCondition searchCondition);
		
		/**
		 * 修改课程
		 * @param coures
		 */
		void updateCoures(Coures coures);
		
		/**
		 * 添加课程
		 * @param coures
		 */
		void addCoures(Coures coures);
		
		/**
		 * 删除课程
		 * @param id
		 */
		void deleteCoures(int id);
		
		/**
		 * 删除教务表的外键
		 * @param id
		 */
		void deleteBanjiCoures(int id);
		
		
}
