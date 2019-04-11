package me.lj.qiniu.token;

import com.qiniu.util.Auth;
import me.lj.qiniu.config.Config;

/**
 * 七牛鉴权Token ：https://developer.qiniu.com/dora/kb/3702/QiniuToken
 */
public class QiniuToken {
    public static void main(String[] args) {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        String bucket = "test-pub";
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String url1 = "http://argus.atlab.ai/v1/face/detect";
        String method = "POST";
        String body = "{\"data\": {\"uri\":\"http://oayjpradp.bkt.clouddn.com/Audrey_Hepburn.jpg\"}}\n";
        String contentType = "application/json";
        System.out.println("Qiniu " + auth.signRequestV2(url1, method, body.getBytes(), contentType));
        System.out.println(auth.uploadToken(bucket));
    }
}
