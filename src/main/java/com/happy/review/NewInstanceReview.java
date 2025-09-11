package com.happy.review;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceReview {


    // 使用 new 创建对象
    public class Main {
        public Main() throws ClassNotFoundException,
                InstantiationException, IllegalAccessException,
                InvocationTargetException, NoSuchMethodException {
            //        注意：Class.newInstance() 在 JDK 9 后被标记为过时，因为它只能调用无参公有构造器，
            //        且会抛出所有异常。
            //        Constructor.newInstance() 更强大、更灵活。
            Person obj = (Person) Class.forName("com.example.MyClass").newInstance();

            Constructor<Person> constructor = Person.class.getConstructor();
            Person obj2 = constructor.newInstance();
        }

        public static void main(String[] args) {
            Person person1 = new Person(); // 调用无参构造
            Person person2 = new Person("Alice"); // 调用有参构造
            person2.sayHello(); // 输出: Hello, Alice
        }



    }
}


// 定义一个类
class Person {
    private String name;

    public Person() {} // 默认构造器
    public Person(String name) { // 带参构造器
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello, " + name);
    }
}
