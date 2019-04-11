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

public class UploadPfopsImage {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String accessKey = Config.ACCESS_KEY;
    String secretKey = Config.SECRET_KEY;
    String bucketName = Config.BUCKET_NAME;
    //上传到七牛后保存的文件名
    //    String key = "mov/qiniu.mov";
    String key = "what-is-python-1213.png";
    String newkey = "png/0104/fop/what-is-python-1213.png";
    //上传文件的路径
    String FilePath = "/Users/jingliu/Desktop/what-is-python.png";

    //设置转码操作参数
    String fops = "imageView2/1/w/200/h/200/format/jpg";
    //设置转码的队列
    String pipeline = "12349";
    String persistentNotifyUrl = "http://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php";
    String callbackUrl = "http://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php";
    String callbackBody = "filename=$(fname)&filesize=$(fsize)&key=${key}";

    //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
    String urlbase64 = UrlSafeBase64.encodeToString(bucketName + ':' + newkey);
    String pfops = fops + "|saveas/" + urlbase64;

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
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);


    public static void main(String args[]) throws IOException {
        new UploadPfopsImage().upload();
    }

    //上传策略中设置persistentOps字段和persistentPipeline字段
    public String getUpToken() {
        return auth.uploadToken(bucketName, key, 3600, new StringMap()
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

    /**
     * 上传转码
     */
    public static class UploadAndAvthumb {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //要上传的空间
        String bucketname = "test-pub";
        //上传文件的路径
        String FilePath = "/Users/jingliu/Desktop/upload/qiniu.mov";
        //上传后的文件名
        String key = "/mov/test6.mov";
        //设置转码操作参数
        String fops = "avthumb/mp4/ab/128k/ar/22050/acodec/libfaac/r/30/vb/300k/vcodec/libx264/s/320x240/autoscale/1/stripmeta/0";
        //设置转码的队列
        String pipeline = "12349";

        //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
        String urlbase64 = UrlSafeBase64.encodeToString("test-pub:qiniu-after5.mov");
        String pfops = fops + "|saveas/" + urlbase64;

        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

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
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);

        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);

        public static void main(String args[]) throws IOException {
            new UploadAndAvthumb().upload();
        }

        //上传策略中设置persistentOps字段和persistentPipeline字段
        public String getUpToken() {
            return auth.uploadToken(bucketname, key, 3600, new StringMap()
                    .putNotEmpty("persistentOps", pfops)
                    .putNotEmpty("persistentPipeline", pipeline), true);
        }

        public void upload() throws IOException {
            try {
                //调用put方法上传 增加上传后的文件名
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

    /**
     * 上传转码
     */
    public static class UploadAndAvthumbToAmr {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //要上传的空间
        String bucketname = "test-pub";
        //上传文件的路径
        String FilePath = "/Users/jingliu/Downloads/old/有用/PLShortVideoKit-1.11.0/Example/PLShortVideoKitDemo/musics/Road_to_Moscow.mp3";
        //上传后的文件名
        String key = "qiniu/mp3/Road_to_Moscow.mp3";
        String newKey = "qiniu/mp3/Road_to_Moscow.amr";
        //设置转码操作参数
    //    String fops = "avthumb/amr/ab/128k/ar/22050/acodec/libfaac/stripmeta/0";
        String fops = "avthumb/amr/ab/128k";
        //设置转码的队列
        String pipeline = "12349";

        //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
        String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" + newKey);
        String pfops = fops + "|saveas/" + urlbase64;

        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

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
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);

        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);

        public static void main(String args[]) throws IOException {
            new UploadAndAvthumbToAmr().upload();
        }

        //上传策略中设置persistentOps字段和persistentPipeline字段
        public String getUpToken() {
            return auth.uploadToken(bucketname, key, 3600, new StringMap()
                    .putNotEmpty("persistentOps", pfops)
                    .putNotEmpty("persistentPipeline", pipeline), true);
        }

        public void upload() throws IOException {
            try {
                //调用put方法上传 增加上传后的文件名
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

    /**
     * 上传转码
     */
    public static class UploadAndDeleteAfterDaysAndAvthumb {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //要上传的空间
        String bucketname = "test-pub";
        //上传文件的路径
        String FilePath = "/Users/jingliu/Desktop/upload/qiniu.mov";
        //上传后的文件名
        String key = "mov/0103/qiniu.mov";
        // 转码后的文件名
        String newKey = "mp4/0103/qiniu.mp4";
        //设置转码操作参数
        String fops = "avthumb/mp4/vcodec/libx264";
        //设置转码的队列
        String pipeline = "12349";

        int deleteAfterDays = 1;
        String callbackUrl = "https://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php";
        String callbackBody = "filename=$(fname)&key=$(key)&filesize=$(fsize)&deleteAfterDays=" + deleteAfterDays;
        String persistentNotifyUrl = callbackUrl;

        //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
        String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" + newKey);
        String pfops = fops + "|saveas/" + urlbase64;

        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

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
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);

        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);

        public static void main(String args[]) throws IOException {
            new UploadAndDeleteAfterDaysAndAvthumb().upload();
        }

        //上传策略中设置persistentOps字段和persistentPipeline字段
        public String getUpToken() {
            return auth.uploadToken(bucketname, key, 3600, new StringMap()
                    .put("deleteAfterDays", deleteAfterDays)
                    .put("callbackUrl", callbackUrl)
                    .put("callbackBody", callbackBody)
                    .putNotEmpty("persistentOps", pfops)
                    .putNotEmpty("persistentNotifyUrl", persistentNotifyUrl)
                    .putNotEmpty("persistentPipeline", pipeline), true);
        }

        public void upload() throws IOException {
            try {
                //调用put方法上传 增加上传后的文件名
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
}
