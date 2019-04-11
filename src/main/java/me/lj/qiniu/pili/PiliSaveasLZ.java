package me.lj.qiniu.pili;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.util.*;
import me.lj.qiniu.config.Config;

public class PiliSaveasLZ {

    public static void main(String[] args) throws QiniuException {

        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String hub = "meizhou-tvliving";
        String stream = "Fm1058";
        String fname = "Fm1058-1202.m3u8";
        String pipeline = "Fm1058";
        String format = "m3u8";
        long start = 1543755600;
        long end = 1543759200;

        String url = "http://pili.qiniuapi.com/v2/hubs/" + hub + "/streams/" + UrlSafeBase64.encodeToString(stream) + "/saveas";
        String contentType = "application/json";

        StringMap stringMap = new StringMap();
        stringMap.put("fname", fname);
        stringMap.put("format", format);
        stringMap.put("start", start);
        stringMap.put("end", end);
        stringMap.put("pipeline", pipeline);

        System.out.println(Json.encode(stringMap));

        String qiniuToken = "Qiniu " + auth.signRequestV2(url, "POST", StringUtils.utf8Bytes(Json.encode(stringMap)), contentType);
        StringMap headers = new StringMap().put("Authorization", qiniuToken);
        headers.put("Content-Type", contentType);

        Client client = new Client();
        Response response = null;
        try {
            response = client.post(url, StringUtils.utf8Bytes(Json.encode(stringMap)), headers, contentType);
            System.out.println(response.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        }

        response.close();
    }
}