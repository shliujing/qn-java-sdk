package me.lj.qiniu.tmp;

/**
 * Created by IntelliJ IDEA.
 * User: jingliu
 * Date: 2019/1/23
 * Time: 11:26 AM
 */
public class Count {
    public static void main(String[] args) {
        int result = 0;

        while (!(result % 1 == 0 && result % 2 == 1 && result % 3 == 0 && result % 4 == 1 &&
                result % 5 == 4 && result % 6 == 3 && result % 7 == 0 && result % 8 == 1 && result % 9 == 0)) {
            result++;
        }

        System.out.println(result);
    }
}
