## 以图搜图

**创建图像库**
[demo](https://github.com/shliujing/qn-java-sdk/blob/master/src/main/java/me/lj/qiniu/ai/imageSearch/NewGroup.java)
![demo结果](https://i.iamlj.com/19-02-21/120730.png)

**显示所有图像库**
[demo](https://github.com/shliujing/qn-java-sdk/blob/master/src/main/java/me/lj/qiniu/ai/imageSearch/GroupList.java)
![demo结果](https://i.iamlj.com/19-02-21/121200.png)

其他的接口，触类旁通，换下请求url 和参数即可


## 人脸识别

文件 https://github.com/shliujing/qn-java-sdk/blob/master/src/main/java/me/lj/qiniu/ai/FaceDetect.java
![](http://i.iamlj.com/18-9-3/24583009.jpg)

## 图片打标

文件见 [demo](https://github.com/shliujing/qn-java-sdk/blob/master/src/main/java/me/lj/test/ai/ImageLabel.java)

![](http://i.iamlj.com/18-11-6/28348867.jpg)

## ocr

文件见 [demo](https://github.com/shliujing/qn-java-sdk/blob/master/src/main/java/me/lj/test/ai/OcrIdcard.java)

![](http://i.iamlj.com/18-12-20/35387363.jpg)


## 图片内容审核

![](http://i.iamlj.com/19-1-2/45359682.jpg)


## 视频内容审核 v3

5c4812ac0b056e0007b555bc

![](https://i.iamlj.com/19-01-23-8eae0f072ffceb3f2e75121cc6c316a2.png)


结果

![](https://i.iamlj.com/19-01-23-c4d07ca9e9a4f1af8d961800d8703649.png)

截帧图

http://test-pub.iamlj.com/test/video/cut/1381458772/Y-tRwuUzv_rGUgCnYvgs7Mnt6Pk=/75500

## 视频内容审核 v1

发起审核请求

请求参数
{ "data": { "uri": "http://test-pub.iamlj.com/mp4/720p/123004.mp4" }, "params": { "async": true, "vframe": { "mode": 0, "interval": 3 }, "save": { "bucket": "test-pub", "prefix": "video/quip" }, "hookURL": "https://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php" }, "ops": [ { "op": "pulp", "hookURL": "https://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php" }, { "op": "terror", "hookURL": "https://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php" }, { "op": "politician", "hookURL": "https://practice.dandantuan.com/demo/qiniu/qiniu_sdk_notify.php" } ] }

![](https://i.iamlj.com/19-01-22-7f902ec04c73129bd6c16f24b9b6e229.png)

查询审核进度，包括回调信息都可以看到

 {"job":"5c46d57e984fe60008eb91c4"}

 截帧图片访问示例

 http://test-pub.iamlj.com/video/quipcut/1381458772/Y-tRwuUzv_rGUgCnYvgs7Mnt6Pk=/63500

![](https://i.iamlj.com/19-01-22-0143c6faf08321aac030a6d8330d79a3.png)


## 新版本鉴黄

**地址**

https://developer.qiniu.com/censor/api/5588/image-censor

http://test-pub.iamlj.com/sex/sex-sexy.jpeg?image-censor/v3/pulp/terror/politician

{
    "code": 200,
    "message": "OK",
    "result": {
        "suggestion": "review",
        "scenes": {
            "politician": {
                "suggestion": "pass"
            },
            "pulp": {
                "suggestion": "review",
                "details": [
                    {
                        "suggestion": "review",
                        "label": "sexy",
                        "score": 0.93611
                    }
                ]
            },
            "terror": {
                "suggestion": "pass",
                "details": [
                    {
                        "suggestion": "pass",
                        "label": "normal",
                        "score": 0.99998
                    }
                ]
            }
        }
    }
}

## 场景识别

[demo 文件](https://github.com/shliujing/qn-java-sdk/tree/master/src/main/java/me/lj/qiniu/ai/EvalDetection.java)
![demo效果图](https://i.iamlj.com/19-02-22/171756.png)

[demo 文件](https://github.com/shliujing/qn-java-sdk/tree/master/src/main/java/me/lj/qiniu/ai/EvalScene.java)
![demo效果图](https://i.iamlj.com/19-02-22/171858.png)