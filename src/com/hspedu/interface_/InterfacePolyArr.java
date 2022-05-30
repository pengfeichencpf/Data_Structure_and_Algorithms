package com.hspedu.interface_;

public class InterfacePolyArr {
    public static void main(String[] args) {
        //多态数组 --> 接口类型数组
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone_();
        usbs[1] = new Camera_();
        /*
        演示一个案例：给Usb数组中，存放Phone和相机对象，Phone类还有一个特
        有的方法call()，请遍历Usb数组，如果Phone对象，除了调用Usb接口定义
        的方法外，还需要调用Phone特有方法call
        * */
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();//动态绑定
            //和前面一样，我们仍然需要进行类型的向下转型
            if (usbs[i] instanceof Phone_) {//判断他的运行类型是 Phone_
                ((Phone_) usbs[i]).call();
            }
        }
    }
}

interface Usb{
    void work();
}
class Phone_ implements Usb {
    public void call() {
        System.out.println("手机可以打电话...");
    }

    @Override
    public void work() {
        System.out.println("手机工作中...");
    }
}
class Camera_ implements Usb{

    @Override
    public void work() {
        System.out.println("相机工作中...");
    }
}
