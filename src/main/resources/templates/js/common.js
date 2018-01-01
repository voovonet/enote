/**全局配置**/
//var ms_shop='http://localhost:7009';
var ms_shop='http://192.168.1.111:7009';
var tokenErr=[101,102,103,104,105,106];//token错误码，见parent Exception
/****/

function setCookie(name,value) 
{ 
    var Days = 30; 
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*24*60*60*1000); 
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString(); 
}

function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)"); 
　　 return (arr=document.cookie.match(reg))?unescape(arr[2]):null;
}

function delCookie(name) 
{ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getCookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+exp.toGMTString(); 
}

var defaultUint=['件','箱','个','瓶','打','千克'];

//检查状态码
function checkRes(res){
	if(res==null){
		alert('网络异常！');return;
	}else if(typeof res=="string"){
		res=JSON.parse(res);
	}
	if(res.code!='200'){
		var err=true;
		for(x in tokenErr){
			if(res.code==tokenErr[x]){
				layer.msg(res.message,{time:1000});
				err=false;
				setTimeout(function (){
					location.href="/login";
				}, 1100);
			}
		}
		if(err==true){
			console.log('未知错误！',JSON.stringify(res));
		}
	}
}

//表单校验
function formVerify(myForm){
	var form = layui.form;
	var $myForom=myForm;
	form.verify({
		  field_text: function(value,$myForom){ //value：表单的值、item：表单的DOM对象
			  if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
			      return '该属性不能有特殊字符';
			    }
			    if(/(^\_)|(\__)|(\_+$)/.test(value)){
			      return '该属性首尾不能出现下划线\'_\'';
			    }
			    if(/^\d+$/.test(value)){
			      return '该属性不能全为数字';
			    }
		  },
		  price:function(value,$myForom){
			  if(!new RegExp(/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/).test(value)){
			      return '请输入正确的金额！(支持两位小数)';
			    }
		  },
		  field_number:function(value,$myForom){
			  //正整数
			  if(!new RegExp(/^[0-9]*[0-9][0-9]*$/).test(value)){
			      return '请输入正确的数字';
			    }
		  }
	});
}

//屏幕宽高
var svh={width: window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth,height: window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight};
function getViewportSize () {
    return {
        width: window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth,
        height: window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight
    };
}

function xlog(o){
	console.log(o);
}

//获取对象克隆，并删除val为null的键值对
function getObj(o){
	var obj = $.extend(true, {}, o);//克隆对象
	for(var key in o){
		if(o[key]==null){
			delete o[key];
		}
	}
	return obj;
}

/*base64 工具类*/
/*  Base.encode('文字');  //--> "asc"
 *  Base.decode(asc); //--> '文字'
 */
$(function(root, factory) {
	  if (typeof define === "function" && define.amd) {
    define([], factory);
  } else if (typeof module === "object" && module.exports) {
    module.exports = factory();
  } else {
    root.Base = factory();
  }
}(this, function() {
   'use strict';
   
    function Base64() {
        // private property
        this._keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    }
    //public method for encoding
    Base64.prototype.encode = function (input) {
        var output = "", chr1, chr2, chr3, enc1, enc2, enc3, enc4, i = 0;
        input = this._utf8_encode(input);
        while (i < input.length) {
            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);
            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;
            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }
            output = output +
            this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) +
            this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);
        }
        return output;
    }

    // public method for decoding
    Base64.prototype.decode = function (input) {
        var output = "", chr1, chr2, chr3, enc1, enc2, enc3, enc4, i = 0;
        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
        while (i < input.length) {
            enc1 = this._keyStr.indexOf(input.charAt(i++));
            enc2 = this._keyStr.indexOf(input.charAt(i++));
            enc3 = this._keyStr.indexOf(input.charAt(i++));
            enc4 = this._keyStr.indexOf(input.charAt(i++));
            chr1 = (enc1 << 2) | (enc2 >> 4);
            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
            chr3 = ((enc3 & 3) << 6) | enc4;
            output = output + String.fromCharCode(chr1);
            if (enc3 != 64) {
                output = output + String.fromCharCode(chr2);
            }
            if (enc4 != 64) {
                output = output + String.fromCharCode(chr3);
            }
        }
        output = this._utf8_decode(output);
        return output;
    }

    // private method for UTF-8 encoding
    Base64.prototype._utf8_encode = function (string) {
        string = string.replace(/\r\n/g,"\n");
        var utftext = "";
        for (var n = 0; n < string.length; n++) {
            var c = string.charCodeAt(n);
            if (c < 128) {
                utftext += String.fromCharCode(c);
            } else if((c > 127) && (c < 2048)) {
                utftext += String.fromCharCode((c >> 6) | 192);
                utftext += String.fromCharCode((c & 63) | 128);
            } else {
                utftext += String.fromCharCode((c >> 12) | 224);
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                utftext += String.fromCharCode((c & 63) | 128);
            }
    
        }
        return utftext;
    }

    // private method for UTF-8 decoding
    Base64.prototype._utf8_decode = function (utftext) {
        var string = "", i = 0, c = 0, c1 = 0, c2 = 0, c3 = 0;
        while ( i < utftext.length ) {
            c = utftext.charCodeAt(i);
            if (c < 128) {
                string += String.fromCharCode(c);
                i++;
            } else if((c > 191) && (c < 224)) {
                c2 = utftext.charCodeAt(i+1);
                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
                i += 2;
            } else {
                c2 = utftext.charCodeAt(i+1);
                c3 = utftext.charCodeAt(i+2);
                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
                i += 3;
            }
        }
        return string;
    }
    
    var Base = new Base64();
    
    return Base;
}));