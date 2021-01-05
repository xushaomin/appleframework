// MD5
var hexcase=0;var b64pad="";var chrsz=8;function hex_md5(s){return binl2hex(core_md5(str2binl(s),s.length*chrsz))}function b64_md5(s){return binl2b64(core_md5(str2binl(s),s.length*chrsz))}function str_md5(s){return binl2str(core_md5(str2binl(s),s.length*chrsz))}function hex_hmac_md5(key,data){return binl2hex(core_hmac_md5(key,data))}function b64_hmac_md5(key,data){return binl2b64(core_hmac_md5(key,data))}function str_hmac_md5(key,data){return binl2str(core_hmac_md5(key,data))}function md5_vm_test(){return hex_md5("abc")=="900150983cd24fb0d6963f7d28e17f72"}function core_md5(x,len){x[len>>5]|=128<<((len)%32);x[(((len+64)>>>9)<<4)+14]=len;var a=1732584193;var b=-271733879;var c=-1732584194;var d=271733878;for(var i=0;i<x.length;i+=16){var olda=a;var oldb=b;var oldc=c;var oldd=d;a=md5_ff(a,b,c,d,x[i+0],7,-680876936);d=md5_ff(d,a,b,c,x[i+1],12,-389564586);c=md5_ff(c,d,a,b,x[i+2],17,606105819);b=md5_ff(b,c,d,a,x[i+3],22,-1044525330);a=md5_ff(a,b,c,d,x[i+4],7,-176418897);d=md5_ff(d,a,b,c,x[i+5],12,1200080426);c=md5_ff(c,d,a,b,x[i+6],17,-1473231341);b=md5_ff(b,c,d,a,x[i+7],22,-45705983);a=md5_ff(a,b,c,d,x[i+8],7,1770035416);d=md5_ff(d,a,b,c,x[i+9],12,-1958414417);c=md5_ff(c,d,a,b,x[i+10],17,-42063);b=md5_ff(b,c,d,a,x[i+11],22,-1990404162);a=md5_ff(a,b,c,d,x[i+12],7,1804603682);d=md5_ff(d,a,b,c,x[i+13],12,-40341101);c=md5_ff(c,d,a,b,x[i+14],17,-1502002290);b=md5_ff(b,c,d,a,x[i+15],22,1236535329);a=md5_gg(a,b,c,d,x[i+1],5,-165796510);d=md5_gg(d,a,b,c,x[i+6],9,-1069501632);c=md5_gg(c,d,a,b,x[i+11],14,643717713);b=md5_gg(b,c,d,a,x[i+0],20,-373897302);a=md5_gg(a,b,c,d,x[i+5],5,-701558691);d=md5_gg(d,a,b,c,x[i+10],9,38016083);c=md5_gg(c,d,a,b,x[i+15],14,-660478335);b=md5_gg(b,c,d,a,x[i+4],20,-405537848);a=md5_gg(a,b,c,d,x[i+9],5,568446438);d=md5_gg(d,a,b,c,x[i+14],9,-1019803690);c=md5_gg(c,d,a,b,x[i+3],14,-187363961);b=md5_gg(b,c,d,a,x[i+8],20,1163531501);a=md5_gg(a,b,c,d,x[i+13],5,-1444681467);d=md5_gg(d,a,b,c,x[i+2],9,-51403784);c=md5_gg(c,d,a,b,x[i+7],14,1735328473);b=md5_gg(b,c,d,a,x[i+12],20,-1926607734);a=md5_hh(a,b,c,d,x[i+5],4,-378558);d=md5_hh(d,a,b,c,x[i+8],11,-2022574463);c=md5_hh(c,d,a,b,x[i+11],16,1839030562);b=md5_hh(b,c,d,a,x[i+14],23,-35309556);a=md5_hh(a,b,c,d,x[i+1],4,-1530992060);d=md5_hh(d,a,b,c,x[i+4],11,1272893353);c=md5_hh(c,d,a,b,x[i+7],16,-155497632);b=md5_hh(b,c,d,a,x[i+10],23,-1094730640);a=md5_hh(a,b,c,d,x[i+13],4,681279174);d=md5_hh(d,a,b,c,x[i+0],11,-358537222);c=md5_hh(c,d,a,b,x[i+3],16,-722521979);b=md5_hh(b,c,d,a,x[i+6],23,76029189);a=md5_hh(a,b,c,d,x[i+9],4,-640364487);d=md5_hh(d,a,b,c,x[i+12],11,-421815835);c=md5_hh(c,d,a,b,x[i+15],16,530742520);b=md5_hh(b,c,d,a,x[i+2],23,-995338651);a=md5_ii(a,b,c,d,x[i+0],6,-198630844);d=md5_ii(d,a,b,c,x[i+7],10,1126891415);c=md5_ii(c,d,a,b,x[i+14],15,-1416354905);b=md5_ii(b,c,d,a,x[i+5],21,-57434055);a=md5_ii(a,b,c,d,x[i+12],6,1700485571);d=md5_ii(d,a,b,c,x[i+3],10,-1894986606);c=md5_ii(c,d,a,b,x[i+10],15,-1051523);b=md5_ii(b,c,d,a,x[i+1],21,-2054922799);a=md5_ii(a,b,c,d,x[i+8],6,1873313359);d=md5_ii(d,a,b,c,x[i+15],10,-30611744);c=md5_ii(c,d,a,b,x[i+6],15,-1560198380);b=md5_ii(b,c,d,a,x[i+13],21,1309151649);a=md5_ii(a,b,c,d,x[i+4],6,-145523070);d=md5_ii(d,a,b,c,x[i+11],10,-1120210379);c=md5_ii(c,d,a,b,x[i+2],15,718787259);b=md5_ii(b,c,d,a,x[i+9],21,-343485551);a=safe_add(a,olda);b=safe_add(b,oldb);c=safe_add(c,oldc);d=safe_add(d,oldd)}return Array(a,b,c,d)}function md5_cmn(q,a,b,x,s,t){return safe_add(bit_rol(safe_add(safe_add(a,q),safe_add(x,t)),s),b)}function md5_ff(a,b,c,d,x,s,t){return md5_cmn((b&c)|((~b)&d),a,b,x,s,t)}function md5_gg(a,b,c,d,x,s,t){return md5_cmn((b&d)|(c&(~d)),a,b,x,s,t)}function md5_hh(a,b,c,d,x,s,t){return md5_cmn(b^c^d,a,b,x,s,t)}function md5_ii(a,b,c,d,x,s,t){return md5_cmn(c^(b|(~d)),a,b,x,s,t)}function core_hmac_md5(key,data){var bkey=str2binl(key);if(bkey.length>16){bkey=core_md5(bkey,key.length*chrsz)}var ipad=Array(16),opad=Array(16);for(var i=0;i<16;i++){ipad[i]=bkey[i]^909522486;opad[i]=bkey[i]^1549556828}var hash=core_md5(ipad.concat(str2binl(data)),512+data.length*chrsz);return core_md5(opad.concat(hash),512+128)}function safe_add(x,y){var lsw=(x&65535)+(y&65535);var msw=(x>>16)+(y>>16)+(lsw>>16);return(msw<<16)|(lsw&65535)}function bit_rol(num,cnt){return(num<<cnt)|(num>>>(32-cnt))}function str2binl(str){var bin=Array();var mask=(1<<chrsz)-1;for(var i=0;i<str.length*chrsz;i+=chrsz){bin[i>>5]|=(str.charCodeAt(i/chrsz)&mask)<<(i%32)}return bin}function binl2str(bin){var str="";var mask=(1<<chrsz)-1;for(var i=0;i<bin.length*32;i+=chrsz){str+=String.fromCharCode((bin[i>>5]>>>(i%32))&mask)}return str}function binl2hex(binarray){var hex_tab=hexcase?"0123456789ABCDEF":"0123456789abcdef";var str="";for(var i=0;i<binarray.length*4;i++){str+=hex_tab.charAt((binarray[i>>2]>>((i%4)*8+4))&15)+hex_tab.charAt((binarray[i>>2]>>((i%4)*8))&15)}return str}function binl2b64(binarray){var tab="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";var str="";for(var i=0;i<binarray.length*4;i+=3){var triplet=(((binarray[i>>2]>>8*(i%4))&255)<<16)|(((binarray[i+1>>2]>>8*((i+1)%4))&255)<<8)|((binarray[i+2>>2]>>8*((i+2)%4))&255);
    for(var j=0;j<4;j++){if(i*8+j*6>binarray.length*32){str+=b64pad}else{str+=tab.charAt((triplet>>6*(3-j))&63)}}}return str};
/**
 //需要发布到服务器上运行，并且server端需要处理跨域
 //在IndexController.java上加@CrossOrigin(origins={"*"})

 sdk.config({
    url : 'http://localhost:8080/api'
    ,app_key : 'test'
    ,secret : '123456'
    ,jwt : 'xxx'
});

 sdk.post({
	name   : 'goods.get' // 接口名
// 	,version:'1.0'
// 	,access_token:''
	,data  : {'goods_name':'iphone'} // 请求参数
	,callback:function(resp) { // 成功回调
		console.log(resp)
	}
});

 sdk.post({
	name   : 'goods.get' // 接口名
	,data  : {'goods_name':'iphone'} // 请求参数
	,callback:function(resp) { // 成功回调
		console.log(resp)
	}
});
 */
;(function(){

    var config = {
        url : 'http://127.0.0.1:8080/api'
        ,app_key : 'test'
        ,secret : '123456'
        ,default_version : ''

        ,api_name : "name"
        ,version_name : "version"
        ,app_key_name : "app_key"
        ,data_name : "data"
        ,timestamp_name : "timestamp"
        ,sign_name : "sign"
        ,format_name : "format"
        ,access_token_name : "access_token"
        ,jwt : ''
        ,system_param_map : ''
    }

    var DEFAULT_FORMAT = 'json';
    var UPLOAD_FORM_DATA_NAME = 'body_data';
    var CONTENT_TYPE_JSON = 'application/json';

    var CONTENT_TYPE_KEY = 'Content-Type';
    var POST_TYPE = 'POST';
    var GET_TYPE = 'GET';

    function copy(source, target) {
        if (target && source && typeof source == 'object') {
            for (var p in source) {
                target[p] = source[p];
            }
        }
        return target;
    }

    function add0(m){return m<10?'0'+m:m }

    function formatDate(time)
    {
        var y = time.getFullYear();
        var m = time.getMonth()+1;
        var d = time.getDate();
        var h = time.getHours();
        var mm = time.getMinutes();
        var s = time.getSeconds();
        return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
    }

    /** 构建签名 */
    function buildSign(postData,secret) {
        if (typeof postData === 'string') {
            throw new Error('postData类型必须json对象');
        }
        var paramNames = [];
        for(var key in postData) {
            paramNames.push(key);
        }

        paramNames.sort();

        var paramNameValue = [];

        for(var i=0,len=paramNames.length;i<len;i++) {
            var paramName = paramNames[i];
            paramNameValue.push(paramName);
            paramNameValue.push(postData[paramName]);
        }

        var source = secret + paramNameValue.join('') + secret;
        // MD5算法参见http://pajhome.org.uk/crypt/md5/
        return hex_md5(source).toUpperCase();
    }

    var ajax = {
        /**
         * 提交请求
         * @param opts.url 请求url
         * @param opts.params 请求参数json
         * @param opts.headers 请求header，json
         * @param opts.form 表单dom对象
         * @param opts.callback 回调
         * @param opts.error 错误回调
         */
        request:function(opts) {
            var url = opts.url;
            var params = opts.params;
            var headers = opts.headers;
            var form = opts.form;
            var callback = opts.callback;
            var error = opts.error || function(e){alert('数据请求失败')};
            var method = opts.method;
            var paramStr = JSON.stringify(params);

            var xhr = this.createXhrObject();

            xhr.onreadystatechange = function() {
                var jsonData = '';
                if (xhr.readyState == 4){
                    var status = xhr.status;
                    if ((status >= 200 && status < 300) || status == 304){
                        jsonData = JSON.parse(xhr.responseText);
                        callback(jsonData, paramStr);
                    } else {
                        jsonData = JSON.parse('{"message":"后台请求错误(status:' + status + ')"}');
                        console.log(xhr.responseText)
                        error(jsonData, paramStr);
                    }
                }
            };
            if (method == GET_TYPE) {
                var queryString = [];
                for (var key in params) {
                    var p = key + '=' + encodeURIComponent(params[key]);
                    queryString.push(p);
                }
                url = url + '?' + queryString.join('&');
            }

            xhr.open(method, url, true);

            // 添加header
            if(headers) {
                for (var key in headers) {
                    xhr.setRequestHeader(key,headers[key]);
                }
            }
            var postData = null;
            if(method == POST_TYPE) {
                if(form) {
                    var formData = new FormData(form);
                    // 添加json
                    formData.append(UPLOAD_FORM_DATA_NAME, paramStr);
                    postData = formData;
                } else {
                    xhr.setRequestHeader(CONTENT_TYPE_KEY, CONTENT_TYPE_JSON);
                    postData = paramStr;
                }
            }
            // 发送请求
            xhr.send(postData);
        }
        /**
         * 创建XHR对象
         * @private
         */
        ,createXhrObject:function() {
            var methods = [
                function(){ return new XMLHttpRequest();}
                ,function(){ return new ActiveXObject('Msxml2.XMLHTTP');}
                ,function(){ return new ActiveXObject('Microsoft.XMLHTTP');}
            ];

            var xhr = null;
            for(var i=0,len=methods.length; i<len; i++) {
                try {
                    xhr = methods[i]();
                } catch (e) {
                    continue;
                }

                this.createXhrObject = methods[i];

                return xhr;
            }

            throw new Error("创建XHR对象失败");
        }
    }

    /**
     * 请求
     * @param opts.name 接口名
     * @param opts.version 版本号
     * @param opts.method 请求方式
     * @param opts.data 请求数据，json对象
     * @param opts.access_token
     * @param opts.form 表单dom
     * @param opts.callback 响应回调
     * @param opts.jwt jwt
     */
    function request(opts) {
        var name 		= opts.name,
            version 	= opts.version || config.default_version,
            data 		= opts.data || {},
            callback 	= opts.callback,
            accessToken = opts.access_token,
            url			= opts.url || config.url;

        var headers = {};
        var postData = {};

        postData[config.api_name] = name;
        postData[config.version_name] = version;
        postData[config.app_key_name] = config.app_key;
        postData[config.data_name] = encodeURIComponent(JSON.stringify(data));
        postData[config.timestamp_name] = formatDate(new Date());
        postData[config.format_name] = DEFAULT_FORMAT;

	config.system_param_map.forEach(function (item, key, mapObj) {
        	console.log("system param--->" + key + "=" + item.toString());
        	postData[key] = item.toString();
        });
        
        if(accessToken) {
            postData[config.access_token_name] = accessToken;
        }

        postData[config.sign_name] = buildSign(postData,config.secret);

        var jwt = opts.jwt || config.jwt; // 优先使用opts中的jwt
        if(jwt) {
            headers['Authorization'] = 'Bearer ' + jwt;
        }
		headers['easyopen-standard-mode'] = 'true';

        ajax.request({
            url:url
            ,method:opts.method
            ,params:postData
            ,headers:headers
            ,form:opts.form
            ,callback:callback
            ,error:opts.error
        });
    }

    var sdk = {
        config:function(cfg) {
            copy(cfg,config);
        }
        /**
         * post请求
         * @param opts.name 接口名
         * @param opts.version 版本号
         * @param opts.data 请求数据，json对象
         * @param opts.access_token
         * @param opts.form 表单dom
         * @param opts.callback 响应回调
         * @param opts.jwt jwt
         */
        ,post:function(opts) {
            opts.method = POST_TYPE;
            request(opts);
        }
        /**
         * get请求
         * @param opts.name 接口名
         * @param opts.version 版本号
         * @param opts.data 请求数据，json对象
         * @param opts.access_token
         * @param opts.callback 响应回调
         * @param opts.jwt jwt
         */
        ,get:function(opts) {
            if(opts.form) {
                throw new Error('get方式不支持上传功能');
            }
            opts.method = GET_TYPE;
            request(opts);
        }

    }

    window.sdk = sdk;

})();