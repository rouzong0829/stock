$(function(){
	showHeader();
	getUsernameAndAvatar();
})

function showHeader(){
	var html = '<a id="top"></a>'
		+'<div class="head-div">'
			+'<a href="index.html">'
				+'<img src="../images/logo1.png" width="100px">'
			+'</a>'
			+'<span class="head-title">臺灣證劵交易所</span>'
			+'<div class="head-list">'
				+'<ul>'
					+'<li class="logout-title"><a href="register.html">註冊</a></li>'
					+'<li class="logout-title">|</li>'
					+'<li class="logout-title"><a href="login.html">登入</a></li>'
					+'<li class="login-title"><a href="upload.html" class="avatar-size"><img id="header-img-avatar" src="../images/user.jpg" ></a></li>'
					+'<li class="login-title"><a href="password.html" id="title-username" title="修改資料">#{username}</a></li>'
					+'<li class="login-title">|</li>'
					+'<li class="login-title"><a href="password.html" title="修改資料">修改資料</a></li>'
					+'<li class="login-title">|</li>'
					+'<li class="login-title"><a id="logout" href="" onclick="logout()">登出</a></li>'
				+'</ul>'
			+'</div>'
			+'<div class="menu">'
				+'<ul>'
					+'<li><a href="index.html">首頁</a></li>'
					+'<li>|</li>'
					+'<li><a href="product.html">商品</a></li>'
					+'<li>|</li>'
					+'<li><a href="favorite.html">我的收藏</a></li>'
					+'<li>|</li>'
					+'<li><a href="orderList.html">我的訂單</a></li>'
				+'</ul>'
			+'</div>'
		+'</div>';
	
	
	$("header").html(html);
}

function getUsernameAndAvatar(){
	var url = "../user/info";
	$.ajax({
		"url": url,
		"type": "POST",
		"dataType": "json",
		"success": function(json){
			if(json.data.username != null){
				$("#title-username").html(json.data.username);
				$(".logout-title,.login-title").toggle();
			}
			if(json.data.avatar != null){
				$("#header-img-avatar").attr("src", json.data.avatar);
			}
		}
	})
}

function logout(){
	var url = "../user/logout";
	$.ajax({
		"url": url,
		"type": "POST",
		"dataType": "json",
		"success": function(json){
			alert("登出成功!");
			location.href = "login.html";
			location.reload(true);
		},
		"error": function(xhr,text,errorThrown){
			alert("未登入!");
			location.href = "login.html";
		}
	})
}
