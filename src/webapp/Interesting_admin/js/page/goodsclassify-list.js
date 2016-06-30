document.write("<script src='js/page/tools.js' type='text/javascript'></script>");
function append_tbody(){
	var content_html = "";
	for (var i = 0; i < 13; i++) {
		  
      
		var item = '<tr>'+							
			'<td width="40%" class="tableleft" id="good-classify-id'+i+'">'+		
			'分类'+i+
			'</td>'+
			'<td style="text-align: center;">'+
	        '<a data-toggle="collapse" data-parent="#accordion" '+ 
 			 ' href="#rename'+i+'">'+
	        '<button type="button" class="btn btn-success btn-xs">'+
	           '修改'+
	        '</button>'+
	        '</a>'+
	        '<div id="rename'+i+'" class="panel-collapse collapse ">'+
	          '<fieldset>'+
					'<br/>'+
				'<input  type="text" class="form-control" placeholder="分类名" id="reclassify'+i+'">'+	
			        '&nbsp;'+
			        '&nbsp;'+
			        '&nbsp;'+
	           '<button  class="btn btn-primary" type="button" id="btn-sure'+i+'" onclick="reset('+i+')">'+	
	           		'确定'+
	           '</button>'+
			  '</fieldset>'+
	        '</div>'+
			'</td>'+
		'</tr>';
		content_html+=item;
	}
//	console.log(content_html);
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
	
	var re_id_name = '#reclassify' + i;
	var re_id_value = $(re_id_name).val();
	
	console.log(re_id_value+ "--" );
//	location.href = "menu-edit.html"; //接收页面.
	//  setCookie(o_id_name,o_id_value);
}

function search() {
    var search_value = $('#search_value').val();
    console.log(search_value + "--" );
}

function add_classify(){
	var add_classify_value = $('#classify-add-value').val();
    console.log(add_classify_value + "--" );
}


function add_put_info(cl_id_value){
   
	var put_url = '';
	$.ajax({
		type : 'post',
		url : put_url,
		data : {
			'sort_name' :cl_id_value
		},
		dataType : "json",
		success : function(data) {
			
		}
	});
}

function edit_put_info(cl_id_value,sort_id){
   
	var put_url = '';
	$.ajax({
		type : 'post',
		url : put_url,
		data : {
			'sort_name' :cl_id_value,
			'sort_ID':sort_id
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