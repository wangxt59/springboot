package com.antke.website.model.bean;

import java.util.Date;

public class GoodsPic {
    private Integer id;

    private Integer goodsId;

    private String picUrl;

    private Date createDate;

    private Date updateDate;

    private Integer isHome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
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

    public Integer getIsHome() {
        return isHome;
    }

    public void setIsHome(Integer isHome) {
        this.isHome = isHome;
    }
}