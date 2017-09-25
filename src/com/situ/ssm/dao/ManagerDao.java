package com.situ.ssm.dao;

import java.util.List;

import com.situ.ssm.pojo.BanjiCoures;
import com.situ.ssm.vo.SearchCondition;

public interface ManagerDao {
		List<BanjiCoures> pageList(SearchCondition searchCondition);
		Integer getCount(SearchCondition searchCondition);
		void addManager(BanjiCoures manager);
		void deleteManager(Integer id);
}
