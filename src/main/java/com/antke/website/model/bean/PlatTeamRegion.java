package com.antke.website.model.bean;

import java.util.Date;

public class PlatTeamRegion {
    private Integer id;

    private Integer pteamId;

    private Integer goodsId;

    private String goodsName;

    private String goodsPic;

    private Integer regionId;

    private String regionName;

    private Double marketPrice;

    private Double regionPrice;

    private Double vipPrice;

    private Integer rebateType;

    private Double rebateValue;

    private Integer stock;

    private Date createDate;

    private Date updateDate;

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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic == null ? null : goodsPic.trim();
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getRegionPrice() {
        return regionPrice;
    }

    public void setRegionPrice(Double regionPrice) {
        this.regionPrice = regionPrice;
    }

    public Double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public Integer getRebateType() {
        return rebateType;
    }

    public void setRebateType(Integer rebateType) {
        this.rebateType = rebateType;
    }

    public Double getRebateValue() {
        return rebateValue;
    }

    public void setRebateValue(Double rebateValue) {
        this.rebateValue = rebateValue;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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
}