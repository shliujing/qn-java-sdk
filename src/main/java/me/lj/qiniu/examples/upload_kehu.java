package me.lj.qiniu.examples;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import me.lj.qiniu.config.Config;

import java.io.IOException;


public class upload_kehu {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    //    String ACCESS_KEY = me.lj.qiniu.pandora.logdb.me.lj.qiniu.pandora.sender.Config.ACCESS_KEY;
    String ACCESS_KEY = Config.ACCESS_KEY;
    //    String SECRET_KEY = me.lj.qiniu.pandora.logdb.me.lj.qiniu.pandora.sender.Config.SECRET_KEY;
    String SECRET_KEY = Config.SECRET_KEY;
    //要上传的空间
    //    String bucketname = "test-pub";
    String bucketname = "video";
    //上传到七牛后保存的文件名
    String key = "qiniu/1.mp4";
    //    String key = null;
    //上传文件的路径
    String FilePath = "/Users/jingliu/Desktop/upload/1111.mp4";//小文件

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    //    Zone z = new Zone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    public static void main(String args[]) throws IOException {
        new upload_kehu().upload();
    }

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        String token = auth.uploadToken(bucketname, key);
        System.out.println(token);
        return token;
        //        return auth.uploadToken(bucketname,key,3600, new StringMap().put("insertOnly", 0));
    }

    //    public String getUpToken() {
    //        //<bucket>:<key>，表示只允许用户上传指定key的文件。在这种格式下文件默认允许“修改”，已存在同名资源则会被本次覆盖。
    //        //如果希望只能上传指定key的文件，并且不允许修改，那么可以将下面的 insertOnly 属性值设为 1。
    //        //第三个参数是token的过期时间
    //        return auth.uploadToken(bucketname, key, 3600, new StringMap().put("insertOnly", 1));
    //    }

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
