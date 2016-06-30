document.write("<script src='js/page/tools.js' type='text/javascript'></script>");
function append_tbody(){
	var content_html = "";
	for (var i = 0; i <10; i++) {
		var item ='<tr>'+
					'<td id="ul-user-id'+i+'">'+
					'00'+i+
					'</td>'+
					'<td id="ul-user-name'+i+'">'+
					'admin'+i+
					'</td>'+
					'<td>'+
					    '&nbsp;'+
					    '&nbsp;'+
						'<button type="button" class="btn btn-info btn-xs" value="修改" onclick="reset('+i+')">'+
						'修改'+
						'</button>'+
						'&nbsp;'+
						'&nbsp;'+
						'<button type="button" class="btn btn-danger btn-xs" value="删除"  onclick="del('+i+')">'+
						'删除'+
						'</button>'+
					'</td>'+
				'</tr>';
		content_html+=item;
	}
		$("#table_content").empty();
		$("#table_content").append(content_html);
     
}
append_tbody();
function reset(i) {
	var user_id = '#ul-user-id' + i;
	var user_id_value = $(user_id).text();
	var user_name = '#ul-user-name' + i;
	var user_name_value = $(user_name).text();
	
	console.log(user_id_value+ "--" + user_name_value);
	location.href = "users-edit.html"+"?"+"usid="+user_id_value; //接收页面  传参
}

function pre_input(){
	
}
function del(i) {
	warning_dialog('未开发');

}
function search() {
	var user_value=$('#user-name').val();
	if(user_value==''){
		var url_it='users-list.html';
		location.replace(url_it);
	}
	else{
		
		
	var content_html = "";
	for (var i = 0; i <2; i++) {
		var item ='<tr>'+
					'<td id="ul-user-id'+i+'">'+
					'00'+i+
					'</td>'+
					'<td id="ul-user-name'+i+'">'+
					'admin'+i+
					'</td>'+
					'<td>'+
					    '&nbsp;'+
					    '&nbsp;'+
						'<button type="button" class="btn btn-info btn-xs" value="修改" onclick="reset('+i+')">'+
						'修改'+
						'</button>'+
						'&nbsp;'+
						'&nbsp;'+
						'<button type="button" class="btn btn-danger btn-xs" value="删除"  onclick="del('+i+')">'+
						'删除'+
						'</button>'+
					'</td>'+
				'</tr>';
		content_html+=item;
	}
		$("#table_content").empty();
		$("#table_content").append(content_html);	
	}
	

}

function put_info(){
    var user_value=$('#user-name').val();
	var put_url = '';
	$.ajax({
		type : 'post',
		url : put_url,
		data : {
			'keyword' :user_value
			
		},
		dataType : "json",
		success : function(data) {
			
		}
	});
}

