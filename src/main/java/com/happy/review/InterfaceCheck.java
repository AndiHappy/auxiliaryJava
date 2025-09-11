package com.happy.review;

public class InterfaceCheck {
    public static void main(String[] args) {
        // 下面的代码可以运行
        ConcreteClass obj = new ConcreteClass();
    }
}

interface Animal {
    void makeSound();
    static void staticMethod() {
        System.out.println("Static method in interface");
    }
    private void logSleep() {
        System.out.println("Logging sleep");
    }
}

abstract class AbstractClass {
    public AbstractClass() {
        // 构造器代码
        System.out.println("AbstractClass constructor called");
    }

    public abstract void abstractMethod();
}

class ConcreteClass extends AbstractClass {
    public ConcreteClass() {
        super(); // 调用抽象类的构造器
        System.out.println("ConcreteClass constructor called");
    }

    @Override
    public void abstractMethod() {
        // 实现抽象方法
    }
}