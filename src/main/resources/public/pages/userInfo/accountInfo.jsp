<%@ page language="java"
	import="java.util.*,com.antke.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet" />
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet">
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'>		
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
<title>账户明细</title> <script language='javascript' src="js/edit.js"></script>
<script src="/js/ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="/js/ckfinder/ckfinder.js" type="text/javascript"></script>
<script language="JavaScript" src="/js/WdatePicker.js"></script>
</head>
<body>
	<div class="wrapper">
		<!-- 左侧导航栏开始 -->
		<jsp:include page="/pages/inc/nav.jsp"></jsp:include>
		<!-- 左侧导航栏结束 -->
		<div class="main-panel" data-ps-id="fabe6d0c-fb7a-4814-760e-94b6d796f92a">
			<!-- 头部开始 -->
			<jsp:include page="/pages/inc/header.jsp"></jsp:include>
			<!-- 头部结束 -->
			<!-- 内容table开始 -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
									<div class="content">
										<legend>账户明细</legend>
										<!-- 1.名称 -->
										
										<div class="row">
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>现金余额</label>
	                                                <input type="text" class="form-control" placeholder="City" value="${map.accountInfo.cashBalance}"  style="border:0">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>冻结余额</label>
	                                                <input type="text" class="form-control" placeholder="City" value="${map.accountInfo.frozenBalance}"  style="border:0">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>解冻中余额</label>
	                                                <input type="text" class="form-control" placeholder="City" value="${map.accountInfo.thawingBalance}"  style="border:0">
	                                            </div>
	                                        </div>
                                    	</div>
                                    	
                                    	<div class="row">
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>销售返利</label>
	                                                <input type="text" class="form-control" placeholder="City" value="${map.accountInfo.salesRebateBonus}" style="border:0">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>返利奖励</label>
	                                                <input type="text" class="form-control" placeholder="Country" value="${map.accountInfo.rebateBonus}" style="border:0">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>红包奖励</label>
	                                                <input type="text" class="form-control" placeholder="${map.accountInfo.redBonus}" style="border:0">
	                                            </div>
	                                        </div>
                                    	</div>
                                    	<div class="row">
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>勋章奖励</label>
	                                                <input type="text" class="form-control" placeholder="City" value="${map.accountInfo.medalBonus}" style="border:0">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>勋章数量</label>
	                                                <input type="text" class="form-control" placeholder="Country" value="${map.accountInfo.medalAmount}" style="border:0">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>累计收益</label>
	                                                <input type="text" class="form-control" placeholder="${map.accountInfo.accountTotal}" style="border:0">
	                                            </div>
	                                        </div>
                                    	</div>
                                    	
                                    	<div class="row">
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>销售余额</label>
	                                                <input type="text" class="form-control" placeholder="City" value="${map.accountInfo.salesBalance}" style="border:0">
	                                            </div>
	                                        </div>
                                    	</div>
										
									</div>

									<div class="footer text-center">
										<button type="button" class="btn btn-fill btn-wd" onclick="goToList();"><spring:message code="language.backBtn"/></button>
									</div>

							</div>
							<!--  end card  -->
						</div>
						<!-- end col-md-12 -->
					</div>
					<!-- end row -->
				</div>

			</div>
			<!-- 内容table结束 -->

			<!-- 底部开始 -->
			<jsp:include page="/pages/inc/footer.jsp"></jsp:include>
			<!-- 底部结束 -->
		</div>
	</div>

	<script type="text/javascript">
		//返回按钮跳转到区域列表
			function goToList() {
				location.href = "/userInfo/queryUserInfoList.do";
			}
	</script>

</body>
</html>