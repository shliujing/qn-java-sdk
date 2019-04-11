package me.lj.qiniu.dandantuan;


import java.util.Arrays;

/**
 * US，添加步骤。
 * 1 添加文件名即可
 */
public class GenUS {
    public static void main(String[] args) {

        String files = "64-余轩-北京.jpeg\n" +
                "95-李敏-江苏.jpg\n" +
                "108-郭擎华-上海.jpeg\n" +
                "131-陈良-北京.jpg\n" +
                "147-刘营-北京.jpg\n" +
                "163-路广-北京.jpeg\n" +
                "165-于秉球-北京.jpg\n" +
                "166-郭俊杰-杭州.jpeg\n" +
                "175-苏丽珍-杭州.jpeg\n" +
                "186-沈晓燕-江苏.jpg\n" +
                "202-邵波-上海.jpg\n" +
                "231-赵树丽-北京.jpg\n" +
                "236-陈玲丽-杭州.jpeg\n" +
                "237-张建军-上海.jpg\n" +
                "245-张照业-武汉.jpeg\n" +
                "352-周正-北京.jpg\n" +
                "376-吕斌-北京.jpg\n" +
                "386-郭婷-上海.png\n" +
                "389-郑杰-北京.jpeg\n" +
                "399-薛红-北京.jpg\n" +
                "403-任光辉-上海.jpg\n" +
                "404-彭亚乐-上海.jpeg\n" +
                "414-刘贵林-上海.png\n" +
                "432-付亮-上海.jpeg\n" +
                "467-赵剑锋-上海.jpeg\n" +
                "484-李辉-北京.jpg\n" +
                "488-房超-北京.jpeg\n" +
                "509-张成-北京.jpeg\n" +
                "517-赵淼-上海.png\n" +
                "545-王永涛-北京.jpeg\n" +
                "571-蔡璐-北京.jpeg\n" +
                "599-盛磊-上海.jpeg\n" +
                "745-李永涛-上海.png\n" +
                "756-黄杰-杭州.jpeg\n" +
                "764-罗银平-上海.jpg\n" +
                "771-田苗苗-上海.jpeg\n" +
                "786-程冠儒-上海.jpeg\n" +
                "794-钟泽佳-上海.jpeg\n" +
                "801-齐蒙-北京.jpeg\n" +
                "803-蔡小龙-杭州.jpeg\n" +
                "804-郑上浩-北京.jpeg\n" +
                "807-邓含旖-.jpeg\n" +
                "811-张修远-北京.jpeg\n" +
                "824-彭帆-上海.jpeg\n" +
                "833-徐焕超-上海.jpeg\n" +
                "834-谯志成-北京.jpeg\n" +
                "837-刘化鲁-上海.png\n" +
                "840-谢勇-北京.jpeg\n" +
                "843-张环-上海.jpeg\n" +
                "854-张翰-上海.jpeg\n" +
                "856-宋飞-北京.jpeg\n" +
                "857-任留筛-上海.jpeg\n" +
                "877-周银屏-北京.jpg\n" +
                "880-漆润泽-江苏.jpg\n" +
                "892-陈然-北京.jpeg\n" +
                "916-胡磊-杭州.jpeg\n" +
                "938-董亚男-北京.jpg\n" +
                "967-谢阳-上海.jpeg\n" +
                "1008-陈格睿-北京.jpeg\n" +
                "1032-陈国超-北京.jpg\n" +
                "1066-许威-江苏.jpg\n" +
                "1067-李佳丽-北京.jpg\n" +
                "1082-刘海亭-上海.jpeg\n" +
                "1095-董丽-上海.jpg\n" +
                "1096-王斌-上海.jpeg\n" +
                "1105-许媛媛-北京.jpeg\n" +
                "1111-王璐-北京.jpeg\n" +
                "1151-黄卫杰-上海.jpeg\n" +
                "1152-杨帆-上海.jpg\n" +
                "1163-周密-上海.jpg\n" +
                "1165-陈亮-上海.jpeg\n" +
                "1166-李兴然-上海.jpeg\n" +
                "1167-王星辰-上海.jpeg\n" +
                "1171-刘丽丽-上海.jpeg\n" +
                "1177-杨新泉-北京.jpeg\n" +
                "1183-陈真-杭州.jpeg\n" +
                "1184-丁琴-上海.jpg\n" +
                "1188-吴恋恋-上海.jpeg\n" +
                "1191-温尊宁-上海.png\n" +
                "1193-刘靖-上海.png\n" +
                "1194-高锡健-上海.jpeg\n" +
                "1200-张中一-北京.jpg\n" +
                "1203-虞燕-上海.jpeg\n" +
                "1215-郑忠波-北京.jpeg\n" +
                "1216-常学圣-北京.jpg\n" +
                "1236-姜帆-北京.jpeg\n" +
                "1246-张宇飞-上海.png\n" +
                "1247-张静-北京.JPG\n" +
                "1252-郭鹏鹏-北京.jpeg\n" +
                "1259-赵飞-山东.jpg\n" +
                "1260-张辉-北京.jpeg\n" +
                "1262-马天宇-杭州.jpeg\n" +
                "1264-吕燕辉-山东.jpeg\n" +
                "1299-郑康众-南京.jpeg\n" +
                "1301-田东芊-北京.jpeg\n" +
                "1312-王倩倩-北京.jpeg\n" +
                "1313-路旭-北京.jpeg\n" +
                "1320-王玉翔-杭州.jpeg\n" +
                "1321-吴警-江苏.jpg\n" +
                "1329-崔昊-上海.png\n" +
                "1347-郭逍遥-上海.JPG\n" +
                "1348-陈磊-北京.jpeg\n" +
                "1365-杨耀辉-杭州.jpeg\n" +
                "1368-孟令涛-北京.jpg\n" +
                "1381-胡杰-上海.jpg\n" +
                "1382-杨世成-上海.jpg\n" +
                "1383-梁坤-上海.jpeg\n" +
                "1384-张亚丽-上海.jpeg\n" +
                "1390-唐廷羽-北京.jpeg\n" +
                "1407-武开涛-杭州.jpeg\n" +
                "1409-刘阿丁-上海.jpg\n" +
                "1410-贺志兵-上海.jpeg\n" +
                "1411-梁怡琴-上海.jpeg\n" +
                "1412-王丽丽-上海.jpeg\n" +
                "1434-陈芳莹-北京.jpeg\n" +
                "1435-高娇-北京.jpeg\n" +
                "1450-史超-上海.jpeg\n" +
                "1451-胡文宣-北京.jpeg\n" +
                "1472-叶丹丹-上海.jpg\n" +
                "1478-李求龙-南京.jpeg\n" +
                "1479-江伟伟-江苏.jpg\n" +
                "1494-吕倩文-杭州.jpeg\n" +
                "1498-汪孝辉-江苏.jpg\n" +
                "1499-张静如-北京.jpg";

        String spNums = "1450 1348 1194 756  236 95 1498 1188 1479 1411 1216 1194";
        String[] spNum = spNums.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        String[] name = files.split("\n");
        int len = name.length;

        String s1 = "<script src=\"/js/lazy/jquery.lazyload.min.js\" type=\"text/javascript\"></script><div id=\"block238\" class=\"panel panel-block block-custom-html panel-borderless panel-titleless \" style=\"height: auto;\"><div class=\"panel-heading\"></div><div class=\"panel-body\"><div class=\"team\" id=\"team\"><div class=\"container\"><div class=\"col-sm-12 col-xs-12\"><div class=\"yongge team-grids zoomInLeft animated \"><div class=\"team-bg\"><h5>张永</h5><h4><ul class=\"list-2\"><li><p><span class=\"icon icon-map-marker\"></span></p></li><li><h4>上海</h4></li></ul></h4></div><div class=\"team-img\"><img src=\"https://s.dandantuan.com/us/81-张永-上海.jpeg?imageView2/1/w/500/h/500\"/></div></div></div><div class=\"one-team\"><div class=\"team-info\">";
        stringBuilder.append(s1);

        for (int i = 0; i < len; i++) {
            String s9 = "<div class=\"col-sm-3 col-xs-6 team-grids zoomInLeft animated\"><div class=\"team-bg\"><h5>";
            stringBuilder.append(s9);

            String[] ns = name[i].split("-");
            String s2 = ns[1];
            stringBuilder.append(s2);

            String s3 = "</h5><h4><ul class=\"list-2\"><li><p><span class=\"icon icon-map-marker\"></span></p></li><li><h4>";
            String s4="";
            try {
                s4 = ns[2].split("\\.")[0];
            } catch (Exception e) {
                System.out.println(name[i]);
            }
            String s5 = "</h4></li></ul></h4></div><div class=\"team-img\"> <img src=\"https://s.dandantuan.com/us/";
            String s6 = name[i];
            String s7;
            if (Arrays.asList(spNum).contains(ns[0].toString())) {
                s7 = "?imageView2/1/w/500/h/501\"/></div></div>";
            } else {
                s7 = "?imageView2/1/w/500/h/500\"/></div></div>";
            }
            stringBuilder.append(s3);
            stringBuilder.append(s4);
            stringBuilder.append(s5);
            stringBuilder.append(s6);
            stringBuilder.append(s7);

        }
        String s8 = "</div></div></div></div></div></div>";
        stringBuilder.append(s8);

        System.out.println(stringBuilder.toString());
    }
}
