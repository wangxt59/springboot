/**
 * 
 */
package com.website.service.impl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.RankBrokerage;
import com.website.dao.RankBrokerageMapper;
import com.website.service.IRankBrokerageService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class RankBrokerageServiceImpl implements IRankBrokerageService {
	private final static Log log = LogFactory.getLog(RankBrokerageServiceImpl.class);
	@Autowired
	public RankBrokerageMapper rankBrokerageMapper;
	
	
	public RankBrokerage getBrokerageByRank(int rank) {
		return  rankBrokerageMapper.getBrokerageByRank(rank);
	}
	
}
