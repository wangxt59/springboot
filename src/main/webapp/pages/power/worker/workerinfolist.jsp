<%@ page language="java"
	import="java.util.*,com.power.bean.WorkerInfo,com.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>员工管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="canonical" href="https://www.creative-tim.com/product/light-bootstrap-dashboard-pro"/>
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet"/>
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'/>
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
</head>
<style>
.fixed-table-toolbar{width:100%;overflow:hidden;}
</style>
<body>


<div class="wrapper">
     <!-- 左侧导航栏开始 -->
    <jsp:include page="/pages/inc/nav.jsp"></jsp:include>
    <!-- 左侧导航栏结束 -->
    <div class="main-panel">
       <!-- 头部开始 -->
       <jsp:include page="/pages/inc/header.jsp"></jsp:include>
		<!-- 头部结束 -->
       <!-- 内容table开始 -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                    <div class="card">
                       	<div class="header">
                                 <h4 class="title"><spring:message code="language.title" />>><spring:message code="language.workertitle" /></h4>
                           </div>
                           <form action="/worker/selectWorkerInfoList.do" id="queryForm" method="post" accept-charset="utf-8">
							<div class="content">
							<div class="row">
	                            <div class="col-md-2">
	                                <div class="form-group">
	                                    <input type="text" placeholder="<spring:message code="language.workername" />" class="form-control"  id="worker_name" name="worker_name" 
	                                    value="${map.worker_name}" size="15"/>
	                                </div>
	                            </div>
	                            <div class="col-md-2">
	                                <div class="form-group">
	                                    <input type="text" placeholder="<spring:message code="language.merchantsnum" />" class="form-control"  id="worker_code" name="worker_code" 
	                                    value="${map.worker_code}" size="32"/>
	                                </div>
	                            </div>
	                            
								 <div class="col-md-2">
	                            	<div class="form-group">
	                                  <select  id="status" name="status" class="selectpicker" data-title="<spring:message code="language.status" />" data-style="btn-default btn-block" data-menu-style="dropdown-blue">
	                                      <option value="" ${map.status == ''?'selected':''} ><spring:message code="language.all" /></option>
											<option value="0" ${map.status == '0'?'selected':''} ><spring:message code="language.normal" /></option>
											<option value="1" ${map.status == '1'?'selected':''} ><spring:message code="language.freeze" /></option>
											<option value="3" ${map.status == '3'?'selected':''} ><spring:message code="language.cancellation" /></option>
	                                  </select>
	                                  </div>
	                            </div>
	                            <div class="footer">
	                            		<button class="btn btn-info btn-fill btn-wd" type="submit" ><spring:message code="language.queryBtn" />
	                                   </button>
	                                   <button class="btn btn-default btn-fill btn-wd" type="button" onclick="javascript:location.href='/worker/addWorkerPage.do'" >
	                                       	<spring:message code="language.addworker" />
	                                   </button>
	                            </div>
	                            
	                            </div>
	                             <div class="card">
                             <table id="bootstrap-table" class="table">
                             <thead>
                                    <th><spring:message code="language.mxu" /></th>
                                    <th data-field="id" class="text-center"><spring:message code="language.merchantsnum" /></th>
									<th data-field="name" data-sortable="true"><spring:message code="language.workername" /></th>
									<th data-field="loginname" data-sortable="true"><spring:message code="language.loginname" /></th>
									<%--<th data-field="sex" data-sortable="true">性别</th>
									--%><th data-field="company" data-sortable="true"><spring:message code="language.company" /></th>
									<%--<th data-field="position" data-sortable="true">职位</th>
									--%><th data-field="TEL" data-sortable="true"><spring:message code="language.mphone" /></th>
									<th data-field="status" data-sortable="true"><spring:message code="language.status" /></th>
									<th data-field="count" data-sortable="true"><spring:message code="language.loginci" /></th>
									<th data-field="role" data-sortable="true"><spring:message code="language.role" /></th>
									<th data-field="cabinetManage" data-sortable="true"><spring:message code="language.cabinetMag" /></th>
									<th data-field="regtime" data-sortable="true"><spring:message code="language.mregtime" /></th>
									<th data-field="logintime"><spring:message code="language.prelogin" /></th>
                                	<th data-field="actions" ><spring:message code="language.operation" /></th>
                                </thead>
                                <tbody>
                                   <c:forEach items="${map.pageInfo.datas}" varStatus="item" var="worker">
									<tr>
									 	<td>
									 		<c:out value="${item.index+1}"/>
									 	</td>
										<!-- 员工编号 -->
										<td>
											<c:out value="${worker.worker_code}"/>
										</td>
										<!-- 员工姓名 -->
										<td>
											<c:out value="${worker.worker_name}"/>
										</td>
										<!-- 登录名 -->
										<td>
											<c:out value="${worker.login_name}"/>
										</td>
										<!-- 性别-->
										<%--<td>
											<c:if test="${worker.sex=='0'}">男</c:if>
											<c:if test="${worker.sex=='1'}">女</c:if>
											<c:if test="${worker.sex=='2'}">保密</c:if>
										</td>
										--%><!-- 所属公司 -->
										<td>
											<c:out value="${worker.company}"/>
										</td>
										<!-- 职位 -->
										<%--<td>
											<c:out value="${worker.professional}"/>
										</td>
										--%><!-- 手机号 -->
										<td>
											<c:out value="${worker.contact}"/>
										</td>
										<!-- 状态 -->
										<td>
											<c:if test="${worker.status=='0'}"><spring:message code="language.enable" /></c:if>
											<c:if test="${worker.status=='1'}"><spring:message code="language.freeze" /></c:if>
											<c:if test="${worker.status=='2'}"><spring:message code="language.lock" /></c:if>
											<c:if test="${worker.status=='3'}"><spring:message code="language.cancellation" /></c:if>
										</td>
										<!-- 登录次数 -->
										<td>
											<c:out value="${worker.login_num}"/>
										</td>
										<!-- 用户角色 -->
										<td>
											<c:if test="${worker.rank=='1'}"><spring:message code="language.chantManager" /></c:if>
											<c:if test="${worker.rank=='2'}"><spring:message code="language.backWorker" /></c:if>
											<c:if test="${worker.rank=='3'}"><spring:message code="language.lunchWorker" /></c:if>
											<c:if test="${worker.rank=='4'}"><spring:message code="language.dianzhang" /></c:if>
										</td>
										<!-- 管理货柜 -->
										<td>
											<c:if test="${worker.rank=='1'}"><spring:message code="language.allCabinet" /></c:if>
											<c:if test="${worker.rank=='2'}"><spring:message code="language.noCabinet" /></c:if>
											<c:if test="${worker.rank=='3'}">
												<c:out value="${worker.cabinet_name}"/>
											</c:if>
										</td>
										<!-- 注册时间 -->
										<td>
											<fmt:formatDate value="${worker.create_date}" pattern="yyyy-MM-dd"/>
										</td>
										<!-- 上次登录时间 -->
										<td>
											<fmt:formatDate value="${worker.update_date}" pattern="yyyy-MM-dd"/>
										</td>
										<!-- 操作 -->
										<td>
											<c:if test="${worker.status!='3'}">
												<c:if test="${worker.status!='0'}">
													<a href="javascript:updateStatus('${worker.worker_id}','0');" title="启动"><spring:message code="language.enable" /></a>&nbsp;&nbsp;
												</c:if>
												<c:if test="${worker.status!='1'}">
													<a href="javascript:updateStatus('${worker.worker_id}','1');" title="冻结"><spring:message code="language.freeze" /></a>&nbsp;&nbsp;
												</c:if>
												<a href="/worker/updateWorkerInfoPage.do?worker_id=${worker.worker_id}" title="修改"><spring:message code="language.edit" /></a>&nbsp;&nbsp;
												<a href="javascript:updateStatus('${worker.worker_id}','3');" title="注销"><spring:message code="language.cancellation" /></a>&nbsp;&nbsp;
												<c:if test="${worker.rank=='3'}">
													<a href="javascript:alotCabinet('${worker.worker_id}');"><spring:message code="language.alotCabinet" /></a>
												</c:if>
											</c:if>
										</td>
									</tr>
								</c:forEach>
                                </tbody>
                            </table>
                        </div><!--  end card  -->
                        <div class="newpages">
							        	<%@include file="/page/page.jsp" %>
							        </div>
	                		</div>            
	                		
	                       </div>
                    </div> <!-- end col-md-12 -->
                </div> <!-- end row -->
		</form>
            </div>
        </div>
        <!-- 内容table结束 -->
        
        <!-- 底部开始 -->
		 <jsp:include page="/pages/inc/footer.jsp"></jsp:include>
		<!-- 底部结束 -->
    </div>
</div>

 <!-- 右侧设置开始 -->
 <jsp:include page="/pages/inc/setting.jsp"></jsp:include>
<!-- 右侧设置结束 -->
</body>
     <script type="text/javascript">
        var $table = $('#bootstrap-table');

        function operateFormatter(value, row, index) {
            return [
                '<a rel="tooltip" title="View" class="btn btn-simple btn-info btn-icon table-action view" href="javascript:void(0)">',
                    '<i class="fa fa-image"></i>',
                '</a>',
                '<a rel="tooltip" title="Edit" class="btn btn-simple btn-warning btn-icon table-action edit" href="javascript:void(0)">',
                    '<i class="fa fa-edit"></i>',
                '</a>',
                '<a rel="tooltip" title="Remove" class="btn btn-simple btn-danger btn-icon table-action remove" href="javascript:void(0)">',
                    '<i class="fa fa-remove"></i>',
                '</a>'
            ].join('');
        }

        $().ready(function(){
            window.operateEvents = {
                'click .view': function (e, value, row, index) {
                    info = JSON.stringify(row);

                    swal('You click view icon, row: ', info);
                    console.log(info);
                },
                'click .edit': function (e, value, row, index) {
                    info = JSON.stringify(row);

                    swal('You click edit icon, row: ', info);
                    console.log(info);
                },
                'click .remove': function (e, value, row, index) {
                    console.log(row);
                    $table.bootstrapTable('remove', {
                        field: 'id',
                        values: [row.id]
                    });
                }
            };

            /* $table.bootstrapTable({
                toolbar: ".toolbar",
                clickToSelect: true,
                showRefresh: true,
                search: true,
                showToggle: true,
                showColumns: true,
                pagination: false,
                searchAlign: 'left',
                pageSize: 8,
                clickToSelect: false,
                pageList: [8,10,25,50,100],

                formatShowingRows: function(pageFrom, pageTo, totalRows){
                    //do nothing here, we don't want to show the text "showing x of y from..."
                },
                formatRecordsPerPage: function(pageNumber){
                    return pageNumber + " rows visible";
                },
                icons: {
                    refresh: 'fa fa-refresh',
                    toggle: 'fa fa-th-list',
                    columns: 'fa fa-columns',
                    detailOpen: 'fa fa-plus-circle',
                    detailClose: 'fa fa-minus-circle'
                }
            });
 */
            //activate the tooltips after the data table is initialized
            $('[rel="tooltip"]').tooltip();

            $(window).resize(function () {
                $table.bootstrapTable('resetView');
            });


        });

    </script> 

<script type="text/javascript">
   function updateStatus(worker_id,status){
	   var content = "";
	   if(status == 0){
  			content = "<spring:message code='language.askopen'/>";
  		}
  		if(status == 1){
  			content = "<spring:message code='language.askfreeze'/>";
  		}
  		if(status == 2){
  			content = "<spring:message code='language.asklock'/>";
  		}
  		if(status == 3){
  			content = "<spring:message code='language.askcansel'/>";
  		}
		swal({
			title : "<spring:message code='language.modalTitle'/>?",
			text : content,
			type : "warning",
			showCancelButton : true,
			confirmButtonText : "<spring:message code='language.determineBtn'/>",
			cancelButtonText : "<spring:message code='language.cancelBtn'/>",
			closeOnConfirm : false,
			closeOnCancel : true
		}, function(isConfirm) {
			if (isConfirm) {
				swal("<spring:message code='language.success'/>!", "success");
				location.href="updateWorkerInfoStatus.do?worker_id=" + worker_id+"&status=" + status;
			}
		});
	}
	
	function alotCabinet(worker_id){
		location.href="queryWorkerInfo.do?worker_id=" + worker_id;
	}
	
</script>

</html>

