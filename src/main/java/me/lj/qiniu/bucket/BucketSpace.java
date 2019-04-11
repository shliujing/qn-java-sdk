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
public class BucketSpace {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String bucketName = Config.BUCKET_NAME;
        String region = "z0";
        String begin = "20180528000000";
        String end = "20180628230405";
//        String url = "http://api.qiniu.com/v6/space?bucket=" + bucketName + "&region=" + region + "&begin=" + begin + "&end=" + end + "&g=day";
        String url = "http://api.qiniu.com/v6/space?$bucket=" + bucketName + "&$region=" + region + "&begin=" + begin + "&end=" + end + "&g=day";
        String host = "api.qiniu.com";
        String contentType = "application/json";

        String qboxToken = "QBox " + auth.signRequest(url, null, contentType);
        System.out.println(qboxToken);

        StringMap header = new StringMap();
        header.put("Host", host);
        header.put("Authorization", qboxToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.autoZone());
        Client client = new Client(c);
        Response response = client.get(url, header);

        System.out.println("Response: " + response.bodyString());
    }
}
