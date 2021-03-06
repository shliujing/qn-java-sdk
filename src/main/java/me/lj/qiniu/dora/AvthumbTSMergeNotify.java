package me.lj.qiniu.dora;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.processing.OperationManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.UrlSafeBase64;
import me.lj.qiniu.config.Config;

import java.io.IOException;

/**
 * 转码+回调
 */
public class AvthumbTSMergeNotify {

    public static void main(String args[]) throws IOException {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //要上传的空间
        String bucketname = "test-pili-ever";
        //上传文件的路径  http://imc-hd.iamlj.com/test/test264-2.mp4

        String key = "m3u8/0520/test-ffmpeg.m3u8";
        //上传后的文件名
        String newKey = "ts/0520/test-ffmpeg.ts";
//        String newKey = "p4/0520/test-ffmpeg.mp4";

        //设置转码操作参数
        String fops = "avthumb/mpegts/vcodec/copy/acodec/copy";
//        String fops = "avthumb/mp4/vcodec/copy/acodec/copy";
        //设置转码的队列
        String pipeline = "12349";

        //可以对转码后的文件进行使用saveas参数自定义命 名，当然也可以不指定文件会默认命名并保存在当前空间。
        String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" + newKey);
        String pfops = fops + "|saveas/" + urlbase64;

        //回调 url
        String notifyUrl = "http://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php";

        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);

        OperationManager operationManager = new OperationManager(auth, c);

        String id = null;
        try {
            id = operationManager.pfop(bucketname, key, pfops, pipeline, notifyUrl, true);
        } catch (QiniuException e) {
            e.printStackTrace();
        }

        System.out.println(id);
    }

}
