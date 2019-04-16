/**
 * 
 */
package com.antke.website.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.CardInfoMapper;
import com.antke.website.model.bean.CardInfo;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.ICardInfoService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class CardInfoServiceImpl implements ICardInfoService {
	private final static Log log = LogFactory.getLog(CardInfoServiceImpl.class);
	@Autowired
	public CardInfoMapper cardInfoMapper;
	
	public int insertGoodsSkuInfo(CardInfo cardInfo) {
		return  cardInfoMapper.insertSelective(cardInfo);
	}
	
 
	public PageInfo<List> queryCardListByPages(PageInfo<List> pageInfo, Map<String, Object> map) {
		int count = cardInfoMapper.queryCardListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<List> cardList = cardInfoMapper.queryCardListByPages(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,cardList);
		return pageInfo;
	}
	
	public int deleteCard(int card_id) {
		return  cardInfoMapper.deleteCard(card_id);
	}
	
	public int updateCard(CardInfo cardInfo) {
		return  cardInfoMapper.updateByPrimaryKeySelective(cardInfo);
	}
	
	public CardInfo getCardById(int cardId) {
		return  cardInfoMapper.selectByPrimaryKey(cardId);
	}
	
	
	
}
