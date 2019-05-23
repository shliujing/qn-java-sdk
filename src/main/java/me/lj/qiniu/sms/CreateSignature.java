package me.lj.qiniu.sms;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.Json;
import com.qiniu.util.StringMap;
import me.lj.qiniu.config.Config;

/**
 * 创建签名
 * https://developer.qiniu.com/sms/api/5844/sms-api-create-signature
 */
public class CreateSignature {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = "DP4FyFXIHuThsAqZec6ykFkqjMy6EmSzC1Amd3hd";
        String SECRET_KEY = "BoG_hT6idwA85rFQ4vpmJGiHXzVOur9RtQm6RtaQ";

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String url = "https://sms.qiniuapi.com/v1/signature";
        String host = "sms.qiniuapi.com";
        String contentType = "application/json";
        String body = "{\"signature\":\"Test1\",\"source\":\"website\"}";

        String qiniuToken = "Qiniu "+auth.signRequestV2(url, "POST", body.getBytes(), contentType);
        System.out.println(qiniuToken);

        StringMap header = new StringMap();
        header.put("Host", host);
        header.put("Authorization", qiniuToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        Response response = client.post(url, body.getBytes(), header, contentType);

        System.out.println("Response: " + response.bodyString());
    }
}
