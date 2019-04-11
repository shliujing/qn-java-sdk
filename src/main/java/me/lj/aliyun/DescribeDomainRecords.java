package me.lj.aliyun;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import static me.lj.qiniu.config.Config.AliAccessKeyId;
import static me.lj.qiniu.config.Config.AliaccessKeySecret;

/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
域名解析列表
*/
public class DescribeDomainRecords {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("default", AliAccessKeyId, AliaccessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("alidns.aliyuncs.com");
        request.setVersion("2015-01-09");
        request.setAction("DescribeDomainRecords");
        request.putQueryParameter("DomainName", "iamlj.com");
        request.putQueryParameter("PageNumber", "1");
        request.putQueryParameter("PageSize", "100");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}

//return {"RecordId":"17197974744758272","RequestId":"428F21CF-25BE-4CA8-8D05-DAD738B1A40E"}
