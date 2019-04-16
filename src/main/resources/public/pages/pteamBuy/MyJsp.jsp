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
<title>编辑商品</title> <script language='javascript' src="js/edit.js"></script>
<script type="text/javascript" src="/js/ueditor1.4.3.3/ueditor.config.js"></script>
<script type="text/javascript" src="/js/ueditor1.4.3.3/ueditor.all.js"></script>
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<script language="javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" src="/js/layer/layer.js"></script>

</head>
<style>
.select{
height:38px;line-height:38px;border-radius:5px;border:1px solid #12101066;width:200px;
}
.list-border{height:70px;border:1px solid #a0a0a0 ;border-radius:5px;display:block;padding:10px;}
.line{width:180px;float:left}
.select{width:160px}
</style>
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
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star>
												<spring:message code="language.goodsDetails"/>:</label>
												<div class="col-sm-6">
													<textarea id="ta_ckeditor" name="goodsDesc" class="ckeditor" cols="20"  style="overflow:auto">
													</textarea>
												</div>
												<span id="goodsDescMsg" style="color: red"></span>
											</div>
										</fieldset>

							<!--  end card  -->
						</div>
						<!-- end col-md-12 -->
					</div>
					<!-- end row -->
				</div>

			</div>

   
    <div class="col-md-12" style="float:left" style="margin:200px" id="tu">
    
    <div>
        <div class="form-group  " id="pic1">
            <input data-options="prompt:'Choose a file...'" type="file"
                   id='file1' name="file"
                   onchange="ajaxFileUploadMY('file1',1)"/>
            <input id="pic_url1" type="hidden" name="goodsPics[1].picUrl" />
            <img src="" id="pic_urla1"  style="width:100px" />
            <div id="pic_div1" style="display:block;">
                <input id="isHome1" name="goodsPics[1].isHome"  type="hidden" value="1" />
                <a type="button"  onclick="remove('pic1');" >删除</a>
            </div>
        </div>
        </div>
    </div>
<p class='three' id="pp">我是子元素append</p><p class='three'>我是子元素append</p>

			
			<!-- 内容table结束 -->

			<!-- 底部开始 -->
			<jsp:include page="/pages/inc/footer.jsp"></jsp:include>
			<!-- 底部结束 -->
		</div>
	</div>
<script type="text/javascript">

    var num=1;
    // newNode.innerHTML = '我是子元素append'
    function newpic() {
        num++;
        var divid="pic"+num;
        var inpid="file"+num;
        var pic_url="pic_urla"+num;
        alert(num);
		var sas=document.getElementById("file"+(num-1));
		
        sas.style.display="none";
        var htm='';
        var htm ='<div class="form-group " style="float:left" id="'+divid+'">\n' +
            '                <input data-options="prompt:\'Choose a file...\'" type="file"\n' +
            '                       id=\''+inpid+'\' name="file"\n' +
            '                       onchange="ajaxFileUploadMY(\''+inpid+'\','+num+')"/>\n' +
            '                <input id="pic_url1" type="hidden" name="goodsPics[1].picUrl" />\n' +
            '                <img src="" id="'+pic_url+'"  style="width:100px" />\n' +
            '                <div id="pic_div1" style="display:show;">\n' +
            '                    <input id="isHome1" name="goodsPics[1].isHome"  type="hidden" value="1" />\n' +
            '                    <a type="button"  onclick="remove(\''+divid+'\');" >删除</a>\n'+
            '                </div>\n' +
            '            </div>';
        var newNode = document.createElement("div");
        newNode.innerHTML=htm;
        aa=document.getElementById("tu");
        // alert(aa);
        aa.append(newNode);
    }
    function remove(picid) {
		for(i=0;i<arr.length;i++){
    		var map=arr[i];
    		alert(map.name);
    		if(picid==map.name){
    			arr.splice(i,1);
    		}
    	}
        document.getElementById(picid).remove();
    }
    var arr=[];
    function ajaxFileUploadMY(divID,type)
    {	
        if(divID == null){
            divID = "file";
        }
        $.ajaxFileUpload({
                url:"/fileUpload/fileUpload.action",             //需要链接到服务器地址
                secureuri:false,
                dataType: 'multipart/form-data',
                fileElementId: divID,                         //文件选择框的id属性
                dataType: 'json',                                     //服务器返回的格式，可以是json
                success: function (data, status)             //相当于java中try语句块的用法
                {	alert(divID);
                	newpic();
                    if(data.image_url!=null){
                        $("#pic_url"+type).val(data.image_url);
                        $("#pic_urla"+type).attr("src",data.image_url);
                        var imgname="pic"+type;
                        var img={"name":imgname,"url":data.image_url};
                        arr.push(img);
                        $("#pic_div"+type).show();
                        for(i=0;i<arr.length;i++){
				    		var map=arr[i];
				    		alert(map.name);
				    	}
                    }
                },
                error: function (data, status, e){
                }
            }
        );
    }


</script>
	<script type="text/javascript">
	

	</script>
	

</body>
</html>