package com.happy.algreview;

public class ZhiShu {
    //给一堆整数，写算法，找出质数
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7, 9, 11, 13, 17, 19, 21};
        for (int num : arr) {
            if (isPrime(num)) {
                System.out.println(num + " is a prime number.");
            }
        }
    }

    // isPrime 判断一个数是否是质数
    private static boolean isPrime(int num) {
        if (num <= 1) return false; // 质数大于1
        for (int i = 2; i <= Math.sqrt(num); i++) { // 只需检查到平方根
            if (num % i == 0) return false; // 能被整除不是质数
        }
        return true; // 是质数
    }
}
