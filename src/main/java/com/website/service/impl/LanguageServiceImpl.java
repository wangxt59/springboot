/**
 * 
 */
package com.website.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.dao.LanguageMapper;
import com.website.service.ILanguageService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class LanguageServiceImpl implements ILanguageService {

	@Autowired
	public LanguageMapper languageMapper;
	
	@Override
	public List queryLanguageList(Map map) {
		return languageMapper.queryLanguageList(map);
	}
}
