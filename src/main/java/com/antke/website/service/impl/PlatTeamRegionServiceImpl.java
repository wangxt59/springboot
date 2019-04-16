package com.antke.website.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.PlatTeamRegionMapper;
import com.antke.website.model.bean.PlatTeamRegion;
import com.antke.website.service.IGoodsInfoService;
import com.antke.website.service.IPlatTeamRegionService;
import com.antke.website.utils.CommonsUtil;

@Service
public class PlatTeamRegionServiceImpl implements IPlatTeamRegionService {

	@Autowired
	private PlatTeamRegionMapper platTeamRegionMapper;
	@Autowired
	private IGoodsInfoService goodsInfoService;

	@Override
	public PlatTeamRegion getRegionById(Integer id) {
		return platTeamRegionMapper.getRegionById(id);
	}
	
	@Override
	public List<PlatTeamRegion> selectPlatTeamRegionList(Map map) {
		return platTeamRegionMapper.selectPlatTeamRegionList(map);
	}
	
	@Override
	public List<Map> selectRegionList(Map map) {
		return platTeamRegionMapper.selectRegionList(map);
	}
	
	@Override
	public void saveTeamRegion(Map<String, Object> param, Date date, SimpleDateFormat sdf, int platid) {
		PlatTeamRegion teamRegion = new PlatTeamRegion();
		teamRegion.setCreateDate(date);
		teamRegion.setUpdateDate(date);
		String region = "" + param.get("goodsStr");
		List<Map> goodsInfos = new ArrayList<Map>();
		if (CommonsUtil.isNotEmpty(region)) {
			String[] regions = region.split(",");
			if (CommonsUtil.isNotEmpty(param.get("cityIds") + "")
					&& CommonsUtil.isNotEmpty(param.get("cityNames") + "")) {
				String[] cityIds = (param.get("cityIds") + "").split(",");
				String[] cityName = (param.get("cityNames") + "").split(",");
				for (int i = 0; i < cityIds.length; i++) {
					for (String goodsCode : regions) {
						goodsInfos = goodsInfoService.queryByCode(goodsCode);
						for (Map goodsInfo : goodsInfos) {
							if (CommonsUtil.isNotEmpty(goodsInfo + "")) {
								teamRegion.setGoodsId(Integer.valueOf(goodsInfo.get("goods_id") + ""));
								teamRegion.setGoodsName(goodsInfo.get("goods_name") + "");
								teamRegion.setGoodsPic(goodsInfo.get("pic_url") + "");
								teamRegion.setMarketPrice(Double.valueOf(goodsInfo.get("market_price") + ""));
								teamRegion.setPteamId(platid);
								if (CommonsUtil.isNotEmpty(goodsInfo.get("rebate_type") + "")) {
									teamRegion.setRebateType(Integer.valueOf(goodsInfo.get("rebate_type") + ""));
								}
								if (CommonsUtil.isNotEmpty(goodsInfo.get("rebate_amount") + "")) {
									teamRegion.setRebateValue(Double.valueOf(goodsInfo.get("rebate_amount") + ""));
								}
								if (CommonsUtil.isNotEmpty(goodsInfo.get("region_id") + "")) {
									teamRegion.setRegionId(Integer.valueOf(cityIds[i]));
								}
								if (CommonsUtil.isNotEmpty(goodsInfo.get("region_name") + "")) {
									teamRegion.setRegionName(cityName[i]);
								}
								if (CommonsUtil.isNotEmpty(goodsInfo.get("region_price") + "")) {
									teamRegion.setRegionPrice(Double.valueOf(goodsInfo.get("region_price") + ""));
								}
//								if (CommonsUtil.isNotEmpty(goodsInfo.get("region_type") + "")) {
//									teamRegion.setRegionType(Integer.valueOf(goodsInfo.get("region_type") + ""));
//								}
								if (CommonsUtil.isNotEmpty(goodsInfo.get("stock") + "")) {
									teamRegion.setStock(Integer.valueOf(goodsInfo.get("stock") + ""));
								}
								// teamRegion.setVipPrice(goodsInfo.get("rebate_type") +
								// "");vip价格
								platTeamRegionMapper.newPlatTeamRegion(teamRegion);
							}
						}
					}
				}
			}

		}
	}
	@Override
	public int insertPlatTeamRegion(PlatTeamRegion region) {
		return platTeamRegionMapper.newPlatTeamRegion(region);
	}
	@Override
	public int updateSelective(PlatTeamRegion region){
		 return platTeamRegionMapper.updateSelective(region);
	 }
	 
	@Override
	public int updateRegion(PlatTeamRegion region) {
		return platTeamRegionMapper.updateRegion(region);
	}

}
