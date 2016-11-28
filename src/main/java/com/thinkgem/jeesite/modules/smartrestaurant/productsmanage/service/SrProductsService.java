/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.productsmanage.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.smartrestaurant.productsmanage.entity.SrProducts;
import com.thinkgem.jeesite.modules.smartrestaurant.productsmanage.dao.SrProductsDao;

/**
 * 菜品管理Service
 * @author Julong
 * @version 2016-11-24
 */
@Service
@Transactional(readOnly = true)
public class SrProductsService extends CrudService<SrProductsDao, SrProducts> {

	public SrProducts get(String id) {
		return super.get(id);
	}
	
	public List<SrProducts> findList(SrProducts srProducts) {
		return super.findList(srProducts);
	}
	
	public Page<SrProducts> findPage(Page<SrProducts> page, SrProducts srProducts) {
		return super.findPage(page, srProducts);
	}
	
	@Transactional(readOnly = false)
	public void save(SrProducts srProducts) {
		super.save(srProducts);
	}
	
	@Transactional(readOnly = false)
	public void delete(SrProducts srProducts) {
		super.delete(srProducts);
	}
	
}