package com.situ.ssm.service;

import java.util.List;

import com.situ.ssm.pojo.Coures;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

public interface ICouresService {

	PageBean<Coures> pageList(SearchCondition searchCondition);

	void addCoures(Coures coures);

	Coures findById(Integer id);

	void updateCoures(Coures coures);

	void deleteCoures(Integer id);

	List<Coures> findAl();

}
