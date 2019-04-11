package me.lj.qiniu.ai.imageSearch;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import me.lj.qiniu.config.Config;

/**
 * https://developer.qiniu.com/dora/manual/4680/image-search#2
 * 新建图像库
 */
public class NewGroup {
    public static void main(String[] args) throws QiniuException {
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String groupId = "123";
        String url = "http://ai.qiniuapi.com/v1/image/group/" + groupId + "/new";
        String host = "ai.qiniuapi.com";

        String body = "{ \"data\": [ { \"uri\": \"http://test-pub.iamlj.com/sex/sex-sexy.jpeg\", \"attribute\": { \"id\": \"1\", \"label\": \"sexy\", \"desc\": \"sexy iamge\" } }, { \"uri\": \"http://test-pub.iamlj.com/test-idcard.jpg\", \"attribute\": { \"id\": \"2\", \"label\": \"idcard\", \"desc\": \"idcard image\" } } ] }";
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


//{
//        "data": [
//        {
//        "uri": "http://test-pub.iamlj.com/sex/sex-sexy.jpeg",
//        "attribute": {
//        "id": "1",
//        "label": "sexy",
//        "desc": "sexy iamge"
//        }
//        },
//        {
//        "uri": "http://test-pub.iamlj.com/test-idcard.jpg",
//        "attribute": {
//        "id": "2",
//        "label": "idcard",
//        "desc": "idcard image"
//        }
//        }
//        ]
//        }