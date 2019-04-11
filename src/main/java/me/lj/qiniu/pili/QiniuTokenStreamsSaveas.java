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
 * 直播生成回放视频
 */
public class QiniuTokenStreamsSaveas {
    public static void main(String[] args) throws QiniuException {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String url1 = "http://pili.qiniuapi.com/v2/hubs/qiniu-pili-imc/streams/dGVzdA==/saveas";
        String method = "POST";
        String body = "{\n" +
                "  \"fname\": \"qiniu-ai-saveas\",\n" +
                "  \"start\": 0,\n" +
                "  \"end\": 0,\n" +
                "  \"format\": \"m3u8\",\n" +
                "  \"pipeline\": \"12349\",\n" +
                "  \"expireDays\": -1\n" +
                "}";
        String contentType = "application/json";

        //生成token
        String qiniuToken = "Qiniu " + auth.signRequestV2(url1, method, body.getBytes(), contentType);
        System.out.println(qiniuToken);

        StringMap header = new StringMap();
        header.put("Host", "pili.qiniuapi.com");
        header.put("Authorization", qiniuToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone0());
        Client client = new Client(c);
        Response response = client.post(url1, body.getBytes(), header,contentType);
        System.out.println("Response: " + response.toString());
    }
}
