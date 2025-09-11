package com.happy.review;

public class StaticReview {

    static int staticVar = 0; // 静态变量

    public StaticReview() {
        staticVar++; // 每创建一个对象，静态变量自增
    }

    public static void printStaticVar() {
        System.out.println("Static Var: " + staticVar);
    }

    public static void main(String[] args) {
        // 使用示例
        StaticReview obj1 = new StaticReview();
        StaticReview obj2 = new StaticReview();
        StaticReview.printStaticVar(); // 输出 Static Var: 2

        // 使用示例
        StaticReview.incrementCount(); // 调用静态方法
        StaticReview.displayCount();   // 输出 Count: 1
    }

    static int count = 0;

    // 静态方法
    public static void incrementCount() {
        count++;
    }

    public static void displayCount() {
        System.out.println("Count: " + count);
    }

    //-------------------------------------------------------------
    private static int staticVar1 = 10;
    private int instanceVar = 20;

    // 静态内部类
    public static class StaticInnerClass {
        public void print() {
            System.out.println(staticVar1); // 可访问外部类静态变量
            // System.out.println(instanceVar); // 错误：不能直接访问非静态变量
        }
    }
}

// 使用静态内部类
class Test {
    public static void main(String[] args) {
        StaticReview.StaticInnerClass inner = new StaticReview.StaticInnerClass();
        inner.print();
    }
}


