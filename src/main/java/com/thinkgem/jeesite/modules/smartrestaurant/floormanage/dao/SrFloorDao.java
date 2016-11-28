/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.floormanage.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.smartrestaurant.floormanage.entity.SrFloor;

/**
 * 楼层管理DAO接口
 * @author Julong
 * @version 2016-11-24
 */
@MyBatisDao
public interface SrFloorDao extends CrudDao<SrFloor> {
	
}