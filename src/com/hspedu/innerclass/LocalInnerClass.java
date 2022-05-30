package com.hspedu.innerclass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("Outer02的hashCode"+outer02);
        //Outer02.this hashcode=com.hspedu.innerclass.Outer02@2f7c7260
    }
}

class Outer02{//外部类
    private int n1 = 100;
    private void m2() {//私有方法
        System.out.println("Outer m2()...");
    }
    public void m1() {//方法
        //1.局部内部类是定义在外部类的局部位置，通常在方法
        //3.不能添加访问修饰符，因为它的地位就是一个局部变量，
        //  局部变量是不能使用修饰符的。但是可以使用final修饰，
        //  因为局部变量也可以使用final
        //4.作用域：仅仅在定义它的方法或者代码块中
        final class Inner02 {//局部内部类（本质仍然是一个类）
            //2.可以直接访问外部类的所有成员，包含私有的
            int n1 = 800;
            public void f1() {
                //5.局部内部类可以直接访问外部类的成员，比如下面外部类n1和m2()
                //7.如果外部类和局部内部类的成员重名时，默认遵循就近原则，
                // 如果想访问外部类的成员，则可以使用（外部类名.this.成员）去访问
                //解读：
                //Outer02.this 本质就是外部类的对象，即哪个对象调用m1,Outer02.this就是哪个对象
                System.out.println("n1=" +n1+"外部类的n1"+ Outer02.this.n1);
                System.out.println("Outer02.this hashcode=" + Outer02.this);
                //Outer02的hashCodecom.hspedu.innerclass.Outer02@2f7c7260
                m2();
            }
        }
        //class Inner03 extends Inner02 {}
        //6.外部类在方法中，可以创建Inner02对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
    {//代码块
        class Inner03{ }
    }
}