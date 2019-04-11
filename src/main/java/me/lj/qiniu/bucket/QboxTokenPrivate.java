package me.lj.qiniu.bucket;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import me.lj.qiniu.config.Config;


/**
 * 设置 Bucket 访问权限 https://developer.qiniu.com/kodo/api/3946/put-bucket-acl
 */
public class QboxTokenPrivate {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String bucketName = "qiniu-private";
        String url = "http://uc.qbox.me/private";
        String host = "uc.qbox.me";
        String body = "bucket=" + bucketName + "&private=" + 0;//0：公有 1：私有
        String contentType = "application/x-www-form-urlencoded";

        String qboxToken = "QBox " + auth.signRequest(url, body.getBytes(), contentType);
        String qboxToken1 = "QBox " + auth.sign("/private\n"+body);
        System.out.println(qboxToken);
        System.out.println(qboxToken1);

        StringMap header = new StringMap();
        header.put("Host", host);
        header.put("Authorization", qboxToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        Response response = client.post(url, body.getBytes(), header, contentType);

        System.out.println("Response: " + response.toString());
    }
}
