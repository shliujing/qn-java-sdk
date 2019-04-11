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
 * https://developer.qiniu.com/censor/api/5620/video-censor
 * 生成很多截帧图，类似 http://test-pub.iamlj.com/video/quipcut/1381458772/kXmiw9toA6iq5HtnA2yQCAM_TDo=/132520
 */

public class VideoPulpV3 {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String url = "http://ai.qiniuapi.com/v3/video/censor";
        String host = "ai.qiniuapi.com";

        String body = "{ \"data\": { \"uri\": \"http://test-pub.iamlj.com/mp4/720p/123004.mp4\" }, \"params\": { \"scenes\": [ \"pulp\", \"terror\", \"politician\" ], \"cut_param\": { \"interval_msecs\": 5000 }, \"saver\": { \"bucket\": \"test-pub\", \"prefix\": \"test/video/\" }, \"hookURL\": \"https://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php\" } }";
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

//请求body示例：
//{
//        "data": {
//        "uri": "http://test-pub.iamlj.com/mp4/720p/123004.mp4"
//        },
//        "params": {
//        "scenes": [
//        "pulp",
//        "terror",
//        "politician"
//        ],
//        "cut_param": {
//        "interval_msecs": 5000
//        },
//        "saver": {
//        "bucket": "test-pub",
//        "prefix": "test/video/"
//        }
//        }
//        }