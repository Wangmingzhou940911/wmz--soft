package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
* 控制弹框*/
public class Alert {
    WebDriver webDriver;
    @BeforeMethod
    public void openBrowser() throws InterruptedException {
//        webDriver = new FirefoxDriver();
        webDriver = new ChromeDriver();
        webDriver.get("file:///E:/Baiduyun%20download/index.html ");
        Thread.sleep(1000);

    }
    @Test
    /*只能处理js警告弹框，元素是不能定位的*/
    public void test_Aler() throws InterruptedException {
        webDriver.findElement(By.className("alert")).click();
        Thread.sleep(1000);
        org.openqa.selenium.Alert alert = webDriver.switchTo().alert();
        String s = alert.getText();
        alert.accept();
        System.out.println(s);
   }
    @Test
    /*测试打开comfirm弹框*/
    public void confirmTest() throws InterruptedException {
        webDriver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        org.openqa.selenium.Alert alert = webDriver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
    }
    @Test
    public void test_Prompt() throws InterruptedException {
        webDriver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        org.openqa.selenium.Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("jkjk");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }
    /*测试iframe*/
    /*关闭浏览器*/
    @AfterMethod
    public void Closed_Browser() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}
