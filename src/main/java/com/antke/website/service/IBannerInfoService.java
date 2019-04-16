package com.antke.website.service;

import java.util.Map;
import com.antke.website.model.bean.BannerInfo;
import com.antke.website.model.bean.PageInfo;

/**  
 * 描述: banner
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-9-26 
*/  
public interface IBannerInfoService {
	 
	/**   
	 * 描述: banner创建 
	 * @param  bannerInfo
	 * @return int    返回类型   
	 * @throws   
	 * @author shengtaihua 
	 * @date  2018-9-26 
	*/
	public int addBannerInfo(BannerInfo bannerInfo);
	
 
	/**   
	 * 描述: 分页查询banner列表 
	 * @param pageInfo
	 * @param map
	 * @return PageInfo<BannerInfo>    返回类型   
	 * @throws   
	 * @author shengtaihua 
	 * @date  2018-9-26 
	*/
	public PageInfo<BannerInfo> queryBannerListByPages(PageInfo<BannerInfo> pageInfo, Map<String, Object> map);
	
	 
	/**   
	 * 描述: 根据id查询banner详情
	 * @param map
	 * @return BannerInfo    返回类型   
	 * @throws   
	 * @author shengtaihua 
	 * @date  2018-9-26 
	*/
	public BannerInfo qyById(Map map);
	
   
	/**   
	 * 描述: 修改banner信息  
	 * @param bannerInfo
	 * @return int    返回类型   
	 * @throws   
	 * @author shengtaihua 
	 * @date  2018-9-26 
	*/
	public int updateBannerInfo(BannerInfo bannerInfo);
	

}
