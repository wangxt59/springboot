package com.website.service;

import java.util.List;
import java.util.Map;

import com.website.bean.GoodsPic;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface IGoodsPicService {
	public int insertGoodsPic(GoodsPic goodsPic);
	
	List queryPics(Map map);
	
	public int deleteGoodsPicByGoodsId(int goods_id);

	public Map queryPicsByGoodId(Integer string);
}
