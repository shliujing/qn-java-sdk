package me.lj.qiniu.bucket;

import com.qiniu.util.Auth;
import me.lj.qiniu.config.Config;

/**
 * 验证上传回调
 */
public class VerifyUploadCallback {
    public static void main(String[] args) {

        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        String originAuthorization = "QBox 1oMhuZ5a7zjXSSMjM1KWQKGUpbCkEUw9yxYy1ENE:JkMnfnHRpbiP-YOzJx_z5USwQaw=";
        //回调 url，具体看 https://developer.qiniu.com/kodo/manual/1653/callback
        String callbackUrl = "http://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php";
        //回调内容，key 是上传后文件名，filename 是本地文件名。具体看 https://developer.qiniu.com/kodo/manual/1235/vars
        String callbackBody = "{\"filename\":\"test-desktop.png\",\"key\":\"qiniu/0129/qiniu-desktop-2.png\",\"hash\":\"FqigP1GCnlm34WGXpLODMrlMpeNo\",\"fsize\":1253913,\"bucket\":\"test-pub\"}";
        //回调内容类型
        String callbackBodyType = "application/json";

        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        boolean b = auth.isValidCallback(originAuthorization, callbackUrl, callbackBody.getBytes(), callbackBodyType);
        System.out.println(b);
    }
}