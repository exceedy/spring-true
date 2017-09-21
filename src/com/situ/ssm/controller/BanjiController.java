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
	
	@RequestMapping(value="toAddBanji")
	public String toAddBanji() {
		return "add_banji";
	}
	
	@RequestMapping(value="addBanji")
	public String addBanji(Banji banji,Model model){
		banjiService.addBanji(banji);
		return "redirect:/banji/pageList.action";
	}
	
	@RequestMapping(value="deleteBanji")
	public String deleteBanji(Integer id) {
		banjiService.deleteBanji(id);
		return "redirect:/banji/pageList.action";
	}
	
	@RequestMapping(value="deleteAll")
	public String deleteAll(Integer[] selectId) {
		for (Integer id : selectId) {
			banjiService.deleteBanji(id);
		}
		return "redirect:/banji/pageList.action";
	}
	
	@RequestMapping(value="toUpdateBanji")
	public String toUpdateBanji(Integer id, Model model) {
		Banji banji = banjiService.findById(id);
		model.addAttribute("banji", banji);
		return "update_banji";
	}
	
	@RequestMapping(value="updateBanji")
	public String updateBanji(Banji banji) {
		banjiService.updateBanji(banji);
		return "redirect:/banji/pageList.action";
	}
}
