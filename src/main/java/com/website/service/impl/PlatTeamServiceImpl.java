package com.website.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.website.bean.PageInfo;
import com.website.bean.PlatTeam;
import com.website.bean.PlatTeamGoods;
import com.website.bean.PlatTeamRegion;
import com.website.dao.PlatTeamDetailsMapper;
import com.website.dao.PlatTeamGoodsMapper;
import com.website.dao.PlatTeamMapper;
import com.website.service.IGoodsInfoService;
import com.website.service.IPlatTeamRegionService;
import com.website.service.IPlatTeamService;
import com.website.utils.CommonsUtil;

@Service
public class PlatTeamServiceImpl implements IPlatTeamService {

	private final static String XLS = "xls";
	private final static String XLSX = "xlsx";

	@Autowired
	private PlatTeamMapper platTeamMapper;
	@Autowired
	private PlatTeamDetailsMapper platTeamDetailsMapper;
	@Autowired
	private IGoodsInfoService goodsInfoService;
	@Autowired
	private IPlatTeamRegionService platTeamRegionService;
	@Autowired
	private PlatTeamGoodsMapper platTeamGoodsMapper;
	
	
	
	/* 
	 * 查询团购列表
	 * @see com.website.service.IPlatTeamService#selectAll(java.util.Map, com.website.model.bean.PageInfo)
	 */
	@Override
	public PageInfo<Map> selectPlatTeamListByMap(Map map, PageInfo pageInfo) {
		int count = platTeamMapper.selectPlatTeamCountByMap(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<Map> noticeList = platTeamMapper.selectPlatTeamListByMap(rowBounds, map);
		for (Map map2 : noticeList) {
			String region_name = map2.get("region_name") + "";
			if (CommonsUtil.isNotEmpty(region_name)) {
				String[] regionNames = array_unique(region_name.split(","));
				String region = Arrays.toString(regionNames);
				map2.put("region_name", region.substring(1, region.length() - 1));
			}
		}
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,noticeList);
		return pageInfo;
		
	}

	
	/**
	 * 数组去重
	 * 
	 * @param arr
	 * @return
	 */
	public String[] array_unique(String[] a) {
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(a));
		return set.toArray(new String[0]);
	}
	
	/**
	 * 插入平台商品
	 * @param platTeamGoods
	 * @return
	 */
	public int insertPlatTeamGoods(PlatTeamGoods platTeamGoods){
		return platTeamGoodsMapper.insertSelective(platTeamGoods);
	}
	
	/* 
	 * 保存团购信息
	 * @see com.website.service.IPlatTeamService#savePlatTeam(com.website.model.bean.PlatTeam)
	 */
	@Override
	public int savePlatTeam(PlatTeam platTeam)
			throws ParseException {
		return platTeamMapper.newPlatTeam(platTeam);
	}
	/* 
	 *更新团购信息
	 * @see com.website.service.IPlatTeamService#savePlatTeam(com.website.model.bean.PlatTeam)
	 */
	@Override
	public int updatePlatTeam(PlatTeam platTeam){
		return platTeamMapper.updatePlatTeam(platTeam);
	}
	
	/* 
	 *删除团商品
	 */
	@Override
	public int deletePlatTeamGoods(Integer platmId){
		return platTeamMapper.deletePlatTeamGoods(platmId);
	}
	/* 
	 *删除团商品
	 */
	@Override
	public int deletePlatTeamRegion(Integer platmId){
		return platTeamMapper.deletePlatTeamRegion(platmId);
	}
	
	/* 
	 * 导出团购模板
	 * @see com.website.service.IPlatTeamService#slectAllByPlatmId(java.lang.Integer)
	 */
	@Override
	public List<Map> slectAllByPlatmId(Integer platmId) {
		return platTeamMapper.slectAllByPlatmId(platmId);
	}

	@Override
	public PlatTeam slectPlatTeamByPlatmId(Integer platmId) {
		return platTeamMapper.slectPlatTeamByPlatmId(platmId);
	}
	
	/*
	 * (non-Javadoc)导入填好的团购模板
	 * 
	 * @see
	 * com.website.service.IPlatTeamService#export(org.springframework.web
	 * .multipart.MultipartFile)
	 */
	@Override
	public int export(MultipartFile file, Map<String, Object> param) throws IOException {
//		List<String[]> rowList = POIUtils.readExcel(file);
		PlatTeamRegion region = new PlatTeamRegion();
		region.setRebateType(1);
		region.setUpdateDate(new Date());
//		for (String[] strings : rowList) {
//			region.setPteamId(Integer.valueOf(param.get("plaTeamId") + ""));
//			if (CommonsUtil.isNotEmpty(strings[0])) {
//				region.setRegionId(Integer.valueOf(strings[0]));
////				region.setRegionName(strings[1]);
//			}
//			region.setGoodsId(Integer.valueOf(strings[2]));
//			
//			if (CommonsUtil.isNotEmpty(strings[5])) {
//				region.setRegionPrice(Double.valueOf(strings[5]));
//			}
//			if (CommonsUtil.isNotEmpty(strings[6])) {
//				region.setVipPrice(Double.valueOf(strings[6]));
//			}
//			if (CommonsUtil.isNotEmpty(strings[7])) {
//				region.setRebateValue(Double.valueOf(strings[7]));
//			}
//			if (CommonsUtil.isNotEmpty(strings[8])) {
//				region.setStock(Integer.valueOf(strings[8]));
//			}else{
//				region.setStock(999999);
//			}
//			region.setUpdateDate(new Date());
//			platTeamRegionService.updateSelective(region);
//		}
		return 1;
	}
}
