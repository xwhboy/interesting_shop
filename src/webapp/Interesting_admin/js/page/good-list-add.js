var host = 'http://127.0.0.1'
_init();
function append_tbody(){
	var content_html = "";
	for (var i = 0; i < 13; i++) {
		var item = '<tr>'+
						'<input type="hidden" value="12" id="goods_item_'+i+'"/>' +
						'<td>'+
							'商品1'+
						'</td>'+
						'<td>'+
							'<div>'+
								'<select name="updown" style="width:80px;" id="updown1_'+i+'">'+
									'<option value="0">'+'上架'+'</option>'+
									'<option value="1">'+'不上架'+'</option>'+
									'<option value="2">'+'上架'+'</option>'+
							'</div>'+
						'</td>'+
						'<td>'+
							'<div>'+
								'<select name="updown" style="width:80px;" id="updown2_'+i+'">'+
									'<option value="0">'+'上架'+'</option>'+
									'<option value="1">'+'不上架'+'</option>'+
									'<option value="2">'+'上架'+'</option>'+
							'</div>'+
						'</td>'+
						'<td>'+
							'<input type="text" name="num" placeholder="'+'20'+' "style="width: 30px;" id="input_cnt_'+i+'"/>'+
						'</td>'+
						'<td>'+
							'类别1'+
						'</td>'+
						'<td>'+
							'<div align="center">'+
								'<button type="button" class="btn btn-success btn-xs" onclick="update_cnt('+i+')" >'+
									'更新库存'+
								'</button>'+
						'</td>'+
					'</tr>';
		content_html+=item;
		
	}
		$("#table_content").empty();
		$("#table_content").append(content_html);
}

function update_cnt(i){
	var gid = $("#goods_item_"+i).val();
	var cnt = $("#input_cnt_"+i).val();
	var art1 = $('#updown1_'+i+' option:selected').val();
	var art2 = $('#updown2_'+i+' option:selected').val();
	if (cnt == '') {
		warning_dialog('库存不能为空');
		return;
	}else if (isNaN(cnt)) {
		warning_dialog('库存要为数字');
		return;
	}
	var post_url = host + '/manager/edit_goods_num'
	$.ajax({
		type : 'post',
		url : post_url,
		data : {
			'pro_id' : gid,
			'good_proAttribute1' : art1,
			'good_proAttribute2':art2,
			'good_count':cnt
		},
		dataType : "json",
		success : function(data) {
			
		},
		error:function(xhr){
			debugger;
		}
	});
}

function _init(){
	append_tbody();
}

$("#search").click(function(){
	var keyword = $("#search_input").val();
	var post_url = host + '/manager/edit_goods_num'
	$.ajax({
		type : 'post',
		url : post_url,
		data : {
			'pro_id' : gid,
			'good_proAttribute1' : art1,
			'good_proAttribute2':art2,
			'good_count':cnt
		},
		dataType : "json",
		success : function(data) {
			
		},
		error:function(xhr){
			debugger;
		}
	});
});

