- [基本参数](#%E5%9F%BA%E6%9C%AC%E5%8F%82%E6%95%B0)
  - [输入图片格式](#%E8%BE%93%E5%85%A5%E5%9B%BE%E7%89%87%E6%A0%BC%E5%BC%8F)
- [API](#api)
  - [image/label](#imagelabel)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 基本参数

## 输入图片格式
* 支持`JPG`、`PNG`、`BMP`

* 图片资源表示方式（URI）。通过统一方式定位、获取资源（图片、二进制数据等）
    * HTTP， 网络资源，形如：http://host/path、https://host/path
    * Data，Data URI Scheme形态的二进制文件，形如：data:application/octet-stream;base64,xxx。ps: 当前只支持前缀为data:application/octet-stream;base64,的数据

# API

* __HOST__: http://argus.atlab.ai
* Authorization: qiniu/mac

| PATH | Note | Input | Response Type |
| :--- | :--- | :--- | :---: |
| [`/v1/image/label`](#image/label)|图片打标|image URI|json|

## image/label

> 每次输入一张图片，尽可能多而准确的返回图片中的主要场景、物体、动物等内容

Request

```
POST /v1/image/label  Http/1.1
Content-Type: application/json
Authorization: Qiniu <AccessKey>:<Sign>

{
	"data": {
		"uri": "http://oayjpradp.bkt.clouddn.com/Audrey_Hepburn.jpg"
	}
}
```

Response

```
200 ok

{
	"code": 0,
	"message": "",
	"result": {
		"confidences": [
            {
                "class": "/s/shower",
                "score": 0.8726697
            },
            {
                "class": "Woman",
                "score": 0.6530496
            },
            ...
	}
}
```

请求字段说明：

|字段|取值|说明|
|:---|:---|:---|
|uri|string|图片资源地址|

返回字段说明：

|字段|取值|说明|
|:---|:---|:---|
|code|int|0:表示正确|
|message|string|结果描述信息|
|confidences|list|图片打标信息列表|
|class|string|识别到的物体或场景名称|
|score|float|所识别内容的准确度|