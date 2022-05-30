package com.hspedu.codeblock_;

public class CodeBlockDetail04 {
    public static void main(String[] args) {
        //说明
        //1.类的加载
        //1.1先加载父类A02
        //1.2再加载B02
        //2.创建对象
        //2.1从子类的构造器开始
        //new B02();//对象

        new C02();
    }
}

class A02 {//父类
    private static int n1 = getVal01();
    static {
        System.out.println("A02的一个静态代码块..");//(2)
    }

    {
        System.out.println("A02的第一个普通代码块..");//(5)
    }
    public int n3 = getVal02();//普通属性的初始化
    public static int getVal01() {
        System.out.println("getVal01");//(1)
        return 10;
    }

    public int getVal02() {
        System.out.println("getVal02");//(6)
        return 10;
    }

    public A02() {
        //隐藏了
        //super
        //普通代码块和普通属性的初始化...
        System.out.println("A02的构造器");//(7)
    }
}
class C02 {
    private int n1 = 100;
    private static int n2 = 200;

    private void m1() {

    }
    private static void m2() {

    }
    static {
        //静态代码块，只能调用静态
        //System.out.println(n1);错误
        System.out.println(n2);//ok
        //m1();错误
        m2();
    }
    {
        //普通代码块，可以试用任意成员
        System.out.println(n1);
        System.out.println(n2);//ok
        m1();
        m2();
    }
}
class B02 extends A02 {
    private static int n3 = getVal03();
    static {
        System.out.println("B02的一个静态代码块");//(4)
    }
    public int n5 = getVal04();
    {
        System.out.println("B02的第一个普通代码块..");//(9)
    }

    public static int getVal03() {
        System.out.println("getVal03");//(3)
        return 10;
    }

    public int getVal04() {
        System.out.println("getVal04");//(8)
        return 10;
    }

    public B02() {//构造器
        //隐藏了
        //super
        //普通代码块和普通属性的初始化...
        System.out.println("B02的构造器");//(10)
    }
}
