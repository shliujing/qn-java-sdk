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
 * https://developer.qiniu.com/dora/manual/3701/ai-pulp
 */
public class ImageQuip {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

//        String url = "https://ai.qiniuapi.com/v1/ocr/sari/idcard";
//        String host = "ai.qiniuapi.com";
        String url = "http://ai.qiniuapi.com/v1/pulp";
        String host = "ai.qiniuapi.com";
        String body = "{\n" +
                "    \"data\": {\n" +
                "        \"uri\": \"http://7xlv47.com1.z0.glb.clouddn.com/pulpsexy.jpg\"\n" +
                "    }\n" +
                "}";
        String contentType = "application/json";

        String method = "POST";
        String qiniuToken = "Qiniu " + auth.signRequestV2(url,method, body.getBytes(), contentType);
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
