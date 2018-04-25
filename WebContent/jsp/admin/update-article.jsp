<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>文章修改 - 王振博客管理系统</title>
<link rel="stylesheet" type="text/css"
	href="static/admin/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="static/admin/css/style.css">
<link rel="stylesheet" type="text/css"
	href="static/admin/css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed"
	href="static/admin/images/icon/icon.png">
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
	<section class="container-fluid">
		<header>
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">切换导航</span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="/">YlsatCMS</a>
					</div>
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="">消息 <span class="badge">1</span></a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">admin <span class="caret"></span></a>
								<ul class="dropdown-menu dropdown-menu-left">
									<li><a title="查看或修改个人信息" data-toggle="modal"
										data-target="#seeUserInfo">个人信息</a></li>
									<li><a title="查看您的登录记录" data-toggle="modal"
										data-target="#seeUserLoginlog">登录记录</a></li>
								</ul></li>
							<li><a href="login.html"
								onClick="if(!confirm('是否确认退出？'))return false;">退出登录</a></li>
							<li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>
						</ul>
						<form action="" method="post" class="navbar-form navbar-right"
							role="search">
							<div class="input-group">
								<input type="text" class="form-control" autocomplete="off"
									placeholder="键入关键字搜索" maxlength="15"> <span
									class="input-group-btn">
									<button class="btn btn-default" type="submit">搜索</button>
								</span>
							</div>
						</form>
					</div>
				</div>
			</nav>
		</header>
		<div class="row">
			<aside class="col-sm-3 col-md-2 col-lg-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="manageindex">主页</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="article">文章</a></li>

					<li><a href="comment">评论</a></li>

				</ul>

				<ul class="nav nav-sidebar">
					<li><a href="manage-user.html">用户</a></li>

				</ul>
			</aside>
			<s:iterator value="#art" status="art" var="ar">
				<div
					class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main"
					id="main">
					<div class="row">
						<form action="updateArticle" method="post"
							class="add-article-form">
							<div class="col-md-9">
								<h1 class="page-header">文章修改</h1>
								<div class="form-group">
									<label for="article-title" class="sr-only">标题</label> <input
										type="text" id="article-title" name="title"
										class="form-control" placeholder="在此处输入标题"
										value='<s:property value="title"></s:property>' required
										autofocus autocomplete="off">
								</div>
								<div class="form-group">
									<%-- <label for="article-content" class="sr-only">内容</label>
              <script id="article-content" name="content" type="text/plain"></script> --%>
									<h2 class="add-article-box-title">
										<span>内容</span>
									</h2>
									<textarea id="container" name="contents"
										style="width: 800px; height: 400px; margin: 0 auto;"><s:property
											value="#ar.content.content"></s:property></textarea>
								</div>
								<div class="add-article-box">
									<h2 class="add-article-box-title">
										<span>关键字</span>
									</h2>
									<div class="add-article-box-content">
										<input type="text" class="form-control" placeholder="请输入关键字"
											value="<s:property value="keywords"></s:property>"
											name="article.keywords" autocomplete="off"> <span
											class="prompt-text">多个标签请用英文逗号,隔开。</span>
									</div>
								</div>
								<div class="add-article-box">
									<h2 class="add-article-box-title">
										<span>描述</span>
									</h2>
									<div class="add-article-box-content">
										<textarea class="form-control" name="article.abstr"
											autocomplete="off"><s:property value="abstr" /></textarea>
										<span class="prompt-text">描述是可选的手工创建的内容总结，并可以在网页描述中使用</span>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<h1 class="page-header">操作</h1>
								<div class="add-article-box">
									<h2 class="add-article-box-title">
										<span>栏目</span>
									</h2>
									<div class="add-article-box-content">
										<s:iterator value="#categories" status="categories" var="ca">
											<ul class="category-list">
												<li><label> <%-- <s:radio list="#{'1':'先生','0':'女士'}" name="gender" value="1"/> --%>
														<%--  <s:radio name="categorys" value="id"/> --%> <input
														name="categorys" type="radio"
														value='<s:property value="id"></s:property>' checked>
														<s:property value="chiName"></s:property> <em
														class="hidden-md">( 栏目ID: <span><s:property
																	value="id"></s:property></span> )
													</em></label></li>
											</ul>
										</s:iterator>
									</div>
								</div>
								<!-- 是否热门 -->
								<div class="add-article-box">
									<h2 class="add-article-box-title">
										<span>是否热门</span>
									</h2>
									<div class="add-article-box-content">

										<ul class="category-list">
<%-- 									<s:set name="isTrue" value='<s:property value="#ar.top"></s:property>' scope="application"/> 
											 <s:if test='#application["isTrue"]== "1"'>   --%>
										 <s:if test="#ar.top==1">  
											<li>
												<!-- 为真 -->
												 <label> 
											<input type="radio" name="article.top" value="true" checked /> 
                                            	是</label>
                                             <label> 
                                            <input type="radio" name="article.top" value="false" />  
                                          	  否</label>
                                            </li>
                                            </s:if>
											<s:else>
												<!-- 否则 -->
												 <li><label> 
												<input type="radio" name="article.top" value="true" />
												是--<s:property value='#ar.top'></s:property></label>
												<label> <input type="radio" name="article.top" value="false" checked />
												否</label></li>
											</s:else>
											<%-- <li><label> <input name="article.top"
													type="radio" value=''> 是</label></li>
											<li><label> <input name="article.top"
													type="radio" value='2'></span> 否</em></label></li> --%>
										</ul>

									</div>
								</div>
								<%--   <div class="add-article-box">
              <h2 class="add-article-box-title"><span>标签</span></h2>
              <div class="add-article-box-content">
                <input type="text" class="form-control" placeholder="输入新标签" value="测试,文章" name="tags" autocomplete="off">
                <span class="prompt-text">多个标签请用英文逗号,隔开</span> </div>
            </div> --%>
								<div class="add-article-box">
									<h2 class="add-article-box-title">
										<span>标题图片</span>
									</h2>
									<div class="add-article-box-content">
										<input type="text" class="form-control" placeholder="点击按钮选择图片"
											id="pictureUpload" name="article.imgurl"
											value='<s:property value="imgurl"></s:property>'
											autocomplete="off">
									</div>
									<div class="add-article-box-footer">
										<button class="btn btn-default" type="button" ID="upImage">选择</button>
									</div>
								</div>
								<div class="add-article-box">
									<h2 class="add-article-box-title">
										<span>发布</span>
									</h2>
									<div class="add-article-box-content">
										<p>
											<label>状态：</label><span class="article-status-display">已发布</span>
										</p>
										<p>
											<label>公开度：</label><input type="radio" name="visibility"
												value="0" checked />公开 <input type="radio" name="visibility"
												value="1" />加密
										</p>
										<p>
											<label>发布于：</label><span class="article-time-display"><input
												style="border: none;" type="datetime" name="time"
												value="<s:property value="article.createDate" />" /></span>
										</p>
									</div>
									<div class="add-article-box-footer">
										<button class="btn btn-primary" type="submit" name="submit">更新</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</s:iterator>
		</div>
	</section>
	<!--个人信息模态框-->
	<div class="modal fade" id="seeUserInfo" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form action="" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">个人信息</h4>
					</div>
					<div class="modal-body">
						<table class="table" style="margin-bottom: 0px;">
							<thead>
								<tr>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td wdith="20%">姓名:</td>
									<td width="80%"><input type="text" value="王雨"
										class="form-control" name="truename" maxlength="10"
										autocomplete="off" /></td>
								</tr>
								<tr>
									<td wdith="20%">用户名:</td>
									<td width="80%"><input type="text" value="admin"
										class="form-control" name="username" maxlength="10"
										autocomplete="off" /></td>
								</tr>
								<tr>
									<td wdith="20%">电话:</td>
									<td width="80%"><input type="text" value="18538078281"
										class="form-control" name="usertel" maxlength="13"
										autocomplete="off" /></td>
								</tr>
								<tr>
									<td wdith="20%">旧密码:</td>
									<td width="80%"><input type="password"
										class="form-control" name="old_password" maxlength="18"
										autocomplete="off" /></td>
								</tr>
								<tr>
									<td wdith="20%">新密码:</td>
									<td width="80%"><input type="password"
										class="form-control" name="password" maxlength="18"
										autocomplete="off" /></td>
								</tr>
								<tr>
									<td wdith="20%">确认密码:</td>
									<td width="80%"><input type="password"
										class="form-control" name="new_password" maxlength="18"
										autocomplete="off" /></td>
								</tr>
							</tbody>
							<tfoot>
								<tr></tr>
							</tfoot>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!--个人登录记录模态框-->
	<div class="modal fade" id="seeUserLoginlog" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">登录记录</h4>
				</div>
				<div class="modal-body">
					<table class="table" style="margin-bottom: 0px;">
						<thead>
							<tr>
								<th>登录IP</th>
								<th>登录时间</th>
								<th>状态</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>::1:55570</td>
								<td>2016-01-08 15:50:28</td>
								<td>成功</td>
							</tr>
							<tr>
								<td>::1:64377</td>
								<td>2016-01-08 10:27:44</td>
								<td>成功</td>
							</tr>
							<tr>
								<td>::1:64027</td>
								<td>2016-01-08 10:19:25</td>
								<td>成功</td>
							</tr>
							<tr>
								<td>::1:57081</td>
								<td>2016-01-06 10:35:12</td>
								<td>成功</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">朕已阅</button>
				</div>
			</div>
		</div>
	</div>
	<!--微信二维码模态框-->
	<div class="modal fade user-select" id="WeChat" tabindex="-1"
		role="dialog" aria-labelledby="WeChatModalLabel">
		<div class="modal-dialog" role="document"
			style="margin-top: 120px; max-width: 280px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="WeChatModalLabel"
						style="cursor: default;">微信扫一扫</h4>
				</div>
				<div class="modal-body" style="text-align: center">
					<img src="static/admin/images/weixin.jpg" alt=""
						style="cursor: pointer" />
				</div>
			</div>
		</div>
	</div>
	<!--提示模态框-->
	<div class="modal fade user-select" id="areDeveloping" tabindex="-1"
		role="dialog" aria-labelledby="areDevelopingModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="areDevelopingModalLabel"
						style="cursor: default;">该功能正在日以继夜的开发中…</h4>
				</div>
				<div class="modal-body">
					<img src="static/admin/images/baoman/baoman_01.gif" alt="深思熟虑" />
					<p
						style="padding: 15px 15px 15px 100px; position: absolute; top: 15px; cursor: default;">很抱歉，程序猿正在日以继夜的开发此功能，本程序将会在以后的版本中持续完善！</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">朕已阅</button>
				</div>
			</div>
		</div>
	</div>
	<!--右键菜单列表-->
	<div id="rightClickMenu">
		<ul class="list-group rightClickMenuList">
			<li class="list-group-item disabled">欢迎访问异清轩博客</li>
			<li class="list-group-item"><span>IP：</span>172.16.10.129</li>
			<li class="list-group-item"><span>地址：</span>河南省郑州市</li>
			<li class="list-group-item"><span>系统：</span>Windows10</li>
			<li class="list-group-item"><span>浏览器：</span>Chrome47</li>
		</ul>
	</div>
	<script src="static/admin/js/bootstrap.min.js"></script>
	<script src="static/admin/js/admin-scripts.js"></script>
	<script src="static/ueditor/ueditor.config.js"></script>
	<script src="static/ueditor/ueditor.all.min.js"> </script>
	<script src="static/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script id="uploadEditor" type="text/plain" style="display: none;"></script>
	<script type="text/javascript">
var editor = UE.getEditor("container");  
//var editor = UE.getEditor('article-content');
window.onresize=function(){
    window.location.reload();
}
var _uploadEditor;
$(function () {
    //重新实例化一个编辑器，防止在上面的editor编辑器中显示上传的图片或者文件
    _uploadEditor = UE.getEditor('uploadEditor');
    _uploadEditor.ready(function () {
        //设置编辑器不可用
        //_uploadEditor.setDisabled();
        //隐藏编辑器，因为不会用到这个编辑器实例，所以要隐藏
        _uploadEditor.hide();
        //侦听图片上传
        _uploadEditor.addListener('beforeInsertImage', function (t, arg) {
            //将地址赋值给相应的input,只去第一张图片的路径
            $("#pictureUpload").attr("value", arg[0].src);
            //图片预览
            //$("#imgPreview").attr("src", arg[0].src);
        })
        //侦听文件上传，取上传文件列表中第一个上传的文件的路径
        _uploadEditor.addListener('afterUpfile', function (t, arg) {
            $("#fileUpload").attr("value", _uploadEditor.options.filePath + arg[0].url);
        })
    });
});
//弹出图片上传的对话框
$('#upImage').click(function () {
    var myImage = _uploadEditor.getDialog("insertimage");
    myImage.open();
});
//弹出文件上传的对话框
function upFiles() {
    var myFiles = _uploadEditor.getDialog("attachment");
    myFiles.open();
}
</script>
</body>
</html>