function numFormat(val, v){
	if(/\D/.test(val)){
		alert("請輸入正確格式!");
		$('#' + v).val("");
	}
}
