<%@ page language="java"
	import="java.util.*,com.power.bean.WorkerInfo"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="sidebar" data-color="azure"
	data-image="/images/full-screen-image-3.jpg">
	<div class="logo">
		<a href="/pages/login/index.jsp" class="logo-text"> <%--<img src="" style="width:20px;height:20px;margin-top:-5px;"/>&nbsp;--%>
			<spring:message code="language.name" />
		</a>
	</div>
	<div class="logo logo-mini">
		<a href="#" class="logo-text"> 8鲜生 </a>
	</div>

	<div class="sidebar-wrapper">
		<div class="user">
			<div class="photo">
				<img src="/images/default-avatar.png">
			</div>
			<div class="info">
				<a data-toggle="collapse" href="#collapseExample" class="collapsed">
					<%--<spring:message code="language.admin" /> --%>
					${workerInfo.workerName} &nbsp;<spring:message
						code="language.hello" />!<br /> <%--<spring:message code="language.businumber"/>:${chant.chant_code}
                   --%>
					<%--<b class="caret"></b>
                --%>
				</a>
				<%--
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        <li><a href="#">My Profile</a></li>
                        <li><a href="#">Edit Profile</a></li>
                        <li><a href="#">Settings</a></li>
                    </ul>
                </div>
            --%>
			</div>
		</div>

		<ul class="nav">


			<c:forEach items="${topMenuList}" var="topMenu" varStatus="v">
				<li style="clear:both;position:relative;" class="parentli"><a
					data-toggle="collapse" href="#${topMenu.menu_id}"
					style="margin:5px  10px 0;display:flex;"> <span
						style="display:inline-block;margin-top:5px;margin-right:5px;"><img
							src="${topMenu.icon_url}" /></span>
						<p>
							<span style="display:block;line-height:25px;">${topMenu.menu_name}</span>
							<span style="display:block;line-height:25px;">${topMenu.menu_desciption}</span>
						</p> <span style="position:absolute;top:20px;right:20px"><b
							class="caret"></b></span>
				</a>
					<div class="collapse parent" id="${topMenu.menu_id}">
						<ul class="nav">
							<c:forEach items="${topMenu.childMenuList}" var="childMenu">

								<li id="${childMenu.menu_id}"><a
									href="${childMenu.url}?${childMenu.menu_id}"
									style="overflow:hidden;">
										<p style="float:left;display:inline-block;">
											<span style="display:block;line-height:25px;">${childMenu.menu_name }</span>
											<span style="display:block;line-height:25px;">${childMenu.menu_desciption}</span>
										</p>

								</a></li>
							</c:forEach>
						</ul>
					</div></li>
			</c:forEach>
		</ul>
	</div>
</div>
<script>
function GetUrlPara()
{
var url = document.location.toString();
var arrUrl = url.split("?");
var para = arrUrl[1];
	var $div=$(".parent");
	var $li=$(".parentli")
	$('#'+para+'').parent().parent().addClass("in");
	$('#'+para+'' ).addClass("active");
	$('#'+para+'').parent().parent().parent().addClass("active");
	
	 
}
$(function(){
	GetUrlPara()
})

	
</script>
