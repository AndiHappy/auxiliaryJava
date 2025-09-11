package com.happy.review;

public class GenericsReview {
    private static <T extends Number> double add(T a, T b) {
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {
        add(10, 20); // 使用 Integer
        add(10.5, 20.3); // 使用 Double
        // add("10", "20"); // 编译错误，String 不符合 T extends Number 的约束
    }
}
