package com.kyson.chapter1.section1;

import java.util.Arrays;

/*
* 1.1.30 数组练习。编写一段程序，创建一个 N×N 的布尔数组 a[][]。其中当 i 和 j 互质时
* (没有相同 因子)，a[i][j] 为 true，否则为 false。

1.1.30 Array exercise. Write a code fragment that creates an N-by-N boolean
array a[][] such that a[i][j] is true if i and j are relatively
prime (have no common factors), and false otherwise.
*
* */
public class Practise_01_01_30 {

    /***
     * 求最大公约数
     */
    public static int gcd(int m, int n) {
        if (n == 0)
            return m;

        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }

    /**
     * 两数是否互质
     */
    public static boolean isCoprime(int m, int n) {
        if (1 == gcd(m, n)) {
            return true;
        }
        return false;
    }

    public static boolean[][] boolArray(int N) {
        boolean[][] resultArray = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 如果是第0行或第0列
                if (i == 0 || j == 0) {
                    resultArray[i][j] = false;
                } else {
                    resultArray[i][j] = isCoprime(i, j) ? true : false;
                }
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        boolean[][] resultArray = boolArray(9);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(Arrays.toString(resultArray[i]));
        }
    }
}
