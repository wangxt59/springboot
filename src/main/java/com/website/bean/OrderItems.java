package com.website.bean;

import java.util.Date;

public class OrderItems {
    private Integer itemId;

    private Integer orderId;

    private Integer goodsId;

    private Integer skuId;

    private String goodsName;

    private Integer goodsNum;

    private Double totalMoney;

    private Date createDate;

    private Date updateDate;

    private Integer userId;

    private Double regionPrice;

    private Double vipPrice;

    private String goodsPic;
    
    private String description;
    
    private String adWords;
    
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdWords() {
		return adWords;
	}

	public void setAdWords(String adWords) {
		this.adWords = adWords;
	}

	public String getGoodsPic() {
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}