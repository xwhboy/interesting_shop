var host = 'http://127.0.0.1';
var curr_page = 1;
var total_page = 20;
_init();

function append_tbody() {
	var content_html = "";
	for (var i = 0; i < 10; i++) {
		var item = '<tr>' +
			'<input type="hidden" value="12" id="goods_item_'+i+'"/>' +
			'<td>' +
			'商品1' +
			'</td>' +
			'<td>' +
			'10' +
			'</td>' +
			'<td>' +
			'9' +
			'</td>' +
			'<td>' +
			'10' +
			'</td>' +
			'<td>' +
			'类别1' +
			'</td>' +
			'<td>' +
			'<div>' +
			'无' +
			'</div>' +
			'</td>' +
			'<td style="min-width:320px">' +
			'<div align="baseline">' +
			'&nbsp;' +
			'<a href="goods-change.html?id=1">' +
			'<button type="button" class="btn btn btn-primary btn-xs">' +
			'修改' +
			'</button>' +
			'</a>' +
			'&nbsp;' +
			'<a href="goods-list-add.html">' +
			'<button type="button" class="btn btn-info btn-xs" value="库存">' +
			'库存' +
			'</button>' +
			'</a>' +
			'&nbsp;' +
			'<button type="button" class="btn btn-success btn-xs" id="item_'+i+'" value="上架" onclick="changebutton(this,'+i+')">' +
			'上架' +
			'</button>' +
			'&nbsp;' +
			'<button type="button" class="btn btn-danger btn-xs" onclick="delete_goods(this,'+i+')">' +
			'删除' +
			'</button>' +
			'</div>' +
			'</td>' +
			'</tr>';
		content_html += item;
	}
	$("#table_content").empty();
	$("#table_content").append(content_html);

}

function changebutton(obj,i) {
	var gid = $("#goods_item_"+i).val();
	if (obj.value == "上架") {
		obj.setAttribute("class", "btn btn-warning");
		obj.innerHTML = "下架";
		obj.setAttribute("value", "下架");
	} else {
		obj.setAttribute("class", "btn btn-success");
		obj.innerHTML = "上架";
		obj.setAttribute("value", "上架");
	}
}




function delete_goods(obj,i) {
	var gid = $("#goods_item_"+i).val();
	var post_url = host +'/manager/delete_goods';
	$.ajax({
		type : 'post',
		url : post_url,
		data : {
			'pro_id' : gid
		},
		dataType : "json",
		success : function(data) {
			location.reload();
		},
		error:function(xhr){
			debugger;
		}
	});
}


function update_status(gid,status){
	var post_url = host +'/manager/delete_goods';
	$.ajax({
		type : 'post',
		url : post_url,
		data : {
			'pro_id' : gid
		},
		dataType : "json",
		success : function(data) {
			//todo
		},
		error:function(xhr){
			debugger;
		}
	});
}

$("#pre_page").click(function(){
	pre_page();
});
$("#next_page").click(function(){
	next_page();
});
$("#back_to_first").click(function(){
	back_to_first();
});

function pre_page(){
	if (curr_page > 1) {
		curr_page--;
		change_curr_page(curr_page);
	}
}

function next_page(){
	if (curr_page < total_page) {
		curr_page++;
		change_curr_page(curr_page);
	}
}

function back_to_first(){
	alert(curr_page);
}

function change_curr_page(i){
	$("#li_pc").html('当前'+i+'页');
};

function _init(){
	append_tbody();
	change_curr_page(curr_page);
}



