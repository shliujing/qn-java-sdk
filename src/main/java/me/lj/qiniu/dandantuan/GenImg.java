package me.lj.qiniu.dandantuan;


/**
 * 老相册
 */
public class GenImg {
    public static void main(String[] args) {

        String urlStrs = "https://s.dandantuan.com/min_photos/2018-07-15_00038.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00045.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00047.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00049.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00051.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00055.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00056.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00059.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00064.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00069.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00072.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00075.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00086.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00092.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00096.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00098.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00101.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00099.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00105.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00106.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00110.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00113.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00119.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00122.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00126.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00130.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00132.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00133.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00140.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00159.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00173.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00175.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00176.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00178.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00181.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00184.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00193.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00192.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00195.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00199.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00203.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00207.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00209.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00224.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00232.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00267.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00269.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00279.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00303.jpg\n" +
                "https://s.dandantuan.com/min_photos/2018-07-15_00313.jpg\n" +
                "http://s.dandantuan.com/min_photos/2018-07-16_00018.jpg\n" +
                "http://s.dandantuan.com/min_photos/2018-07-16_00043.jpg\n" +
                "http://s.dandantuan.com/min_photos/2018-07-16_00038.jpg\n" +
                "http://s.dandantuan.com/min_photos/2018-07-16_00079.jpg\n" +
                "http://s.dandantuan.com/min_photos/2018-07-16_00128.jpg\n" +
                "http://s.dandantuan.com/min_photos/2018-07-16_00137.jpg\n" +
                "http://s.dandantuan.com/min_photos/2018-07-16_00136.jpg\n" +
                "http://s.dandantuan.com/min_photos/2018-07-16_00141.jpg\n" +
                "http://s.dandantuan.com/min_photos/2018-07-16_00140.jpg";
        String wordStrs = "";

        String[] urlStrLists = urlStrs.split("\n");
        int len = urlStrLists[0].equals("") == true ? 0 : urlStrLists.length;;

        String[] wordStrLists = wordStrs.split("\n");
        int wordLen =  wordStrLists[0].equals("") == true ? 0 : wordStrLists.length;;

        String s1 = "<div class=\"tuanjian_p baguetteBoxOne\">";
        String s2 = " <div class=\"col-sm-2 col-xs-6\"><a href=\"";
        String s4 = "";

        String s5 = ">";
        String s6 = "<img src=\"/js/lazy/grey.gif\" class=\"lazy col-md-12\" data-original=\"";
        String s8 = "</div>";

        StringBuilder stringBuilder = new StringBuilder();
        if (len > 0) {
            stringBuilder.append(s1);
            for (int i = 0; i < len; i++) {
                String url = urlStrLists[i];//min url
                String photo_url = url.replace("min_photos", "photos");//photo url
                String s3 = photo_url + "?imageView2/2/w/1000\"";//url
                String s7 = url + "?imageView2/2/w/200\"/></a></div>";//url

                stringBuilder.append(s2);
                stringBuilder.append(s3);
                if (wordLen > 0) {
                    s4 = " title=\"" + wordStrLists[i] + "\"";//内容
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
