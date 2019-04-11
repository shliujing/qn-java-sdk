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
 * 获取 Bucket 列表
 * https://developer.qiniu.com/kodo/api/3926/get-service
 */
public class KodoBuckets {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String url = "http://rs.qbox.me/buckets";
        String uri = "/buckets\n";
        String host = "rs.qbox.me";
        String contentType = "application/x-www-form-urlencoded";

        String qboxToken = "QBox "+auth.sign(uri);
        System.out.println(qboxToken);

        StringMap header = new StringMap();
        header.put("Host", host);
        header.put("Authorization", qboxToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        Response response = client.get(url, header);

        System.out.println("Response: " + response.bodyString());
    }
}
