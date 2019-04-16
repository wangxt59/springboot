package com.antke.website.model.bean;

import java.util.Date;

public class RecommendGoods {
    private Integer id;

    private Integer goodsId;

    private Integer recommendGoodsId;

    private Date createDate;

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

    public Integer getRecommendGoodsId() {
        return recommendGoodsId;
    }

    public void setRecommendGoodsId(Integer recommendGoodsId) {
        this.recommendGoodsId = recommendGoodsId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}