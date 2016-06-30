document.write("<script src='js/page/tools.js' type='text/javascript'></script>");
function append_tbody(){
	var content_html = "";
	for (var i = 0; i <10; i++) {
		var item ='<tr>'+
			'<td id="menu-id'+i+'">'+
			'0000000'+i+
			'</td>'+
			'<td id="user-id'+i+'">'+
			'jobs'+i+
			'</td>'+
			'<td id="state-id'+i+'">'+
			'1'+
			'</td>'+
			'<td>'+
			    '&nbsp;'+
			    '&nbsp;'+
				'<button type="button" class="btn btn-info btn-xs" value="修改" onclick="reset('+i+')">'+
				'修改'+
				'</button>'+
				'</a>'+
				'&nbsp;'+
				'&nbsp;'+
				'<button type="button" class="btn btn-danger btn-xs" value="删除" onclick="del('+i+')">'+
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
var curr_page = 1;
var total_page=20;
$("#total_num").text(20);
$("#pre_page").click(function(){
	pre_page();
});
$("#next_page").click(function(){
	next_page();
});
$("#back_to_first").click(function(){
	back_to_first();
});


function reset(i) {
	var o_id_name = '#menu-id' + i;
	var o_id_value = $(o_id_name).text();
	var u_id_name = '#user-id' + i;
	var u_id_value = $(u_id_name).text();
	var s_id_name = '#state-id' + i;
	var s_id_value = $(s_id_name).val();
	var url_content="menu-edit.html"+"?"+
	"muid="+o_id_value+"&"+
	"usid="+u_id_value+"&"+
	"stid="+s_id_value;
	location.href = url_content; //接收页面  传参
	
}
function pre_input(){
	
}
function del(i) {
	warning_dialog('待开发');

}
function search() {
	check_input();

}
function check_input(){
    var o_id_value=$('#menu-name').val();
    var u_id_value=$('#id-name').val();
    var s_id_value=$('#parent-id').val();
    var alert_content;
    //console.log((o_id_value=='')+'--'+(u_id_value==''));
    if((o_id_value=='')&&(u_id_value=='')){
    	var url_it='menu-list.html';
		warning_dialog("输入为空");
    }
//  "^\d{n}$" n位数字验证
//"^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"  email验证
    else{
    	var check=true;
 		var reg1=/^\d{11}$/;   
        var reg2=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if(!reg2.test(u_id_value)){
        	alert_content="用户名必须是邮箱格式";
        	check=false;
        }
        if(!reg1.test(o_id_value)){
        	alert_content="订单号必须是11位数字";
        	check=false;
        }
        if(!check){
        	warning_dialog(alert_content);
        }
        else{
        	success_dialog("正在查询","");
        }
        
    }
}

function put_info(){
    var o_id_value=$('#menu-name').val();
    var u_id_value=$('#id-name').val();
    var s_id_value=$('#parent-id').val();
	var put_url = '';
	$.ajax({
		type : 'post',
		url : put_url,
		data : {
			'keyword1' :o_id_value,
			'keyword2' : u_id_value,
			'keyword3' : s_id_value
		},
		dataType : "json",
		success : function(data) {
			
		}
	});
}


function set_page(){
	
}
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