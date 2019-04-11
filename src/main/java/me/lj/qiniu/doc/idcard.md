用户通过身份证识别接口`idcard`对存储在七牛云 bucket（支持华东、华北和华南 bucket）或 非七牛云 bucket 的身份证正面图片进行智能识别，可得到身份证中姓名、性别、民族、住址和身份证号码等关键信息。目前支持的图片格式有 png、jpg 和 bmp。

# 使用方式


### 请求域名

```
HOST: http://ai.qiniuapi.com
```

### 请求语法

```
POST /v1/ocr/sari/idcard  Http/1.1
Content-Type:application/json
Authorization: Qiniu <AccessKey>:<Sign>

{
	"data": {
		"uri": "http://oayjpradp.bkt.clouddn.com/age_gender_test.png"
	}
}
```
**注意：** 需要在 POST 请求的 head 部分添加[七牛鉴权](https://developer.qiniu.com/dora/kb/3702/QiniuToken)，以进行用户身份验证。


请求字段说明:

|字段|取值|说明|
|----|------|-------|
|uri|string|身份证图片链接|


### 响应语法

```
身份正面反馈
{
    "code": 0,
    "message": "",
    "result": {
        "uri": "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAIBAQEBAQIBAQECAgICAgQD...",
        "bboxes": [
            [[134,227],[419,227],[419,262],[134,262]],
            ...
            [[115,50],[115,100],[232,100],[232,50]]
        ],
        "texts": [
            ["民族","汉"],
            ["住址","河南省项城市菊花巷东三胡同1号"],
            ["性别","男"],
            ["公民身份号码","412702199005127504"],
            ["出生","1990年5月12日"],
            ["姓名","张杰"]
        ]
    }
}

身份证背面反馈
{
    "code": 0,
    "message": "",
    "result": {
        "uri": "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAIBAQEBAQIBAQECAgICAgQD...",
        "bboxes": [
            [[440,562],[440,611],[854,611],[854,562]],
            [[427,478],[427,531],[854,531],[854,478]]
        ],
        "texts": [
            ["有效期限","2014.05.05-2024.05.05"],
            ["签发机关","项城市公安局"]
        ]
    }
}

```
返回字段说明：

|字段|取值|说明|
|:---|:---|:---|
|code|int|0:表示正确|
|message|string|结果描述信息|
|uri|string|截取原图中身份证区域后的图片 base64 编码|
|bboxes|list[4,2]<int>|返回的图片中所有的文本框位置，为顺时针/逆时针方向旋转的任意四边形[[x1,y1],[x2,y2],[x3,y3],[x4,y4]]|
|texts|string|识别后信息结构化的结果，[key,value]对|


