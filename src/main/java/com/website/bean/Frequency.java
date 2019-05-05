package com.website.bean;

import java.util.Date;

public class Frequency {
    private Integer id;

    private String name;

    private String picUrl;

    private Integer isHomeShow;

    private Integer status;

    private Date createDate;

    private Date updateDate;

    private String createUserId;
    
    private String recgCategoryIds;
    
    private Integer relationType;
    
    private String recgGoodsIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getIsHomeShow() {
        return isHomeShow;
    }

    public void setIsHomeShow(Integer isHomeShow) {
        this.isHomeShow = isHomeShow;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

	public String getRecgCategoryIds() {
		return recgCategoryIds;
	}

	public void setRecgCategoryIds(String recgCategoryIds) {
		this.recgCategoryIds = recgCategoryIds;
	}

	public Integer getRelationType() {
		return relationType;
	}

	public void setRelationType(Integer relationType) {
		this.relationType = relationType;
	}

	public String getRecgGoodsIds() {
		return recgGoodsIds;
	}

	public void setRecgGoodsIds(String recgGoodsIds) {
		this.recgGoodsIds = recgGoodsIds;
	}
}