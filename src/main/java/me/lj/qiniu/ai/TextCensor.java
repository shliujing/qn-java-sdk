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
 * 文本审核
 */
public class TextCensor {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String url = "http://ai.qiniuapi.com/v1/text/censor";
        String host = "ai.qiniuapi.com";
        String text = "你好，ak47，sexy";
        String body = "{ \"data\": { \"text\": \"" + text + "\" }, \"params\": { \"scenes\": [ \"spam\" ] } }";
//        String body = "{ \"data\": { \"text\": \"你好，ak47，sexy\" }, \"params\": { \"scenes\": [ \"spam\" ] } }";
        String contentType = "application/json";

        String method = "POST";
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
        Response response = null;
        try {
            response = client.post(url, body.getBytes(), header, contentType);
        } catch (QiniuException e) {
            e.printStackTrace();
        }

        System.out.println("Response: " + response.bodyString());
    }
}
