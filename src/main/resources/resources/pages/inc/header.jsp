<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="/js/common.js"></script>
		<script type="text/javascript" src="/js/ajaxfileupload.js"></script>
	<nav class="navbar navbar-default">
            <div class="container-fluid">
				<div class="navbar-minimize">
    				<button id="minimizeSidebar" class="btn btn-warning btn-fill btn-round btn-icon">
    					<i class="fa fa-ellipsis-v visible-on-sidebar-regular"></i>
    					<i class="fa fa-navicon visible-on-sidebar-mini"></i>
    				</button>
    			</div>
                <!-- <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> -->
                <div class="collapse navbar-collapse">

                    <!-- <form class="navbar-form navbar-left navbar-search-form" role="search">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" value="" class="form-control" placeholder="Search...">
                        </div>
                    </form> -->

                    <ul class="nav navbar-nav navbar-right">
                    	<li>
	                    	 <a href="#" onclick="langsdsChange('zh');">
		                    	 <i class="fa fa-flag-o"></i> 
		                    	  <p>CN</p>
	                    	 </a>
                        </li>
                        <li>
	                    	 <a href="#" onclick="langsdsChange('en');">
		                    	  <i class="fa pe-7s-global"></i> 
		                    	  <p>EN</p>
	                    	 </a>
                        </li>
           
                        <!-- <li>
                            <a href="/pages/statistics/charts.jsp">
                                <i class="fa fa-line-chart"></i>
                                <p>统计</p>
                            </a>
                        </li> -->

                       <%--  <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-bell-o"></i>
                                <span class="notification">5</span>
                                <p class="hidden-md hidden-lg">
    								通知
    								<b class="caret"></b>
    							</p>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="/notice/queryNoticeList.do">系统公告</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                           </ul>
                        </li> --%>
 			
                        <li class="dropdown dropdown-with-icons">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-list"></i>
                                <p class="hidden-md hidden-lg">
    								More
    								<b class="caret"></b>
    							</p>
                            </a>
                            <ul class="dropdown-menu dropdown-with-icons">
                               <!--  <li>
                                    <a href="/notice/queryNoticeList.do">
                                        <i class="pe-7s-mail"></i> Messages
                                    </a>
                                </li> -->
                                <%--<li>
                                    <a href="#">
                                        <i class="pe-7s-help1"></i> Help Center
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="pe-7s-tools"></i> Settings
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">
                                        <i class="pe-7s-lock"></i> Lock Screen
                                    </a>
                                </li>
                                --%><li>
                                    <a href="/login/loginOut.do" class="text-danger">
                                        <i class="pe-7s-close-circle"></i>
                                        Log out
                                    </a>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>
        <script type="text/javascript">
		
		function langsdsChange(langType){
				$.ajax({
					url : "/language/langsdsChange.do?langType="+langType,
					type : 'get',
					async: false,
				});
				window.location.reload();
			
		}
		$(".gohome").on("click",function(){
			window.location.href="/pages/login/index.jsp"
		})
		</script>
</html>