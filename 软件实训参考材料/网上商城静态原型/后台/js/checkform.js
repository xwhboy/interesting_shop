// JavaScript Document
function checkitemform(){
if(document.form1.name.value===""){
window.alert("��������Ʒ���ƣ�");
document.form1.name.focus();
return false;
}if(document.form1.price.value==""){
window.alert("��������Ʒ�۸�");
document.form1.price.focus();
return false;
}if(document.form1.storage.value==""){
window.alert("��������Ʒ�������");
document.form1.storage.focus();
return false;
}if(document.form1.discount.value==""){
window.alert("��������Ʒ�ۿۣ�");
document.form1.discount.focus();
return false;
}else{
window.location.href="item_list.html";
} 
}

function checkregform(){
if(document.form1.email.value===""){
window.alert("��������Ч�������ַ��");
document.form1.name.focus();
return false;
}if(document.form1.password.value==""){
window.alert("���������룡");
document.form1.password.focus();
return false;
}if(document.form1.passwordConfirm.value==""){
window.alert("���ٴ��������룡");
document.form1.passwordConfirm.focus();
return false;
}else{
window.location.href="home.html";
} 
}

function checkcategoryform(){
if(document.form1.name.value===""){
window.alert("������Ŀ¼���ƣ�");
document.form1.name.focus();
return false;
}else{
window.location.href="category_list.html";
} 

}

function checkstorageform(){
if(document.form1.storage.value===""){
window.alert("������������");
document.form1.storage.focus();
return false;
}else{
window.location.href="storage_list.html";
} 

}

function checkpriceform(){
if(document.form1.price.value===""){
window.alert("������۸�");
document.form1.price.focus();
return false;
}if(document.form1.discount.value===""){
window.alert("������������");
document.form1.discount.focus();
return false;
}else{
window.location.href="price_list.html";
} 

}

function checkloginform(){
if(document.form1.name.value===""){
window.alert("�������û�����");
document.form1.name.focus();
return false;
}if(document.form1.password.value===""){
window.alert("���������룡");
document.form1.password.focus();
return false;
}else{
window.location.href="category_list.html";
} 

}

function checkusersetform(){

if(document.form1.credit.value===""){
window.alert("������������ޣ�");
document.form1.credit.focus();
return false;
}if(document.form1.ratio.value===""){
window.alert("��������ֱ�����");
document.form1.ratio.focus();
return false;
}else{
window.location.href="user_admin.html";
} 
}

function checkordercheck(){
	window.alert("��˳ɹ���");
	window.location.href="order_list_refresh.html";		
}

function checkorderselect(){
var k=0;
	for(i=0;i<document.form1.ordersn.length;i++){
		if(document.form1.ordersn[i].checked)
		   k=1;
		}
if(k===0){
window.alert("��ѡ��Ҫ��˵Ķ�����");
return false;
}else{
window.location.href="order_check.html";
} 

}

function checkitemrefresh(){
if(document.form1.name.value===""){
window.alert("��������Ʒ���ƣ�");
document.form1.name.focus();
return false;
}if(document.form1.price.value==""){
window.alert("��������Ʒ�۸�");
document.form1.price.focus();
return false;
}if(document.form1.storage.value==""){
window.alert("��������Ʒ�������");
document.form1.storage.focus();
return false;
}if(document.form1.discount.value==""){
window.alert("��������Ʒ�ۿۣ�");
document.form1.discount.focus();
return false;
}else{
window.location.href="item_list_refresh.html";
} 
	
}