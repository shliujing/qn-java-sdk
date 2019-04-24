package me.lj.qiniu.bucket;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Recorder;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;
import me.lj.qiniu.config.Config;

import java.io.IOException;

public class UploadRecorder {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    String accessKey = Config.ACCESS_KEY;
    String secretKey = Config.SECRET_KEY;
    //要上传的空间
    String bucketName = Config.BUCKET_NAME;
    //上传到七牛后保存的文件名
    String key = "test/0424/1.png";
    //上传文件的路径
    String filePath = "/Users/jingliu/Desktop/upload-test-data/1.png";

    //密钥配置
    Auth auth = Auth.create(accessKey, secretKey);

    ///////////////////////指定上传的Zone的信息//////////////////
    //第一种方式: 指定具体的要上传的zone
    //注：该具体指定的方式和以下自动识别的方式选择其一即可
    //要上传的空间(bucket)的存储区域为华东时
    // Zone z = Zone.zone0();
    //要上传的空间(bucket)的存储区域为华北时
    // Zone z = Zone.zone1();
    //要上传的空间(bucket)的存储区域为华南时
    // Zone z = Zone.zone2();

    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.zone0();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    // 覆盖上传
    public String getUpToken() {
        return auth.uploadToken(bucketName);
    }

    public void upload() throws IOException {
        //设置断点记录文件保存在指定文件夹或的File对象
        String recordPath = "/Users/jingliu/Desktop/upload-test-data/1.txt";
        //实例化recorder对象
        Recorder recorder = new FileRecorder(recordPath);
        //实例化上传对象，并且传入一个recorder对象
        UploadManager uploadManager = new UploadManager(new Configuration(Zone.autoZone()),recorder);

        try {
            //调用put方法上传
            Response res = uploadManager.put("path/file", "key", getUpToken());
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

    public static void main(String args[]) throws IOException {
        new UploadRecorder().upload();
    }

}