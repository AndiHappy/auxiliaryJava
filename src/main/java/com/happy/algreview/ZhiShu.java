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

    // isPrime2 判断一个数是否是质数
    private static boolean isPrime2(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
