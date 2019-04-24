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


public class Upload {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = Config.ACCESS_KEY;
    String SECRET_KEY = Config.SECRET_KEY;
    //要上传的空间
    String bucketname = "lj-huadong";
    //上传到七牛后保存的文件名
    String key = "test-idcard.jpg";
    //    String key = "download/wordpress-5.0.2-zh_CN.zip";
    //上传文件的路径
//    String FilePath = "/Users/jingliu/local/doc/企业微信/2018-11/对象存储竞品分析_V2.pptx";//小文件
    String FilePath = "/Users/jingliu/Desktop/upload-test-data/test-idcard.jpg";//小文件

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    //    Zone z = new Zone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    public static void main(String args[]) throws IOException {
        new Upload().upload();
    }

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        String tokenOri = auth.uploadToken(bucketname, key);
        String tokenOri1 = auth.uploadToken(bucketname);
        String token = auth.uploadToken(bucketname, key, -3600, new StringMap()
                .put("mimeLimit", "!application/zip")
                .put("callbackUrl", "https://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php")
                .put("callbackBody", "filename=$(fname)&key=$(key)&filesize=$(fsize)&deleteAfterDays=1")
        );
        System.out.println(tokenOri);
        System.out.println(token);
        return token;
        // 如果希望只能上传指定key的文件，并且不允许修改，那么可以将下面的 insertOnly 属性值设为 1。第三个参数是token的过期时间
        // return auth.uploadToken(bucketname,key,3600, new StringMap().put("insertOnly", 0));
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
