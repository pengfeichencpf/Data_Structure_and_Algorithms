package com.hspedu.interface_;
/*
* 演示多态传递现象
* */
public class InterfacePolyPass {
    public static void main(String[] args) {
        //接口类型的变量可以指向，实现了该接口的类的对象实例
        IG ig = new Teacher();
        //如果IG继承了IH这个接口，而我们的Teacher类，
        // 实现了IG这个接口
        //那么，实际上就相当于Teacher类也实现了IH接口
        //这就是所谓的接口多态传递现象
        IH ih = new Teacher();
    }
}
interface IH {
    void hi();
}
interface IG extends  IH{}
class Teacher implements IG {

    @Override
    public void hi() {

    }
}