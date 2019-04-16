package com.antke.website.model.bean;

import java.util.Date;

public class UserWithdraw {
    private Integer withdrawId;

    private Integer userId;

    private Double total;

    private Integer bankId;

    private String bankName;

    private String cartNum;

    private String name;

    private String contact;

    private Integer status;

    private Date createDate;

    private Date updateDate;

    private String tradeNo;

    private String province;

    private String city;

    private Double beforeTotal;

    private Integer withdrawIntegral;

    private Double withdrawFee;

    private Double realTotal;

    private String bankBranch;

    private String integralId;

    private Double integralRatioTotal;

    private Integer role;

    public Integer getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(Integer withdrawId) {
        this.withdrawId = withdrawId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getCartNum() {
        return cartNum;
    }

    public void setCartNum(String cartNum) {
        this.cartNum = cartNum == null ? null : cartNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Double getBeforeTotal() {
        return beforeTotal;
    }

    public void setBeforeTotal(Double beforeTotal) {
        this.beforeTotal = beforeTotal;
    }

    public Integer getWithdrawIntegral() {
        return withdrawIntegral;
    }

    public void setWithdrawIntegral(Integer withdrawIntegral) {
        this.withdrawIntegral = withdrawIntegral;
    }

    public Double getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(Double withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public Double getRealTotal() {
        return realTotal;
    }

    public void setRealTotal(Double realTotal) {
        this.realTotal = realTotal;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch == null ? null : bankBranch.trim();
    }

    public String getIntegralId() {
        return integralId;
    }

    public void setIntegralId(String integralId) {
        this.integralId = integralId == null ? null : integralId.trim();
    }

    public Double getIntegralRatioTotal() {
        return integralRatioTotal;
    }

    public void setIntegralRatioTotal(Double integralRatioTotal) {
        this.integralRatioTotal = integralRatioTotal;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}