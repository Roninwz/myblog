<%@ page language="java" import="java.util.Map" import="com.opensymphony.xwork2.ActionContext" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>王振博客管理系统</title>
<link rel="stylesheet" type="text/css" href="static/admin/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="static/admin/css/style.css">
<link rel="stylesheet" type="text/css" href="static/admin/css/login.css">
<link rel="apple-touch-icon-precomposed" href="static/admin/images/icon/icon.png">
<link rel="shortcut icon" href="static/admin/images/icon/favicon.ico">
<script src="static/admin/js/jquery-2.1.4.min.js"></script>
<!--[if gte IE 9]>
  <script src="static/admin/js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="static/admin/js/html5shiv.min.js" type="text/javascript"></script>
  <script src="static/admin/js/respond.min.js" type="text/javascript"></script>
  <script src="static/admin/js/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
</head>

<body class="user-select">
<%-- <% if(!session.getAttribute("is_loginerr").equals("")&&session.getAttribute("is_loginerr").equals(false)){ %>
         <h2 class="form-signin-heading" style="color:red;">输入信息有误</h2>
        <%} %>  --%>
<div class="container">
  <div class="siteIcon"><img src="static/admin/images/icon/icon.png" alt="" data-toggle="tooltip" data-placement="top" title="欢迎使用王振博客管理系统" draggable="false" /></div>
  <form action="admin_login" method="post" autocomplete="off" class="form-signin">
   <s:if test="%{is_loginerr!=null&&is_loginerr==flase}">
     <h2 class="form-signin-heading" style="color:red;">输入信息有误</h2>
    </s:if> 
        <s:div>${is_loginerr}</s:div>
    <h2 class="form-signin-heading">管理员登录</h2>
    
    <label for="userName" class="sr-only">用户名</label>
  
    <input type="text" id="userName" name="name" value="${username}" class="form-control" placeholder="请输入用户名" required autofocus autocomplete="off" maxlength="20">
    
    <label for="userPwd" class="sr-only">密码</label>
    
    <input type="password" id="userPwd" name="password" value="${password}" class="form-control" placeholder="请输入密码" required autocomplete="off" maxlength="18">
    <input type="text" id="yanzhengma" name="yanzhengma" value="" class="form-control" placeholder="请输入验证码" required autocomplete="off" maxlength="18">
   
   
   <div style="margin: 0px 0px 0px 0px;">
		<div id="v_container" class="hui_kuang" style="width: 92px;height: 31px;font-size: 24px;"></div>
		  <div class="shuaxin" style="width:auto;">
		               看不清?点击图片
		</div>
	</div>
     <div class="checkbox" style="width: 100px;height: 20px;">
          <label>
            <input type="checkbox"  name="remember" value="y"> <span style="top:-5px;">记住我</span>
          </label>
          <a href="admin_register">立即注册</a>
     </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="signinSubmit">登录</button>

  </form>
  <div class="footer">
    <p><a href="index.html" data-toggle="tooltip" data-placement="left" title="不知道自己在哪?">回到后台 →</a></p>
  </div>
</div>
<script src="static/admin/js/bootstrap.min.js"></script> 
<script>
$('[data-toggle="tooltip"]').tooltip();
window.oncontextmenu = function(){
	//return false;
};
$('.siteIcon img').click(function(){
	window.location.reload();
});
$('#signinSubmit').click(function(){
	if($('#userName').val() === ''){
		$(this).text('用户名不能为空');
	}else if($('#userPwd').val() === ''){
		$(this).text('密码不能为空');
	}else{
		$(this).text('请稍后...');
	}
});
</script>
<script src="static/admin/plugin/gVerify.js"></script>
<script>
	var verifyCode = new GVerify("v_container");
</script>
</body>
</html>
