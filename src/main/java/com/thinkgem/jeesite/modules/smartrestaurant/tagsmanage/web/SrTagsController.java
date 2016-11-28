/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.tagsmanage.web;

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
import com.thinkgem.jeesite.modules.smartrestaurant.tagsmanage.entity.SrTags;
import com.thinkgem.jeesite.modules.smartrestaurant.tagsmanage.service.SrTagsService;

/**
 * 菜品标签管理Controller
 * @author Julong
 * @version 2016-11-24
 */
@Controller
@RequestMapping(value = "${adminPath}/tagsmanage/srTags")
public class SrTagsController extends BaseController {

	@Autowired
	private SrTagsService srTagsService;
	
	@ModelAttribute
	public SrTags get(@RequestParam(required=false) String id) {
		SrTags entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srTagsService.get(id);
		}
		if (entity == null){
			entity = new SrTags();
		}
		return entity;
	}
	
	@RequiresPermissions("tagsmanage:srTags:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrTags srTags, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrTags> page = srTagsService.findPage(new Page<SrTags>(request, response), srTags); 
		model.addAttribute("page", page);
		return "smartrestaurant/tagsmanage/srTagsList";
	}

	@RequiresPermissions("tagsmanage:srTags:view")
	@RequestMapping(value = "form")
	public String form(SrTags srTags, Model model) {
		model.addAttribute("srTags", srTags);
		return "smartrestaurant/tagsmanage/srTagsForm";
	}

	@RequiresPermissions("tagsmanage:srTags:edit")
	@RequestMapping(value = "save")
	public String save(SrTags srTags, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srTags)){
			return form(srTags, model);
		}
		srTagsService.save(srTags);
		addMessage(redirectAttributes, "保存标签成功");
		return "redirect:"+Global.getAdminPath()+"/tagsmanage/srTags/?repage";
	}
	
	@RequiresPermissions("tagsmanage:srTags:edit")
	@RequestMapping(value = "delete")
	public String delete(SrTags srTags, RedirectAttributes redirectAttributes) {
		srTagsService.delete(srTags);
		addMessage(redirectAttributes, "删除标签成功");
		return "redirect:"+Global.getAdminPath()+"/tagsmanage/srTags/?repage";
	}

}