package com.hspedu.abstract_;

public class BB extends Template{

    public void job() {//这里也重写了Template的job方法
        long num = 0;
        for (long i = 0; i < 8000; i++) {
            num *= i;
        }
    }
}
