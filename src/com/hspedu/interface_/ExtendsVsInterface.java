package com.hspedu.interface_;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey wuKong = new LittleMonkey("悟空");
        wuKong.climbing();
        wuKong.swimming();

    }
}
//猴子
class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void climbing() {
        System.out.println(name + "猴子会爬树...");
    }
}
//接口
interface Fishable {
    void swimming();
}
interface Birdable {
    void flying();
}
//继承
//小结：当子类继承了父类，就自动拥有了父类的功能
//     如果子类需要拓展功能，可以通过实现接口的方式去拓展
//     实现接口是对java单继承机制的一种补充
class LittleMonkey extends Monkey implements Fishable, Birdable{

    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName()+"通过学习，可以像鱼儿一样游泳...");
    }

    @Override
    public void flying() {
        System.out.println(getName()+"通过学习，可以像鸟儿一样飞翔...");
    }
}