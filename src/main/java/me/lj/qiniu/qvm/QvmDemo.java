package me.lj.qiniu.qvm;

import com.qiniu.util.UrlSafeBase64;
import me.lj.qiniu.config.Config;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: jingliu
 * Date: 2019/1/17
 * Time: 3:10 PM
 * 400 false
 */
public class QvmDemo {
    private static final String ENCODING = "UTF-8";
    private static final String HTTP_METHOD = "GET";
    private static final String ALGORITHM = "HmacSHA1";

    private static String percentEncode(String value) throws UnsupportedEncodingException {
        return value != null ? URLEncoder.encode(value, ENCODING).replace("+", "%20").replace("*", "%2A").replace("%7E", "~") : null;
    }

    private static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private static String formatIso8601Date(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT);
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return df.format(date);
    }


    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String host = "https://qvm-openapi.qiniu.io";
        String code = "ecs";
        String public_key = Config.QVM_PUBLIC_KEY;
        String timestamp = formatIso8601Date(new Date());
        String signature_method = "HMAC-SHA1";
        String signature_version = "1.0";
        String signature_nonce = UUID.randomUUID().toString();
        String describeInstancePath = "/v1/instance";

        Map parameters = new HashMap(); // 输入请求参数
        parameters.put("code", code);
        parameters.put("public_key", public_key);
        parameters.put("timestamp", timestamp);
        parameters.put("signature_method", signature_method);
        parameters.put("signature_version", signature_version);
        parameters.put("signature_nonce", signature_nonce);

        String[] sortedKeys = (String[]) parameters.keySet().toArray(new String[]{});
        Arrays.sort(sortedKeys);
        final String SEPARATOR = "&"; // 构造 stringToSign 字符串
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append(HTTP_METHOD).append(SEPARATOR);
        stringToSign.append(percentEncode(describeInstancePath)).append(SEPARATOR);
        StringBuilder canonicalizedQueryString = new StringBuilder();
        for (String key : sortedKeys) {
            // 这里注意编码 key 和 value
            canonicalizedQueryString.append("&")
                    .append(percentEncode(key)).append("=")
                    .append(percentEncode(String.valueOf(parameters.get(key))));
        } // 这里注意编码 canonicalizedQueryString
        stringToSign.append(
                percentEncode(
                        canonicalizedQueryString.toString().substring(1)
                )
        );

        // 以下是一段计算签名的示例代码
        String secretKey = Config.QVM_SECRET_KEY;
        Mac mac = Mac.getInstance(ALGORITHM);
        mac.init(new SecretKeySpec(secretKey.getBytes(ENCODING), ALGORITHM));
        byte[] signData = mac.doFinal(stringToSign.toString().getBytes(ENCODING));
        String signature = UrlSafeBase64.encodeToString(signData);

        String url = String.format("%s%s?page=%s&page_size=%s&code=%s&public_key=%s&signature_method=%s&signature_version=%s&signature_nonce=%s&timestamp=%s&signature=%s", host, describeInstancePath, 1, 30, code, public_key, signature_method, signature_version, signature_nonce, timestamp, signature);
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(url);
    }

}
