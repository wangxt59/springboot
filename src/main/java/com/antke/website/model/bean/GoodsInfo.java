package com.antke.website.model.bean;

import java.util.Date;
import java.util.List;

public class GoodsInfo {
    private Integer goodsId;

    private String goodsCode;

    private String goodsName;

    private String adWords;

    private String createUserId;

    private Integer status;

    private String spec;

    private Integer saleCount;

    private Double costPrice;

    private Double marketPrice;

    private Integer categoryId;

    private String categoryName;

    private Integer channelId;

    private Integer labelId;

    private Integer stockType;

    private Integer stock;

    private Double returnTime;

    private String commitment;

    private Date createDate;

    private Date updateDate;

    private Date shelfTime;

    private Integer returnType;

    private String goodsPic;

    private Double vipPrice;

    private List<GoodsPic> goodsPics;
    
    private List<GoodsSku> goodsSkus;
    


	public List<GoodsPic> getGoodsPics() {
		return goodsPics;
	}

	public void setGoodsPics(List<GoodsPic> goodsPics) {
		this.goodsPics = goodsPics;
	}

	public List<GoodsSku> getGoodsSkus() {
		return goodsSkus;
	}

	public void setGoodsSkus(List<GoodsSku> goodsSkus) {
		this.goodsSkus = goodsSkus;
	}

	public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getAdWords() {
        return adWords;
    }

    public void setAdWords(String adWords) {
        this.adWords = adWords == null ? null : adWords.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getStockType() {
        return stockType;
    }

    public void setStockType(Integer stockType) {
        this.stockType = stockType;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Double returnTime) {
        this.returnTime = returnTime;
    }

    public String getCommitment() {
        return commitment;
    }

    public void setCommitment(String commitment) {
        this.commitment = commitment == null ? null : commitment.trim();
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

    public Date getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(Date shelfTime) {
        this.shelfTime = shelfTime;
    }

    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic == null ? null : goodsPic.trim();
    }

    public Double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Double vipPrice) {
        this.vipPrice = vipPrice;
    }
}