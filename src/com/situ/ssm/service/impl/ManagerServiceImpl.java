package com.situ.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.ssm.dao.ManagerDao;
import com.situ.ssm.pojo.BanjiCoures;
import com.situ.ssm.pojo.Coures;
import com.situ.ssm.service.IManagerService;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

@Service("managerService")
public class ManagerServiceImpl implements IManagerService {
	@Resource(name="managerDao")
	private ManagerDao managerDao;

	public PageBean<BanjiCoures> pageList(SearchCondition searchCondition) {
		PageBean<BanjiCoures> pageBean = new PageBean<BanjiCoures>();
		Integer pageIndex = searchCondition.getPageIndex();
		int index = 1;
		if (pageIndex != null) {
			index = pageIndex;
		}
		pageBean.setPageIndex(index);
		Integer pageSize = searchCondition.getPageSize();
		int size = 3;
		if (pageSize != null) {
			size = pageSize;
		}
		pageBean.setPageSize(size);
		searchCondition.setPageIndex((index - 1) * size);
		searchCondition.setPageSize(size);
		
		Integer totalCount = managerDao.getCount(searchCondition);
		
		pageBean.setTotalCount(totalCount);
		
		int totalPage = (int) Math.ceil(1.0 * totalCount / size);
		
		pageBean.setTotalPage(totalPage);
		
		List<BanjiCoures> list = managerDao.pageList(searchCondition);
		pageBean.setList(list);
		return pageBean;
	}

	public void addManger(BanjiCoures manager) {
		managerDao.addManager(manager);
	}

	public void deleteManager(Integer id) {
		managerDao.deleteManager(id);
	}

}
