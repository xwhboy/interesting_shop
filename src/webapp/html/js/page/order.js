function append_tbody(){
	var content_html = "";
	for (var i = 0; i < 1; i++) {
		var item =  '<div class="address1" id="">'+
		'				<div class="main-add">'+
		'					<span class="add1"></span>'+
		'					<span class="add1-name"></span>'+
		'					<div class="icon add-close">'+
		'					</div>'+
		'				</div>'+
		'				<div class="detailed-add">'+
		'					<span class="add2" ></span><span class="phone-num"></span></br>'+
		'				</div>'+
		'				<span class="add-modify" >修改</span>'+
		'			</div>'
	content_html+=item;
} 
}


/*function append_tbody(){
var content_html = "";
for (var i = 0; i < 11; i++) {
var item =  '<div class="pic-inf-attr">'+
'				<div class="pic01">'+
'					<img src="">'+
'				</div>'+
'				<div class="attr01">'+
'					<span class="informations"><a href="single.html"></a></span>'+
'					<span class="attributes"></span>'+
'				</div>'+
'			</div>'+
'			<div class="price-num-total">'+
'				<ul>'+
'					<li></li>'+
'					<li></li>'+
'					<li></li>'+
'				</ul>'+
'			</div>'+
'			<div class="shipping">'+
'			   	<span></span>'+
'			</div>'
} 
}
append_tbody();*/

$(document).ready(function(){
	$("#add-modify").css('display','');
})
$(".address1").click(function(){
	$(".address1").css('border', '1px solid #ddd');
	$('.address1').children('.detailed-add').children('.add-modify').css('display','none');
	$(this).css('border', '3px solid #ff9090');
	$(this).children('.detailed-add').children('.add-modify').css('display','block');
});

$(".add-modify").hover(function() {
	$(this).css('color','#ff9090');
}, function() {
	$(this).css('color','#aaa');
});
$(".display-add").hover(function() {
	$(this).css('color','#f74');
}, function() {
	$(this).css('color','#000');
});
/*修改地址*/
$(function() {
    $( "#dialog" ).dialog({
    	autoOpen: false,
       	modal: true,
      	buttons: {
          	"确认": function() {
            $( this ).dialog( "close" );
          	},
          	"取消": function() {
            $( this ).dialog( "close" );
          	}
    	}
    });
 
    $( ".add-modify" ).click(function() {
      $( "#dialog" ).dialog( { autoOpen: true } );
      $('.dialog').dialog({ draggable: false,resizable:false }); 
      $('.dialog').dialog({ height: 375,width:500 }); 
    });
});

$(function() {
    $( "#dialog-new" ).dialog({
      	autoOpen: false,
       	modal: true,
      	buttons: {
          	"确认": function() {
            $( this ).dialog( "close" );
            $(function(){
    			var name = $('#user-name').val();
    			var phone = $('#user-phone').val();
    			var city = $('#user-city').val();
    			var address = $('#user-add').val();
    			append_tbody();
    			$('.add1').text(city);
    			$('.add1-name').text(name);
    			$('.add2').text(address);
    			$('.phone-num').text(phone);
    			})
          	},
          	"取消": function() {
            $( this ).dialog( "close" );
          	}
    	}
    });
});
$( "#use-new-add" ).click(function() {
	$( "#dialog-new" ).dialog( { autoOpen: true } );
	$('.dialog-new').dialog({ draggable: false,resizable:false }); 
	$('.dialog-new').dialog({ height: 375,width:500 });
});

$( "#use-new-add" ).click(function() {
	$( ".confirm-delete" ).dialog( { autoOpen: true } );
});


$('#manage-add').toggle(function() {
	$('.add-close').css('display','block');
}, function() {
	$('.add-close').css('display','none');
});

$('.add-close').click(function(){
	$(this).parent().parent().css('display','none')
	
})

