package com.website.dao;

import java.util.List;
import java.util.Map;

import com.website.bean.Channel;

public interface ChannelMapper {
    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
    
    public List queryChannelList(Map map);
}