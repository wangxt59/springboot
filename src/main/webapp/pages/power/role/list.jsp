<%@ page language="java"
	import="java.util.*,com.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>角色管理</title>
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
			<form action="/role/selectRoleList.do" name="form1" method="post">
               <div class="row">
                   <div class="col-md-12">
                       <div class="card">
                       	<div class="header">
                               <h4 class="title"><spring:message code="language.title" />>><spring:message code="language.roletitle" /></h4>
                           </div>
						<div class="content">
						<div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    <input type="text" placeholder="<spring:message code="language.rolename" />" class="form-control"  id="role_name" name="role_name" 
                                    value="${map.role_name}"/>
                                </div>
                            </div>
							 <div class="col-md-2">
                            	<div class="form-group">
                                  <select  id="status" name="status_flg" class="selectpicker" data-title="<spring:message code="language.status" />" data-style="btn-default btn-block" data-menu-style="dropdown-blue">
										<option value="" >全部</option>
										<option value="1" ${map.status_flg== 1?'selected':''}><spring:message code="language.takeffect" /></option>
										<option value="0" ${map.status_flg == 0?'selected':''}><spring:message code="language.failure" /></option>
                                  </select>
                                  </div>
                            </div>
                            <div class="footer">
                            		<button class="btn btn-info btn-fill btn-wd" type="submit" >
                                           <spring:message code="language.queryBtn" />
                                   </button>
                                   <button class="btn btn-default btn-fill btn-wd" type='button' onclick="resetInfo();" >
                                       	  <spring:message code="language.resetBtn" />
                                   </button>
                                   <button class="btn btn-default btn-fill btn-wd" type='button' onclick="javascript:location='/role/queryRole.do'" >
                                       	  <spring:message code="language.addrole" />
                                   </button>
                            </div>
                            </div>
                             <div class="card">
                           <table id="bootstrap-table" class="table">
                            <thead>
                               	<th><spring:message code="language.mxu" /></th>
								<th><spring:message code="language.rolename" /></th>
								<th><spring:message code="language.grouprole" /></th>
								<th><spring:message code="language.status" /></th>
								<th><spring:message code="language.edittime" /></th>
								
								<th><spring:message code="language.operation" /></th>
                               </thead>
                               <tbody>
                                  <c:forEach items="${map.pageInfo.datas}" varStatus="item" var="da">
									<tr>
										<td class="tcenter">
											<c:out value="${item.index+1}"/>
										</td>
										<td class="tcenter">
											<c:out value="${da.role_name}"/>
										</td>
										<td >
											<c:out value="${da.selectedPgroup}"/>
										</td>
										<td class="tcenter">
											<c:if test="${da.status_flg==1}"><font color="green"><spring:message code="language.takeffect" /></font> </c:if>
											<c:if test="${da.status_flg==0}"><font color="red"><spring:message code="language.failure" /></font> </c:if>
										</td>
										<td class="tcenter">
										 <fmt:formatDate value="${da.update_date}" pattern="yyyy-MM-dd"/>
										</td>
										<td class="tcenter">
										 	<a href="/role/queryRole.do?role_id=${da.role_id}" ><spring:message code="language.edit" /></a>&nbsp;&nbsp;
											<c:if test="${da.status_flg==1}">
										 		<!--<a href="/role/updateRole.do?roleInfo.role_id=${role_id}&roleInfo.status_flg=0" >删除</a>&nbsp;&nbsp;
											-->
												<a href='#' onclick="deleteStatus('${da.role_id}')"><spring:message code="language.deleteBtn" /></a>
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
   function deleteStatus(role_id){
	   swal({
			title : '<spring:message code="language.deleteBtn" />?',
			text : '<spring:message code="language.opdetele" />?',
			type : "warning",
			showCancelButton : true,
			confirmButtonText :'<spring:message code="language.determineBtn" />',
			cancelButtonText :'<spring:message code="language.cancelBtn" />',
			closeOnConfirm : false,
			closeOnCancel : true
		}, function(isConfirm) {
			if (isConfirm) {
				swal( '<spring:message code="language.success" />！', "success");
				location.href="/role/updateRole.do?role_id="+role_id+"&status_flg=0";
			}
		});
	}
</script>
</body>
	
</html>
