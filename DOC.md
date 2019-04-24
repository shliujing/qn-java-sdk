## 覆盖上传

![](http://i.iamlj.com/18-12-18/47426216.jpg)

## bucket公有私有属性切换

![](http://img-lj.oss-cn-hangzhou.aliyuncs.com/18-7-22/2438210.jpg)

## 直播实时信息

### 文件

/Users/jingliu/lj-local/code/github/qn-java-sdk/src/main/java/me/lj/test/pili/PiliRealTimeInfo.java

mp4格式生成
![](http://img-lj.oss-cn-hangzhou.aliyuncs.com/18-8-2/42660545.jpg)

### 执行结果

![](http://img-lj.oss-cn-hangzhou.aliyuncs.com/18-7-10/96465172.jpg)

## 直播生成回放

### 文件

/Users/jingliu/lj-local/code/githiub/qn-java-sdk/src/main/java/me/lj/test/pili/PiliSaveasBH.java

### 执行结果

![](http://img-lj.oss-cn-hangzhou.aliyuncs.com/18-7-17/11257185.jpg)

## 直播转码

![](http://img-lj.oss-cn-hangzhou.aliyuncs.com/18-7-20/381501.jpg)

## 生成私链

### 文件

/Users/jingliu/lj-local/code/github/qn-java-sdk/src/main/java/me/lj/test/bucket/PrivateDownload.java

### 访问地址

有效期 100h

http://test-private.iamlj.com/1.png?e=1532179543&token=1oMhuZ5a7zjXSSMjM1KWQKGUpbCkEUw9yxYy1ENE:K9bGnjcddgomTiImH9JXFyVPB4Y=


### 执行结果

![](http://img-lj.oss-cn-hangzhou.aliyuncs.com/18-7-17/67131087.jpg)

## 音视频转码

### 文件

/Users/jingliu/lj-local/code/github/qn-java-sdk/src/main/java/me/lj/test/examples/fops.java

![](http://i.iamlj.com/19-1-9/1678424.jpg)

## 覆盖上传

覆盖上传，如果只制定bucket，则会提示文件存在，如果指定bucket+key，默认是可以覆盖的return auth.uploadToken(bucketname,key);
![](http://img-lj.oss-cn-hangzhou.aliyuncs.com/18-8-23/80707459.jpg)


## 资源列举

```
qshell 拉 bucket 的文件列表，量大容易中断。可以用 java 调接口拉资源列表。
接口：https://developer.qiniu.com/kodo/api/4539/v2-list
本地落成 txt 文件后，可以用再用 awk 处理。

文件名 KodoApi.java
这个是 awk 指令，示例搜索包含 html 的文件

```

## base64上传图片
base
![](http://i.iamlj.com/18-10-31/47075628.jpg)

## 阿里云发短信

![](http://i.iamlj.com/18-10-31/89755401.jpg)

## 在线人数

![](http://test-pub.iamlj.com/18-11-15/73976255.jpg)


## drm 加密

文件见 [Drm.php](https://github.com/shliujing/qn-java-sdk/blob/master/src/main/java/me/lj/test/dora/Drm.java)

![](http://i.iamlj.com/18-12-17/61028013.jpg)

## hls 切片

http://api.qiniu.com/status/get/prefop?id=z0.5c19fc0038b9f349c8254983

http://test-pub.iamlj.com/hls/11.m3u8

![](http://i.iamlj.com/18-12-19/8135495.jpg)


## pm3u8

![](http://i.iamlj.com/18-12-20/75011097.jpg)


## mp3->amr

文件见 [demo](https://github.com/shliujing/qn-java-sdk/blob/master/src/main/java/me/lj/test/dora/UploadAndAvthumbToAmr.java)

http://api.qiniu.com/status/get/prefop?id=z0.5c1b64e638b9f349c8ca499c

![](http://i.iamlj.com/18-12-20/9325405.jpg)

## amr->mp3

文件见 [demo](https://github.com/shliujing/qn-java-sdk/blob/master/src/main/java/me/lj/test/dora/AvthumbToMP3.java)

http://test-pub.iamlj.com/test/mp3/New_Road_to_Moscow.mp3

http://api.qiniu.com/status/get/prefop?id=z0.5c1b65e338b9f349c8cada17

![](http://i.iamlj.com/18-12-20/84870984.jpg)

## 上传+转码成 MP4

![](http://i.iamlj.com/19-1-9/24730151.jpg)

## 上传1天后删除+转码+回调

http://test-pub.iamlj.com//mp4/0103/test.mp4

http://api.qiniu.com/status/get/prefop?id=z0.5c2df5f838b9f349c81f4625

![](http://i.iamlj.com/19-1-3/63182756.jpg)

![](http://i.iamlj.com/19-1-3/16821026.jpg)

https://github.com/shliujing/qn-java-sdk/blob/master/src/main/java/me/lj/qiniu/bucket/UploadPfops720P.java

## 人脸1:1

![](http://i.iamlj.com/19-1-4/60568073.jpg)

## 转码+回调

http://api.qiniu.com/status/get/prefop?id=z0.5c37031138b9f349c8a4ef73


![](http://i.iamlj.com/19-1-10/6002584.jpg)


## 上传+回调+mineType

![](http://i.iamlj.com/19-1-16/76452154.jpg)

## 视频缩略图

![](https://i.iamlj.com/19-01-21-cdda1335cb8347cb921e9e1f947886e3.png)

## 私有资源fop

![](https://i.iamlj.com/19-01-23-14346627b9ecbed3763f2b30f01a1a82.png)

## 视频转GIF

![](https://i.iamlj.com/19-01-25/102519.png)

## 视频裁剪

![](https://i.iamlj.com/19-01-28/171417.png)