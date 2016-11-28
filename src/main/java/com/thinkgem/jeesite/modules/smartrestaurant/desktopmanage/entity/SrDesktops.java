/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.desktopmanage.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 餐台管理Entity
 * @author Julong
 * @version 2016-11-24
 */
public class SrDesktops extends DataEntity<SrDesktops> {
	
	private static final long serialVersionUID = 1L;
	private String number;		// 桌号
	private String location;		// 位置
	private String size;		// 大中小
	private String waiter;		// 服务员
	private String accommodate;		// 容纳人数
	
	public SrDesktops() {
		super();
	}

	public SrDesktops(String id){
		super(id);
	}

	@Length(min=0, max=45, message="桌号长度必须介于 0 和 45 之间")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Length(min=0, max=45, message="位置长度必须介于 0 和 45 之间")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Length(min=0, max=45, message="大中小长度必须介于 0 和 45 之间")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	@Length(min=0, max=45, message="服务员长度必须介于 0 和 45 之间")
	public String getWaiter() {
		return waiter;
	}

	public void setWaiter(String waiter) {
		this.waiter = waiter;
	}
	
	@Length(min=0, max=11, message="容纳人数长度必须介于 0 和 11 之间")
	public String getAccommodate() {
		return accommodate;
	}

	public void setAccommodate(String accommodate) {
		this.accommodate = accommodate;
	}
	
}