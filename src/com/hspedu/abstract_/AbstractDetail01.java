package com.hspedu.abstract_;

public class AbstractDetail01 {
    public static void main(String[] args) {
        //抽象类不能够被实例化
        //A a = new A();
    }
}
//抽象类不一定要包含abstract方法。也就是说，抽象类可以没有abstract方法
//还可以有实现的方法
abstract class A {
    public void hi() {
        System.out.println("hi");
    }
}
//一旦包含了abstract方法，则这个类必须声明为abstract
abstract class B {
    public abstract void hi();
}
//abstract只能修饰类和方法，不能修饰属性和其他的
class C {
    //public abstract int n1 = 1;
}
