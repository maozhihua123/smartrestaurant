/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.desktopmanage.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.smartrestaurant.desktopmanage.entity.SrDesktops;
import com.thinkgem.jeesite.modules.smartrestaurant.desktopmanage.service.SrDesktopsService;

/**
 * 餐台管理Controller
 * @author Julong
 * @version 2016-11-24
 */
@Controller
@RequestMapping(value = "${adminPath}/desktopmanage/srDesktops")
public class SrDesktopsController extends BaseController {

	@Autowired
	private SrDesktopsService srDesktopsService;
	
	@ModelAttribute
	public SrDesktops get(@RequestParam(required=false) String id) {
		SrDesktops entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srDesktopsService.get(id);
		}
		if (entity == null){
			entity = new SrDesktops();
		}
		return entity;
	}
	
	@RequiresPermissions("desktopmanage:srDesktops:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrDesktops srDesktops, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrDesktops> page = srDesktopsService.findPage(new Page<SrDesktops>(request, response), srDesktops); 
		model.addAttribute("page", page);
		return "smartrestaurant/desktopmanage/srDesktopsList";
	}

	@RequiresPermissions("desktopmanage:srDesktops:view")
	@RequestMapping(value = "form")
	public String form(SrDesktops srDesktops, Model model) {
		model.addAttribute("srDesktops", srDesktops);
		return "smartrestaurant/desktopmanage/srDesktopsForm";
	}

	@RequiresPermissions("desktopmanage:srDesktops:edit")
	@RequestMapping(value = "save")
	public String save(SrDesktops srDesktops, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srDesktops)){
			return form(srDesktops, model);
		}
		srDesktopsService.save(srDesktops);
		addMessage(redirectAttributes, "保存餐台成功");
		return "redirect:"+Global.getAdminPath()+"/desktopmanage/srDesktops/?repage";
	}
	
	@RequiresPermissions("desktopmanage:srDesktops:edit")
	@RequestMapping(value = "delete")
	public String delete(SrDesktops srDesktops, RedirectAttributes redirectAttributes) {
		srDesktopsService.delete(srDesktops);
		addMessage(redirectAttributes, "删除餐台成功");
		return "redirect:"+Global.getAdminPath()+"/desktopmanage/srDesktops/?repage";
	}

}