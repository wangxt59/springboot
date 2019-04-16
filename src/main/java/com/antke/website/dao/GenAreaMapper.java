package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.antke.website.model.bean.GenArea;

public interface GenAreaMapper {


    int insert(GenArea record);

    int insertSelective(GenArea record);

    public List getArea(String areaParentno);

}