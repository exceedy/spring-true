package com.situ.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.ssm.pojo.Coures;
import com.situ.ssm.service.ICouresService;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

@Controller
@RequestMapping(value="coures")
public class CouresController {
	@Resource(name="couresService")
	private ICouresService couresService;
	
	@RequestMapping(value="pageList")
	public String pageList(SearchCondition searchCondition, Model model) {
		PageBean<Coures> pageBean = couresService.pageList(searchCondition);
		model.addAttribute("pageBean", pageBean);
		return "coures_show";
	}
	
	@RequestMapping(value="toAddCoures")
	public String toAddCoures() {
		return "add_coures";
	}
	
	@RequestMapping(value="addCoures")
	public String addCoures(Coures coures){
		couresService.addCoures(coures);
		return "redirect:/coures/pageList.action";
	}
	
	@RequestMapping(value="toUpdateCoures")
	public String toUpdateCoures(Integer id,Model model) {
		Coures coures = couresService.findById(id);
		model.addAttribute("coures", coures);
		return "update_coures";
	}
	
	@RequestMapping(value="updateCoures")
	public String updateCoures(Coures coures) {
		couresService.updateCoures(coures);
		return "redirect:/coures/pageList.action";
	}
	
	@RequestMapping(value="deleteCoures")
	public String deleteCoures(Integer id) {
		couresService.deleteCoures(id);
		return "redirect:/coures/pageList.action";
	}
	
	public String deleteAll(Integer[] selectId) {
		for (Integer id : selectId) {
			couresService.deleteCoures(id);
		}
		return "redirect:/coures/pageList.action";
	}
		
}