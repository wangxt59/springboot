package com.antke.website.model.bean;

import java.util.Date;

public class UserInfo {
	private Integer id;

    private String userCode;

    private String realName;

    private String nickName;

    private String idCardFront;

    private String idCardBack;

    private String idCardNo;

    private String contact;

    private String loginName;

    private String password;

    private Integer status;

    private String header;

    private Date loginDate;

    private Integer assembleNum;

    private Integer role;

    private Integer level;

    private String address;

    private String community;

    private String longitude;

    private String latitude;

    private Date createDate;

    private Date updateDate;

    private Integer directSuperior;

    private Integer indirectSuperior;

    private Integer ascriptionUser;

    private String openid;

    private String unionid;

    private Double rebateTotle;

    private Integer vip;

    private Date vipValidity;

    private Integer groupNum;

    private String province;
    
    private String city;
    
    public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIdCardFront() {
		return idCardFront;
	}

	public void setIdCardFront(String idCardFront) {
		this.idCardFront = idCardFront;
	}

	public String getIdCardBack() {
		return idCardBack;
	}

	public void setIdCardBack(String idCardBack) {
		this.idCardBack = idCardBack;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Integer getAssembleNum() {
		return assembleNum;
	}

	public void setAssembleNum(Integer assembleNum) {
		this.assembleNum = assembleNum;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Integer getIndirectSuperior() {
		return indirectSuperior;
	}

	public void setIndirectSuperior(Integer indirectSuperior) {
		this.indirectSuperior = indirectSuperior;
	}

	public Integer getAscriptionUser() {
		return ascriptionUser;
	}

	public void setAscriptionUser(Integer ascriptionUser) {
		this.ascriptionUser = ascriptionUser;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public Double getRebateTotle() {
		return rebateTotle;
	}

	public void setRebateTotle(Double rebateTotle) {
		this.rebateTotle = rebateTotle;
	}

	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public Date getVipValidity() {
		return vipValidity;
	}

	public void setVipValidity(Date vipValidity) {
		this.vipValidity = vipValidity;
	}

	public Integer getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}

	private Integer rank;
 
    private String directName;
    
    private String indirectName;
    
    
    
    public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDirectName() {
		return directName;
	}

	public void setDirectName(String directName) {
		this.directName = directName;
	}

	public String getIndirectName() {
		return indirectName;
	}

	public void setIndirectName(String indirectName) {
		this.indirectName = indirectName;
	}

	public String getUserName() {
        return realName;
    }

    public void setUserName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAddress() {
        return contact;
    }

    public void setAddress(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getHeadPortrait() {
        return header;
    }

    public void setHeadPortrait(String header) {
        this.header = header == null ? null : header.trim();
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
 
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

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

	public Integer getDirectSuperior() {
		return directSuperior;
	}

	public void setDirectSuperior(Integer directSuperior) {
		this.directSuperior = directSuperior;
	}
}