package me.lj.qiniu.bucket;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import me.lj.qiniu.config.Config;

import java.io.IOException;

/**
 * 上传策略 :https://developer.qiniu.com/kodo/manual/1206/put-policy
 */
public class UploadCallback {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = Config.ACCESS_KEY;
    String SECRET_KEY = Config.SECRET_KEY;
    //要上传的空间
    String bucketname = Config.BUCKET_NAME;
    //上传到七牛后保存的文件名
    String key = "qiniu/0129/qiniu-desktop-2.png";
    //上传文件的路径
    String FilePath = "/Users/jingliu/Desktop/upload-test-data/1.png";
    // 过期时间
    long expires = 3600;
    //允许类型
    String mimeLimit = "image/*";
    //回调 url，具体看 https://developer.qiniu.com/kodo/manual/1653/callback
    String callbackUrl = "http://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php";
    //回调内容，key 是上传后文件名，filename 是本地文件名。具体看 https://developer.qiniu.com/kodo/manual/1235/vars
//    String callbackBody = "{\"filename\":\"$(fname)\",\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"fsize\":$(fsize),\"bucket\":\"$(bucket)\",\"name\":\"$(x:name)\"}";
    String callbackBody = "{\"filename\":\"$(fname)\",\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"fsize\":$(fsize),\"bucket\":\"$(bucket)\"}";
//    String callbackBody = "filename=$(fname)&key=$(key)&filesize=$(fsize)";
    //回调内容类型
    String callbackBodyType = "application/json";

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    //设置callbackUrl以及callbackBody,七牛将文件名和文件大小回调给业务服务器
    public String getUpToken() {
        return auth.uploadToken(bucketname, key, expires, new StringMap()
                .put("mimeLimit", mimeLimit)
                .put("callbackBodyType", callbackBodyType)
                .put("callbackUrl", callbackUrl)
                .put("callbackBody", callbackBody));
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传
            String token = getUpToken();
            System.out.println(token);
            Response res = uploadManager.put(FilePath, key, token);
            //打印返回的信息
            System.out.println(res.getInfo());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    public static void main(String args[]) throws IOException {
        new UploadCallback().upload();
    }

}