package com.happy.review;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


interface MyInterface {}


class ParentClass {}

class MyClass extends ParentClass implements MyInterface {
    private String privateField = "私有字段的值";

    public int publicField;

    public MyClass() {}
    public MyClass(String arg) {}

    public void myMethod() {}
    private void privateMethod() {}
}

public class ReflectReview {
    public static void main(String[] args) throws
            NoSuchFieldException, IllegalAccessException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException {
        MyClass obj = new MyClass();
        // 获取 Class 对象
        Class<?> clazz = obj.getClass();
        // 获取私有字段
        Field privateField = clazz.getDeclaredField("privateField");
        // 设置可访问性
        privateField.setAccessible(true);
        // 获取私有字段的值
        String value = (String) privateField.get(obj);
        System.out.println(value);

        // 类名
        System.out.println("类名: " + clazz.getSimpleName());
        // 包名
        System.out.println("包名: " + clazz.getPackage().getName());
        // 父类
        System.out.println("父类: " + clazz.getSuperclass().getSimpleName());
        // 实现的接口
        System.out.print("实现的接口: ");
        for (Class<?> iface : clazz.getInterfaces()) {
            System.out.print(iface.getSimpleName() + " ");
        }
        System.out.println();

        // 构造函数
        System.out.println("构造函数:");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            System.out.println("  " + constructor);
        }

        // 方法
        System.out.println("方法:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("  " + method);
        }

        // 字段
        System.out.println("字段:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("  " + field);
        }

        // 使用反射机制，根据这个字符串获得Class对象
        Class<?> c = Class.forName(clazz.getSimpleName());
        System.out.println(c.getSimpleName());
        // 获取方法
        Method method = c.getDeclaredMethod(clazz.getDeclaredMethods()[0].getName());
        // 绕过安全检查
        method.setAccessible(true);
        // 创建实例对象
        MyClass testInvoke = (MyClass)c.newInstance();
        // 调用方法
        method.invoke(testInvoke);
    }
}


