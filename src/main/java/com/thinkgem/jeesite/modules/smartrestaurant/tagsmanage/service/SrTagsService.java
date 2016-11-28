/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.tagsmanage.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.modules.smartrestaurant.tagsmanage.entity.SrTags;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.smartrestaurant.tagsmanage.dao.SrTagsDao;

/**
 * 菜品标签管理Service
 * @author Julong
 * @version 2016-11-24
 */
@Service
@Transactional(readOnly = true)
public class SrTagsService extends CrudService<SrTagsDao, SrTags> {

	public SrTags get(String id) {
		return super.get(id);
	}
	
	public List<SrTags> findList(SrTags srTags) {
		return super.findList(srTags);
	}
	
	public Page<SrTags> findPage(Page<SrTags> page, SrTags srTags) {
		return super.findPage(page, srTags);
	}
	
	@Transactional(readOnly = false)
	public void save(SrTags srTags) {
		super.save(srTags);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}
	
	@Transactional(readOnly = false)
	public void delete(SrTags srTags) {
		super.delete(srTags);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}
	
}