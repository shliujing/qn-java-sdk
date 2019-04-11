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
 * 人脸检测 https://developer.qiniu.com/dora/manual/4281/face-detection
 */
public class FaceDetect {
    public static void main(String[] args) {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String url = "http://argus.atlab.ai/v1/face/detect";
        String body = "{ \"data\": { \"uri\": \"http://oayjpradp.bkt.clouddn.com/Audrey_Hepburn.jpg\" } }";
        String contentType = "application/json";
        String qiniuToken = "Qiniu " + auth.signRequestV2(url, "POST", body.getBytes(), contentType);
        System.out.println(qiniuToken);

        StringMap header = new StringMap();
        header.put("Authorization", qiniuToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        Response response = null;
        try {
            response = client.post(url, body.getBytes(), header, contentType);
        } catch (QiniuException e) {
            System.out.println("调用client.post报错，信息为：" + e.getMessage());
        }

        try {
            System.out.println("Response: " + response.bodyString());
        } catch (QiniuException e) {
            System.out.println("调用response.bodyString报错，信息为：" + e.getMessage());
        }
    }
}
