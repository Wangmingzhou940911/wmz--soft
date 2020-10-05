package com.testng;

import org.testng.annotations.*;

public class day01 {
    @BeforeTest
    public static void before(){
        System.out.println("这是beforetest");
    }
    @BeforeMethod static void beforemehtod(){
        System.out.println("这是beforemethod");
    }
    @Test
    public static void a(){
        System.out.println("111");
    }
    @Test
    public static void b(){
        System.out.println("222");
    }
    @AfterMethod
    public static void aftermehtod(){
        System.out.println("这是aftermehod");
    }
    @AfterTest static void aftermethod(){
        System.out.println("这是aftermethod");
    }
}
