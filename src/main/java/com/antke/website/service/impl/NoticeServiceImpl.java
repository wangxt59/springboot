package com.antke.website.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.NoticeMapper;
import com.antke.website.model.bean.Notice;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.INoticeService;

@Service
public class NoticeServiceImpl implements INoticeService {

	@Autowired
	NoticeMapper noticeMapper;

	 
	@Override
	public int addNotice(Notice notice) {
		return noticeMapper.insertSelective(notice);
	}

	 
	@Override
	public PageInfo<Notice> queryNoticeListByPages(PageInfo<Notice> pageInfo, Map<String, Object> map) {
		int count = noticeMapper.queryNoticeListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<Notice> noticeList = noticeMapper.queryNoticeListByPages(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,noticeList);
		return pageInfo;
	}

	 
	@Override
	public Notice qyById(Map map) {
		return noticeMapper.qyById(map);
	}
 
	@Override
	public int updateNotice(Notice notice) {
		return noticeMapper.updateByPrimaryKeySelective(notice);
	}

}
