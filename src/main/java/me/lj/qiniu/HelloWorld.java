package me.lj.qiniu;

public class HelloWorld {
    public static void main(String[] args) {


        HelloWorld b = new HelloWorld();
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        b.arrayPrint(arr, 5);
//
//        System.out.println(0);
//        HelloWorld.a();
//
//        HelloWorld b = new HelloWorld();
//        b.b();
    }

    public void arrayPrint(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }

        int tmp;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 4 - i; j++) {
                tmp = arr[i][j];
                arr[i][j] = arr[4 - i][4 - j];
                arr[4 - i][4 - j] = tmp;
            }
        }

        System.out.println("交换后：");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }
    }


    public static void a() {
        System.out.println("a");
    }

    public void b() {
        System.out.println("b");
    }

    public void ipp() {
        int i = 0;
        System.out.print(String.format("%d,%d,%d", ++i, i--, i++));
    }
}
