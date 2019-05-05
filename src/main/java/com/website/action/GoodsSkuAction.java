package com.website.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.bean.GoodsInfo;
import com.website.bean.GoodsSku;
import com.website.bean.PageInfo;
import com.website.service.IGoodsInfoService;
import com.website.service.IGoodsSkuService;
import com.website.utils.CommonsUtil;

@Controller
@RequestMapping("/goodsSku")
public class GoodsSkuAction {
	private static Logger log = Logger.getLogger(GoodsSkuAction.class);
	
	@Autowired
	private IGoodsSkuService goodsSkuService;
	@Autowired
	private IGoodsInfoService goodsInfoService;
	
	/**wxt
	 * 查看区域价格
	 */
	@RequestMapping("/regionalPrices.do")
	public ModelAndView regionalPrices(@RequestParam("goods_id")Integer goods_id,Integer currentPage){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		PageInfo<Map> pageInfo = new PageInfo<Map>();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		if (CommonsUtil.isEmpty(currentPage+"")) {
			pageInfo.setCurrentPage("1");
		}else {
			pageInfo.setCurrentPage(currentPage);
		}
//		pageInfo.setPageSize(1);
		pageInfo=goodsSkuService.qyById(pageInfo, goods_id);
		
//		list=goodsSkuService.qyById(goods_id);
		returnMap.put("pageInfo",pageInfo);
		returnMap.put("goods_id",goods_id);
		return new ModelAndView("goodsInfo/regionalPrices.jsp","map",returnMap);
	}
	
	/**wxt
	 * 设置区域价格(进入)
	 */
	@RequestMapping("/addRegionalPrices.do")
	public ModelAndView addRegionalPrices(@RequestParam("goods_id")String goodsId){
		Map goods=goodsInfoService.qyById(Integer.valueOf(goodsId));
		return new ModelAndView("goodsInfo/addRegionalPrices.jsp","map",goods);
	}	
	/**wxt
	 * 设置区域价格
	 */
	@RequestMapping("/addgoodsSku.do")
	public ModelAndView addgoodsSku(@RequestBody ArrayList<Map> goodsSkuList){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String, Object> reMap=new HashMap<String, Object>();
		try {
			String  goodsId=goodsSkuList.get(0).get("goodsId")+"";
			for (Map<String,String> map : goodsSkuList) {
				System.out.println(map.toString());
//				GoodsSku goodsSku=JSON.parseObject(JSON.toJSONString(map), GoodsSku.class);
				if (map.get("goodsId")!=null&&!("".equals(map.get("goodsId")))) {
					List<GoodsSku> goodsSkus=new ArrayList<GoodsSku>();
					GoodsSku goodsSku=new GoodsSku();
					if (map.get("regionId")!=null&&!("".equals(map.get("regionId")))) {
						reMap.put("goodsId", Integer.parseInt(goodsId));
						reMap.put("regionId", Integer.parseInt(map.get("regionId")));
						goodsSkus=goodsSkuService.selectByMap(reMap);
						if (goodsSkus.size()>0) {
							goodsSku=goodsSkus.get(0);
						}
						
						
						goodsSku.setRegionId(Integer.parseInt(map.get("regionId")));
					}
					
//					goodsSku.setCreateDate(new Date());
					goodsSku.setUpdateDate(new Date());
					goodsSku.setRegionType(3);
					
					if (map.get("regionName")!=null&&!("".equals(map.get("regionName")))) {
						goodsSku.setRegionName(map.get("regionName"));
					}
					if (map.get("goodsId")!=null&&!("".equals(map.get("goodsId")))) {
						goodsSku.setGoodsId(Integer.parseInt(map.get("goodsId")));
					}
					if (map.get("marketPrice")!=null&&!("".equals(map.get("marketPrice")))) {
						goodsSku.setMarketPrice(Double.valueOf(map.get("marketPrice")));			
					}
					if (map.get("regionPrice")!=null&&!("".equals(map.get("regionPrice")))) {
						goodsSku.setRegionPrice(Double.valueOf(map.get("regionPrice")));
					}
					if (map.get("stock")!=null&&!("".equals(map.get("stock")))) {
						goodsSku.setStock(Integer.parseInt(map.get("stock")));
					}
					if (CommonsUtil.isNotEmpty(map.get("rebateRatio")+"")) {
//						BigDecimal rebateRatio=new BigDecimal(map.get("rebateRatio")+"");
//						BigDecimal rebateAmount=rebateRatio.subtract(rebateRatio).setScale(2, BigDecimal.ROUND_HALF_UP);
						goodsSku.setRebateRatio(Double.valueOf(map.get("rebateRatio")));
//						goodsSku.setRebateAmount();
					}
					
					GoodsInfo goodsInfo=goodsInfoService.selectByPrimaryKey(Integer.parseInt(goodsId));
					if (goodsInfo==null) {
						return new ModelAndView("redirect:/goodsSku/regionalPrices.do?goods_id="+goodsId);
					}else {
						if (goodsInfo.getStockType()==2) {
							if (goodsInfo.getStock()<goodsSku.getStock()) {
								continue;
							}
							goodsInfo.setStock(goodsInfo.getStock()-goodsSku.getStock());
							goodsInfoService.updateGoodsInfo(goodsInfo);
						}
						goodsSku.setRebateType(1);
						
						if (goodsSkus.size()>0) {
							goodsSkuService.updateByPrimaryKeySelective(goodsSku);
						}else {
							goodsSkuService.insertMap(goodsSku);
						}
						
					}
					
				}
			}
			return new ModelAndView("redirect:/goodsSku/regionalPrices.do?goods_id="+goodsId);
//			list=goodsSkuService.qyById(Integer.valueOf(goodsSkuList.get(0).get("goodsId").toString()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/goodsSku/addgoodsSku.do");
//		return new ModelAndView("goodsInfo/regionalPrices.jsp","list",list);,
	}
	
	
}
