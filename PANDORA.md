## 生成 token

![](http://i.iamlj.com/19-1-7/17158139.jpg)

## 打数据到仓库

![](http://i.iamlj.com/19-1-7/88446199.jpg)

## 通过 api 签名工具实现

最后通过`curl -XPOST  -H "Content-Type: application/json" -H "Date: Mon, 07 Jan 2019 06:24:22 GMT" -H "Authorization: Pandora v_s4L4kwQ-er524cv0ByjdiU7KtwzcaTgb7-y_nU:HmHQ3cx1L4Eeem9kvvmilEtGH5Y=" https://logdb.qiniu.com/v5/repos/test-create-repo -d '{ "region": "nb", "retention": "1d" "schema": [ { "key": "userName", "valtype": "string", }, { "key": "createDate", "valtype": "date" } ] }'`