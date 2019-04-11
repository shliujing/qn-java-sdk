package me.lj.qiniu.ai;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import me.lj.qiniu.config.Config;

/**
 * https://developer.qiniu.com/dora/manual/4258/video-pulp
 */
public class VideoPulpJobV1 {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String jobId = "5c46d57e984fe60008eb91c4";
        String url = "http://ai.qiniuapi.com/v1/jobs/video/" + jobId;
        String host = "ai.qiniuapi.com";

        String body = "";
        String contentType = "application/json";

        String method = "GET";
        String qiniuToken = "Qiniu " + auth.signRequestV2(url, method, body.getBytes(), contentType);
        System.out.println(url);
        System.out.println(body);
        System.out.println(qiniuToken);

        StringMap header = new StringMap();
        header.put("Host", host);
        header.put("Authorization", qiniuToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        Response response = client.get(url, header);

        System.out.println("Response: " + response.bodyString());
    }
}
