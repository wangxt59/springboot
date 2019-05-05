package com.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.dao.GenAreaMapper;
import com.website.service.IGenArea;


@Service
public class GenAreaImpl implements IGenArea{
	@Autowired
	private GenAreaMapper genAreaMapper;
	@Override
	public List getArea(String areaParentno) {
		// TODO Auto-generated method stub
		return genAreaMapper.getArea(areaParentno);
	}

}
