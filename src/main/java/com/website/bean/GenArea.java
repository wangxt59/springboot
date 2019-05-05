package com.website.bean;

public class GenArea {
    private Integer areaId;

    private String areaNo;

    private String areaName;

    private String areaShortname;

    private String areaFullspell;

    private String areaShortspell;

    private String areaCode;

    private String areaParentno;

    private String areaOldno;

    private Integer areaRank;

    private String areaZipcode;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo == null ? null : areaNo.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaShortname() {
        return areaShortname;
    }

    public void setAreaShortname(String areaShortname) {
        this.areaShortname = areaShortname == null ? null : areaShortname.trim();
    }

    public String getAreaFullspell() {
        return areaFullspell;
    }

    public void setAreaFullspell(String areaFullspell) {
        this.areaFullspell = areaFullspell == null ? null : areaFullspell.trim();
    }

    public String getAreaShortspell() {
        return areaShortspell;
    }

    public void setAreaShortspell(String areaShortspell) {
        this.areaShortspell = areaShortspell == null ? null : areaShortspell.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaParentno() {
        return areaParentno;
    }

    public void setAreaParentno(String areaParentno) {
        this.areaParentno = areaParentno == null ? null : areaParentno.trim();
    }

    public String getAreaOldno() {
        return areaOldno;
    }

    public void setAreaOldno(String areaOldno) {
        this.areaOldno = areaOldno == null ? null : areaOldno.trim();
    }

    public Integer getAreaRank() {
        return areaRank;
    }

    public void setAreaRank(Integer areaRank) {
        this.areaRank = areaRank;
    }

    public String getAreaZipcode() {
        return areaZipcode;
    }

    public void setAreaZipcode(String areaZipcode) {
        this.areaZipcode = areaZipcode == null ? null : areaZipcode.trim();
    }
}