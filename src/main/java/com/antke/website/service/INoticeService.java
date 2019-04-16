package com.antke.website.service;

import java.util.Map;

import com.antke.website.model.bean.Notice;
import com.antke.website.model.bean.PageInfo;

public interface INoticeService {

	public int addNotice(Notice notice);

	public PageInfo<Notice> queryNoticeListByPages(PageInfo<Notice> pageInfo,Map<String, Object> map);

	public Notice qyById(Map map);

	public int updateNotice(Notice notice);

}
