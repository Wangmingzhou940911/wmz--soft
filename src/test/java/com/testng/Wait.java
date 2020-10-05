package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*元素等待问题*/
public class Wait {
    WebDriver webDriver;
    @BeforeMethod
    public void opendBrowser(){
        webDriver = new ChromeDriver();
        webDriver.get("file:///E:/Baiduyun%20download/index.html");
        /*全局等待，每个case都会操作---*/
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test_wait() throws InterruptedException {

    /*    Thread.sleep(5000);*/
        /*全局等待的方法*/

        /*自动*/
        webDriver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        /*显示等待，会在规定时间范围内寻找那个元素-----*/
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));
       /* 显示等待*/
//        webDriverWait.until(Ex)
        String string =   webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(string,"wait for display");
    }
    @AfterMethod
    public void closedBroswer() throws InterruptedException {
        Thread.sleep(8000);
        webDriver.quit();
    }
}
