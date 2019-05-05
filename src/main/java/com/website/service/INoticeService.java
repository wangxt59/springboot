package com.website.service;

import java.util.Map;

import com.website.bean.Notice;
import com.website.bean.PageInfo;

public interface INoticeService {

	public int addNotice(Notice notice);

	public PageInfo<Notice> queryNoticeListByPages(PageInfo<Notice> pageInfo,Map<String, Object> map);

	public Notice qyById(Map map);

	public int updateNotice(Notice notice);

}
