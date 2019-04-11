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
 * hls https://developer.qiniu.com/dora/manual/1485/audio-and-video-slice
 */
public class HLS {

    public static void main(String args[]) throws IOException {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //要上传的空间
        String bucketname = "test-pub";
        String key = "11.mp4";
        //上传后的文件名
        String newKey = "hls/11.m3u8";

        //设置转码操作参数
        //      /noDomain/<NoDomain>	  取值 0 或 1，默认为 0，推荐取值为 1。表示切片索引中的切片列表，是否使用相对地址，设置为 0 则使用绝对地址，设置为 1 则使用相对地址。
        //     t/<Duration>		指定视频截取的长度，单位为秒，支持精确到毫秒，例如1.500s。用于视频截取，从一段视频中截取一段视频。
        String fops = "avthumb/m3u8/noDomain/1/vb/500k/t/1";
        //设置转码的队列
        String pipeline = "12349";

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

        System.out.println(id);
    }
}
