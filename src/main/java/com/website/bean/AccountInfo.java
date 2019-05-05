package com.website.bean;

import java.util.Date;

public class AccountInfo {
    private Integer accountId;

    private String userId;

    private Double cashBalance;

    private Double frozenBalance;

    private Double thawingBalance;

    private Double salesRebateBonus;

    private Double rebateBonus;

    private Double redBonus;

    private Double medalBonus;

    private Integer medalAmount;

    private Integer medalTotle;

    private Double boxBonus;

    private Integer status;

    private Date createDate;

    private Date updateDate;

    private Double accountTotal;

    private Double salesBalance;

    private String payPassword;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(Double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public Double getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(Double frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public Double getThawingBalance() {
        return thawingBalance;
    }

    public void setThawingBalance(Double thawingBalance) {
        this.thawingBalance = thawingBalance;
    }

    public Double getSalesRebateBonus() {
        return salesRebateBonus;
    }

    public void setSalesRebateBonus(Double salesRebateBonus) {
        this.salesRebateBonus = salesRebateBonus;
    }

    public Double getRebateBonus() {
        return rebateBonus;
    }

    public void setRebateBonus(Double rebateBonus) {
        this.rebateBonus = rebateBonus;
    }

    public Double getRedBonus() {
        return redBonus;
    }

    public void setRedBonus(Double redBonus) {
        this.redBonus = redBonus;
    }

    public Double getMedalBonus() {
        return medalBonus;
    }

    public void setMedalBonus(Double medalBonus) {
        this.medalBonus = medalBonus;
    }

    public Integer getMedalAmount() {
        return medalAmount;
    }

    public void setMedalAmount(Integer medalAmount) {
        this.medalAmount = medalAmount;
    }

    public Integer getMedalTotle() {
        return medalTotle;
    }

    public void setMedalTotle(Integer medalTotle) {
        this.medalTotle = medalTotle;
    }

    public Double getBoxBonus() {
        return boxBonus;
    }

    public void setBoxBonus(Double boxBonus) {
        this.boxBonus = boxBonus;
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

    public Double getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(Double accountTotal) {
        this.accountTotal = accountTotal;
    }

    public Double getSalesBalance() {
        return salesBalance;
    }

    public void setSalesBalance(Double salesBalance) {
        this.salesBalance = salesBalance;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }
}