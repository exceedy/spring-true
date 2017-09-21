package com.situ.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.ssm.pojo.Banji;
import com.situ.ssm.service.IBanjiService;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

@Controller
@RequestMapping(value="banji")
public class BanjiController {
	@Resource(name="banjiService")
	private IBanjiService banjiService;
	
	@RequestMapping(value="pageList")
	public String pageList(SearchCondition searchCondition, Model model) {
		
		PageBean<Banji> pageBean = banjiService.pageBean(searchCondition);
		model.addAttribute("searchCondition", searchCondition);
		model.addAttribute("pageBean", pageBean);
		return "banji_show";
		
	}
}
