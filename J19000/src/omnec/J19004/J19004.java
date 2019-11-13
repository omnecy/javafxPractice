package omnec.J19004;

import java.util.Arrays;
import java.util.Random;

public class J19004 {

    private int num;   // 边长
    private int[][] arr; // 矩阵

    public J19004(int num) {

        this.num = num;
        arr = new int[num][num];
    }

    /**
     * 要求:
     * 1.生成num*num大小矩阵（num必须为奇数）
     * 2.随机填充1-100的整数并打印矩阵
     * 3.排序，使数字从内到外依次变小
     * 4.打印输出新的矩阵
     *
     * 方法:
     * 1.生成矩阵方法
     * 2.排序矩阵方法
     * 3.打印矩阵方法
     */
    public void run() {

        build();
        sort();
    }

    // 生成矩阵方法
    private void build() {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                arr[i][j] = (int) (Math.random() * 100);
            }
        }

        System.out.println("原始矩阵 ：");
        print();
    }

    // 排序矩阵方法
    // 1.将所有数存入数组中
    // 2.排序
    // 3.将排好的数放入矩阵中
    // 6 1 2 7 9 10 4 5 3 8
    // 1 2 3 4 5 6 7 8 9 10
    private void sort() {

        int[] a = new int[num * num];
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                a[k++] = arr[i][j];
            }
        }

        Arrays.sort(a);

        // 中心赋值
        k = 0;
        int point = (num - 1) / 2;
        arr[point][point] = a[k++];
        // 外圈赋值
        for (int i = point - 1; i >= 0; i--) {

            int n = point * 2 - i;
            for (int j = i; j <= n; j++) {
                arr[i][j] = a[k++];
                arr[n][j] = a[k++];

                if (j != i && j!= n) {
                    arr[j][i] = a[k++];
                    arr[j][n] = a[k++];
                }
            }
        }

        System.out.println("排序后矩阵 ：");
        print();
    }

    // 打印矩阵方法
    private void print() {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (i != 0 && j == 0) {
                    System.out.println();
                }
                if (arr[i][j] < 10) {
                    System.out.print("0" + arr[i][j] + " ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            } 
        }
        System.out.println();
    }
}
