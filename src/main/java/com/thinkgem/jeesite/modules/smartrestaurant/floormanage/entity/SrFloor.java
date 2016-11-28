/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.floormanage.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 楼层管理Entity
 * @author Julong
 * @version 2016-11-24
 */
public class SrFloor extends DataEntity<SrFloor> {
	
	private static final long serialVersionUID = 1L;
	private String level;		// 层数
	private String name;		// 楼层名
	private String waiter;		// 服务员数量
	private String room;		// 包间数量
	
	public SrFloor() {
		super();
	}

	public SrFloor(String id){
		super(id);
	}

	@Length(min=0, max=11, message="层数长度必须介于 0 和 11 之间")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	@Length(min=0, max=45, message="楼层名长度必须介于 0 和 45 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=100, message="服务员数量长度必须介于 0 和 100 之间")
	public String getWaiter() {
		return waiter;
	}

	public void setWaiter(String waiter) {
		this.waiter = waiter;
	}
	
	@Length(min=0, max=45, message="包间数量长度必须介于 0 和 45 之间")
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
}