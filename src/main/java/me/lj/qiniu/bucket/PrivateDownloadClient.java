package me.lj.qiniu.bucket;

import com.qiniu.util.Auth;

public class PrivateDownloadClient {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "";
    String SECRET_KEY = "";
    //构造私有空间的需要生成的下载的链接
    //    String URL = "http://p7qrleioy.bkt.clouddn.com/1.png";
//    String URL = "http://test-private.iamlj.com/1.png?watermark/2/text/cWluaXU=";
//    String URL = "http://test-private.iamlj.com/hls/11.m3u8";
//    String URL = "https://qiniuvideo.51shizhong.com/FntCvtgKOmY0dQwN5XWHfWF57wdk.mp4?qhash/md5";
    String URL = "https://jobfile.edutouch.net.cn/20190116_1547620133952.jpg";
//    String URL = "https://qiniuvideo.51shizhong.com/2018/12/19/lrdIvkrZ7v8_b8SkLSOGjO2aj4A4?avinfo";
//    String URL = "http://test-private.iamlj.com/hls/11.m3u8?pm3u8/0";

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    public static void main(String args[]) {
        new PrivateDownloadClient().download();
    }

    public void download() {
        //调用privateDownloadUrl方法生成下载链接,第二个参数可以设置Token的过期时间
        String downloadRUL = auth.privateDownloadUrl(URL, 43200);
        System.out.println(downloadRUL);
    }
}