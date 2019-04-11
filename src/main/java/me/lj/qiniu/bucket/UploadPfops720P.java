package me.lj.qiniu.bucket;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import me.lj.qiniu.config.Config;

import java.io.IOException;

public class UploadPfops720P {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = Config.ACCESS_KEY;
    String SECRET_KEY = Config.SECRET_KEY;
    String bucketname = Config.BUCKET_NAME;
    //上传到七牛后保存的文件名
    String key = "mp4/1.mp4";
    String newKey = "mp4/720p/科目2-1号道考试车模拟X.mp4";

    //上传文件的路径
    String FilePath = "D:\\BaiduNetdiskDownload\\科目2-1号道考试车模拟.mp4";

    //设置转码操作参数
    String fops = "avthumb/mp4/vcodec/libx264/s/1280x720";
    //设置转码的队列
    String pipeline = "12349";
    String persistentNotifyUrl = "http://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php";
    String callbackUrl = "http://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php";
    String callbackHost = "practice.dandantuan.com";
    //    String callbackBody = "key=$(fname)&fsize=$(fsize)";
    String callbackBody = "filename=$(fname)&filesize=$(fsize)&key=$(key)";
    String callbackBodyType = "application/json";

    //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
    String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" + newKey);
    String pfops = fops + "|saveas/" + urlbase64;

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    ///////////////////////指定上传的Zone的信息//////////////////
    //自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    public static void main(String args[]) throws IOException {
        new UploadPfops720P().upload();
    }

    //上传策略中设置persistentOps字段和persistentPipeline字段
    public String getUpToken() {
        return auth.uploadToken(bucketname, key, 3600, new StringMap()
                .put("deleteAfterDays", 1)
                .put("callbackUrl", callbackUrl)
                .put("callbackBody", callbackBody)
                .put("persistentOps", pfops)
                .put("persistentNotifyUrl", persistentNotifyUrl)
                .put("persistentPipeline", pipeline), true);
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
