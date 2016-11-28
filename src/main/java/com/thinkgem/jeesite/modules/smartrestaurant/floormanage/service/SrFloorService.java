/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.floormanage.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.smartrestaurant.floormanage.entity.SrFloor;
import com.thinkgem.jeesite.modules.smartrestaurant.floormanage.dao.SrFloorDao;

/**
 * 楼层管理Service
 * @author Julong
 * @version 2016-11-24
 */
@Service
@Transactional(readOnly = true)
public class SrFloorService extends CrudService<SrFloorDao, SrFloor> {

	public SrFloor get(String id) {
		return super.get(id);
	}
	
	public List<SrFloor> findList(SrFloor srFloor) {
		return super.findList(srFloor);
	}
	
	public Page<SrFloor> findPage(Page<SrFloor> page, SrFloor srFloor) {
		return super.findPage(page, srFloor);
	}
	
	@Transactional(readOnly = false)
	public void save(SrFloor srFloor) {
		super.save(srFloor);
	}
	
	@Transactional(readOnly = false)
	public void delete(SrFloor srFloor) {
		super.delete(srFloor);
	}
	
}