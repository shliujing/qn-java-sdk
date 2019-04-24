package me.lj.qiniu.fusion;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.Json;
import com.qiniu.util.StringMap;
import me.lj.qiniu.config.Config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

/**
 * 下载七牛log
 */
public class DownloadQiniuCdnLog {
    final static String ACCESS_KEY = Config.ACCESS_KEY;
    final static String SECRET_KEY = Config.SECRET_KEY;
    final static String LOGURL = "test-pub.iamlj.com";
    final static String DIRECTORY = "/Users/jingliu/Desktop/file";

    public static void main(String[] args) throws QiniuException {
        String day = "2018-08-21";//args第一个参数为 day
        Response response = getApiRes(day);
        if (response == null) return;
        System.out.println(response.bodyString());

        LogRes res = Json.decode(response.bodyString(), LogRes.class);
        if (res == null || res.getCode() != 0 || res.getData() == null || res.getData().size() == 0) return;

        downLoadLogFile(res);
    }

    private static void downLoadLogFile(LogRes res) {
        List<LogItem> items = res.getData().get(LOGURL);
        for (int i = 0; i < items.size(); i++) {
            File f = new File(DIRECTORY, items.get(i).getName());
            FileOutputStream fs = null;

            try {
                URL logUrl = new URL(items.get(i).getUrl());
                URLConnection conn = logUrl.openConnection();
                InputStream inStream = conn.getInputStream();
                fs = new FileOutputStream(f);

                byte[] buffer = new byte[1204];
                int bytesum = 0;
                int byteread = 0;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;
//                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Response getApiRes(String day) {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        String url = "http://fusion.qiniuapi.com/v2/tune/log/list";
        String host = "fusion.qiniuapi.com";
        String contentType = "application/json";
        String method = "POST";
        StringMap bodyMap = new StringMap().put("day", day).put("domains", LOGURL);
        String body = Json.encode(bodyMap);
        String qiniuToken = "Qiniu " + auth.signRequestV2(url, method, body.getBytes(), contentType);
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
            return null;
        }
        return response;
    }


    public class LogRes {
        int code;
        String error;
        HashMap<String, List<LogItem>> data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public HashMap<String, List<LogItem>> getData() {
            return data;
        }

        public void setData(HashMap<String, List<LogItem>> data) {
            this.data = data;
        }
    }

    public class LogItem {
        String name;
        long size;
        long mtime;
        String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public long getMtime() {
            return mtime;
        }

        public void setMtime(long mtime) {
            this.mtime = mtime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
