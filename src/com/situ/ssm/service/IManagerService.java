package com.situ.ssm.service;

import com.situ.ssm.pojo.BanjiCoures;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

public interface IManagerService {

	PageBean<BanjiCoures> pageList(SearchCondition searchCondition);

	void addManger(BanjiCoures manager);

	void deleteManager(Integer id);

}
