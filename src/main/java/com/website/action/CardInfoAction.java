/**
 * 
 */
package com.website.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.power.bean.WorkerInfo;
import com.website.bean.CardInfo;
import com.website.bean.GoodsSku;
import com.website.bean.PageInfo;
import com.website.service.ICardInfoService;
import com.website.service.IGoodsSkuService;
//import com.website.utils.POIUtils;
import com.website.utils.POIUtils;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
@Controller
@RequestMapping("/cardInfo")
public class CardInfoAction extends BaseAction{
 
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CardInfoAction.class);
	
	@Autowired
	private ICardInfoService cardInfoService;
	@Autowired
	private IGoodsSkuService goodsSkuService;
	
	 
	/**
	 * 导入卡密
	 */
	@RequestMapping("/importCard.do")
	public String importCard(HttpSession session, HttpServletRequest request,String skuId,
			@RequestParam(value = "file") MultipartFile excelFile){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
	 
			CardInfo  cardInfo =new CardInfo();
			cardInfo.setSkuId(Integer.valueOf(skuId));
			cardInfo.setCreateDate(new Date());
			cardInfo.setUpdateDate(new Date());
			cardInfo.setStatus(0);
			cardInfo.setIsDelete(1);
			//读取文件
			List<String[]> rowList = POIUtils.readExcel(excelFile);
			for(int i=0;i<rowList.size();i++){
				String[] row = rowList.get(i);
				cardInfo.setCardNum(row[0]);
				cardInfo.setCarmine(row[1]);
				cardInfoService.insertGoodsSkuInfo(cardInfo);
			}
			//然后修改这个sku商品的库存
			GoodsSku goodsSku = new GoodsSku();
			goodsSku.setSkuId(Integer.valueOf(skuId));
			goodsSku.setStock(rowList.size());
			goodsSkuService.updateSkuGoodStock(goodsSku);
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/goodsInfo/selectGoodsInfoList.do";
	}
	
	 
		@RequestMapping("/queryCardList.do")
		public ModelAndView queryCardList(PageInfo pageInfo, HttpSession session,
				@RequestParam(value = "goods_name", required = false) String goods_name,
				@RequestParam(value = "goods_code", required = false) String goods_code,
				@RequestParam(value = "flow_no", required = false) String flow_no,
				@RequestParam(value = "status", required = false) String status) {
			WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
	 
			if (worker == null) {
				return new ModelAndView("redirect:/login/workLogin.do");
			}
			// 定义返回值Map
			Map<String, Object> returnMap = new HashMap<String, Object>();
			// 定义回显Map
			Map<String, Object> map = new HashMap<String, Object>();
			try {
				// 如果是初次访问或新的查询时，重置分页
				if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
					pageInfo = new PageInfo<List>();
					pageInfo.setCurrentPage("1");
				}
			 
				if (goods_name != null && !"".equals(goods_name.trim())) {
					map.put("goods_name", goods_name);
					returnMap.put("goods_name", goods_name);
				}
				if (goods_code != null && !"".equals(goods_code.trim())) {
					map.put("goods_code", goods_code);
					returnMap.put("goods_code", goods_code);
				}
				
				if (flow_no != null && !"".equals(flow_no.trim())) {
					map.put("flow_no", flow_no);
					returnMap.put("flow_no", flow_no);
				}
				
				if (status != null && !"".equals(status.trim())) {
					map.put("status", status);
					returnMap.put("status", status);
				}
		 
				pageInfo = cardInfoService.queryCardListByPages(pageInfo, map);
				returnMap.put("pageInfo", pageInfo);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("查询卡密列表异常", e);
			}
			return new ModelAndView("cardInfo/cardInfoList.jsp", "map", returnMap);
		}
	 
		/**
		 * 删除卡
		 * 
		 * @return
		 * @throws IOException
		 */
		@RequestMapping("/deleteCard.do")
		public void  deleteCard(HttpSession session,HttpServletRequest request,HttpServletResponse response,String card_id) throws IOException {
			CardInfo cardInfo=new CardInfo();
			cardInfo.setCardId(Integer.valueOf(card_id));
			cardInfo.setIsDelete(0);
			int count =cardInfoService.updateCard(cardInfo);
			if (count > 0) {
				response(response, "OK", "操作成功！");
			}
		}
		
		
		@RequestMapping("gotoUpdateCard.do")
		public ModelAndView gotoUpdateCard(String cardId) {
			CardInfo info = cardInfoService.getCardById(Integer.valueOf(cardId));
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("info", info);
			return new ModelAndView("cardInfo/updateCard.jsp", "map", returnMap);
		}
		
		
		@RequestMapping("updateCard.do")
		public String updateCard(CardInfo cardInfo) {
			cardInfo.setUpdateDate(new Date());
			cardInfoService.updateCard(cardInfo);
			return "redirect:queryCardList.do";
		}

}
