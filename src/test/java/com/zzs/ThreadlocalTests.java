package com.zzs;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


public class ThreadlocalTests {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Test
    public void test(){
        threadLocal.set(1);
        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
}
