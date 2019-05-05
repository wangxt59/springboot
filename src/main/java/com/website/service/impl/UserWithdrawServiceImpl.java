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
import com.website.bean.UserWithdraw;
import com.website.dao.UserWithdrawMapper;
import com.website.service.IUserWithdrawService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class UserWithdrawServiceImpl implements IUserWithdrawService {
	private final static Log log = LogFactory.getLog(UserWithdrawServiceImpl.class);
	@Autowired
	public UserWithdrawMapper userWithdrawMapper;
	

	public PageInfo<List> queryWithdrawListByPages(PageInfo<List> pageInfo, Map<String, Object> map) {
		int count = userWithdrawMapper.queryWithdrawListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<List> withdrawList = userWithdrawMapper.queryWithdrawListByPages(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,withdrawList);
		return pageInfo;
	}
	
	public int updateWithdraw(UserWithdraw userWithdraw) {
		return  userWithdrawMapper.updateByPrimaryKeySelective(userWithdraw);
	}
	
	public UserWithdraw getWithdrawById(int withdrawId) {
		return  userWithdrawMapper.selectByPrimaryKey(withdrawId);
	}
	
}
