package com.happy.review;

public class CloneCopy {
    class MyClass implements Cloneable {
        private String field1;
        private NestedClass nestedObject;
        @Override
        protected Object clone() throws CloneNotSupportedException {
            MyClass cloned = (MyClass) super.clone();
            cloned.nestedObject = (NestedClass) nestedObject.clone(); // 深拷贝内部的引用对象
            return cloned;
        }
    }

    class NestedClass implements Cloneable {
        private int nestedField;
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

}
