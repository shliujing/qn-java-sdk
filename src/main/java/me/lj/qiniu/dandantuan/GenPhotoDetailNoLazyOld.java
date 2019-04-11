package me.lj.qiniu.dandantuan;


/**
 * 不动
 * 新相册详情，添加步骤。
 * 1 修改num ，int num = 1;
 * 2 修改url2017Q4tuanjian String[] urlStrLists = url201712daxie.split("\n");
 * 3 run，复制打印值
 */
public class GenPhotoDetailNoLazyOld {
    public static void main(String[] args) {

        int num = 3;

        String wordStrs = "17年Q4团建\n" +
                "17年12月份客户答谢会\n" +
                "18年5月南京开业\n" +
                "2018年5月团建";

        String url2017Q4tuanjian = "https://s.dandantuan.com/2017Q4tuanjian/IMG_8019.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8020.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8027.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8041.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8044.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8072.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8155.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8170.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8178.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8184.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8187.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8197.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8200.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8212.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8217.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8219.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8232.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8247.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8248.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8252.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8259.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8260.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8264.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8311.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8331.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8341.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8349.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8355.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8379.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8384.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8391.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8409.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8415.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8418.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8419.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8423.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8425.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8429.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8432.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8435.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8436.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8440.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8458.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8464.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8466.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8467.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8488.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8491.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8499.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8510.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8514.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8546.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8565.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8566.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8572.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8597.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8634.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8637.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8661.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8670.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8674.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8681.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8697.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8710.JPG\n" +
                "https://s.dandantuan.com/2017Q4tuanjian/IMG_8715.JPG";
        String url201712daxie = "https://s.dandantuan.com/201712daxie/DSC_0161.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0163.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0165.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0172.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0174.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0175.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0177.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0185.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0198.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0319.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0365.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0382.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0393.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0395.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0407.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0412.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0432.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0434.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0476.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0483.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0519.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0522.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0528.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0588.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0640.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0650.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0656.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0664.JPG\n" +
                "https://s.dandantuan.com/201712daxie/DSC_0670.JPG";
        String url201805nanjing = "https://s.dandantuan.com/201805nanjing/IMG_0012.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0019.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0020.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0026.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0027.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0034.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0048.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0054.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0056.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0057.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0061.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0063.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0065.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0069.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0075.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0094.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0105.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0107.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0113.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0120.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0130.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0136.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0139.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0147.JPG\n" +
                "https://s.dandantuan.com/201805nanjing/IMG_0149.JPG";
        String url201805tuanjian = "https://s.dandantuan.com/201805tuanjian/DSC_0048.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0051.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0055.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0057.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0059.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0061.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0076.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0078.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0096.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0098.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0100.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0102.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0104.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0114.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0117.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0120.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0122.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0176.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0178.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0181.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0198.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0199.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0204.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0208.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0215.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0221.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0241.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0243.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0254.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0266.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0275.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0299.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0301.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0302.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0305.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0306.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0315.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0317.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0321.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0322.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0323.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0361.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0365.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0366.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0372.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0381.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0382.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0383.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0387.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0389.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0391.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0392.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0393.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0394.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0397.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0399.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0400.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0440.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0454.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0458.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0461.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0462.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0465.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0476.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0478.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0486.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0488.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0489.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0495.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0498.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0499.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0501.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0523.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0528.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0532.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0534.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0536.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0549.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0550.JPG\n" +
                "https://s.dandantuan.com/201805tuanjian/DSC_0552.JPG";

        String[] urlStrLists = url201805tuanjian.split("\n");
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
