package me.lj.qiniu.other;

import java.util.Arrays;
import java.util.Scanner;

public class RGB2HSB {

    public static void main(String[] args) {
        RGB2HSB it = new RGB2HSB();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数值R：");
        float r = sc.nextFloat();
        System.out.println("请输入数值G：");
        float g = sc.nextFloat();
        System.out.println("请输入数值B：");
        float b = sc.nextFloat();

        float[] rgb = {r, g, b};
        float[] hsb = it.rgb2hsb(rgb);
//        float[] hsb = it.rgb2hsb((int) r, (int) g, (int) b);

        System.out.println(String.format("HSB 值分别为：%s %s %s", hsb[0], hsb[1], hsb[2]));
    }


    public static float[] rgb2hsb(int rgbR, int rgbG, int rgbB) {
        assert 0 <= rgbR && rgbR <= 255;
        assert 0 <= rgbG && rgbG <= 255;
        assert 0 <= rgbB && rgbB <= 255;
        int[] rgb = new int[]{rgbR, rgbG, rgbB};
        Arrays.sort(rgb);
        int max = rgb[2];
        int min = rgb[0];

        float hsbB = max / 255.0f;
        float hsbS = max == 0 ? 0 : (max - min) / (float) max;

        float hsbH = 0;
        if (max == rgbR && rgbG >= rgbB) {
            hsbH = (rgbG - rgbB) * 60f / (max - min) + 0;
        } else if (max == rgbR && rgbG < rgbB) {
            hsbH = (rgbG - rgbB) * 60f / (max - min) + 360;
        } else if (max == rgbG) {
            hsbH = (rgbB - rgbR) * 60f / (max - min) + 120;
        } else if (max == rgbB) {
            hsbH = (rgbR - rgbG) * 60f / (max - min) + 240;
        }

        return new float[]{hsbH, hsbS, hsbB};
    }


    public float[] rgb2hsb(float[] rgb) {
        float[] hsb = new float[3];
        float[] rearranged = rgb.clone();
        int maxIndex = 0, minIndex = 0;
        float tmp;
        //将rgb的值从小到大排列，存在rearranged数组里
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 - i; j++)
                if (rearranged[j] > rearranged[j + 1]) {
                    tmp = rearranged[j + 1];
                    rearranged[j + 1] = rearranged[j];
                    rearranged[j] = tmp;
                }
        }
        //rgb的下标分别为0、1、2，maxIndex和minIndex用于存储rgb中最大最小值的下标
        for (int i = 0; i < 3; i++) {
            if (rearranged[0] == rgb[i]) minIndex = i;
            if (rearranged[2] == rgb[i]) maxIndex = i;
        }
        //算出亮度
        hsb[2] = rearranged[2] / 255.0f;//亮度 B=max(R,G,B)/255

        //算出饱和度
        hsb[1] = 1 - rearranged[0] / rearranged[2];//饱和度S=1-min(R,G,B)/max(R,G,B)

        //算出色相
        hsb[0] = maxIndex * 120 + 60 * (rearranged[1] /( hsb[1] * rearranged[2]) + (1 - 1 / hsb[1])) * ((maxIndex - minIndex + 3) % 3 == 1 ? 1 : -1);
        //防止色相为负值
        hsb[0] = (hsb[0] + 360) % 360;
        return hsb;
    }
}
