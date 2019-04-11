package me.lj.qiniu.dandantuan;


/**
 * 第3批次
 */
public class GenPhotoDetailNoLazy2 {
    public static void main(String[] args) {

        int num = 1;

        //16团建待fix
        String wordStrs = "上海-16年年会\n" +
                "上海-16年Q3\n" +
                "上海-17年Q2团建\n";

        String urlbeijingannual = "https://s.dandantuan.com/16annual1/img-00000.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00001.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00002.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00003.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00004.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00005.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00006.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00007.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00008.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00009.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00010.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00011.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00012.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00013.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00014.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00015.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00016.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00017.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00018.jpg\n" +
                "https://s.dandantuan.com/16annual1/img-00019.jpeg\n" +
                "https://s.dandantuan.com/16annual1/img-00020.jpeg\n" +
                "https://s.dandantuan.com/16annual1/img-00021.jpeg\n" +
                "https://s.dandantuan.com/16annual1/img-00022.jpeg\n" +
                "https://s.dandantuan.com/16annual1/img-00023.jpeg\n" +
                "https://s.dandantuan.com/16annual1/img-00024.jpeg";
        String urlbeijingmoving= "https://s.dandantuan.com/16Q3tuanjian1/img-00000.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00001.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00002.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00003.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00004.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00005.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00006.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00007.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00008.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00010.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00011.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00012.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00013.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00014.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00015.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00016.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00017.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00018.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00020.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00021.jpg\n" +
                "https://s.dandantuan.com/16Q3tuanjian1/img-00023.jpg\n";
        String urldaily= "https://s.dandantuan.com/17Q2tuanjian1/img-00000.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00001.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00002.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00003.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00004.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00005.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00006.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00007.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00008.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00009.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00010.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00011.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00012.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00013.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00014.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00015.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00016.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00017.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00018.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00019.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00020.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00021.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00022.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00023.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00024.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00025.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00026.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00027.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00028.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00029.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00030.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00031.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00032.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00033.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00034.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00035.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00036.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00037.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00038.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00039.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00040.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00041.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00042.jpg\n" +
                "https://s.dandantuan.com/17Q2tuanjian1/img-00043.jpg";

        String[] urlStrLists = urlbeijingmoving.split("\n");
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
