package me.lj.qiniu.bucket.base64;

import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import me.lj.qiniu.config.Config;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.File;
import java.io.FileInputStream;

public class UploadBase64 {
    String ACCESS_KEY = Config.ACCESS_KEY;
    String SECRET_KEY = Config.SECRET_KEY;
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    String bucketname = Config.BUCKET_NAME;    //空间名
    String key = "base64/03082/qiniu-desktop.png";    //上传的图片名

    public String getUpToken() {
        String token = auth.uploadToken(bucketname, key, 3600, new StringMap().put("insertOnly", 1));
        System.out.println(token);
        return token;
    }

    public void put64image() throws Exception {
        String file = "/Users/jingliu/Desktop/upload-test-data/1.png";//图片路径
        FileInputStream fis = null;
        int l = (int) (new File(file).length());
        byte[] src = new byte[l];
        fis = new FileInputStream(new File(file));
        fis.read(src);
        String file64 = Base64.encodeToString(src, 0);

        String url = "http://upload.qiniup.com/putb64/" + l + "/key/" + UrlSafeBase64.encodeToString(key);
        //非华东空间需要根据注意事项 1 修改上传域名
        RequestBody rb = RequestBody.create(null, file64);
        String token = getUpToken();
        Request request = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + token)
                .post(rb).build();
        System.out.println(request.headers());

        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
        System.out.println(response);
    }

    public static void main(String[] args) throws Exception {
        new UploadBase64().put64image();
    }
}
