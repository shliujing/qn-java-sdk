package me.lj.qiniu.sms;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.util.Auth;
import me.lj.qiniu.config.Config;
import me.lj.qiniu.utils.RPCCall;

/**
 * 模板
 * https://developer.qiniu.com/sms/api/5893/sms-api-create-template
 */
public class CreateAndListTemplate {
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
        url = "https://sms.qiniuapi.com/v1/template";
        host = "sms.qiniuapi.com";
        contentType = "application/json";
        method = "POST";
        //{ "name": "test-template", "template": "Test1", "type": "verification", "description": "测试", "signature_id": "1131017766455742464" }
        body = "{ \"name\": \"test-t\", \"template\": \"Test1\", \"type\": \"verification\", \"description\": \"测试\", \"signature_id\": \"1131017766455742464\" }";
        response = RPCCall.call(auth, url, host, contentType, method, body);
        // {"template_id":"1131454346853097472"}
        System.out.println("Create Res: " + response.bodyString());

        //list
        url = "https://sms.qiniuapi.com/v1/template";
        contentType = "application/x-www-form-urlencoded";
        method = "GET";
        response = RPCCall.call(auth, url, host, contentType, method, "");
        // {"items":[{"audit_status":"passed","created_at":1558536729,"description":"测试 验证码","id":"1131211147840589824","name":"验证码","reject_reason":"","signature_id":"1131017766455742464","signature_text":"新业小站","template":"您的验证码为: ${code}, 该验证码5分钟内有效, 请勿泄露给他人。","type":"verification","uid":1380569221,"updated_at":1558592462,"variable_count":0},{"audit_status":"reviewing","created_at":1558594712,"description":"测试","id":"1131454346853097472","name":"test-t","reject_reason":"","signature_id":"1131017766455742464","signature_text":"新业小站","template":"Test1","type":"verification","uid":1380569221,"updated_at":1558594712,"variable_count":0}],"page":1,"page_size":20,"total":2}
        System.out.println("List Res: " + response.bodyString());

    }
}
