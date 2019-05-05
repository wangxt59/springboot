package com.website.dao;

import java.util.List;

import com.website.bean.GenArea;

public interface GenAreaMapper {


    int insert(GenArea record);

    int insertSelective(GenArea record);

    public List getArea(String areaParentno);

}