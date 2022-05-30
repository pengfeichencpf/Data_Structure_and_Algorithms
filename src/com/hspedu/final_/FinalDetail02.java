package com.hspedu.final_;

public class FinalDetail02 {
    public static void main(String[] args) {
        System.out.println(BBB.num);//10000
        //包装类，String是final类，不能被继承
    }
}

class BBB {
    public final static int num = 10000;
    static {
        System.out.println("BBB静态代码块被执行...");
    }
}

final class AAA{
    //一般来说，如果一个类已经是final类了，就没有必要再将方法修饰成final方法
    //public void cry() { }
}