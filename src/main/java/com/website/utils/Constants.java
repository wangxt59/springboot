package com.website.utils;

/**
 * 描述：常量类
 * 
 * @author duff
 * @version 1.0
 */
public class Constants {

	/***************************************************************************
	 * 成功常量
	 */
	public static final int SUCCESS_CODE = 0;

	/***************************************************************************
	 * 失败常量
	 */
	public static final int FAIL_CODE = 1;

	/***************************************************************************
	 * 分页中每页显示条数
	 */
	public static final int RECORDS_PER_PAGE = 1;

	/***************************************************************************
	 * 操作类型
	 */
	public static final String OPERATION_UPDATE = "UPDATE";

	public static final String OPERATION_DETAIL = "DETAIL";

	/**
	 * 字符集
	 */
	public static final String CHARSET = "UTF-8";

	/**
	 * session存储用户的key
	 */
	public static final String USER_INFO = "userInfo";

	/***************************************************************************
	 * 用户状态(0:待审核，1:审核中，2:审核通过，3:审核未通过)
	 */
	public static final int USER_STATUS_ENABLED = 0;

	public static final int USER_STATUS_FROZEN = 1;

	public static final int USER_STATUS_DIABLED = 2;

	/***************************************************************************
	 * 部门状态(0:默认状态，1:已删除)
	 */
	public static final int DEPARTMENT_STATUS_INIT = 0;

	public static final int DEPARTMENT_STATUS_DELETED = 1;

	/***************************************************************************
	 * 是否为负责人(0:否，1:是)
	 */
	public static final int RESPONSIBLE_Y = 1;

	public static final int RESPONSIBLE_N = 2;

	/***************************************************************************
	 * 赠票卡状态(0:未分配，1：已分配，2：已赠送，3：兑换成功，4：二次兑换成功，5：现场兑换，6：兑换失败)
	 */
	public static final int TICKET_STATUS_NO_ASSIGN = 0;// 未分配
	public static final int TICKET_STATUS_NO_SEND = 1;// 已分配
	public static final int TICKET_STATUS_SEND = 2;// 已赠送
	public static final int TICKET_STATUS_EXCHANGED = 3;// 兑换成功
	public static final int TICKET_STATUS_AGAIN_EXCHANGE_SUCCESS = 4;// 二次兑换成功
	public static final int TICKET_STATUS_LOCALE_EXCHANGE = 5;// 现场兑换
	public static final int TICKET_STATUS_EXCHANGE_FAIL = 6;// 兑换失败
	/***************************************************************************
	 * 操作类型(0:生成 1:分配，2：赠送，3:兑换，4:二次兑换，5：现场兑换,6:兑换失败,7:未赠送异常,8:修改赠与人)
	 */
	public static final int TICKET_LOG_CREATE = 0;
	public static final int TICKET_LOG_ASSIGN = 1;
	public static final int TICKET_LOG_SEND = 2;
	public static final int TICKET_LOG_EXCHANGE_SUCCESS = 3;
	public static final int TICKET_LOG_AGAIN_EXCHANGE = 4;
	public static final int TICKET_LOG_LOCALE_EXCHANGE = 5;
	public static final int TICKET_LOG_EXCHANGE_FAIL = 6;
	public static final int TICKET_LOG_UPDATE_RECV = 7;

	/***************************************************************************
	 * 发送邮件相关
	 */
	public static String SEND_FROM = "";
	public static String EMAIL_HOST = "";
	public static String EMAIL_USER = "";
	public static String EMAIL_PASSWORD = "";

	/***************************************************************************
	 * 批量赠送票务错误原因相关
	 */
	public static final String MOBILE_ERROR = "手机号格式不正确";
	public static final String EMAIL_ERROR = "邮箱格式不正确";
	public static final String ITEM_NOTEMPTY_ERROR = "不可为空";

	/***************************************************************************
	 * 每日发送票务统计数据相关
	 */
	public static String SEND_DATA_PROJECT_ID = "";
	public static String SEND_DATA_ADMIN_EMAIL = "";
	
	/****************************************************************************
	 * 票务信息-项目类型
	 */
	public static final int TICKET_PROJECT_TYPE_SEND = 0;
	public static final int TICKET_PROJECT_TYPE_SALE = 1;
	
	/****************************************************************************
	 * 项目信息-项目类型
	 */
	public static final int PROJECT_TYPE_SEND = 1;
	public static final int PROJECT_TYPE_SALE = 2;
	
	
	
	/****************************************************************************
	 * 菜单操作配置
	 */
	public static final String HOUSEMENUID = "M10000021";
	public static final String M10000020 = "M10000020";
	public static final String CUSTOMERMENUID = "M10000022";
	public static final String M10000013 = "M10000013";
	public static final String M10000012 = "M10000012";
	public static final String M10788416 = "M10788416";
	
}

