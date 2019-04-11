package me.lj.qiniu.pili;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import me.lj.qiniu.config.Config;

public class PiliHistoryactivity {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String url = "http://pili.qiniuapi.com/v2/hubs/qiniu-ever/streams/test41/historyactivity?start=1533079282&end=1534202482";
        String host = "pili.qiniuapi.com";
        String contentType = "application/x-www-form-urlencoded";
        String qiniuToken = "Qiniu "+auth.signRequestV2(url, "GET", null, contentType);

        StringMap header = new StringMap();
        header.put("Host", host);
        header.put("Content-Type", contentType);
        header.put("Authorization", qiniuToken);
        header.put("Accept-Encoding", "gzip");

        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        Response response = client.get(url);

        System.out.println("Response: " + response.toString());
    }
}