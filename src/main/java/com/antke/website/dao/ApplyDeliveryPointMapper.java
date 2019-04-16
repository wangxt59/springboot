package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.ApplyDeliveryPoint;

public interface ApplyDeliveryPointMapper {
    int insert(ApplyDeliveryPoint record);

    int insertSelective(ApplyDeliveryPoint record);

    ApplyDeliveryPoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyDeliveryPoint record);

    int updateByPrimaryKey(ApplyDeliveryPoint record);
    
    List queryPointListByParam(Map param);
    
}