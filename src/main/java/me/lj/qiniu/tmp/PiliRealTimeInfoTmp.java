package me.lj.qiniu.tmp;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import me.lj.qiniu.config.Config;


/**
 * 直播实时信息 : https://developer.qiniu.com/pili/api/2776/live-broadcast-of-real-time-information
 */
public class PiliRealTimeInfoTmp {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String hub = "miaobolive";
        String stream = "9fd48e0c5f85f73cafc91ea501e30d67";
        String body = "";
        String url = "http://pili.qiniuapi.com/v2/hubs/"+hub+"/streams/"+UrlSafeBase64.encodeToString(stream)+"/live";
        String host = "pili.qiniuapi.com";
        String contentType = "application/x-www-form-urlencoded";

        String qiniuToken = "Qiniu "+auth.signRequestV2(url, "GET", body.getBytes(), contentType);

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
