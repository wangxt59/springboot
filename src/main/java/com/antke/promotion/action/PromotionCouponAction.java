package com.antke.promotion.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.antke.promotion.model.bean.PromotionConstants;
import com.antke.promotion.model.bean.PromotionCoupon;
import com.antke.promotion.model.bean.PromotionCouponBatch;
import com.antke.promotion.service.IPromotionCouponService;
import com.antke.website.action.BaseAction;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.utils.CommonsUtil;

@Controller
@Scope("prototype")
public class PromotionCouponAction extends BaseAction {

	private static final long serialVersionUID = -4482062977952297177L;
	/**
	 * 生成日志对象
	 */
	private static Logger log = Logger.getLogger(PromotionCouponAction.class);

	@Autowired
	private IPromotionCouponService promotionCouponService;

	private PromotionCoupon promotionCoupon;
	private PromotionCouponBatch promotionCouponBatch;

	private PageInfo<PromotionCoupon> pageInfo;// 显示分页列表
	private String operation; // 操作
	private String promotion_id; // 促销ID

	/**
	 * 优惠券促销
	 * 
	 * @return
	 */
	public String selectPromotionCouponList() {

		log.info("优惠券信息列表查询，start");
		// 如果是初次访问或新的查询时，重置分页
		if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
			pageInfo = new PageInfo<PromotionCoupon>();
			pageInfo.setCurrentPage("1");
		}
		// 查询优惠券信息
		Map<String, Object> filter = new HashMap<String, Object>();
		if (promotionCoupon != null) {
			filter.put("id", promotionCoupon.getId().trim());
			filter.put("coupon_name", promotionCoupon.getCoupon_name().trim());
			filter.put("type", promotionCoupon.getType());
			filter.put("start_time", promotionCoupon.getStart_time());
			filter.put("end_time", promotionCoupon.getEnd_time());
			filter.put("expense_account", promotionCoupon.getExpense_account());
		} else {
			promotionCoupon = new PromotionCoupon();
		}
		pageInfo = promotionCouponService.queryPromotionCouponListByPage(
				pageInfo, filter);
		return "success";
	}

	/**
	 * 添加优惠券促销
	 * 
	 * @return
	 */
	public String queryPromotionCoupon() {

		if ("add".equals(operation)) {
			return "promotion_add";
		} else if ("query".equals(operation)) {
			promotionCoupon = promotionCouponService
					.getPromotionCoupon(promotion_id);
			return "promotion_query";
		} else {
			return "error";
		}
	}

	/**
	 * 添加优惠券促销
	 * 
	 * @return
	 */
	public String insertPromotionCoupon() {

		int count = 0;
		if (null == promotionCoupon.getId()
				|| "".equals(promotionCoupon.getId())) {
			String id = CommonsUtil.getPrimaryKey();
			promotionCoupon.setId(id);
			promotionCoupon.setUpload_person("admin");
			promotionCoupon
					.setStatus(PromotionConstants.PROMOTION_COUPON_STATUS_01);
			count = promotionCouponService
					.insertPromotionCoupon(promotionCoupon);
		}
		if (count > 0) {
			return "success";
		} else {
			return "failed";
		}
	}

	public PromotionCoupon getPromotionCoupon() {
		return promotionCoupon;
	}

	public void setPromotionCoupon(PromotionCoupon promotionCoupon) {
		this.promotionCoupon = promotionCoupon;
	}

	public PromotionCouponBatch getPromotionCouponBatch() {
		return promotionCouponBatch;
	}

	public void setPromotionCouponBatch(
			PromotionCouponBatch promotionCouponBatch) {
		this.promotionCouponBatch = promotionCouponBatch;
	}

	public PageInfo<PromotionCoupon> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<PromotionCoupon> pageInfo) {
		this.pageInfo = pageInfo;
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

}
