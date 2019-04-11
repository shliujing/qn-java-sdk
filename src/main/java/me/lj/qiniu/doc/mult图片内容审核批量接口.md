
# 1. API

该方法能对非七牛云 bucket 的多张图片进行高性能的鉴黄，鉴暴恐和敏感人物识别。

注: 此方法也支持对七牛云 bucket 的多张图片进行鉴黄，鉴暴恐和敏感人物识别。

请求方式： POST

请求url： http://ai.qiniuapi.com/v3/image/censor/mult

**请求Header**

|字段|	取值|
| :--- | :--- |
|Content-Type|application/json|
|Authorization|Qiniu &lt;AccessKey&gt;:&lt;Sign&gt; <br>注意: 用户请根据 AccessKey 和 SecretKey 后 生成鉴权，以便进行身份验证。`<Sign>`的取值请参考[七牛鉴权](https://developer.qiniu.com/dora/kb/3702/QiniuToken)|

|字段|类型|是否必选|说明|
| :--- | :--- | :--- | :--- |
|data.uris|string数组|Y|网络图片URL地址数组,目前支持http和https，最多可指定100个图片url地址|
|params.scenes|string|Y|审核类型，可选项：pulp/terror/politician|

请求示例

```
POST /v3/image/censor/mult HTTP/1.1
Host: ai.qiniuapi.com
Content-Type: application/json
Authorization: Qiniu YnxrxOSvGotRZpqkZnMzl_euuoqRzOKUd6zwbRju:r6a-o2UpBg6A4puIMnkCExH8lE8=

{
    "data": {
        "uris": ["https://mars-assets.qnssl.com/resource/gogopher.jpg",
                 "http://7xkv1q.com1.z0.glb.clouddn.com/grape.jpg"
                ]
    },
    "params": {
        "scenes": [
            "pulp",
            "terror",
            "politician"
        ]
    }
}
```
注意： 请把 Authorization 换成您的账号七牛鉴权 QiniuToken

## 返回说明
<style>
table th:first-of-type {
    width: 220px;
}
</style>

返回参数

|字段|取值|说明|
| :------------- | :--- | :--- |
|code|string|处理状态：200 调用成功 |
|message|string|与code对应的状态描述信息 |
|results[]|结果数组|每一项中，uri指明对应的图片url，其余同[单图片审核结果](https://developer.qiniu.com/censor/api/5588/image-censor)|

返回示例

```
{
    "code": 200,
    "message": "OK",
    "results": [
        {
            "uri": "https://mars-assets.qnssl.com/resource/gogopher.jpg",
            "code": 200,
            "message": "OK",
            "result": {
                "suggestion": "pass",
                "scenes": {
                    "politician": {
                        "suggestion": "pass"
                    },
                    "pulp": {
                        "suggestion": "pass",
                        "details": [
                            {
                                "suggestion": "pass",
                                "label": "normal",
                                "score": 0.99989
                            }
                        ]
                    },
                    "terror": {
                        "suggestion": "pass",
                        "details": [
                            {
                                "suggestion": "pass",
                                "label": "normal",
                                "score": 0.99914
                            }
                        ]
                    }
                }
            }
        },
        {
            "uri": "http://7xkv1q.com1.z0.glb.clouddn.com/grape.jpg",
            "code": 200,
            "message": "OK",
            "result": {
                "suggestion": "pass",
                "scenes": {
                    "politician": {
                        "suggestion": "pass"
                    },
                    "pulp": {
                        "suggestion": "pass",
                        "details": [
                            {
                                "suggestion": "pass",
                                "label": "normal",
                                "score": 0.99674
                            }
                        ]
                    },
                    "terror": {
                        "suggestion": "pass",
                        "details": [
                            {
                                "suggestion": "pass",
                                "label": "normal",
                                "score": 0.99357
                            }
                        ]
                    }
                }
            }
        }
    ]
}
```
# 审核文件适用规格
###可处理的图片文件：

1.图片大小不超过10M

2.图片尺寸大于32x32，小于5000x5000

3.RGB通道数为3和3以内的图片，不能包含 alpha 通道

4.图片格式支持 png、jpg、jpeg、bmp、webp 和 gif

