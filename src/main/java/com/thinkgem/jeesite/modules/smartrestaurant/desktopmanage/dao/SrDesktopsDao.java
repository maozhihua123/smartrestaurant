/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.desktopmanage.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.smartrestaurant.desktopmanage.entity.SrDesktops;

/**
 * 餐台管理DAO接口
 * @author Julong
 * @version 2016-11-24
 */
@MyBatisDao
public interface SrDesktopsDao extends CrudDao<SrDesktops> {
	
}