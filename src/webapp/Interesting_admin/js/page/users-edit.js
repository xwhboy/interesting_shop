pre_input();
$(function () {
			$('#backid').click(function(){
				window.location.href="users-list.html";
			 });
			 
			 $('#saveid').click(function(){
				if (check_input() == true){
//					put_info();
//					window.location.href="users-list.html";
				}
			 });
	
	    });
	    
function pre_input(){
	var pre_obj=get_paramar();
	var user_id=pre_obj["usid"];
	$('#username').attr("value",user_id);
}

function check_input() {
	var result = true;
	var alert_string = '';
	var username = $('#username').val();
	var password = $('#password').val();
	var password_confirm = $('#password_confirm').val();
	if (username == '') {
		alert_string +=' 账号';
		result = false;
	}
	if (password == '') {
		alert_string +=' 密码';
		result = false;
	}
	alert_string += '不能为空';
	
	if (result == false){
		warning_dialog(alert_string);
	}
	
	if (result == true && password_confirm != password) {
			alert_string = '密码输入不一致';
			warning_dialog(alert_string);
			result = false;
	}
	return result;
}

function put_info(){
	var username = $('#username').val();
	var password = $('#password').val();
	var phone = $('#phone').val();
	var put_url = '';
	$.ajax({
		type : 'post',
		url : put_url,
		data : {
			'user_account' : username,
			'user_pw' : password,
			'user_tel':phone
		},
		dataType : "json",
		success : function(data) {
			
		}
	});
}

