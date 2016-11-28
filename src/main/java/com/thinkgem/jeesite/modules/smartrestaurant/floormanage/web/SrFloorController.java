/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.floormanage.web;

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
import com.thinkgem.jeesite.modules.smartrestaurant.floormanage.entity.SrFloor;
import com.thinkgem.jeesite.modules.smartrestaurant.floormanage.service.SrFloorService;

/**
 * 楼层管理Controller
 * @author Julong
 * @version 2016-11-24
 */
@Controller
@RequestMapping(value = "${adminPath}/floormanage/srFloor")
public class SrFloorController extends BaseController {

	@Autowired
	private SrFloorService srFloorService;
	
	@ModelAttribute
	public SrFloor get(@RequestParam(required=false) String id) {
		SrFloor entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srFloorService.get(id);
		}
		if (entity == null){
			entity = new SrFloor();
		}
		return entity;
	}
	
	@RequiresPermissions("floormanage:srFloor:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrFloor srFloor, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrFloor> page = srFloorService.findPage(new Page<SrFloor>(request, response), srFloor); 
		model.addAttribute("page", page);
		return "smartrestaurant/floormanage/srFloorList";
	}

	@RequiresPermissions("floormanage:srFloor:view")
	@RequestMapping(value = "form")
	public String form(SrFloor srFloor, Model model) {
		model.addAttribute("srFloor", srFloor);
		return "smartrestaurant/floormanage/srFloorForm";
	}

	@RequiresPermissions("floormanage:srFloor:edit")
	@RequestMapping(value = "save")
	public String save(SrFloor srFloor, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srFloor)){
			return form(srFloor, model);
		}
		srFloorService.save(srFloor);
		addMessage(redirectAttributes, "保存楼层成功");
		return "redirect:"+Global.getAdminPath()+"/floormanage/srFloor/?repage";
	}
	
	@RequiresPermissions("floormanage:srFloor:edit")
	@RequestMapping(value = "delete")
	public String delete(SrFloor srFloor, RedirectAttributes redirectAttributes) {
		srFloorService.delete(srFloor);
		addMessage(redirectAttributes, "删除楼层成功");
		return "redirect:"+Global.getAdminPath()+"/floormanage/srFloor/?repage";
	}

}