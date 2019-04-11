package me.lj.baidu;

import com.baidu.aip.ocr.AipOcr;
import me.lj.qiniu.config.Config;
import org.json.JSONObject;

import java.util.HashMap;

public class BaiduOCR {
    //设置APPID/AK/SK
    public static final String APP_ID = "14239153";
    public static final String API_KEY = Config.BdAPI_KEY;
    public static final String SECRET_KEY = Config.BdSECRET_KEY;

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 资源
        String  url = "http://i.iamlj.com/18-9-19/56856395.jpg";
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        JSONObject res = client.basicGeneralUrl(url, options);//通用
        System.out.println(res.toString(2));

//      todo 循环按行输出拼凑 php
    }
}