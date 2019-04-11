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
 * DRM 加密 https://developer.qiniu.com/dora/manual/1248/audio-and-video-transcoding-avthumb
 */
public class Drm {

    public static void main(String args[]) throws IOException {


        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        // bucket 存储空间
        String bucketname = "test-pub";
        //加密前的空间文件
        String key = "qiniu/0128/test-2.mp4";
        //加密后的文件名
        String newKey = "drm/0128/test-2.mp4";
        //设置转码的队列
        String pipeline = "12349";

        String comKey = "ljCom";
        String fileKey = "ljFile";
        System.out.println(comKey.getBytes());
        //设置转码操作参数
        String drmCompanyKey = UrlSafeBase64.encodeToString(comKey);
        String drmFileKey = UrlSafeBase64.encodeToString(fileKey);
        String saveAs = UrlSafeBase64.encodeToString(bucketname + ":" + newKey);
        //可以对转码后的文件进行使用saveas参数自定义命 名，当然也可以不指定文件会默认命名并保存在当前空间。
        String pfops = "avthumb/mp4/vcodec/copy/acodec/copy/drmComKey/" + drmCompanyKey +"/drmFileKey/" +drmFileKey + "|saveas/" +saveAs;

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
