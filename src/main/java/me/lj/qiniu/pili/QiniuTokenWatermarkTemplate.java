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
 * 七牛鉴权Token生成
 */
public class QiniuTokenWatermarkTemplate {
    public static void main(String[] args) throws QiniuException {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        createWatermark(auth);

//        queryWatermark(auth);
    }

    private static void queryWatermark(Auth auth) throws QiniuException {
        String url1 = "http://pili.qiniuapi.com/v2/hubs/qiniu-pili-imc/watermarktemplate?limit=50";
        String method = "GET";
        String contentType = "application/json";

        String qiniuToken = "Qiniu " + auth.signRequestV2(url1, method, null, contentType);
        Configuration c = new Configuration(Zone.zone1());

        StringMap header = new StringMap();
        header.put("Host", "pili.qiniuapi.com");
        header.put("Authorization", qiniuToken);
        header.put("Content-Type", contentType);

        Client client = new Client(c);
        Response response = client.get(url1, header);
        System.out.println("Response: " + response.toString());
        System.out.println("Response: " + response.bodyString());
        System.out.println(qiniuToken);
    }

    private static void createWatermark(Auth auth) throws QiniuException {
        String url1 = "http://pili.qiniuapi.com/v2/hubs/qiniu-pili-imc/watermarktemplate";
        String method = "POST";
        String body = "{\n" +
                "  \"name\": \"test123\",\n" +
                "  \"comment\": \"it is comment\",\n" +
                "  \"left\": \"50%\",\n" +
                "  \"top\": \"50%\",\n" +
                "  \"width\": \"10%\",\n" +
                "  \"imageURL\": \"https://developer.qiniu.com/assets/logo-white-b90d685a6b146884636382426d11b7236f5f7ca1c5dfafdb6fa777a0f976fc1f.png\"\n" +
                "}";
        String contentType = "application/json";

        String qiniuToken = "Qiniu " + auth.signRequestV2(url1, method, body.getBytes(), contentType);
        System.out.println(qiniuToken);

        StringMap header = new StringMap();
        header.put("Host", "pili.qiniuapi.com");
        header.put("Authorization", qiniuToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        Response response = client.post(url1, body.getBytes(), header, contentType);
        System.out.println("Response: " + response.toString());
        System.out.println("Response: " + response.bodyString());
    }
}
