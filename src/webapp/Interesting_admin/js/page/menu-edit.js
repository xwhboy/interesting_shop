document.write("<script src='js/page/tools.js' type='text/javascript'></script>");

$(function() {
	pre_input();
	$('#backid').click(function() {
		window.location.href = "menu-list.html";
	});
	$('#saveid').click(function() {
		if (check_input() == true) {
			put_info();
			window.location.href = "menu-list.html";
		}

	});

});

function pre_input() {
	
//	console.log("is:---"+o_id);
//	$('#order-id').attr("value", o_id);
    var pre_obj=get_paramar();
// pre_obj["stid"]
    $('#parentid').attr("value",pre_obj["stid"]);
    $('#order-id').text(pre_obj["muid"]);
    $('#user-id').text(pre_obj["usid"]);
	$('#name').attr("placeholder", pre_obj["usid"]);
	$('#remark').attr("placeholder", "请输入备注信息");
}

function check_input() {
	var name = $('#name').val();
	var parentid = $('#parentid').val();
	var remark = $('#remark').val();
	var result = true;
	var alert_string = '';
	//	console.log(name+"--"+parentid+"--"+remark);
	if (name == '') {
		result = false;
		alert_string = "收货人姓名不能为空";
	}
	if (!result) {
		warning_dialog(alert_string);
		 
	}
	return result;
}


function put_info() {
	var o_id = $('#order-id').val();
	var name = $('#name').val();
	var parentid = $('#parentid').val();
	var remark = $('#remark').val();
	var put_url = '';
	$.ajax({
		type: 'post',
		url: put_url,
		data: {
			'order_ID': o_id,
			'order_checkName': name,
			'order_tag': parentid,
			'order_desc': remark
		},
		dataType: "json",
		success: function(data) {

		}
	});
}