package me.lj.qiniu.bucket;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.processing.OperationManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.UrlSafeBase64;
import me.lj.qiniu.config.Config;

import java.io.IOException;

/**
 * 视频加文字、图标水印，将操作bucket
 */
public class WatermarkDemo_Bucket {

    public static void main(String args[]) throws IOException {
//        new AvthumbMP4H265().upload();
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //要上传的空间
        String bucketname = "test-pub";
        //上传文件的路径
        String key = "11.mp4";
        //上传后的文件名
        String newKey = "qiniu/mp4/shuiyin_19.mp4";

        //设置转码操作参数
        String fops = "avthumb/mp4/wmImage/aHR0cDovL3Rlc3QtMi5xaW5pdWRuLmNvbS9sb2dvLnBuZw==/wmText/d2Vsb3ZlcWluaXU=/wmFontColor/cmVk/wmFontSize/60/wmGravityText/North";
//        String saveAs = UrlSafeBase64.encodeToString(bucketname + ":" + newKey);
//        fops = fops + "|saveas/"+saveAs;
        //设置转码的队列
        String pipeline = "1234911";

        //可以对转码后的文件进行使用saveas参数自定义命 名，当然也可以不指定文件会默认命名并保存在当前空间。
        String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" + newKey);
        String pfops = fops + "|saveas/" + urlbase64;

        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);

        OperationManager operationManager = new OperationManager(auth, c);

        String id = null;
        try {
            id = operationManager.pfop(bucketname, key, pfops, pipeline, true);
        } catch (QiniuException e) {
            e.printStackTrace();
        }

//        String id = operationManager.pfop(bucketname, key, pfops, (new StringMap()).putNotEmpty("persistentPipeline", pipeline));
        System.out.println(id);
    }

}
