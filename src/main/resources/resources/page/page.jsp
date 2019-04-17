<%@ page language="java" import="com.antke.website.model.bean.PageInfo"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script language="javaScript">
//跳转
function Jumping(currentPage)
{
/* debugger;*/ 
	//$("#currentPage").value = currentPage;
	document.getElementById("currentPage").value = currentPage;
	//alert(currentPage);
    document.forms[0].submit();
    //document.depotform.submit();
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
	//alert(temp);
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
			<input type="button" name="firstPage" value="«" onclick="gotoFirstPage();" class="pagebtn" />
		</c:when >
		<c:otherwise>
		<input type="button" disabled="disabled" name="firstPage" value="«" class="pagebtn" /><!-- 为了要那个灰掉的button -->
		</c:otherwise>
	</c:choose>
   <!-- 上一页 按钮 -->
   
   <c:choose>
	    <c:when  test="${map.pageInfo.currentPage !=1}">
			<input type="button" name="prePage" value="‹" onclick="gotoPreviousPage();"class="pagebtn"  />
		</c:when >
		<c:otherwise>
			<input type="button" disabled="disabled" name="prePage" value="‹" class="pagebtn" /><!-- 为了要那个灰掉的button -->
		</c:otherwise>
  </c:choose>
<span class="fonttext">第&nbsp;${map.pageInfo.currentPage}&nbsp;页</span>

   <!-- 下一页 按钮 -->
    <c:choose>
		<c:when test="${map.pageInfo.currentPage != map.pageInfo.totalPage}">
			<input type="button" name="nextPage" value="›" onclick="gotoNextPage('');"class="pagebtn"  />
		</c:when>
		<c:otherwise>
			<input type="button" disabled="disabled" name="nextPage" value="›"class="pagebtn" class="pagebtn"  /><!-- 为了要那个灰掉的button -->
		</c:otherwise>
	 </c:choose>
	<!-- 尾页 按钮 -->
	 <c:choose>
		<c:when test="${map.pageInfo.currentPage != map.pageInfo.totalPage}">
			<input type="button" name="lastPage" value="»" onclick="gotoLastPage();"class="pagebtn" />
		</c:when>
		<c:otherwise>
			<input type="button" disabled="disabled" name="lastPage" value="»" class="pagebtn" />
		</c:otherwise>
 	</c:choose>
<!-- 直接跳转 -->
<span class="fonttext">共 &nbsp;${map.pageInfo.totalPage} &nbsp;页 &nbsp;&nbsp;&nbsp;向 &nbsp;&nbsp;<input type="text" id="pageNum" style="width: 30px" value=""class="pagebtn" /> &nbsp;&nbsp;页</span> &nbsp;&nbsp; <input type="button" value="跳转" onclick="gotoPage();" class="jumpbtn" />

<!-- 封装并传递分页参数 -->
<input type="hidden" id="currentPage" name="currentPage"  value="0"/>
<input type="hidden" id="totalPage" value="${map.pageInfo.totalPage}" />

