package com.website.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.Attribute;
import com.website.bean.AttributeRelation;
import com.website.bean.AttributeValue;
import com.website.bean.Category;
import com.website.bean.PageInfo;
import com.website.dao.AttributeRelationDao;
import com.website.dao.CategoryDao;
import com.website.service.IAttributeRelationService;

@Service
public class AttributeRelationServiceImpl implements IAttributeRelationService{

	private final static Log log = LogFactory.getLog(AttributeRelationServiceImpl.class);
	
	@Autowired
	public AttributeRelationDao attributeRelationDao;
	@Autowired
	public CategoryDao categoryDao;
	
	@Override
	public int insertAttributeRelation(AttributeRelation attributeRelation) {
		return attributeRelationDao.insertAttributeRelation(attributeRelation);
	}

	@Override
	public int updateAttributeRelation(AttributeRelation attributeRelation) {
		return attributeRelationDao.updateAttributeRelation(attributeRelation);
	}
	

	@Override
	public void deleteAttributeRelation(int relation_id) {
		attributeRelationDao.deleteAttributeRelation(relation_id);
	}

	@Override
	public List<AttributeRelation> queryAttributeRelation(Map map) {
		return attributeRelationDao.queryAttributeRelation(map);
	}

	public List<AttributeRelation> queryAttributeRelationList(Map<String, Object> map) {
		return attributeRelationDao.queryAttributeRelationList(map);
	}

	@Override
	public PageInfo<AttributeRelation> queryAttributeRelationListByPage(
			PageInfo<AttributeRelation> pageInfo, Map map) {
		int totalRecord = attributeRelationDao.queryAttributeRelationListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<AttributeRelation> datas = attributeRelationDao.queryAttributeRelationListByPage(rowBounds, map);
		Map<String, Object> categoryMap = new HashMap<String, Object>();
		List<AttributeRelation> _datas = new ArrayList<AttributeRelation>();
		if(datas.size()>0){
			for(AttributeRelation attributeRelation :datas){
				//三级目录
				//如果不是一级根目录
				if(attributeRelation.getParent_id()!=null){
					if(attributeRelation.getParent_id()!=null && !"-1".equals(attributeRelation.getParent_id())){
						//二级目录
						String buffer = attributeRelation.getCategory_name() + "";
						categoryMap.put("category_id", attributeRelation.getParent_id());
						Category category = categoryDao.queryCategory(categoryMap);
						buffer = category.getCategory_name() + "-" + buffer;
						if(category.getParent_id()!=null && !"-1".equals(category.getParent_id())){
							//一级目录
							categoryMap.put("category_id", category.getParent_id());
							category = categoryDao.queryCategory(categoryMap);
							buffer = category.getCategory_name() + "-" + buffer;
						}
						  attributeRelation.setCategory_name(buffer);
						}
				}else{
					attributeRelation.setCategory_name("未分类");
				}
				_datas.add(attributeRelation);
			}
		}
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord, _datas);
		return pageInfo;
	}

	@Override
	public List queryAttributeRelationList1(Map map) {
		return attributeRelationDao.queryAttributeRelationList1(map);
	}

	@Override
	public List queryAttributeRelationList2(Map map) {
		return attributeRelationDao.queryAttributeRelationList2(map);
	}
	
	@Override
	public AttributeRelation deleteAttributeRelation(Map map) {
		return attributeRelationDao.deleteAttributeRelation(map);
	}

	@Override
	public List<Attribute> queryAttributeList(Map<String, Object> map) {
		return attributeRelationDao.queryAttributeList(map);
	}

	@Override
	public List<AttributeValue> queryAttributeValueList(Map<String, Object> map) {
		return attributeRelationDao.queryAttributeValueList(map);
	}
	
	@Override
	public List<AttributeRelation> queryCateExtendAttrIsExist(String category_id) {
		return attributeRelationDao.queryCateExtendAttrIsExist(category_id);
	}
	
}
