;(function($){


	function amoutInit(){
		var cnt=0;
		var amt=0;
		$("input[class='checkboxclass'][type='checkbox']:checked").each(function(){
			cnt++;
			amt+=$(this).val()*1;
		})
		$("#count").html(cnt);
		$("#amount").html(amt);
	}
	amoutInit();
	$("#checkboxall").click(function(){
		var f;
		if($("#checkboxall").attr("checked"))	f=true;
		else f=false;
		$(".checkboxclass").attr("checked",f) ;
		amoutInit();
	});

	$("#quanxuan").click(function(){
		var f;
		if($("#checkboxall").attr("checked"))	f=false;
		else f=true;
		$("#checkboxall").attr("checked",f);
		$("#checkboxall").click();
		$("#checkboxall").attr("checked",f);
	})
	$(".statement").click(function(){
		window.location = "./order.html";
	})

	$(".checkboxclass").change(function(){
		var cnt = $("#count").html();
		var amt = parseFloat($("#amount").html())*1;
		if($(this).attr("checked")){
			cnt++;
			amt+=$(this).attr("value")*1;
		}
		else{
			cnt--;
			amt-=$(this).attr("value")*1;
		}
		$("#count").html(cnt);
		$("#amount").html(amt);
		$("#checkboxall").attr('checked',false);
	});
	$(function() {
	    $( "#dialog1" ).dialog({
	     	autoOpen: false,
	        buttons: {
	          "确认": function() {
	            $( this ).dialog( "close" );
	          },
	          "取消": function() {
	            $( this ).dialog( "close" );
	          }
	        }
	      });
	});
	$( "#choice-pro-attr" ).click(function() {
	  var x = $(this).offset().top;
	  var y = $(this).offset().left;
	  $( "#dialog1" ).dialog( { 
	  	autoOpen: true,
	  	draggable: true,resizable:false,
	  	height: 250,
	  	width:350,  
	  });
	  
	});

	/*加减商品数量*/
		
	$('#plus').click(function(){
		var t = $("#nums")
		t.val(t.val()*1+1)
		$('#total-price').text((t.val())*300)
	});
	$('#minus').click(function(){
		var t = $("#nums")
		var cnt =t.val()*1-1;
		if(cnt>0)	t.val(cnt);
		$('#total-price').text((t.val())*300)
	})
})(jQuery);