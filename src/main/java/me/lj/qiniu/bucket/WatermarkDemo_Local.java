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

/**
 * 视频加文字、图标水印，将本地传上去，+处理转存
 */
public class WatermarkDemo_Local {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = Config.ACCESS_KEY;
    String SECRET_KEY = Config.SECRET_KEY;
    //要上传的空间
    String bucketname = "test-pub";
    //上传文件的路径
    String FilePath = "/Users/jingliu/Desktop/upload/1111.mp4";
    //上传后的文件名
    String key = "shuiyin_11120.mp4";

    //设置转码操作参数
    String fops = "avthumb/mp4/wmImage/aHR0cDovL3Rlc3QtMi5xaW5pdWRuLmNvbS9sb2dvLnBuZw==/wmText/d2Vsb3ZlcWluaXU=/wmFontColor/cmVk/wmFontSize/60/wmGravityText/North";
    //设置转码的队列
    String pipeline = "12349";

    //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
    String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" + key);
    String pfops = fops + "|saveas/" + urlbase64;

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    public static void main(String args[]) throws IOException {
        new WatermarkDemo_Local().upload();
    }

    //上传策略中设置persistentOps字段和persistentPipeline字段
    public String getUpToken() {
        return auth.uploadToken(bucketname, null, 3600, new StringMap()
                .putNotEmpty("persistentOps", pfops)
                .putNotEmpty("persistentPipeline", pipeline), true);
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传 增加上传后的文件名
            String token = getUpToken();
            System.out.println(token);
            Response res = uploadManager.put(FilePath, key, token);
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
