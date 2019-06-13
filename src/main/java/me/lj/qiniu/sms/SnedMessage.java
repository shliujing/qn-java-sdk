package me.lj.qiniu.sms;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.util.Auth;
import me.lj.qiniu.config.Config;
import me.lj.qiniu.utils.RPCCall;

/**
 * 短信
 * https://developer.qiniu.com/sms/api/5897/sms-api-send-message
 */
public class SnedMessage {
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

        //send
        url = "https://sms.qiniuapi.com/v1/message";
        host = "sms.qiniuapi.com";
        contentType = "application/json";
        method = "POST";
        body = "{ \"signature_id\": \"1131017766455742464\", \"template_id\": \"1131211147840589824\", \"mobiles\": [ \"18801732070\" ], \"parameters\": { \"code\": 123456 } }";
        response = RPCCall.call(auth, url, host, contentType, method, body);

        System.out.println("send Res: " + response.bodyString());
    }
}
