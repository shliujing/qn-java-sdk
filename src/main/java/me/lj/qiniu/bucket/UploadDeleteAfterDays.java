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


public class UploadDeleteAfterDays {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = Config.ACCESS_KEY;
    String SECRET_KEY = Config.SECRET_KEY;
    //要上传的空间
    String bucketname = "test-pub";
    //上传到七牛后保存的文件名
    String key = "png/0103/deleteAfterDays/qiniu-desktop.png";
    //上传文件的路径
    String FilePath = "/Users/jingliu/Desktop/qiniu-desktop.png";//小文件

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    public static void main(String args[]) throws IOException {
        new UploadDeleteAfterDays().upload();
    }

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        String token = auth.uploadToken(bucketname, key, 3600, new StringMap()
                .put("deleteAfterDays", 1)
                .put("callbackUrl", "https://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php")
                .put("callbackBody", "filename=$(fname)&key=$(key)&filesize=$(fsize)&deleteAfterDays=1")
        );
        System.out.println(token);
        return token;
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
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

}
