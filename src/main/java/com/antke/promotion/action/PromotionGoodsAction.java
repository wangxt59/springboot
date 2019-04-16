package com.antke.promotion.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.antke.promotion.model.bean.PromotionConstants;
import com.antke.promotion.model.bean.PromotionGoods;
import com.antke.promotion.model.bean.PromotionGoodsDetail;
import com.antke.promotion.service.IPromotionGoodsDetailService;
import com.antke.promotion.service.IPromotionGoodsService;
import com.antke.website.action.BaseAction;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.utils.CommonsUtil;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class PromotionGoodsAction extends BaseAction {

	private static final long serialVersionUID = 3536690043125592428L;

	/**
	 * 生成日志对象
	 */
	private static Logger log = Logger.getLogger(PromotionGoodsAction.class);

	@Autowired
	private IPromotionGoodsService promotionGoodsService;
	@Autowired
	private IPromotionGoodsDetailService promotionGoodsDetailService;

	private PageInfo<PromotionGoods> pageInfo;// 显示分页列表
	private List<PromotionGoodsDetail> promotionGoodsDetails; // 促销商品明细
	private PromotionGoods promotionGoods;
	private String operation; // 操作
	private String promotion_id; // 促销ID
	private Integer status; // 商品促销状态

	/**
	 * 商品促销--单品/满减促销
	 * 
	 * @return
	 */
	public String selectPromotionGoodsList() {
		log.info("商品促销信息列表查询，start");
		// 如果是初次访问或新的查询时，重置分页
		if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
			pageInfo = new PageInfo<PromotionGoods>();
			pageInfo.setCurrentPage("1");
		}
		// 查询优惠券信息
		Map<String, Object> filter = new HashMap<String, Object>();
		if (promotionGoods != null) {
			filter.put("id", promotionGoods.getId().trim());
			filter.put("promotion_name", promotionGoods.getPromotion_name().trim());
			filter.put("status", promotionGoods.getStatus());
			filter.put("promotion_type", promotionGoods.getPromotion_type());
			filter.put("expense_account", promotionGoods.getExpense_account());
			filter.put("promotion_type", promotionGoods.getPromotion_type());
			filter.put("start_start_time", promotionGoods.getStart_start_time().trim());
			filter.put("end_start_time", promotionGoods.getEnd_start_time().trim());
			filter.put("start_end_time", promotionGoods.getStart_end_time().trim());
			filter.put("end_end_time", promotionGoods.getEnd_end_time().trim());
		} else {
			promotionGoods = new PromotionGoods();
		}
		pageInfo = promotionGoodsService.queryPromotionGoodsListByPage(pageInfo, filter);
		return "success";
	}

	/**
	 * 查询商品促销
	 * 
	 * @return
	 */
	public String queryPromotionGoods() {
		if ("add".equals(operation)) {
			return "promotion_add";
		} else if ("query".equals(operation)) {
			promotionGoods = promotionGoodsService.getPromotionGoods(promotion_id);
			return "promotion_query";
		} else {
			return "error";
		}
	}

	/**
	 * 添加商品促销
	 * 
	 * @return
	 */
	public String insertPromotionGoods() {

		int count = 0;
		if (null == promotionGoods.getId() || "".equals(promotionGoods.getId())) {
			// 插入促销商品信息
			promotionGoodsDetails = new ArrayList<PromotionGoodsDetail>();
			for (PromotionGoodsDetail promotionGoodsDetail : promotionGoodsDetails) {
				int insertPromotionGoodsDetail = promotionGoodsDetailService.insertPromotionGoodsDetail(promotionGoodsDetail);
				System.out.println(insertPromotionGoodsDetail);
			}
			String id = CommonsUtil.getPrimaryKey();
			promotionGoods.setId(id);
			promotionGoods.setUpload_person("admin");
			promotionGoods.setStatus(PromotionConstants.PROMOTION_GOODS_STATUS_01);
			count = promotionGoodsService.insertPromotionGoods(promotionGoods);
		}
		if (count > 0) {
			return "success";
		} else {
			return "failed";
		}
	}

	public String updatePromotionGoodsStatus() throws IOException {

		int count = 0;
		promotionGoods = promotionGoodsService.getPromotionGoods(promotion_id);
		promotionGoods.setStatus(status);
		count = promotionGoodsService.updateByPrimaryKeySelective(promotionGoods);
		String msg = "";
		if (count > 0) {
			msg = "修改成功！";
		} else {
			msg = "修改失败，请稍后再试！";
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(msg);
		return null;
	}
	
	
	/**
	 * 查询商品sku列表
	 */
	public String selectPromotionGoodsSkuList() {
		log.info("添加促销商品SKU信息列表查询，start");
		// 如果是初次访问或新的查询时，重置分页
		if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
			pageInfo = new PageInfo<PromotionGoods>();
			pageInfo.setCurrentPage("1");
		}
		// 查询优惠券信息
		Map<String, Object> filter = new HashMap<String, Object>();
		if (promotionGoods != null) {
			filter.put("id", promotionGoods.getId().trim());
			filter.put("promotion_name", promotionGoods.getPromotion_name().trim());
			filter.put("status", promotionGoods.getStatus());
			filter.put("promotion_type", promotionGoods.getPromotion_type());
			filter.put("expense_account", promotionGoods.getExpense_account());
			filter.put("promotion_type", promotionGoods.getPromotion_type());
			filter.put("start_start_time", promotionGoods.getStart_start_time().trim());
			filter.put("end_start_time", promotionGoods.getEnd_start_time().trim());
			filter.put("start_end_time", promotionGoods.getStart_end_time().trim());
			filter.put("end_end_time", promotionGoods.getEnd_end_time().trim());
		} else {
			promotionGoods = new PromotionGoods();
		}
		pageInfo = promotionGoodsService.queryPromotionGoodsListByPage(pageInfo, filter);
		return "success";
	}
	
	public PageInfo<PromotionGoods> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<PromotionGoods> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public PromotionGoods getPromotionGoods() {
		return promotionGoods;
	}

	public void setPromotionGoods(PromotionGoods promotionGoods) {
		this.promotionGoods = promotionGoods;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getPromotion_id() {
		return promotion_id;
	}

	public void setPromotion_id(String promotion_id) {
		this.promotion_id = promotion_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<PromotionGoodsDetail> getPromotionGoodsDetails() {
		return promotionGoodsDetails;
	}

	public void setPromotionGoodsDetails(List<PromotionGoodsDetail> promotionGoodsDetails) {
		this.promotionGoodsDetails = promotionGoodsDetails;
	}

}
