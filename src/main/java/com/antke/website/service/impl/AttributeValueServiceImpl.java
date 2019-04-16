package com.antke.website.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.AttributeValueDao;
import com.antke.website.model.bean.AttributeValue;
import com.antke.website.service.IAttributeValueService;

@Service
public class AttributeValueServiceImpl implements IAttributeValueService{

	private final static Log log = LogFactory.getLog(AttributeValueServiceImpl.class);
	
	@Autowired
	public AttributeValueDao attributeValueDao;
	
	@Override
	public int insertAttributeValue(AttributeValue attributeValue) {
		return attributeValueDao.insertAttributeValue(attributeValue);
	}

	@Override
	public int updateAttributeValue(AttributeValue attributeValue) {
		return attributeValueDao.updateAttributeValue(attributeValue);
	}

	@Override
	public int deleteAttributeValue(String value_id) {
		return attributeValueDao.deleteAttributeValue(value_id);
	}

	@Override
	public AttributeValue queryAttributeValue(Map map) {
		return attributeValueDao.queryAttributeValue(map);
	}

	@Override
	public List queryAttributeValueList(Map map) {
		return attributeValueDao.queryAttributeValueList(map);
	}

	@Override
	public AttributeValue deleteAttributeValue(Map map) {
		return attributeValueDao.deleteAttributeValue(map);
	}

	@Override
	public List queryAttributeValue1(Map map) {
		return attributeValueDao.queryAttributeValue1(map);
	}

	@Override
	public int delAttributeValue(Map map) {
		return attributeValueDao.delAttributeValue(map);
	}

	

}
