package com.antke.website.model.bean;

import java.util.Date;
import java.util.List;

public class OrderInfo {
    private Integer id;

    private String orderCode;

    private String tradeNo;

    private Double orderTotal;

    private Integer goodsCount;

    private Integer deliveryType;

    private Double deliveryFee;

    private Integer userId;

    private String userName;

    private Integer status;

    private Date createDate;

    private Date updateDate;

    private Date payTime;

    private String payCode;

    private Integer payType;

    private Integer teamId;

    private String contact;

    private String addressId;

    private String pointId;

    private Date receiveDate;

    private Double refundAmount;

    private String orderDesc;

    private String header;
    
    private Double goodsTotal;
    
    private Integer vipOrder;
    
    private Double vipFee;
    
    private List<OrderItems> orderItemsList;
    
    private Date refundDate;
    
    
    public Date getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	public List<OrderItems> getOrderItemsList() {
		return orderItemsList;
	}

	public void setOrderItemsList(List<OrderItems> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}

	public Integer getVipOrder() {
		return vipOrder;
	}

	public void setVipOrder(Integer vipOrder) {
		this.vipOrder = vipOrder;
	}

	public Double getVipFee() {
		return vipFee;
	}

	public void setVipFee(Double vipFee) {
		this.vipFee = vipFee;
	}

	public Double getGoodsTotal() {
		return goodsTotal;
	}

	public void setGoodsTotal(Double goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId == null ? null : pointId.trim();
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

  
}