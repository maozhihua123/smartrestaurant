/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.smartrestaurant.productsmanage.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 菜品管理Entity
 * @author Julong
 * @version 2016-11-24
 */
public class SrProducts extends DataEntity<SrProducts> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String tagIds;		// 标签
	private String sort;		// 排序
	private String images;		// 图片
	private String description;		// 描述
	private String price;		// 价格
	private String unit;		// 单位
	private String ingredients;		// 配料
	private String count;		// 销量
	private String hot;		// 热度
	
	public SrProducts() {
		super();
	}

	public SrProducts(String id){
		super(id);
	}

	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=2000, message="标签长度必须介于 1 和 2000 之间")
	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	@Length(min=1, max=45, message="图片长度必须介于 1 和 45 之间")
	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
	@Length(min=0, max=100, message="描述长度必须介于 0 和 100 之间")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Length(min=1, max=45, message="单位长度必须介于 1 和 45 之间")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Length(min=0, max=45, message="配料长度必须介于 0 和 45 之间")
	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	
	@Length(min=0, max=11, message="销量长度必须介于 0 和 11 之间")
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
	@Length(min=0, max=45, message="热度长度必须介于 0 和 45 之间")
	public String getHot() {
		return hot;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}
	
}