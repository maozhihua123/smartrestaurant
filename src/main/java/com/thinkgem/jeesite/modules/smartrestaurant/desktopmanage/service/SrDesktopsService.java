/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.desktopmanage.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.smartrestaurant.desktopmanage.entity.SrDesktops;
import com.thinkgem.jeesite.modules.smartrestaurant.desktopmanage.dao.SrDesktopsDao;

/**
 * 餐台管理Service
 * @author Julong
 * @version 2016-11-24
 */
@Service
@Transactional(readOnly = true)
public class SrDesktopsService extends CrudService<SrDesktopsDao, SrDesktops> {

	public SrDesktops get(String id) {
		return super.get(id);
	}
	
	public List<SrDesktops> findList(SrDesktops srDesktops) {
		return super.findList(srDesktops);
	}
	
	public Page<SrDesktops> findPage(Page<SrDesktops> page, SrDesktops srDesktops) {
		return super.findPage(page, srDesktops);
	}
	
	@Transactional(readOnly = false)
	public void save(SrDesktops srDesktops) {
		super.save(srDesktops);
	}
	
	@Transactional(readOnly = false)
	public void delete(SrDesktops srDesktops) {
		super.delete(srDesktops);
	}
	
}