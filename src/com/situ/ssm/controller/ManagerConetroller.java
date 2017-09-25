package com.situ.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.ssm.pojo.Banji;
import com.situ.ssm.pojo.BanjiCoures;
import com.situ.ssm.pojo.Coures;
import com.situ.ssm.service.IBanjiService;
import com.situ.ssm.service.ICouresService;
import com.situ.ssm.service.IManagerService;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

@Controller
@RequestMapping(value="manager")
public class ManagerConetroller {
		@Resource(name="managerService")
		private IManagerService managerService;
		
		@Resource(name="banjiService")
		private IBanjiService banjiService;
		
		@Resource(name="couresService")
		private ICouresService couresService;
		
		@RequestMapping(value="pageList")
		public String pageList(SearchCondition searchCondition, Model model) {
			PageBean<BanjiCoures> pageBean = managerService.pageList(searchCondition);
			System.out.println(pageBean);
			model.addAttribute("pageBean", pageBean);
			model.addAttribute("searchCondition", searchCondition);
			return "manager_show";
		}
		
		@RequestMapping(value="toAddManager")
		public String toAddManager(Model model) {
			List<Banji> banjiList = banjiService.banjiList();
			List<Coures> coureList = couresService.findAl();
			model.addAttribute("banjiList", banjiList);
			model.addAttribute("couresList", coureList);
			return "add_manager";
		}
		
		@RequestMapping(value="addManager")
		public String addManager(BanjiCoures manager) {
			managerService.addManger(manager);
			return "redirect:/manager/pageList.action";
		}
		
		@RequestMapping(value="deleteManager")
		public String deleteManager(Integer id) {
			managerService.deleteManager(id);
			System.out.println(id);
			return "redirect:/manager/pageList.action";
		}
		
		@RequestMapping(value="deleteAll")
		public String deleteAll(Integer[] selectId) {
			for (Integer id : selectId) {
				managerService.deleteManager(id);
			}
			return "redirect:/manager/pageList.action";
			
		}
}
