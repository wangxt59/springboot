package com.antke.promotion.model.bean;

public interface PromotionConstants {

	// ---------公用常量-----
	/** 费用承担方 -- 平台承担 */
	public static final int PROMOTION_COUPON_EXPENSE_ACCOUNT_01 = 1;
	/** 费用承担方 -- 供应商承担 */
	public static final int PROMOTION_COUPON_EXPENSE_ACCOUNT_02 = 2;
	/** 费用承担方 -- 双方承担 */
	public static final int PROMOTION_COUPON_EXPENSE_ACCOUNT_03 = 3;

	// ----------- 促销优惠券常量 ---------
	/** 优惠券类型--现金券 */
	public static final int PROMOTION_COUPON_TYPE_01 = 1;
	/** 优惠券类型--满减券 */
	public static final int PROMOTION_COUPON_TYPE_02 = 2;
	/** 状态 */
	public static final int PROMOTION_COUPON_STATUS_01 = 1;
	public static final int PROMOTION_COUPON_STATUS_02 = 2;

	/** 优惠券使用状态 -- 未使用 */
	public static final int PROMOTION_COUPON_BATCH_STATUS_01 = 1;
	/** 优惠券使用状态 -- 已使用 */
	public static final int PROMOTION_COUPON_BATCH_STATUS_02 = 2;
	/** 优惠券使用状态 -- 已作废 */
	public static final int PROMOTION_COUPON_BATCH_STATUS_03 = 3;

	// ------ 商品促销模块常量 ------
	/** 商品促销状态 -- 未开始 */
	public static final int PROMOTION_GOODS_STATUS_01 = 1;
	/** 商品促销状态 -- 已开始 */
	public static final int PROMOTION_GOODS_STATUS_02 = 2;
	/** 商品促销状态 -- 已结束 */
	public static final int PROMOTION_GOODS_STATUS_03 = 3;
	/** 商品促销状态 -- 已暂停 */
	public static final int PROMOTION_GOODS_STATUS_04 = 4;
	/** 商品促销状态 -- 已取消 */
	public static final int PROMOTION_GOODS_STATUS_05 = 5;

	/** 商品促销渠道分类 -- APP-Android */
	public static final int PROMOTION_GOODS_SOURCE_01 = 1;
	/** 商品促销渠道分类 -- APP-IOS */
	public static final int PROMOTION_GOODS_SOURCE_02 = 2;
	/** 商品促销渠道分类 -- WEB端 */
	public static final int PROMOTION_GOODS_SOURCE_03 = 3;
	/** 商品促销渠道分类 -- M站 */
	public static final int PROMOTION_GOODS_SOURCE_04 = 4;

	/** 领取限制 -- 每日一次 */
	public static final int PROMOTION_GOODS_RECEIVE_LIMIT_01 = 1;
	/** 领取限制 -- 每人一次 */
	public static final int PROMOTION_GOODS_RECEIVE_LIMIT_02 = 2;
	/** 领取限制 -- 每IP一次 */
	public static final int PROMOTION_GOODS_RECEIVE_LIMIT_03 = 3;

	/** 下单购买限制 -- 售完即止 */
	public static final int PROMOTION_GOODS_BUY_LIMIT_01 = 1;
	/** 下单购买限制 -- 可以使用优惠券 */
	public static final int PROMOTION_GOODS_BUY_LIMIT_02 = 2;
	/** 下单购买限制 -- 需要验证码 */
	public static final int PROMOTION_GOODS_BUY_LIMIT_03 = 3;

	/** 优惠项 -- 折扣 */
	public static final int PROMOTION_GOODS_PREFERENTIAL_TERM_01 = 1;
	/** 优惠项 -- 直降 */
	public static final int PROMOTION_GOODS_PREFERENTIAL_TERM_02 = 2;
	/** 优惠项 -- 返积分 */
	public static final int PROMOTION_GOODS_PREFERENTIAL_TERM_03 = 3;
	/** 优惠项 -- 送券 */
	public static final int PROMOTION_GOODS_PREFERENTIAL_TERM_04 = 4;

}
