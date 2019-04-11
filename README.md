## 说明

代码为使用 qiniu-java-sdk，调测七牛产品全家桶。





## 历史

github地址

https://github.com/shliujing/qn-java-sdk

文件目录

https://github.com/shliujing/qn-java-sdk/tree/master/src/main/java/me/lj/test

### 配置

1. java-sdk，下载下来解决有依赖问题，比如okhhto.xxx，正确为org.xx.xx.okhttp.xx
    - fix 不用java-sdk，改用gradle或maven的jdk jar包，可到`http://mvnrepository.com/artifact/com.qiniu/qiniu-java-sdk`找对应版本的qiniu-java-sdk
2. 将Config中的参数修改成自己的


### 代码错误fix

1. 有几个类名叫UploadDemo，但文件命名叫xx_xx.java，甚至有空格upload_ recorder.java
    - fix 将类名改为xx_xx，虽然xx是小写不规范
2. BucketManagerDemo 缺少闭合}
3. ![](http://img-lj.oss-cn-hangzhou.aliyuncs.com/18-4-27/19183301.jpg)
4. 好几个类，要加new Configuration(Zone.autoZone()，加ctx配置信息
5. 关于设置notifyURL没有收到回调.md `istentNotifyUrl和notifyUrl讲处理结中的讲`应为 `将`
