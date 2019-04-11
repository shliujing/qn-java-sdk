package me.lj.qiniu.bucket;

import com.qiniu.util.Auth;
import me.lj.qiniu.config.Config;

public class PrivateDownload {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = Config.ACCESS_KEY;
    String SECRET_KEY = Config.SECRET_KEY;
    //构造私有空间的需要生成的下载的链接
    //    String URL = "http://p7qrleioy.bkt.clouddn.com/1.png";
//    String URL = "http://test-private.iamlj.com/1.png?watermark/2/text/cWluaXU=";
//    String URL = "http://test-private.iamlj.com/hls/11.m3u8";
//    String URL = "http://test-private.iamlj.com/11.mp4?avinfo";
    String URL = "http://test-private.iamlj.com/11.mp4";
//    String URL = "http://qiniu-private.iamlj.com/11.mp4?qhash/md5";
//    String URL = "http://freedownload.originoo.cn/image/1/2e64c82f28fc4096b64a8bfd38381c4a.jpeg";
//    String URL = "http://test-private.iamlj.com/hls/11.m3u8?pm3u8/0";

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    public static void main(String args[]) {
        new PrivateDownload().download();
    }

    public void download() {
        //调用privateDownloadUrl方法生成下载链接,第二个参数可以设置Token的过期时间
        String downloadRUL = auth.privateDownloadUrl(URL, 43200);
        System.out.println(downloadRUL);
    }
}