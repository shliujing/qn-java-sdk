package me.lj.qiniu.token;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import me.lj.qiniu.config.Config;

/**
 * 获取token
 */
public class AuthDemo {
    public static void main(String[] args) {

        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        // 生成上传 token
        String bucket = "test-pub";
        String key = "test/file/190221.png";
        long expires = 3600l;
        StringMap policy = new StringMap();
        String callbackUrl = "http://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php";
        String callbackBody = "{\"filename\":\"$(fname)\",\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"fsize\":$(fsize),\"bucket\":\"$(bucket)\"}";
        policy.put("callbackUrl", callbackUrl);
        policy.put("callbackBody", callbackBody);

        System.out.println(auth.uploadToken(bucket, key, expires, policy));

        // 生成管理凭证
        String url = "/buckets\n";
        // String url = "/pfop/\n";
        System.out.println(auth.sign(url));

        String url1 = "http://argus.atlab.ai/v1/face/detect";
        String method = "POST";
        String body = "{\"data\": {\"uri\":\"http://oayjpradp.bkt.clouddn.com/Audrey_Hepburn.jpg\"}}\n";
        String contentType = "application/json";
        System.out.println("Qiniu " + auth.signRequestV2(url1, method, body.getBytes(), contentType));

    }
}
