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
 * https://developer.qiniu.com/dora/manual/1246/audio-and-video-stitching-avconcat
 */
public class Avconcat12 {

    public static void main(String args[]) throws IOException {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //要上传的空间
        String bucketname = "test-pub";
        String key1 = "test/avconcat1.mp4";// 视频片段1
        String key2 = "http://test-pub.iamlj.com/test/avconcat2.mp4";// 视频片段2
        String urlbase64Key2 = UrlSafeBase64.encodeToString(key2);
        String newKey = "test/avconcat12.mp4";// 合成视频片段12

        //设置转码操作参数
        String fops = "avconcat/2/format/mp4/index/1/" + urlbase64Key2;
        //设置转码的队列
        String pipeline = "12349";

        //可以对转码后的文件进行使用saveas参数自定义命 名，当然也可以不指定文件会默认命名并保存在当前空间。
        String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" + newKey);
        System.out.println(fops);
        String pfops = fops + "|saveas/" + urlbase64;

        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);

        OperationManager operationManager = new OperationManager(auth, c);

        String id = null;
        try {
            id = operationManager.pfop(bucketname, key1, pfops, pipeline, true);
        } catch (QiniuException e) {
            e.printStackTrace();
        }

        System.out.println(id);
    }

}
