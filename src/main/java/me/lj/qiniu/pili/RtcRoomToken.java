package me.lj.qiniu.pili;

import com.qiniu.common.Zone;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.rtc.RtcRoomManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import me.lj.qiniu.config.Config;


/**
 * 实时音视频 roomToken
 * https://doc.qnsdk.com/rtn/docs/server_sdk#1
 */
public class RtcRoomToken {
    public static void main(String[] args) throws Exception {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = Config.ACCESS_KEY;
        String SECRET_KEY = Config.SECRET_KEY;
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        RtcRoomManager rmanager = new RtcRoomManager(auth);
        long deadline = System.currentTimeMillis() / 1000 + 3600;

        String token = rmanager.getRoomToken("appid", "roomname", "userid", deadline, "user");

        System.out.println("token: " + token);
    }
}
