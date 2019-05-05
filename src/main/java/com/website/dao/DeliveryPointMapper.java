package com.website.dao;

import java.util.List;
import java.util.Map;

import com.website.bean.DeliveryPoint;

public interface DeliveryPointMapper {
    int insert(DeliveryPoint record);

    int insertSelective(DeliveryPoint record);

    DeliveryPoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliveryPoint record);

    int updateByPrimaryKey(DeliveryPoint record);

	void savePoint(Map<String, Object> map);
	
	int queryPointByParam(Map<String, Object> param);

	List querySeMePointList(Map<String, Object> map);

	Map getDeliveryPoint(Map<String, Object> param);
}