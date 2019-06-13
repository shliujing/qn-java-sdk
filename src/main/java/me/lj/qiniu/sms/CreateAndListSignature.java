package me.lj.qiniu.sms;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.util.Auth;
import me.lj.qiniu.config.Config;
import me.lj.qiniu.utils.RPCCall;

/**
 * 创建签名
 * https://developer.qiniu.com/sms/api/5844/sms-api-create-signature
 */
public class CreateAndListSignature {
    public static void main(String[] args) throws QiniuException {
        String accessKey = Config.SMS_ACCESS_KEY;
        String secretKey = Config.SMS_SECRET_KEY;

        Auth auth = Auth.create(accessKey, secretKey);
        String url;
        String host;
        String contentType;
        String method;
        String body;
        Response response;

        //create
        url = "https://sms.qiniuapi.com/v1/signature";
        host = "sms.qiniuapi.com";
        contentType = "application/json";
        method = "POST";
        body = "{\"signature\":\"Test2\",\"source\":\"website\"}";
        response = RPCCall.call(auth, url, host, contentType, method, body);
        System.out.println("Create Res: " + response.bodyString());

        //list
        url = "https://sms.qiniuapi.com/v1/signature";
        contentType = "application/x-www-form-urlencoded";
        method = "GET";
        response = RPCCall.call(auth, url, host, contentType, method, "");
        System.out.println("List Res: " + response.bodyString());

    }
}
