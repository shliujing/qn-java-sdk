package me.lj.qiniu.fusion;

import com.qiniu.cdn.CdnManager;
import com.qiniu.cdn.CdnResult;
import com.qiniu.common.QiniuException;
import com.qiniu.util.Auth;
import me.lj.qiniu.config.Config;

//https://developer.qiniu.com/kodo/sdk/java#fusion-refresh-urls
public class CdnRefreshUrlsDemo {
    public static void main(String args[]) {
        String accessKey = Config.ACCESS_KEY;
        String secretKey = Config.SECRET_KEY;
        Auth auth = Auth.create(accessKey, secretKey);
        CdnManager c = new CdnManager(auth);
        //待刷新的链接列表
        String[] urls = new String[]{
                "http://mdcdn.iamlj.com/mengda/mp4/%E8%92%99%E5%A4%A7%E5%90%8E%E5%8F%B0-%E8%80%81%E5%B8%88%E6%93%8D%E4%BD%9C.mp4",
                "http://mdcdn.iamlj.com/mengda/mp4/蒙大后台-老师操作.mp4",
                "http://mdcdn.iamlj.com/mengda/mp4/%E8%92%99%E5%A4%A7%E5%90%8E%E5%8F%B0-%E7%AE%A1%E7%90%86%E5%91%98%E6%93%8D%E4%BD%9C.mp4",
                "http://mdcdn.iamlj.com/mengda/mp4/蒙大后台-管理员操作.mp4"
        };
        try {
            //单次方法调用刷新的链接不可以超过100个
            CdnResult.RefreshResult result = c.refreshUrls(urls);
            System.out.println(result.code);
            //获取其他的回复内容
        } catch (QiniuException e) {
            System.err.println(e.response.toString());
        }
    }
}
