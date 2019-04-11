package me.lj.qiniu.dandantuan;


/**
 * 新相册首页，添加步骤。
 * 1 修改num ，int num = 1;
 * 2 修改url2017Q4tuanjian String[] urlStrLists = url201712daxie.split("\n");
 * 3 run，复制打印值
 */
public class GenPhotoPage {
    public static void main(String[] args) {

        String titles = "团队日常\n" +
                "上海-16年年会\n" +
                "上海-16年Q3\n" +
                "上海-17年Q2团建\n" +
                "上海-17年Q4团建\n" +
                "上海-17年12月份客户答谢会\n" +
                "南京-18年5月南京开业\n" +
                "上海-18年5月团建\n" +
                "北京-年会\n" +
                "北京-乔迁";

        String imageUrls = "https://s.dandantuan.com/daily/WechatIMG304.jpeg?imageView2/1/w/500/h/500\n" +
                "https://s.dandantuan.com/16annual1/img-00005.jpg?imageView2/1/w/500/h/500\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00002.jpg?imageView2/1/w/500/h/500\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00036.jpg?imageView2/1/w/500/h/500\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8379.JPG?imageView2/1/w/500/h/500\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0656.JPG?imageView2/1/w/500/h/500\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0065.JPG?imageView2/1/w/500/h/500\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0317.JPG?imageView2/1/w/500/h/500\n" +
                "https://s.dandantuan.com/beijingannual/%E5%8C%97%E4%BA%AC-%E5%90%88%E7%85%A7.jpeg?imageView2/1/w/500/h/500\n" +
                "https://s.dandantuan.com/beijingmoving/%E5%8C%97%E4%BA%AC-%E4%B9%94%E8%BF%81.jpeg?imageView2/1/w/500/h/500";

        String targetUrl = "http://www.dandantuan.com/index.php/page/daily2.html\n" +
                "http://www.dandantuan.com/index.php/page/16annual.html\n" +
                "http://www.dandantuan.com/index.php/page/16Q3tuanjian1.html\n" +
                "http://www.dandantuan.com/index.php/page/17Q2tuanjian1.html\n" +
                "http://www.dandantuan.com/index.php/page/2017Q4tuanjian.html\n" +
                "http://www.dandantuan.com/index.php/page/201712daxie.html\n" +
                "http://www.dandantuan.com/index.php/page/201805nanjing.html\n" +
                "http://www.dandantuan.com/index.php/page/201805tuanjian.html\n" +
                "http://www.dandantuan.com/index.php/page/beijingannual.html\n" +
                "http://www.dandantuan.com/index.php/page/beijingmoving.html";

        String[] urlStrLists = imageUrls.split("\n");
        String[] wordStrLists = titles.split("\n");
        String[] targetUrlList = targetUrl.split("\n");

        int len = urlStrLists[0].equals("") == true ? 0 : urlStrLists.length;

        String s1 = "<script src=\"/js/lazy/jquery.lazyload.min.js\" type=\"text/javascript\"></script><script src=\"/js/baguettebox/baguettebox.min.js\" type=\"text/javascript\"></script><link rel=\"stylesheet\" href=\"/js/baguettebox/baguettebox.min.css\"/>";
        String s8 = "<div class=\"col-sm-3 col-xs-6\"><div class=\"card\" data-ve=\"product\" id=\"product2\"><a href=\"";
        String s3 = "class=\"media-wrapper\"><div class=\"media-placeholder\"><img class=\"lazy\" src=\"";

        StringBuilder stringBuilder = new StringBuilder();
        if (len > 0) {
            stringBuilder.append(s1);
            for (int i = 0; i < len; i++) {
                String url = urlStrLists[i];//min url
                String s4 = url + "\"/></div></a><div class=\"card-heading\"><div class=\"text-nowrap text-ellipsis text-center\"><a href=\"";//url
                String s5 = "</a></div></div></div></div>";//url

                String s2 = targetUrlList[i] + "\">";
                String s9 = targetUrlList[i] + "\"";
                stringBuilder.append(s8);
                stringBuilder.append(s9);
                stringBuilder.append(s3);
                stringBuilder.append(s4);
                stringBuilder.append(s2);
                stringBuilder.append(wordStrLists[i]);
                stringBuilder.append(s5);
            }
        }
        String s10 = "<script>$(\".lazy\").lazyload()</script>";
        stringBuilder.append(s10);
        System.out.println(stringBuilder.toString());
    }
}
