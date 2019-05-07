<%@ page language="java" import="com.website.bean.PageInfo"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<script language="javaScript">
//跳转
function Jumping1(currentPage1)
{
	document.getElementById("currentPage1").value = currentPage1;
	jQuery.ajax({
		url:$("#ajaxForm").attr("action"),
		data:$("#ajaxForm").serialize(),
		type:"post",
		success:function(data){
			$("#ss").html(data);
		}
	});
}
//跳转首页
function gotoFirstPage1(){
	var temp1 = 1;
	Jumping1(temp1);
}
//跳转第一页
function gotoPreviousPage1(){
	var currentPage1 = '${pageInfo1.currentPage}';
	var totalPage1 = document.getElementById("totalPage1").value;
	if(parseInt(currentPage1, 10) > 1){
		var temp1 = parseInt(currentPage1, 10) - 1;
	}else{
		var temp1 = 1;
	}
	Jumping1(temp1);
}
//跳转下一页
function gotoNextPage1(){
	var currentPage1 = '${pageInfo1.currentPage}';
	var totalPage1 = document.getElementById("totalPage1").value;
	if(parseInt(currentPage1, 10) <= parseInt(totalPage1, 10)){
		var temp1 = parseInt(currentPage1, 10) + 1;
	}else{
		var temp1 = parseInt(totalPage1, 10);
	}
	Jumping1(temp1);
}
//跳转首页
function gotoLastPage1(){
	var totalPage1 = document.getElementById("totalPage1").value;
	var temp1 = parseInt(totalPage1, 10);
	Jumping1(temp1);
}
//跳转指定页
function gotoPage1()
{
	var pageNum1 = document.getElementById("pageNum1").value;
	var currentPage1 = '${pageInfo1.currentPage}';
	var totalPage1 = document.getElementById("totalPage1").value;
	if(!check_validate1(pageNum1)){
		document.getElementById("pageNum1").focus();
		return;
	}
	if(parseInt(pageNum1, 10) <= parseInt(totalPage1, 10)
		&& parseInt(pageNum1, 10) >= 1){
		var temp1 = parseInt(pageNum1, 10);
	}else{
		var temp1 = parseInt(currentPage1, 10);
	}
	Jumping1(temp1);
}
//判断输入是否为数字
function check_validate1(value1){
    var reg1 = new RegExp("^[0-9]+$");
    if(reg1.test(value1)){
        return true;
    }
    return false;
}
</script>
	<!-- 首页 按钮 -->
<s:if test="pageInfo1.currentPage != 1">
	<input type="button" name="firstPage" value="首页" onclick="gotoFirstPage1();" />
</s:if>
<s:else>
	<input type="button" disabled="disabled" name="firstPage" value="首页"/><!-- 为了要那个灰掉的button -->
</s:else>
	
   <!-- 上一页 按钮 -->
<s:if test="pageInfo1.currentPage != 1">
	<input type="button" name="prePage" value="上一页" onclick="gotoPreviousPage1();" />
</s:if>
<s:else>
	<input type="button" disabled="disabled" name="prePage" value="上一页" /><!-- 为了要那个灰掉的button -->
</s:else>
第${pageInfo1.currentPage}页

   <!-- 下一页 按钮 -->
<s:if test="pageInfo1.currentPage != pageInfo1.totalPage">
	<input type="button" name="nextPage" value="下一页" onclick="gotoNextPage1('');" />
</s:if>
<s:else>
	<input type="button" disabled="disabled" name="nextPage" value="下一页" /><!-- 为了要那个灰掉的button -->
</s:else>

	<!-- 尾页 按钮 -->
<s:if test="pageInfo1.currentPage != pageInfo1.totalPage">
	<input type="button" name="lastPage" value="尾页" onclick="gotoLastPage1();"/>
</s:if>
<s:else>
	<input type="button" disabled="disabled" name="lastPage" value="尾页" />
</s:else>

<!-- 直接跳转 -->
共${pageInfo1.totalPage}页 &nbsp;&nbsp;&nbsp;向<input type="text" id="pageNum1" style="width: 30px" value=""/>页 <input type="button" value="跳转" onclick="gotoPage1();" />

<!-- 封装并传递分页参数 -->
<input type="hidden" id="currentPage1" name="pageInfo1.currentPage" value=null />
<input type="hidden" id="totalPage1" value="${pageInfo1.totalPage}" />

