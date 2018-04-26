<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<script src="static/admin/js/jquery-3.1.1.min.js"></script>
<style>
*{
	margin:0;
	padding:0;
	font-family:"微软雅黑";
	font-size:12px;
}
.box{
	width:390px;
	height:320px;
	border:solid 1px #ddd;
	background:#FFF;
	position:absolute;
	left:50%;
	top:42%;
	margin-left:-195px;
	margin-top:-160px;
}
.box h2{
	font-weight:normal;
	color:#666;
	font-size:16px;
	line-height:46px;
	height:46px;
	overflow:hidden;
	text-align:center;
	border-bottom:solid 1px #ddd;
	background:#f7f7f7;
}
.input_box{
	width:350px;
	padding-bottom:15px;
	margin:0 auto;
	overflow:hidden;
}
.input_box input{
	float:left;
	width:348px;
	height:40px;
	font-size:14px;
	border:solid 1px #ddd;
	text-indent:10px;
	outline:none;
	line-height:40px;
}
.input_box .button{
	width:350px;
	height:48px;
	background:#3f89ec;
	border:none;
	border-radius:2px;
	outline:none;
	cursor:pointer;
	font-size:16px;
	color:#FFF;
}
#error_box{
	height:40px;
	width:350px;
	margin:0 auto;
	line-height:40px;
	color:#fc4343;
}
</style>
<script>
//长度必须在6~20位之间
//开头不能为数字
//只能包含小写字母和数字
//数字：48~57
//小写字母：97~122
//innerHTML
var flag=true;
var fname=true;
var femail=true;
$(document).ready(function(){  
	
 $("#uname").blur(function(){
	 //alert("ss");
	 var user={
	            'user.username':$('#uname').val()  
	            
	        };
	        $.ajax({
	            url:'isexistusername',
	            type:'post',
	            data:user,
	            dataType:"json",
	            async: false,
                cache:false,
                //在请求之前调用的函数
                beforeSend: function () {  $("#error_box").html("正在验证用户名是否存在。。。");  },
	            success:function(data){
	            	$("#error_box").text("");
	                //有时候感觉接受的数据总是显示各种乱七八糟的错误，你可以先alert看下，传回的是什么东西
	                //alert(data);
	                //随便的显示一下传回的数据喽
	                var backdata=JSON.parse(data); //传回的是json字符串，要先把它转换成js中的类对象，对于json字符串和json对象自己去百度
	                var f=backdata.isUsernameTrue;//将json字符串转换成json对象后，就可以这样获取其中的值。
	               //alert(f);
	               	    if(f=="用户名已存在")  {
	               	    	
	               	    	$("#error_box").text(f);
	               	    	$("#uname").focus();
	               	    	fname=false;
	               	    }else {
	               	    	fname=true;
	               	    	$("#error_box").text("");
	               	    }         	

	            }
	        });
 });
	$("#uemail").blur(function(){
		 var user={
		            'user.email':$('#uemail').val()  
		            
		        };
		$.ajax({
            url:'isexistemail',
            type:'post',
            data:user,
            dataType:"json",
            success:function(data){
                //有时候感觉接受的数据总是显示各种乱七八糟的错误，你可以先alert看下，传回的是什么东西
                //alert(data);
                //随便的显示一下传回的数据喽
                var backdata=JSON.parse(data); //传回的是json字符串，要先把它转换成js中的类对象，对于json字符串和json对象自己去百度
                var f=backdata.isEmailTrue;//将json字符串转换成json对象后，就可以这样获取其中的值。       	
                	if(f=="邮箱已存在"){
                		$("#error_box").text(f);
                		$("#uemail").focus();
                		femail=false;
                	}else{
                		femail=true;
                		$("#error_box").text("");
                	}
                
            }
        });
	});
       /*  $.ajax({
            url:'isexistemail',
            type:'post',
            data:user,
            dataType:"json",
            success:function(data){
                //有时候感觉接受的数据总是显示各种乱七八糟的错误，你可以先alert看下，传回的是什么东西
                alert(data);
                //随便的显示一下传回的数据喽
                var backdata=JSON.parse(data); //传回的是json字符串，要先把它转换成js中的类对象，对于json字符串和json对象自己去百度
                var f=backdata.isEmailTrue;//将json字符串转换成json对象后，就可以这样获取其中的值。
                if(f){
                	
                	$("#error_box").text("邮箱已存在");
                }else{
                	$("#error_box").text("邮箱符合要求");
                }
 
            }
        }); */
	
});

function submitForm(){
	var oUname = document.getElementById("uname");
	var oUpass = document.getElementById("upass");
	var oUemail = document.getElementById("uemail");
	var oError = document.getElementById("error_box");
	var re = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/ ;
	var isNotError = true;
	
	if(oUname.value.length > 20 || oUname.value.length < 2){
		oError.innerHTML = "用户名长度必须在2~20位之间";
		isNotError = false;
		flag=false;
		
	}else if(oUname.value.charCodeAt(0) >= 48 && oUname.value.charCodeAt(0) <= 57){
		oError.innerHTML = "用户名开头不能为数字";
		isNotError = false;
		flag=false;
	}else{
		for(var i=0; i<oUname.value.length; i++){
			if((oUname.value.charCodeAt(i) > 122 || oUname.value.charCodeAt(i) < 97) && (oUname.value.charCodeAt(i) > 57 || oUname.value.charCodeAt(i) < 48)){
				oError.innerHTML = "用户名只能包含小写字母和数字";
				isNotError = false;
				flag=false;
			}
		}
	}
	
	
	if(oUpass.value.length > 20 || oUpass.value.length < 3){
		oError.innerHTML = "密码长度必须在3~20位之间";
		isNotError = false;
		flag=false;
	}
	if(!re.test(oUemail.value)){
		oError.innerHTML = "邮箱格式不正确";
		flag=false;
	}
	return flag;
	//oError.innerHTML = "登录成功";
}

function checkUkey(){  
    var f=submitForm(); 
    alert(f+" "+femail+" "+fname);
    if(f&&femail&&fname){  
        document.loginForm.submit();  
    }else{ 
    	return false;
    	}  
    }
</script>
</head>
<body>

<div class="box">
	<h2>注册</h2>
    <div id="error_box"></div>
	<form action="admin_registerCheck" method="post" name="loginForm">	
    <div class="input_box">
    	<input type="text" placeholder="请输入账户名" name="user.username" id="uname"/>
    </div>
    <div class="input_box">
    	<input type="password" placeholder="请输入密码" name="user.password" id="upass"/>
    </div>
	 <div class="input_box">
    	<input type="text" placeholder="请输入邮箱" name="user.email" id="uemail"/>
    </div>
    <div class="input_box">
    	<input type="submit" value="注册" onclick="checkUkey();return false;" class="button">
    	<a href="admin">立即登录</a>
    </div>
	</form>
</div>

</body>
</html>