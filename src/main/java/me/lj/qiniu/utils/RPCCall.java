package me.lj.qiniu.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * Created by IntelliJ IDEA.
 * User: jingliu
 * Date: 2019-05-23
 * Time: 14:47
 */
public class RPCCall {
    public static Response call(Auth auth, String url, String host, String contentType, String method, String body) throws QiniuException {
        String qiniuToken = "Qiniu " + auth.signRequestV2(url, method, body.getBytes(), contentType);
        System.out.println(qiniuToken);

        StringMap header = new StringMap();
        header.put("Host", host);
        header.put("Authorization", qiniuToken);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        if (method != null && method.equalsIgnoreCase("POST")) {
            return client.post(url, body.getBytes(), header, contentType);
        } else {
            return client.get(url, header);
        }
    }
}
