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
 * 批量图片审核
 */
public class ImageCensorMult {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);


        String url = "http://ai.qiniuapi.com/v3/image/censor/mult";
        String host = "ai.qiniuapi.com";

//        String body = "{ \"data\": { \"uris\": [ \"http://img.yzcdn.cn/upload_files/2018/12/11/7ed91a35cb6314ee75a55a79eb63520b.jpg\" ] }, \"params\": { \"scenes\": [ \"pulp\", \"terror\", \"politician\" ] } }";
        String body = "{\n" +
                "  \"data\": {\n" +
                "    \"uris\": [\n" +
                "      \"http://img.yzcdn.cn/upload_files/2018/12/11/7ed91a35cb6314ee75a55a79eb63520b.jpg\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"params\": {\n" +
                "    \"scenes\": [\n" +
                "      \"pulp\",\n" +
                "      \"terror\",\n" +
                "      \"politician\"\n" +
                "    ]\n" +
                "  }\n" +
                "}";
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
        Response response = client.post(url, body.getBytes(), header, contentType);

        System.out.println("Response: " + response.bodyString());
    }
}
