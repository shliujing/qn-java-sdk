package me.lj.qiniu.pandora.demo;

import com.qiniu.pandora.common.QiniuException;
import com.qiniu.pandora.util.StringMap;

public class PandoraDemo {

    public static void main(String[] args) {
        String url = "";
        StringMap headers = new StringMap();
//        String token = signAuth(url, headers, Client.METHOD_POST);

    }

    private static String signAuth(String url, StringMap headers, String method) throws QiniuException {
        String token = "";
//        try {
//            token = auth.signRequest(url, method, headers.map(), null);
//        } catch (Exception e) {
//            throw new mkblkQiniuRuntimeException(e);
//        }
        return token;
    }

}
