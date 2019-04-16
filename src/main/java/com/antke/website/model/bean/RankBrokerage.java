package com.antke.website.model.bean;

import java.util.Date;

public class RankBrokerage {
    private Integer id;

    private Integer rank;

    private Double amount;

    private Double integral;

    private Double brokerageRatio;

    private Date createDate;

    private Date updateDate;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getIntegral() {
        return integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }

    public Double getBrokerageRatio() {
        return brokerageRatio;
    }

    public void setBrokerageRatio(Double brokerageRatio) {
        this.brokerageRatio = brokerageRatio;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}