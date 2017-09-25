package com.situ.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.ssm.dao.CouresDao;
import com.situ.ssm.pojo.Coures;
import com.situ.ssm.service.ICouresService;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

@Service("couresService")
public class CouresServiceImpl implements ICouresService{
	@Resource(name="couresDao")
	private CouresDao couresDao;
	
	public PageBean<Coures> pageList(SearchCondition searchCondition) {
		PageBean<Coures> pageBean = new PageBean<Coures>();
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
		
		Integer totalCount = couresDao.getCount(searchCondition);
		
		pageBean.setTotalCount(totalCount);
		
		int totalPage = (int) Math.ceil(1.0 * totalCount / size);
		
		pageBean.setTotalPage(totalPage);
		
		List<Coures> list = couresDao.pageList(searchCondition);
		pageBean.setList(list);
		return pageBean;
	}

	public void addCoures(Coures coures) {
		couresDao.addCoures(coures);
		
	}

	public Coures findById(Integer id) {
		return 	couresDao.findById(id);
	}

	public void updateCoures(Coures coures) {
		couresDao.updateCoures(coures);
	}

	public void deleteCoures(Integer id) {
		couresDao.deleteBanjiCoures(id);
		couresDao.deleteCoures(id);
		
	}

	public List<Coures> findAl() {
		return couresDao.findAll();
	}

}
