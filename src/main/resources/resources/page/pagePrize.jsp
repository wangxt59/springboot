<%@ page language="java" import="com.antke.website.model.bean.PageInfo"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script language="javaScript">
//跳转
function Jumping(currentPage)
{
	document.getElementById("currentPage").value = currentPage;
	var datas = $("#queryGoods").serialize();
	var url = document.getElementById("queryGoods").action
	$.post(
		url,datas,function(data){
			$("#ss").html(data);
		}
	);
}
//跳转首页
function gotoFirstPage(){
	var temp = 1;
	Jumping(temp);
}
//跳转第一页
function gotoPreviousPage(){
	var currentPage = '${map.pageInfo.currentPage}';
	var totalPage = document.getElementById("totalPage").value;
	if(parseInt(currentPage, 10) > 1){
		var temp = parseInt(currentPage, 10) - 1;
	}else{
		var temp = 1;
	}
	Jumping(temp);
}
//跳转下一页
function gotoNextPage(){
	var currentPage = '${map.pageInfo.currentPage}';
	var totalPage = document.getElementById("totalPage").value;
	if(parseInt(currentPage, 10) <= parseInt(totalPage, 10)){
		var temp = parseInt(currentPage, 10) + 1;
	}else{
		var temp = parseInt(totalPage, 10);
	}
	Jumping(temp);
}
//跳转首页
function gotoLastPage(){
	var totalPage = document.getElementById("totalPage").value;
	var temp = parseInt(totalPage, 10);
	Jumping(temp);
}
//跳转指定页
function gotoPage()
{
	var pageNum = document.getElementById("pageNum").value;
	var currentPage = '${map.pageInfo.currentPage}';
	var totalPage = document.getElementById("totalPage").value;
	if(!check_validate(pageNum)){
		document.getElementById("pageNum").focus();
		return;
	}
	if(parseInt(pageNum, 10) <= parseInt(totalPage, 10)
		&& parseInt(pageNum, 10) >= 1){
		var temp = parseInt(pageNum, 10);
	}else{
		var temp = parseInt(currentPage, 10);
	}
	Jumping(temp);
}
//判断输入是否为数字
function check_validate(value){
    var reg = new RegExp("^[0-9]+$");
    if(reg.test(value)){
        return true;
    }
    return false;
}
</script>
	<!-- 首页 按钮 -->
	<c:choose>
		<c:when  test="${map.pageInfo.currentPage != 1}">
			<input type="button" name="firstPage" value="首页" onclick="gotoFirstPage();" />
		</c:when >
		<c:otherwise>
		<input type="button" disabled="disabled" name="firstPage" value="首页"/><!-- 为了要那个灰掉的button -->
		</c:otherwise>
	</c:choose>
   <!-- 上一页 按钮 -->
   
   <c:choose>
	    <c:when  test="${map.pageInfo.currentPage !=1}">
			<input type="button" name="prePage" value="上一页" onclick="gotoPreviousPage();" />
		</c:when >
		<c:otherwise>
			<input type="button" disabled="disabled" name="prePage" value="上一页" /><!-- 为了要那个灰掉的button -->
		</c:otherwise>
  </c:choose>
第${map.pageInfo.currentPage}页

   <!-- 下一页 按钮 -->
    <c:choose>
		<c:when test="${map.pageInfo.currentPage != map.pageInfo.totalPage}">
			<input type="button" name="nextPage" value="下一页" onclick="gotoNextPage('');" />
		</c:when>
		<c:otherwise>
			<input type="button" disabled="disabled" name="nextPage" value="下一页" /><!-- 为了要那个灰掉的button -->
		</c:otherwise>
	 </c:choose>
	<!-- 尾页 按钮 -->
	 <c:choose>
		<c:when test="${map.pageInfo.currentPage != map.pageInfo.totalPage}">
			<input type="button" name="lastPage" value="尾页" onclick="gotoLastPage();"/>
		</c:when>
		<c:otherwise>
			<input type="button" disabled="disabled" name="lastPage" value="尾页" />
		</c:otherwise>
 	</c:choose>
<!-- 直接跳转 -->
共${map.pageInfo.totalPage}页 &nbsp;&nbsp;&nbsp;向<input type="text" id="pageNum" style="width: 30px" value=""/>页 <input type="button" value="跳转" onclick="gotoPage();" />

<!-- 封装并传递分页参数 -->
<input type="hidden" id="currentPage" name="currentPage" value="0" />
<input type="hidden" id="totalPage" value="${map.pageInfo.totalPage}" />

