package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.CardInfo;
import com.antke.website.model.bean.PageInfo;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface ICardInfoService {

	public int insertGoodsSkuInfo(CardInfo cardInfo);
	
	public PageInfo<List> queryCardListByPages(PageInfo<List> pageInfo, Map<String, Object> map);

	public int deleteCard(int card_id);
	
	public int updateCard(CardInfo cardInfo);
	
	public CardInfo getCardById(int cardId);
}
