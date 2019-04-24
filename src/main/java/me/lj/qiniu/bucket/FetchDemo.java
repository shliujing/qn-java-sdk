package me.lj.qiniu.bucket;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.util.Auth;
import me.lj.qiniu.config.Config;

public class FetchDemo {

    public static void main(String args[]) {
        //设置需要操作的账号的AK和SK
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        Zone z = Zone.zone0();
        Configuration c = new Configuration(z);

        //实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(auth, c);

        //文件保存的空间名和文件名
        String bucket = "test-pub";
//        String key = "jpg/lengzhu.jpg";
//        String key = "png/0124/3.png";
//        String key = "jpg/lengzhu.jpg";
//        String key = "download/cooleditpro.rar";
        String key = "download/FuelforKeynote14.dmg";
//        String key = "jpg/fanbingbing4.jpg";
//        String key = "jpg/lufei2.jpg";
//        String key = "download/wordpress-5.0.2-zh_CN.zip";
//        String key = "download/TeamViewer.dmg";
//        String key = "qiniuClient/releases/download/0.0.9/qiniu.client-0.0.9-win.exe";
//        String key = "qiniuClient/releases/download/0.3.0/云存储管理客户端-0.3.0-win.exe";

        //要fetch的url
//        String url = "http://yezi.iamlj.com/lengzhu.jpg";
//        String url = "https://img.whatthehell.cn/FnVPkxYbmdSbjvZ5tmgIg4miACgs";
        String url = "http://160721.171.ctc.data.tv002.com/down/8a78188dbe70653160fcc148226c30d8-517798493/FuelforKeynote14.dmg?cts=dx-f-D116A236A177A50Faceea&ctp=116A236A177A50&ctt=1555620795&limit=1&spd=90000&ctk=c3d09aeac5e38fd911dbd71764f40d8e&chk=8a78188dbe70653160fcc148226c30d8-517798493&mtd=1";
//        String url = "http://sd.downxia.com/down/cooleditpromac.rar";
//        String url = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1160461963,3713854615&fm=26&gp=0.jpg";
//        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546574245009&di=18b77ca4cedc97972c197762bd6f1eb8&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201202%2F27%2F20120227224843_vZaA8.jpg";
//        String url = "https://cn.wordpress.org/wordpress-5.0.2-zh_CN.zip";
//        String url = "https://dl.tvcdn.de/download/TeamViewer.dmg";
//        String url = "https://github.com/willnewii/qiniuClient/releases/download/0.0.9/qiniu.client-0.0.9-win.exe";
//        String url = "http://blog-res.mayday5.me/file/%E4%BA%91%E5%AD%98%E5%82%A8%E7%AE%A1%E7%90%86%E5%AE%A2%E6%88%B7%E7%AB%AF-0.3.0-win.exe";

        try {
            //调用fetch方法抓取文件
            FetchRet ret = bucketManager.fetch(url, bucket, key);
            System.out.println(ret.hash);
            System.out.println(ret.key);
            System.out.println(ret.mimeType);
        } catch (QiniuException e) {
            //捕获异常信息
            Response r = e.response;
            System.out.println(r.toString());
        }
    }

}
