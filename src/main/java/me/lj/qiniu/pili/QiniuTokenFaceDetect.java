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
public class QiniuTokenFaceDetect {
    public static void main(String[] args) throws QiniuException {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String url1 = "http://pili.qiniuapi.com/v2/hubs/qiniu-pili-imc/streams/dGVzdA==/saveas";
        String method = "POST";
        String body = "{\"data\": {\"uri\":\"http://oayjpradp.bkt.clouddn.com/Audrey_Hepburn.jpg\"}}\n";
        String contentType = "application/json";

        String qiniuToken = "Qiniu " + auth.signRequestV2(url1, method, body.getBytes(), contentType);
        System.out.println(qiniuToken);

        StringMap header = new StringMap();
        header.put("Host", "argus.atlab.ai");
        header.put("Authorization", qiniuToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone0());
        Client client = new Client(c);
        Response response = client.post(url1, body.getBytes(), header,contentType);
        System.out.println("Response: " + response.toString());
    }
}
