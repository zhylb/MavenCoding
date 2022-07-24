package com.lihd.maven;

import org.junit.Test;

/**
 * 现在老子在 hot-fix下
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/22 10:59
 */
public class HelloTest {
    @Test
    public void testSayHello() {
        Hello hello = new Hello();
        hello.sayHello();
        hello.sayHello();
        hello.sayHello();
        hello.sayHello();
        hello.sayHello();


        System.out.println("hot-fix");
        System.out.println("hot-fix");
        System.out.println("hot-fix");

    }
}
