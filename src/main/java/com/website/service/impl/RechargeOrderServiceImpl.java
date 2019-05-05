/**
 * 
 */
package com.website.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.PageInfo;
import com.website.bean.RechargeOrder;
import com.website.dao.RechargeOrderMapper;
import com.website.service.IRechargeOrderService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class RechargeOrderServiceImpl implements IRechargeOrderService {
	private final static Log log = LogFactory.getLog(RechargeOrderServiceImpl.class);
	@Autowired
	public RechargeOrderMapper rechargeOrderMapper;
	
	public PageInfo<List> queryRechargeOrderListByPages(PageInfo<List> pageInfo, Map<String, Object> map) {
		int count = rechargeOrderMapper.queryRechargeOrderListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<List> orderList = rechargeOrderMapper.queryRechargeOrderListByPages(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,orderList);
		return pageInfo;
	}
	
	public int updateRechargeOrder(RechargeOrder rechargeOrder) {
		return  rechargeOrderMapper.updateByPrimaryKeySelective(rechargeOrder);
	}
	
	public RechargeOrder getRechargeOrderById(int id) {
		return  rechargeOrderMapper.selectByPrimaryKey(id);
	}
}
