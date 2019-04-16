package com.antke.website.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.AttributeDao;
import com.antke.website.model.bean.Attribute;
import com.antke.website.service.IAttributeService;

@Service
public class AttributeServiceImpl implements IAttributeService{
	
	private final static Log log = LogFactory.getLog(AttributeServiceImpl.class);
	
	@Autowired
	public AttributeDao attributeDao;
	
	@Override
	public int insertAttribute(Attribute attribute) {
		return attributeDao.insertAttribute(attribute);
	}

	@Override
	public int updateAttribute(Attribute attribute) {
		return attributeDao.updateAttribute(attribute);
	}

	@Override
	public int deleteAttribute(String attr_id) {
		return attributeDao.deleteAttribute(attr_id);
	}

	@Override
	public Attribute queryAttribute(Map map) {
		return attributeDao.queryAttribute(map);
	}

	@Override
	public List queryAttributeList(Map map) {
		return attributeDao.queryAttributeList(map);
	}

	@Override
	public List queryAttributeList1(Map map) {
		return attributeDao.queryAttributeList(map);
	}

	@Override
	public List queryAttrValueList(Map map) {
		return attributeDao.queryAttrValueList(map);
	}

	@Override
	public List queryCategoryAttr(Map map) {
		return attributeDao.queryCategoryAttr(map);
	}

}
