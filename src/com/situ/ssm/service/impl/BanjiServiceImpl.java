package com.situ.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.ssm.dao.BanjiDao;
import com.situ.ssm.pojo.Banji;
import com.situ.ssm.service.IBanjiService;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;


@Service("banjiService")
public class BanjiServiceImpl implements IBanjiService {
	@Resource(name="banjiDao")
	private BanjiDao banjiDao;
	
	public List<Banji> banjiList() {
		return banjiDao.findAll();
	}

	public PageBean<Banji> pageBean(SearchCondition searchCondition) {
		PageBean<Banji> pageBean = new PageBean<Banji>();
		//获取页码
		Integer pageIndex = searchCondition.getPageIndex();
		//初始化页码
		int index = 1;
		//赋值当前页面
		if (pageIndex != null) {
			index = pageIndex;
		}
		
		pageBean.setPageIndex(index);
		
		//获取当前页面大小
		Integer pageSize = searchCondition.getPageSize();
		//初始化大小
		int size = 3;
		//赋值当前大小
		if (pageSize != null) {
			size = pageSize;
		}
		//将当前大小赋值给pageBean
		pageBean.setPageSize(size);
		//改变页码为limit偏移
		searchCondition.setPageIndex((index - 1) * size);
		searchCondition.setPageSize(size);
		Integer totalCount = banjiDao.getCount(searchCondition);
		pageBean.setTotalCount(totalCount);
		Integer totalPage = (int) Math.ceil(1.0 * totalCount / size);
		pageBean.setTotalPage(totalPage);
		List<Banji> list = banjiDao.pageList(searchCondition);
		pageBean.setList(list);
		return pageBean;
	}
		
}
