;(function(){

	$("#btn-login").click(function(){
		var formData = $("#form-data").rerialize();
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
	})

})(jQuery);