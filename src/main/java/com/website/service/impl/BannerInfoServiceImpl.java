package com.website.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.BannerInfo;
import com.website.bean.PageInfo;
import com.website.dao.BannerInfoMapper;
import com.website.service.IBannerInfoService;

@Service
public class BannerInfoServiceImpl implements IBannerInfoService {

	@Autowired
	BannerInfoMapper bannerInfoMapper;

	/**
	 * 描述: banner创建
	 * 
	 * @param bannerInfo
	 * @return int 返回类型
	 * @throws
	 * @author shengtaihua
	 * @date 2018-9-26
	 */
	@Override
	public int addBannerInfo(BannerInfo bannerInfo) {
		return bannerInfoMapper.insertSelective(bannerInfo);
	}

	/**
	 * 描述: 分页查询banner列表
	 * 
	 * @param pageInfo
	 * @param map
	 * @return PageInfo<BannerInfo> 返回类型
	 * @throws
	 * @author shengtaihua
	 * @date 2018-9-26
	 */
	@Override
	public PageInfo<BannerInfo> queryBannerListByPages(
			PageInfo<BannerInfo> pageInfo, Map<String, Object> map) {
		int count = bannerInfoMapper.queryBannerListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<BannerInfo> bannerList = bannerInfoMapper.queryBannerListByPages(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,bannerList);
		return pageInfo;
	}

	/**
	 * 描述: 根据id查询banner详情
	 * 
	 * @param map
	 * @return BannerInfo 返回类型
	 * @throws
	 * @author shengtaihua
	 * @date 2018-9-26
	 */
	@Override
	public BannerInfo qyById(Map map) {
		return bannerInfoMapper.qyById(map);
	}

	/**
	 * 描述: 修改banner信息
	 * 
	 * @param bannerInfo
	 * @return int 返回类型
	 * @throws
	 * @author shengtaihua
	 * @date 2018-9-26
	 */
	@Override
	public int updateBannerInfo(BannerInfo bannerInfo) {
		return bannerInfoMapper.updateByPrimaryKeySelective(bannerInfo);
	}

}
