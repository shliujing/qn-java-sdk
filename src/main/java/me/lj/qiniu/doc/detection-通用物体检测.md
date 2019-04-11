
## detection

> 通用物体检测

Request

```
POST /v1/eval/detection  Http/1.1
Host: argus.atlab.ai
Content-Type: application/json
Authorization: Qiniu <AccessKey>:<Sign>

{
	"data": {
		"uri": "http://o8smkso2w.bkt.clouddn.com/dog.jpg"
	}
}
```

***请求字段说明:***

|字段|取值|说明|
|:---|:---|:---|
|uri|string|图片资源地址|


Response

```
200 ok

{
	"code": 0,
	"message": "",
	"result": {
		"detections": [
			{
				"class": "dog",
				"index": 58,
				"pts": [[138,200],[305,200],[305,535],[138,535]],
				"score": 0.9842000007629395,
				"label_cn": "xx"
			},
			...
		]
	}
}
```

***返回字段说明：***

|字段|取值|说明|
|:---|:---|:---|
|code|int|0:表示处理成功；不为0:表示出错|
|message|string|描述结果或出错信息|
|index|uint|物体分类序号|
|class|string|物体分类名称|
|score|float|物体检测的准确度，取值范围0~1，1为准确度最高|
|pts|四点坐标值|[左上，右上，右下，左下]四点坐标框定的物体|
|label_cn|string|中文标签|
