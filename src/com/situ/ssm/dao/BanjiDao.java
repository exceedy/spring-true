package com.situ.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.ssm.pojo.Banji;
import com.situ.ssm.vo.SearchCondition;

public interface BanjiDao {
	/**
	 * 获取分页班级集合
	 * @param searchCondition
	 * @return
	 */
	List<Banji> pageList(SearchCondition searchCondition);
	
	/**
	 * 获取总数
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	int getCount(SearchCondition searchCondition);
	
	/**
	 * 根据id查询班级
	 * @param id
	 * @return
	 */
	Banji findById(int id);
	
	/**
	 * 修改班级
	 * @param banji
	 */
	void updateBanji(Banji banji);
	
	/**
	 * 删除班级
	 * @param id
	 */
	void deleteBanji(int id);
	
	/**
	 * 添加班级
	 * @param banji
	 */
	void addBanji(Banji banji);
	
	/**
	 * 查询所有班级
	 * @return
	 */
	List<Banji> findAll();

	void deleteBanjiCoures(Integer id);

	void updateStudentBanjiId(@Param(value="id")Integer id);
}
