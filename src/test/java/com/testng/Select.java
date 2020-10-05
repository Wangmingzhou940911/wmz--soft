package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*测试下拉框*/
public class Select {
    WebDriver webDriver;
    @BeforeMethod
    public void openBrowser() throws InterruptedException {
//        webDriver = new FirefoxDriver();
        webDriver = new ChromeDriver();
        webDriver.get("file:///E:/Baiduyun%20download/index.html");
        Thread.sleep(1000);

    }
    @Test
    public void test_Select() throws InterruptedException {
        WebElement webElement = webDriver.findElement(By.id("moreSelect"));
        /*实例化select类*/
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(webElement);
        /*通过索引获取*/
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByVisibleText("xiaomi");
        select.selectByValue("huawei");
    }
    @Test
    public void windowTest() throws InterruptedException {
        /*打开测试页面
        * 点击Open new window
        * 点击百度*/
        webDriver.findElement(new By.ByLinkText("Open new window")).click();
        Thread.sleep(3000);
//        webDriver.findElement(By.className("baidu")).click();
        /*此时页面已经发生了转换，是定位不到元素的*/
        /*获取单腔窗口的句柄,将控制权移交给其他的*/
        String Currenthandle = webDriver.getWindowHandle();
        for(String handles : webDriver.getWindowHandles()){
            System.out.println(handles);
            if(handles.equals(Currenthandle)){
                continue;
            }else {
                webDriver.switchTo().window(handles);
            }
        }
//        webDriver.switchTo().window()
        webDriver.findElement(new By.ByLinkText("baidu")).click();
        Thread.sleep(3000);
        webDriver.switchTo().window(Currenthandle);

    }

    @AfterMethod
    public void Closed_Browser() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}
