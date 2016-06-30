;(function($){
	function check(){ 

		var pswlen = $("#psw_id").val().length;
		if(pswlen>20 || pswlen<6)	{
			alert("密码长度必须大于等于6且不能超过20");
			return false;
		}
		if($("#psw_id").val()==$("#psw_id_com").val())	
			{
				return true;
			}
		else {
			alert("两次密码输入不相同！");
			return false;
		}
	}
	$(".btn-submit").click(function(){
		//alert('OK')
		var formData = $("#form-data").serialize();
		console.log(formData);
		var url2='http://127.0.0.1';
		$.ajax({
			type:'post',
			url:url2,
			data:formData,
			beforeSend:check(),
			success:function(data){
				alert(data)
			}
		})
	});
})(jQuery);