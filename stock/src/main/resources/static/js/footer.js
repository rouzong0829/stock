$(function(){
	showFooter();
})

function showFooter(){
	var html = '<div>'
		+'地址：XXXXX X	X市XX路X段X號X樓　電話︰(XX)XXXX-XXXX'
	+'</div>'
	+'<div>'
		+'<ul class="foot-ul">'
			+'<li><a href="construction.html">聯絡我們</a></li>'
			+'<li>|</li>'
			+'<li><a href="construction.html">訂閱電子報</a></li>'
			+'<li>|</li>'
			+'<li><a href="construction.html">網站地圖</a></li>'
			+'<li>|</li>'
			+'<li><a href="construction.html">使用條款</a></li>'
			+'<li>|</li>'
			+'<li><a href="construction.html">隱私權保護說明</a></li>'
			+'<li>|</li>'
			+'<li><a href="construction.html">個人資料管理政策聲明</a></li>'
			+'<li>|</li>'
			+'<li><a href="construction.html">資訊安全政策</a></li>'
		+'</ul>'
	+'</div>'
	+'<div>'
		+'※ 本站建議最佳瀏覽條件：螢幕解析度 1920x1080 以上，瀏覽器為 Google Chrome。'
	+'</div>'
	+'<div class="logo">Logo通過<a href="https://www.designevo.com/tw/logo-maker/" title="免費線上logo製作軟體">DesignEvo</a>設計製作</div>'
	+'<a id="return-top" href="#top">返回頂端</a>'

$("footer").html(html);
}