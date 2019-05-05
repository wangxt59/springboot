package com.power.bean;

import java.util.List;

public class WorkerInfo {
	private String worker_id;// 员工id
	private String worker_name;// 员工名称
	private String worker_code;// 员工编号
	private String login_name;// 登录名
	private String password;// 密码
	private String sex;// 性别（0：男；1：女；2：保密）
	private String company;// 所属公司
	private String community;// 管辖社区
	private String professional;// 职位
	private String contact;// 手机号
	private String fixed_phone;// 座机
	private String province;// 省
	private String city;// 市
	private String district;// 区
	private String head_portrait;// 头像
	private String cert_code;// 身份证号
	private String email;// Email地址
	private String qq;// QQ号
	private String status;// 状态：0，启动；1，冻结；2，锁定；3，注销
	private int login_num;// 登陆次数
	private String isfirst;// 首次登陆（0，是；1，否）
	private String create_date;// 注册时间
	private String update_date;// 更新时间
	private Integer type;// 1人员，2商家，3供应商
	//新增字段
	private String store_id;//店铺id
	private String seller_login_id;//商家登录表id
	private Integer site_id;//站点id
	private Integer chant_id;//商户ID
	private Integer rank;//等级 0 平台管理员 1商户管理员 2商户客服 3商户运维
	//冗余字段
	private List rolesIdList;//角色id集合
	private String roleId;//角色id字符串
 
	
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

	public Integer getSite_id() {
		return site_id;
	}

	public void setSite_id(Integer siteId) {
		site_id = siteId;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String storeId) {
		store_id = storeId;
	}

	public String getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(String worker_id) {
		this.worker_id = worker_id;
	}

	public String getWorker_name() {
		return worker_name;
	}

	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}

	public String getWorker_code() {
		return worker_code;
	}

	public void setWorker_code(String worker_code) {
		this.worker_code = worker_code;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFixed_phone() {
		return fixed_phone;
	}

	public void setFixed_phone(String fixed_phone) {
		this.fixed_phone = fixed_phone;
	}

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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getHead_portrait() {
		return head_portrait;
	}

	public void setHead_portrait(String head_portrait) {
		this.head_portrait = head_portrait;
	}

	public String getCert_code() {
		return cert_code;
	}

	public void setCert_code(String cert_code) {
		this.cert_code = cert_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsfirst() {
		return isfirst;
	}

	public void setIsfirst(String isfirst) {
		this.isfirst = isfirst;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public void setLogin_num(int login_num) {
		this.login_num = login_num;
	}

	public int getLogin_num() {
		return login_num;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSeller_login_id() {
		return seller_login_id;
	}

	public void setSeller_login_id(String sellerLoginId) {
		seller_login_id = sellerLoginId;
	}

	public Integer getChant_id() {
		return chant_id;
	}

	public void setChant_id(Integer chantId) {
		chant_id = chantId;
	}

	@Override
	public String toString() {
		return "WorkerInfo [worker_id=" + worker_id + ", worker_name="
				+ worker_name + ", worker_code=" + worker_code
				+ ", login_name=" + login_name + ", password=" + password
				+ ", sex=" + sex + ", company=" + company + ", community="
				+ community + ", professional=" + professional + ", contact="
				+ contact + ", fixed_phone=" + fixed_phone + ", province="
				+ province + ", city=" + city + ", district=" + district
				+ ", head_portrait=" + head_portrait + ", cert_code="
				+ cert_code + ", email=" + email + ", qq=" + qq + ", status="
				+ status + ", login_num=" + login_num + ", isfirst=" + isfirst
				+ ", create_date=" + create_date + ", update_date="
				+ update_date + ", type=" + type + ", store_id=" + store_id
				+ ", seller_login_id=" + seller_login_id + ", site_id="
				+ site_id + ", chant_id=" + chant_id + ", rank=" + rank
				+ ", rolesIdList=" + rolesIdList + "]";
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
