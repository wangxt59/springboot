package com.website.bean;

import java.util.Date;

public class PlatTeamDetails {
    private Integer id;

    private Integer pteamId;

    private Integer detailsType;

    private String description;

    private Date createDate;

    private Date updateDate;

    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPteamId() {
        return pteamId;
    }

    public void setPteamId(Integer pteamId) {
        this.pteamId = pteamId;
    }

    public Integer getDetailsType() {
        return detailsType;
    }

    public void setDetailsType(Integer detailsType) {
        this.detailsType = detailsType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}