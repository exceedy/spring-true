package com.situ.ssm.service;

import java.util.List;

import com.situ.ssm.pojo.Banji;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

public interface IBanjiService {

	List<Banji> banjiList();

	PageBean<Banji> pageBean(SearchCondition searchCondition);

	void addBanji(Banji banji);

	void deleteBanji(Integer id);

	void updateBanji(Banji banji);

	Banji findById(Integer id);

}
