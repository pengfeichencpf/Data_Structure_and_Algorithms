package com.hspedu.innerclass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {//外部类
    private int n1 = 10;//属性
    public void method() {//方法
        //基于接口的匿名内部类
        //解读
        //1.需求：想用IA接口，并且创建对象
        //2.传统方式，是写一个类，实现该接口，并且创建对象
        //3.需求是 Tiger/Dog类只使用一次，后面不再使用
        //4.可以使用匿名内部类来简化
        //5.tiger的编译类型是 IA
        //6.tiger的运行类型就是 匿名内部类 XXXX==>外部类名字$1==>Outer04$1
        /*
        * 我们看底层
        * class XXXX implements IA {
        *     @Override
              public void cry() {
              System.out.println("老虎叫唤...");
        * }
        * */
        //7.jdk底层在创建匿名内部类Outer04$1，立即马上就创建了Outer04$1实例，并且把地址
        //返回给tiger
        //8.匿名内部类使用一次，就不能再使用，不能再new
        //tiger可以反复使用，tiger是一个对象
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫唤...");
            }
        };
        //getClass获取对象的运行类型
        System.out.println("tiger的运行类型="+tiger.getClass());
        //tiger的运行类型=class com.hspedu.innerclass.Outer04$1
        tiger.cry();
//        IA tiger = new Tiger();
//        tiger.cry();
        //演示基于类的匿名内部类
        //分析
        //1.father编译类型 Father
        //2.father运行类型 匿名内部类Outer04$2
        //3.底层会创建匿名内部类
        /*
        * class Outer04$2 extends Father{
        * }
        * */
        //4.同时也直接返回了匿名内部类Outer04$2的对象
        //5.注意("Jack")参数列表会传递给 构造器
        Father father = new Father("jack"){//Jack传递给father的构造器
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        System.out.println("father对象的运行类型="+father.getClass());
        //father对象的运行类型=class com.hspedu.innerclass.Outer04$2
        father.test();//匿名内部类重写了test方法

        //基于抽象类的匿名内部类
        //抽象类的匿名内部类，必须实现。
        //即必须得有eat这个方法
        //但是前面的father不一定要有test这个方法
        Animal animal = new Animal(){
            @Override
            void eat() {
                System.out.println("小狗吃骨头...");
            }
        };
        animal.eat();//小狗吃骨头...
    }
}
interface IA{//接口
    public void cry();
}
//class Tiger implements IA{
//    @Override
//    public void cry() {
//        System.out.println("老虎叫唤...");
//    }
//}
//class Dog implements IA{
//    @Override
//    public void cry() {
//        System.out.println("小狗叫唤...");
//    }
//}

class Father{//类
    public Father(String name) {//构造器
        System.out.println("接收到name="+name);
    }
    public void test(){//方法
    }
}
abstract class Animal {//抽象类
    abstract void eat();
}