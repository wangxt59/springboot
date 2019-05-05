package com.website.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.dao.ApplyDeliveryPointMapper;
import com.website.dao.DeliveryPointMapper;
import com.website.service.IApplyDeliveryPointService;

@Service
public class ApplyDeliveryPointServiceImpl implements IApplyDeliveryPointService {

	@Autowired
	public ApplyDeliveryPointMapper applyDeliveryPointMapper;
	@Autowired
	public DeliveryPointMapper deliveryPointMapper;
	
	/* 
	 *   根据团user_id 获取自提点的信息
	 * @see com.website.service.IApplyDeliveryPointService#getPointByAppId(java.lang.Integer, java.lang.String)
	 */
	@Override
	public List getPointByAppId(Integer user_id, String string) {
		Map param = new HashMap();
		param.put("user_id", user_id);
		param.put("status", 1);
		List<Map<String, Object>> pointList = applyDeliveryPointMapper.queryPointListByParam(param);
		List newResource = new ArrayList();
		List upResource = new ArrayList();
		if(pointList.size() > 0 && pointList != null){
			for (Map<String, Object> map : pointList) {
				int deliveryPoint = deliveryPointMapper.queryPointByParam(map);
				if(deliveryPoint <= 0){
					newResource.add(map);
				}else {
					upResource.add(map);
				}
			}
		}
		if(string == "new"){
			return newResource;
		}
		if(string == "up"){
			return upResource;
		}
		return null;
	}

}
