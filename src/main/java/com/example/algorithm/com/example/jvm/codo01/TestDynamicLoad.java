package com.example.algorithm.com.example.jvm.codo01;

public class TestDynamicLoad {

    static {
        System.out.println("*************load TestDynamicLoad************");
    }

    public static void main(String[] args) {
        new A1();
        System.out.println("*************load test************");
        B1 b = null;  //B不会加载，除非这里执行 new B()
    }
}

class A1 {
    static {
        System.out.println("*************load A************");
    }

    public A1() {
        System.out.println("*************initial A************");
    }
}

class B1 {
    static {
        System.out.println("*************load B************");
    }

    public B1() {
        System.out.println("*************initial B************");
    }
}