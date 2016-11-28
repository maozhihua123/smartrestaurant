/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.productsmanage.web;

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
import com.thinkgem.jeesite.modules.smartrestaurant.productsmanage.entity.SrProducts;
import com.thinkgem.jeesite.modules.smartrestaurant.productsmanage.service.SrProductsService;

/**
 * 菜品管理Controller
 * @author Julong
 * @version 2016-11-24
 */
@Controller
@RequestMapping(value = "${adminPath}/productsmanage/srProducts")
public class SrProductsController extends BaseController {

	@Autowired
	private SrProductsService srProductsService;
	
	@ModelAttribute
	public SrProducts get(@RequestParam(required=false) String id) {
		SrProducts entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srProductsService.get(id);
		}
		if (entity == null){
			entity = new SrProducts();
		}
		return entity;
	}
	
	@RequiresPermissions("productsmanage:srProducts:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrProducts srProducts, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrProducts> page = srProductsService.findPage(new Page<SrProducts>(request, response), srProducts); 
		model.addAttribute("page", page);
		return "smartrestaurant/productsmanage/srProductsList";
	}

	@RequiresPermissions("productsmanage:srProducts:view")
	@RequestMapping(value = "form")
	public String form(SrProducts srProducts, Model model) {
		model.addAttribute("srProducts", srProducts);
		return "smartrestaurant/productsmanage/srProductsForm";
	}

	@RequiresPermissions("productsmanage:srProducts:edit")
	@RequestMapping(value = "save")
	public String save(SrProducts srProducts, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srProducts)){
			return form(srProducts, model);
		}
		srProductsService.save(srProducts);
		addMessage(redirectAttributes, "保存菜品成功");
		return "redirect:"+Global.getAdminPath()+"/productsmanage/srProducts/?repage";
	}
	
	@RequiresPermissions("productsmanage:srProducts:edit")
	@RequestMapping(value = "delete")
	public String delete(SrProducts srProducts, RedirectAttributes redirectAttributes) {
		srProductsService.delete(srProducts);
		addMessage(redirectAttributes, "删除菜品成功");
		return "redirect:"+Global.getAdminPath()+"/productsmanage/srProducts/?repage";
	}

}