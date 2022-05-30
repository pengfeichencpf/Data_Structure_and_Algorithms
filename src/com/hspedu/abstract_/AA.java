package com.hspedu.abstract_;

public class AA extends Template{

    //计算任务
    //1+...+10000
    public void job() {//实现Templa的抽象方法job
        long num = 0;
        for (long i = 0; i < 1000000; i++) {
            num += i;
        }
    }

//    public void job2() {
//        //得到开始的时间
//        long start = System.currentTimeMillis();
//        long num = 0;
//        for (long i = 0; i < 200000; i++) {
//            num += i;
//        }
//        //得到结束的时间
//        long end = System.currentTimeMillis();
//        System.out.println("AA执行时间"+(end - start));
//    }
}
