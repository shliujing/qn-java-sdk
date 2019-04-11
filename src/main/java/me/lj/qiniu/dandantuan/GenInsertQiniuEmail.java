package me.lj.qiniu.dandantuan;


import me.lj.qiniu.config.Config;

/**
 * US，添加步骤。
 * 1 添加文件名即可
 */
public class GenInsertQiniuEmail {
    public static void main(String[] args) {

        String emails = Config.DdtEmails;
        String names = Config.DdtNames;

        String[] email = emails.split(";");
        String[] name = names.split(";");
        int len = name.length;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            String s1 = "INSERT INTO dandantuan.eps_user (account, password, realname, realnames, nickname, admin, avatar, birthday, gender, email, skype, qq, yahoo, gtalk, wangwang, site, mobile, phone, company, address, zipcode, visits, ip, last, score, rank, maxLogin, fails, referer, `join`, reset, locked, public, emailCertified, security, notification, os, browser, lang)\n" +
                    "VALUES ('";
            String s2 = "', 'e21b399268b686c830f7f6672f0a81d4', '";
            String s3 = "', '', '', 'no', '', '2018-08-08 06:30:35', 'u', '";
            String s4 = "', '','','','','','','','','蛋蛋团','我在七牛','200000', 2, '', '2018-07-18 06:30:35', 0, 0, 10, 0, '', '2018-07-18 06:30:35', '', '0000-00-00 00:00:00', '0', '0','','', 'Mac OS X', 'chrome 64', 'zh-cn');\n";
            stringBuilder.append(String.format("%s%s%s%s%s%s%s", s1, email[i].split("@")[0], s2, name[i], s3, email[i], s4));
        }
        System.out.println(stringBuilder.toString());
    }
}
