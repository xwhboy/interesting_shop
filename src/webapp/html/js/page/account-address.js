function append_tbody(){
	var content_html = "";
	for (var i = 0; i < 13; i++) {
		var item = '<div class="address1">'+
				'<div class="main-add">'+
					'<span class="add1">'+'</span>'+
					'<span class="add1-name">'+'</span>'+
					'<div class="icon add-close">'+
					'</div>'+
				'</div>'+
				'<div class="detailed-add">'+
					'<span class="add2" >'+'</span><span class="phone-num">'+'</span>'+'</br>'+
				'</div>'+
				'<span class="add-modify" id="add-modify">'+'修改'+'</span>'+
			'</div>'
		content_html+=item;
		/*
		所在省市：add1
		收货人姓名：add-name
		具体地址：add2
		电话：phone-num
		*/
	}
	
}
append_tbody();
