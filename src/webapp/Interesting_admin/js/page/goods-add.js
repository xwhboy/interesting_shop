 var catigory;
 var host = '';
 var goods_name;
 var category_id;
 var price;
 var real_price;
 var goods_state;
 var art1;
 var art1_val;
 var art2;
 var art2_val;
 var description;
 var imgs;
 
 $(function () {
		$('#back').click(function(){
				window.location.href="goods-list.html";
		});
		});
		
//function get_imgs(){
//	var xhr = $("#fileInput").files[0];
//}

//var formData = new FormData();
//$("#fileInput").change(function(){
//	var xhr = $("#fileInput")[0].files[0];
//	var file_name = xhr['name'];
//	formData.append(file_name,xhr);
//});

$("#btn-up").click(function(){
	var formData = new FormData(document.getElementById("fileinfo"));
	
	var put_url = 'http://127.0.0.1';
	$.ajax({
		type : 'post',
		url : put_url,
		data :formData,
		processData: false,
	    contentType: false,
		success : function(data) {
		},
		beforeSend:function(xhr){
			console.log(xhr);

		},
		error:function(xhr){
			console.log(xhr);

		}
	});
})


function get_catigory(){
	var put_url = '';
	$.ajax({
		type : 'post',
		url : put_url,
		data : {
			
		},
		dataType : "json",
		success : function(data) {
			//todo
		}
	});
}

function append_catigory(){
	var content_html = '';
	for (var i = 0; i < 10; i++) {
		var item = '<option value="'+i+'">'+i+'zz'+'</option>';
		content_html+=item;
	}
	
	$("#ct_updown").empty();
	$("#ct_updown").append(content_html);
}

function warning_dialog(alert_content){
	BootstrapDialog.confirm({
            title: '警告',
            message: ''+alert_content,
            type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
            closable: true, 
            btnCancelLabel: '取消',
            btnOKLabel: '确定'
           
        });
}



append_catigory();


function post_data(){
	var post_url = 'http://127.0.0.1'
	$.ajax({
		type : 'post',
		url : post_url,
		data : {
			'pro_name' : goods_name,
			'sort_id' : category_id,
			'pro_price':price,
			'pro_realPrice':real_price,
			'pro_onsale':goods_state,
			'pro_attribute1':art1,
			'pro_attribute2':art2,
			'good_proAttribute1':art1_val,
			'good_proAttribute2':art2_val,
			'pro_image':imgs
		},
		dataType : "json",
		success : function(data) {
			
		},
		error:function(xhr){
			debugger;
		}
	});
}

function check_input(){
	goods_name = $("#goods_name").val();
	if (goods_name == '') {
		warning_dialog('商品名称不能为空');
		return;
	}
	
	category_id = $('#ct_updown option:selected').val();
	if (category_id == '') {
		warning_dialog('分类不能为空');
		return;
	}
	
	price = $("#price").val();
	if (price == '') {
		warning_dialog('原价不能为空');
		return;
	}else if (isNaN(price)) {
		warning_dialog('原价要为数字');
		return;
	}
	
	real_price = $("#real_price").val();
	if (real_price == '') {
		warning_dialog('真实价格不能为空');
		return;
	}else if (isNaN(real_price)) {
		warning_dialog('真实价格要为数字');
		return;
	}
	
	goods_state = $("#updown option:selected").val();
	if (goods_state == '') {
		warning_dialog('上下架状态不能为空');
		return;
	}
	
	art1 = $("#att1").val();
	art1_val = $("#att1_val").val();
	art2 = $("#att2").val();
	art2_val = $("#att2_val").val();
	
	if ((art1 == '' || art1_val == '') && (art2 == '' || art2_val == '')){
		warning_dialog('商品属性及值不能为空');
		return;
	}
	
	description = $("#instrument").val();
	if (description == ''){
		warning_dialog('商品描述不能为空');
		return;
	}
	
	post_data()
}


$("#btn-save").click(function(){
	check_input();
});


