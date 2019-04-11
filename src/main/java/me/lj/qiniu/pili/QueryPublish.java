package me.lj.qiniu.pili;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.util.StringMap;


/**
 * 为了避免解析不出七牛的节点去播放可以利用七牛的IP调度的接口 : https://developer.qiniu.com/pili/kb/3730/ip-scheduling-partly-small-operators-analytic-solution
 */
public class QueryPublish {
    public static void main(String[] args) throws QiniuException {
        String url = "http://pili-ipswitch.qiniuapi.com/v1/query/publish?stream=rtmp://pili-publish.ever.iamlj.com/qiniu-ever/&clientIP=180.168.57.238";
        String host = "pili-ipswitch.qiniuapi.com\n";
        String contentType = "application/json";

        StringMap header = new StringMap();
        header.put("Host", host);
        header.put("Content-Type", contentType);
        Configuration c = new Configuration(Zone.zone1());
        Client client = new Client(c);
        Response response = client.get(url);

        System.out.println("Response: " + response.toString());
    }
}
