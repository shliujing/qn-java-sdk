package me.lj.qiniu.pili;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import me.lj.qiniu.config.Config;


/**
 * 直播在线人数统计
 * https://developer.qiniu.com/pili/kb/1487/the-number-of-live-online-statistics-useful
 */
public class PiliStatPlay {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String hub = "qiniu-ever";
        String body = null;
        String url = "https://pili.qiniuapi.com/v2/hubs/"+hub+"/stat/play";
        String host = "pili.qiniuapi.com";
        String contentType = "application/json";

        String qiniuToken = "Qiniu "+auth.signRequestV2(url, "GET", null, contentType);

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
