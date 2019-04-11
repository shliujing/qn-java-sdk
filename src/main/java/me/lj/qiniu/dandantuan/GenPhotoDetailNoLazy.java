package me.lj.qiniu.dandantuan;


/**
 * 新相册详情，添加步骤。
 * 1 修改num ，int num = 1;
 * 2 修改url2017Q4tuanjian String[] urlStrLists = url201712daxie.split("\n");
 * 3 run，复制打印值
 *
 * 去掉的图片
*                 "https://s.dandantuan.com/daily/日常-北京8.jpeg\n" +
*                 "https://s.dandantuan.com/daily/团队日常.jpeg\n" +
 *
 */
public class GenPhotoDetailNoLazy {
    public static void main(String[] args) {

        int num = 2;

        String wordStrs = "北京-年会\n" +
                "北京-乔迁\n" +
                "团队日常";

        String urlbeijingannual = "https://s.dandantuan.com/beijingannual/_DSC1308.jpg\n" +
                "https://s.dandantuan.com/beijingannual/_DSC1309.jpg\n" +
                "https://s.dandantuan.com/beijingannual/_DSC1312.jpg\n" +
                "https://s.dandantuan.com/beijingannual/_DSC1332.jpg\n" +
                "https://s.dandantuan.com/beijingannual/_DSC1333.jpg\n" +
                "https://s.dandantuan.com/beijingannual/_DSC1348.jpg\n" +
                "https://s.dandantuan.com/beijingannual/_DSC1377.jpg\n" +
                "https://s.dandantuan.com/beijingannual/_DSC1450.jpg\n" +
                "https://s.dandantuan.com/beijingannual/_DSC1455.jpg\n" +
                "https://s.dandantuan.com/beijingannual/16年会-北京.jpeg\n" +
                "https://s.dandantuan.com/beijingannual/17年会-北京.jpeg\n" +
                "https://s.dandantuan.com/beijingannual/17年年会-北京.jpeg\n" +
                "https://s.dandantuan.com/beijingannual/17年年会.jpeg\n" +
                "https://s.dandantuan.com/beijingannual/17年年会副本.jpeg\n" +
                "https://s.dandantuan.com/beijingannual/北京-合照.jpeg\n" +
                "https://s.dandantuan.com/beijingannual/北京3.jpeg\n" +
                "https://s.dandantuan.com/beijingannual/年会2.jpeg\n" +
                "https://s.dandantuan.com/beijingannual/年会排练.jpeg";
        String urlbeijingmoving= "https://s.dandantuan.com/beijingmoving/18年-北京乔迁.jpeg\n" +
                "https://s.dandantuan.com/beijingmoving/18年-北京乔迁2.jpeg\n" +
                "https://s.dandantuan.com/beijingmoving/18年1月0北京乔迁.jpeg\n" +
                "https://s.dandantuan.com/beijingmoving/北京-乔迁.jpeg";
        String urldaily= "https://s.dandantuan.com/daily/15年年会.jpeg\n" +
                "https://s.dandantuan.com/daily/北京-团建.jpeg\n" +
                "https://s.dandantuan.com/daily/北京.jpeg\n" +
                "https://s.dandantuan.com/daily/北京2-团建.jpeg\n" +
                "https://s.dandantuan.com/daily/北京开业.jpeg\n" +
                "https://s.dandantuan.com/daily/蛋蛋团.jpeg\n" +
                "https://s.dandantuan.com/daily/杭州小伙伴.jpeg\n" +
                "https://s.dandantuan.com/daily/年会J.jpeg\n" +
                "https://s.dandantuan.com/daily/日常-北京-4.jpeg\n" +
                "https://s.dandantuan.com/daily/日常-北京.jpeg\n" +
                "https://s.dandantuan.com/daily/日常-北京2.jpeg\n" +
                "https://s.dandantuan.com/daily/日常-北京3.jpeg\n" +
                "https://s.dandantuan.com/daily/日常-北京5.jpeg\n" +
                "https://s.dandantuan.com/daily/日常-北京6.jpeg\n" +
                "https://s.dandantuan.com/daily/日常-北京7.jpeg\n" +
                "https://s.dandantuan.com/daily/日常-北京9.jpeg\n" +
                "https://s.dandantuan.com/daily/日常-佚名队.jpeg\n" +
                "https://s.dandantuan.com/daily/日常.jpeg\n" +
                "https://s.dandantuan.com/daily/日常2.jpeg\n" +
                "https://s.dandantuan.com/daily/团建-北京.jpeg\n" +
                "https://s.dandantuan.com/daily/团建.jpeg\n" +
                "https://s.dandantuan.com/daily/轩哥.jpeg\n" +
                "https://s.dandantuan.com/daily/轩哥3.jpeg\n" +
                "https://s.dandantuan.com/daily/永哥.jpeg\n" +
                "https://s.dandantuan.com/daily/战略会议.jpeg\n" +
                "https://s.dandantuan.com/daily/战略会议2.jpeg\n" +
                "https://s.dandantuan.com/daily/战略会议3.jpeg\n" +
                "https://s.dandantuan.com/daily/44bac7b0-6bae-40fb-acca-5d66f9742f3f.jpg\n" +
                "https://s.dandantuan.com/daily/北京-17年年会.jpeg\n" +
                "https://s.dandantuan.com/daily/b474fd1f-074b-4006-825f-9765ff3514ce.jpg\n" +
                "https://s.dandantuan.com/daily/bac56956-7155-438b-a713-9c92e9cd585b.jpg\n" +
                "https://s.dandantuan.com/daily/ccf0e270-b93f-45fe-8c4a-4c88f9df7700.jpg\n" +
                "https://s.dandantuan.com/daily/ee12a446-e3d0-4d85-ac17-1dca0de7d943.jpg\n" +
                "https://s.dandantuan.com/daily/efe25a42-d7d5-4992-b19f-ba4d3383be7e.jpg\n" +
                "https://s.dandantuan.com/daily/WechatIMG304.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG311.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG312.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG313.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG314.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG315.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG316.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG317.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG318.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG319.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG320.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG321.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG322.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG323.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG324.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG325.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG326.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG327.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG328.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG329.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG330.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG331.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG332.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG333.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG334.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG335.jpeg\n" +
                "https://s.dandantuan.com/daily/WechatIMG337.jpeg";

        String[] urlStrLists = urldaily.split("\n");
        int len = urlStrLists[0].equals("") == true ? 0 : urlStrLists.length;

        String[] wordStrLists = wordStrs.split("\n");
        int wordLen = wordStrLists[0].equals("") == true ? 0 : wordStrLists.length;

        String s1 = "<div class=\"tuanjian_p baguetteBoxOne\">";
        String s2 = " <div class=\"col-sm-2 col-xs-6\"><a href=\"";
        String s4 = "";

        String s5 = ">";
        String s6 = "<img class=\"col-md-12\" src=\"";
        String s8 = "</div>";

        StringBuilder stringBuilder = new StringBuilder();
        if (len > 0) {
            stringBuilder.append(s1);
            for (int i = 0; i < len; i++) {
                String url = urlStrLists[i];//min url
                String s3 = url + "\"";//url
                String s7 = url + "?imageView2/1/w/500/h/500\"/></a></div>";//url

                stringBuilder.append(s2);
                stringBuilder.append(s3);
                if (wordLen > 0) {
                    s4 = " title=\"" + wordStrLists[num] + "\"";//内容
                }
                stringBuilder.append(s4);
                stringBuilder.append(s5);
                stringBuilder.append(s6);
                stringBuilder.append(s7);
            }
            stringBuilder.append(s8);
        }
        System.out.println(stringBuilder.toString());
    }
}
