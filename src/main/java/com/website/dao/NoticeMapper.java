package com.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.website.bean.Notice;

public interface NoticeMapper {
    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
    
    public int queryNoticeListCount(Map map);
	
  	public List<Notice> queryNoticeListByPages(RowBounds rowBounds, Map map);
  	
  	public Notice qyById(Map map);
}