<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Roninwz博客栏目页面</title>
<link rel="stylesheet" type="text/css" href="static/user/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="static/user/css/nprogress.css">
<link rel="stylesheet" type="text/css" href="static/user/css/style.css">
<link rel="stylesheet" type="text/css" href="static/user/css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="static/user/images/icon/icon.png">
<link rel="shortcut icon" href="static/user/images/icon/favicon.ico">
<script src="static/user/js/jquery-2.1.4.min.js"></script>
<script src="static/user/js/nprogress.js"></script>
<script src="static/user/js/jquery.lazyload.min.js"></script>
<!--[if gte IE 9]>
  <script src="static/user/js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="static/user/js/html5shiv.min.js" type="text/javascript"></script>
  <script src="static/user/js/respond.min.js" type="text/javascript"></script>
  <script src="static/user/js/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
</head>

<body class="user-select">
<header class="header">
  <nav class="navbar navbar-default" id="navbar">
    <div class="container">
      <div class="header-topbar hidden-xs link-border">
        <ul class="site-nav topmenu">
          <li><a href="tags.html">标签云</a></li>
          <li><a href="readers.html" rel="nofollow">读者墙</a></li>
          <li><a href="links.html" rel="nofollow">友情链接</a></li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" rel="nofollow">关注本站 <span class="caret"></span></a>
            <ul class="dropdown-menu header-topbar-dropdown-menu">
              <li><a data-toggle="modal" data-target="#WeChat" rel="nofollow"><i class="fa fa-weixin"></i> 微信</a></li>
              <li><a href="#" rel="nofollow"><i class="fa fa-weibo"></i> 微博</a></li>
              <li><a data-toggle="modal" data-target="#areDeveloping" rel="nofollow"><i class="fa fa-rss"></i> RSS</a></li>
            </ul>
          </li>
        </ul>
        <a href="javascript:;" class="login" rel="nofollow">Hi,您好</a>&nbsp;&nbsp; </div>
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <h1 class="logo hvr-bounce-in"><a href="" title=""><img src="static/user/images/logo.png" alt=""></a></h1>
      </div>
      <div class="collapse navbar-collapse" id="header-navbar">
         <ul class="nav navbar-nav navbar-right">
          <li class="hidden-index active"><a data-cont="首页" href="index">首页</a></li>
          <li><a href="selectFront">前端技术</a></li>
          <li><a href="selectBack">后端程序</a></li>
          <li><a href="selectBeau">美文推荐</a></li>
          <li><a href="selectLife">我的人生</a></li>
          <li><a href="admin">管理系统</a></li>
        </ul>
        <form class="navbar-form visible-xs" action="/Search" method="post">
          <div class="input-group">
            <input type="text" name="keyword" class="form-control" placeholder="请输入关键字" maxlength="20" autocomplete="off">
            <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
            </span> </div>
        </form>
      </div>
    </div>
  </nav>
</header>
<section class="container">
  <div class="content-wrap">
    <div class="content">
      <div class="title">
        <h3>前端技术</h3>
      </div>
       <s:iterator value="#articles" status="articles" var="ar">
      <article class="excerpt excerpt-1"><a class="focus" href="article.html" title=""><img class="thumb" data-original='<s:property value="imgurl"></s:property>' src='<s:property value="imgurl"></s:property>' alt=""></a>
        <header><a class="cat" href="program"><s:property value="title"></s:property><i></i></a>
          <h2><a href="selectArticle?id=<s:property value="#ar.content.id"></s:property>" title=""><s:property value="title"></s:property></a></h2>
        </header>
        <p class="meta">
          <time class="time"><i class="glyphicon glyphicon-time"></i> <s:property value="createDate"></s:property></time>
          <span class="views"><i class="glyphicon glyphicon-eye-open"></i> 共120人围观</span> <a class="comment" href="article.html#comment"><i class="glyphicon glyphicon-comment"></i> 0个不明物体</a></p>
        <p class="note"> <s:property value="abstr"></s:property></p>
      </article>
       
      </s:iterator>
     
      
      <nav class="pagination" style="display: none;">
        <ul>
          <li class="prev-page"></li>
          <li class="active"><span>1</span></li>
          <li><a href="?page=2">2</a></li>
          <li class="next-page"><a href="?page=2">下一页</a></li>
          <li><span>共 2 页</span></li>
        </ul>
      </nav>
    </div>
  </div>
  <aside class="sidebar">
    <div class="fixed">
      <div class="widget widget_search">
        <form class="navbar-form" action="/Search" method="post">
          <div class="input-group">
            <input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字" maxlength="15" autocomplete="off">
            <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
            </span> </div>
        </form>
      </div>
      <div class="widget widget_sentence">
        <h3>每日一句</h3>
        <div class="widget-sentence-content">
          <h4>2016年01月05日星期二</h4>
          <p>Do not let what you cannot do interfere with what you can do.<br />
            别让你不能做的事妨碍到你能做的事。（John Wooden）</p>
        </div>
      </div>
    </div>
    <div class="widget widget_hot">
      <h3>热门文章</h3>
      <ul>
        <s:iterator value="#remenArticles" status="remenArticles" var="rear">
        <li><a href="selectArticle?id=<s:property value="#ar.content.id"></s:property>"><span class="thumbnail"><img class="thumb" data-original='<s:property value="imgurl"></s:property>' src='<s:property value="imgurl"></s:property>' alt=""></span><span class="text"><s:property value="title"></s:property></span><span class="muted"><i class="glyphicon glyphicon-time"></i> <s:property value="createDate"></s:property> </span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i> 120</span></a></li>
        </s:iterator>
      </ul>
    </div>
  </aside>
</section>
<footer class="footer">
  <div class="container">
    <p>&copy; 2016 <a href="">ylsat.com</a> &nbsp; <a href="#" target="_blank" rel="nofollow">豫ICP备20151109-1</a> &nbsp; &nbsp; <a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
  </div>
  <div id="gotop"><a class="gotop"></a></div>
</footer>
<!--微信二维码模态框-->
<div class="modal fade user-select" id="WeChat" tabindex="-1" role="dialog" aria-labelledby="WeChatModalLabel">
  <div class="modal-dialog" role="document" style="margin-top:120px;width:280px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
      </div>
      <div class="modal-body" style="text-align:center"> <img src="static/user/images/weixin.jpg" alt="" style="cursor:pointer"/> </div>
    </div>
  </div>
</div>
<!--该功能正在日以继夜的开发中-->
<div class="modal fade user-select" id="areDeveloping" tabindex="-1" role="dialog" aria-labelledby="areDevelopingModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="areDevelopingModalLabel" style="cursor:default;">该功能正在日以继夜的开发中…</h4>
      </div>
      <div class="modal-body"> <img src="static/user/images/baoman/baoman_01.gif" alt="深思熟虑" />
        <p style="padding:15px 15px 15px 100px; position:absolute; top:15px; cursor:default;">很抱歉，程序猿正在日以继夜的开发此功能，本程序将会在以后的版本中持续完善！</p>
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
    <li class="list-group-item"><span>系统：</span>Windows10 </li>
    <li class="list-group-item"><span>浏览器：</span>Chrome47</li>
  </ul>
</div>
<script src="static/user/js/bootstrap.min.js"></script> 
<script src="static/user/js/jquery.ias.js"></script> 
<script src="static/user/js/scripts.js"></script>
</body>
</html>