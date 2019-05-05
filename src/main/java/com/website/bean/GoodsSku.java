package com.website.bean;

import java.util.Date;

public class GoodsSku {
    private Integer skuId;

    private Integer goodsId;

    private Double marketPrice;

    private Double regionPrice;

    private Integer rebateType;

    private Double rebateAmount;

    private Double rebateRatio;

    private Integer stock;

    private Date createDate;

    private Date updateDate;

    private Integer regionId;

    private String regionName;

    private Integer regionType;
    
    
//  
//  private Double price;
//  private Double value;
//  private Integer limitNum;
//  private Integer status;
//  private String createUserId;
//  private String imgUrl;
//  private Double salePrice;
//  private Double logistics;
//  private Integer recipient;
//  private Integer isMain;
//  private String relationId;
//  

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

    public Integer getRebateType() {
        return rebateType;
    }

    public void setRebateType(Integer rebateType) {
        this.rebateType = rebateType;
    }

    public Double getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(Double rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    public Double getRebateRatio() {
        return rebateRatio;
    }

    public void setRebateRatio(Double rebateRatio) {
        this.rebateRatio = rebateRatio;
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

    public Integer getRegionType() {
        return regionType;
    }

    public void setRegionType(Integer regionType) {
        this.regionType = regionType;
    }
}