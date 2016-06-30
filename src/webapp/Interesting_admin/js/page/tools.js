show_user_name();
/**
 * 显示管理员用户名
 */
function  show_user_name(){
	
	//	getCookie();
	$('#login-user').text("@xiaoming");
}

/**
 * dialog提示类
 * @param {Object} alert_content  
 * 显示字段
 */
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
//      BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_DEFAULT] = 'Information';
//      BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_INFO] = 'Information';
//      BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_PRIMARY] = 'Information';
//      BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_SUCCESS] = 'Success';
//      BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_WARNING] = 'Warning';
//      BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_DANGER] = 'Danger';
//      BootstrapDialog.DEFAULT_TEXTS['OK'] = 'OK';
//      BootstrapDialog.DEFAULT_TEXTS['CANCEL'] = 'Cancel';
//      BootstrapDialog.DEFAULT_TEXTS['CONFIRM'] = 'Confirmation';

/**
 * 成功跳转dialog
 * @param {Object} alert_content    显示内容
 * @param {Object} url              跳转url
 * 
 */
function success_dialog(alert_content,url){
        BootstrapDialog.show({
            title: '成功',
            message: ''+alert_content,
            buttons: [{
                label: '确定',
                action: function(dialogItself){
                    dialogItself.close();
                }
            }]
        });
}

/**
 * 获取cookie
 * @param {Object} name   关键字
 */
function getCookie(name)
{
var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
if(arr !=null) return unescape(arr[2]); return null;
}

/**
 * 设置cookie
 * @param {Object} name
 * @param {Object} value
 * 参数:name,字符串;value,字符串.
 */
function setCookie(name,value)
{
var Days = 1; //此 cookie 将被保存1 天
var exp　= new Date();
exp.setTime(exp.getTime() + Days*24*60*60*1000);
document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
//location.href = "menu-edit.html"; //接收页面.
}


/**
 * 
 */
function get_paramar() {
	var url = location.search; //获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		console.log(str);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
		}
	}
//	uid = theRequest["id"];

	return theRequest;
}