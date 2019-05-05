/**
 * 
 */
package com.website.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.dao.ChannelMapper;
import com.website.service.IChannelService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class ChannelServiceImpl implements IChannelService {

	@Autowired
	public ChannelMapper channelMapper;
	
	@Override
	public List queryChannelList(Map map) {
		return channelMapper.queryChannelList(map);
	}
}
