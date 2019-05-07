package com.power.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkerInfo {
	private String workerId;// 员工id
	private String workerName;// 员工名称
	private String workerCode;// 员工编号
	private String loginName;// 登录名
	private String password;// 密码
	private Integer sex;// 性别（0：男；1：女；2：保密）
	private String company;// 所属公司
	private String community;// 管辖社区
	private String professional;// 职位
	private String contact;// 手机号
	private String fixedPhone;// 座机
	private String province;// 省
	private String city;// 市
	private String district;// 区
	private String headPortrait;// 头像
	private String certCode;// 身份证号
	private String email;// Email地址
	private String qq;// QQ号
	private String status;// 状态：0，启动；1，冻结；2，锁定；3，注销
	private String loginNum;// 登陆次数
	private Integer isfirst;// 首次登陆（0，是；1，否）
	private Date createDate;// 注册时间
	private Date updateDate;// 更新时间
	private Integer type;// 1人员，2商家，3供应商
	//新增字段
	private String storeId;//店铺id
	private String sellerLoginId;//商家登录表id
	private Integer siteId;//站点id
	private Integer chantId;//商户ID
	private Integer rank;//等级 0 平台管理员 1商户管理员 2商户客服 3商户运维
	//冗余字段
	private List rolesIdList;//角色id集合
	private String roleId;//角色id字符串
 

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId == null ? null : workerId.trim();
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName == null ? null : workerName.trim();
    }

    public String getWorkerCode() {
        return workerCode;
    }

    public void setWorkerCode(String workerCode) {
        this.workerCode = workerCode == null ? null : workerCode.trim();
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community == null ? null : community.trim();
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional == null ? null : professional.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone == null ? null : fixedPhone.trim();
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode == null ? null : certCode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum == null ? null : loginNum.trim();
    }

    public Integer getIsfirst() {
        return isfirst;
    }

    public void setIsfirst(Integer isfirst) {
        this.isfirst = isfirst;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getSellerLoginId() {
        return sellerLoginId;
    }

    public void setSellerLoginId(String sellerLoginId) {
        this.sellerLoginId = sellerLoginId == null ? null : sellerLoginId.trim();
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getChantId() {
        return chantId;
    }

    public void setChantId(Integer chantId) {
        this.chantId = chantId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

	public List getRolesIdList() {
		return rolesIdList;
	}

	public void setRolesIdList(List rolesIdList) {
		this.rolesIdList = rolesIdList;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "WorkerInfo [workerId=" + workerId + ", workerName=" + workerName + ", workerCode=" + workerCode
				+ ", loginName=" + loginName + ", password=" + password + ", sex=" + sex + ", company=" + company
				+ ", community=" + community + ", professional=" + professional + ", contact=" + contact
				+ ", fixedPhone=" + fixedPhone + ", province=" + province + ", city=" + city + ", district=" + district
				+ ", headPortrait=" + headPortrait + ", certCode=" + certCode + ", email=" + email + ", qq=" + qq
				+ ", status=" + status + ", loginNum=" + loginNum + ", isfirst=" + isfirst + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", type=" + type + ", storeId=" + storeId
				+ ", sellerLoginId=" + sellerLoginId + ", siteId=" + siteId + ", chantId=" + chantId + ", rank=" + rank
				+ ", rolesIdList=" + rolesIdList + ", roleId=" + roleId + "]";
	}
	
}
