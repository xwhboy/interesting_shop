document.write("<script src='js/page/tools.js' type='text/javascript'></script>");
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
	    

function check_input() {
	var result = true;
	var alert_string = '';
	var username = $('#username').val();
	var password = $('#password').val();
	var password_confirm = $('#password_confirm').val();
	var phone = $('#phone').val();
	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
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
	
	if (!myreg.test(phone)) {
		warning_dialog('手机格式错误');
		result = false;
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

