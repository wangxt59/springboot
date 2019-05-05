package com.power.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单实体类
 * @author bizf
 *
 */
public class Menu implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	private String m_id;
	private String menu_id;
	private String menu_name;
	private String parentid;
	private String levels;
	private String model;
	private String xmlid;
	private String url;
	private String relate_sub_id;
	private String menu_desciption;
	
	private Integer status;//状态：1，启动；2，删除
	private Date create_date;//注册时间
	private Date update_date;//更新时间
	private String operator;//操作人
	private String icon_url;//菜单栏图片url
	
	private List fristMuenList;
	private List secondMuenList;
	private List thirdMuenList;
	
	private String check;
	
	
	public String getIcon_url() {
		return icon_url;
	}
	public void setIcon_url(String iconUrl) {
		icon_url = iconUrl;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String mId) {
		m_id = mId;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menuId) {
		menu_id = menuId;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menuName) {
		menu_name = menuName;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getXmlid() {
		return xmlid;
	}
	public void setXmlid(String xmlid) {
		this.xmlid = xmlid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRelate_sub_id() {
		return relate_sub_id;
	}
	public void setRelate_sub_id(String relateSubId) {
		relate_sub_id = relateSubId;
	}
	public String getMenu_desciption() {
		return menu_desciption;
	}
	public void setMenu_desciption(String menuDesciption) {
		menu_desciption = menuDesciption;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date updateDate) {
		update_date = updateDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List getSecondMuenList() {
		return secondMuenList;
	}
	public void setSecondMuenList(List secondMuenList) {
		this.secondMuenList = secondMuenList;
	}
	public List getThirdMuenList() {
		return thirdMuenList;
	}
	public void setThirdMuenList(List thirdMuenList) {
		this.thirdMuenList = thirdMuenList;
	}
	public List getFristMuenList() {
		return fristMuenList;
	}
	public void setFristMuenList(List fristMuenList) {
		this.fristMuenList = fristMuenList;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return "Menu [m_id=" + m_id + ", menu_id=" + menu_id + ", menu_name="
				+ menu_name + ", parentid=" + parentid + ", levels=" + levels
				+ ", model=" + model + ", xmlid=" + xmlid + ", url=" + url
				+ ", relate_sub_id=" + relate_sub_id + ", menu_desciption="
				+ menu_desciption + ", status=" + status + ", create_date="
				+ create_date + ", update_date=" + update_date + ", operator="
				+ operator + ", icon_url=" + icon_url + ", fristMuenList="
				+ fristMuenList + ", secondMuenList=" + secondMuenList
				+ ", thirdMuenList=" + thirdMuenList + ", check=" + check + "]";
	}
	
	
}
