<%@ page language="java"
	import="java.util.*,com.antke.website.utils.CommonsUtil,com.antke.website.utils.FileUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="canonical" href="https://www.creative-tim.com/product/light-bootstrap-dashboard-pro"/>
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet"/>
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'/>
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<title>系统管理</title>
<style>
.fixed-table-toolbar{width:100%;overflow:hidden;}
</style>
</head>
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
			<form action="/group/selectPowerGroupList.do" name="form" id="form" method="post" accept-charset="utf-8">
               <div class="row">
                   <div class="col-md-12">
                       <div class="card">
                       	<div class="header">
                               <h4 class="title"><spring:message code="language.XTQX"/></h4>
                           </div>
						<div class="content">
						<div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    <input type="text" placeholder="<spring:message code="language.QXBH"/>" class="form-control"  id="pgroup_id" name="pgroup_id" 
                                    value="${map.pgroup_id}"/>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <input type="text" placeholder="<spring:message code="language.QXMC"/>" class="form-control"  id="groups_name" name="groups_name" 
                                    value="${map.groups_name}"/>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <input type="text" placeholder="<spring:message code="language.CZR"/>" class="form-control"  id="operator" name="operator" value="${map.operator}"/>
                                </div>
                            </div>
                            
                            <%--<div class="col-md-2">
								<div class="form-group">
									<input type="text" id="create_date_start" placeholder="注册开始时间" class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" name="create_date_start" 
									value="${map.create_date_start}" />
								</div>
							</div>
							
							<div class="col-md-2">
								<div class="form-group">
									<input type="text" id="create_date_end" placeholder="注册结束时间" class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" name="create_date_end" 
									value="${map.create_date_end}"  />
								</div>
							</div>
							 --%><div class="col-md-2">
                            	<div class="form-group">
                                  <select  id="status" name="status" class="selectpicker" data-title="<spring:message code="language.QXZT"/>" data-style="btn-default btn-block" data-menu-style="dropdown-blue">
                                     <option value="" ${map.status == ''?'selected':''}><spring:message code="language.QB"/></option>
										<option value="1" ${map.status == '1'?'selected':''}><spring:message code="language.SX"/></option>
										<option value="2" ${map.status == '2'?'selected':''}><spring:message code="language.SSX"/></option>
                                  </select>
                                  </div>
                                 
                            </div>
                            <div class="footer">
                            		<button class="btn btn-info btn-fill btn-wd" type="submit" >
                                         <spring:message code="language.CCX"/>
                                   </button>
                                   <button class="btn btn-default btn-fill btn-wd" type="button"  onclick="javascript:location='/group/insertPowerGroupPage.do'" >
                                       	<spring:message code="language.AddQX"/>
                                   </button>
                            </div>
                             </div>
                             <div class="card">
                           <table id="bootstrap-table" class="table">
                            <thead>
                               	<th><spring:message code="language.XH"/></th>
								<th><spring:message code="language.BH"/></th>
								<th><spring:message code="language.QXMC"/></th>
								<th><spring:message code="language.QXMSS"/></th>
								<th><spring:message code="language.QXZT"/></th>
								<th><spring:message code="language.XGSJ"/></th>
								<th><spring:message code="language.Operations"/></th>
								<th><spring:message code="language.GL"/></th>
                               </thead>
                               <tbody>
                                  <c:forEach items="${map.pageInfo.datas}" varStatus="item"  var="da">
									<tr>
										<td class="tcenter">
											<c:out value="${item.index+1}"/>
										</td>
										<td class="tcenter">
											<c:out value="${da.pgroup_id}"/>
										</td>
										<td class="tcenter">
											<c:out value="${da.groups_name}"/>
										</td>
										<td class="tcenter">
											<c:out value="${groups_desc}"/>
										</td>
										<td class="tcenter">
											<c:if test="${da.status==1}"><spring:message code="language.YX"/></c:if>
											<c:if test="${da.status==2}"><spring:message code="language.SSX"/></c:if>
										</td>
										<td class="tcenter"><!-- 注册时间 -->
											<fmt:formatDate value="${da.update_date}" pattern="yyyy-MM-dd"/>
										</td>
										<td class="tcenter">
											<c:out value="${da.operator}"/>
										</td>
										
										<td class="tcenter">
											<s:if test="status==1">
									 		<a href="/group/queryPowerGroup.do?operation=edit&pgroup_id=${da.pgroup_id}" title="<spring:message code="language.BJ"/>"><spring:message code="language.BJ"/></a>&nbsp;&nbsp;
												<!--<a href="javascript:updateStatus('${pgroup_id}');" title="删除">删除</a>&nbsp;&nbsp;
												-->
												<a href="javascript:delStatus('${da.pgroup_id}');" title="<spring:message code="language.SC"/>"><spring:message code="language.SC"/></a>&nbsp;&nbsp;
											</s:if>
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
            }); */

            //activate the tooltips after the data table is initialized
            $('[rel="tooltip"]').tooltip();

            $(window).resize(function () {
                $table.bootstrapTable('resetView');
            });
        });
</script> 
 <script type="text/javascript">
   
  /* function updateStatus(pgroup_id){
		if(status == 0){
			if(confirm( "确认删除该权限组吗？ ")){
				location.href="updatePowerGroupStatus.do?pgroup_id=" + pgroup_id;
			}
		}
		
   }*/
 //查询商品分类信息
   function queryGoodsCategory(goods_id,num){
   	var url = "/goods/queryGoodsCategory.do";
   	var params = {
   		"goods_id" : goods_id
   	};
   	var target = "#category_name" +num;
   	if (goods_id != "") {
   		$.getJSON(url, params, function(list) {
   			var options = "";
   			if (list != "[]" && typeof list != "undefined") {
   				for (var i = 0; i < list.length; i++) {
   					options += list[i].category_name + " ";
   				}
   				options+= "<a href='#' onclick=\"hiddenGoodsCategory('"+goods_id+"','"+num+"')\">[收]</a>";
   			}
   			$(target).html(options);
   		});
   		
   	} else {
   		$(target).html("");
   	}
   }
   
   function hiddenGoodsCategory(goods_id,num){
   var options = "";
   options+= "<a href='#' onclick=\"queryGoodsCategory('"+goods_id+"','"+num+"')\">[查]</a>";
		$("#category_name"+num).html(options);
  }
  	function delStatus(pgroup_id){
   		if(status == 0){
			if(confirm( "确认删除该权限组吗？ ")){
				location.href="updatePowerGroupStatus.do?pgroup_id=" + pgroup_id;
			}
		}
	}
	function cancel(){
		$(".popup").hide();
		$(".addhousepp").hide();
	}
   </script>
</body>
</html>
