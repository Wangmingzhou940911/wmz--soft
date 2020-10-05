package com.testng;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*打开浏览器*/
public class OpenBrowser {
    WebDriver webDriver;
    @BeforeMethod
    public void openBrowserCommmethod(){
        webDriver = new ChromeDriver();
    }
    @Test
    public  void openBrowser() throws InterruptedException {
//        设置路径
//        实例化
//        WebDriver webDriver = new ChromeDriver();
        Dimension dimension = new Dimension(300,300);
        webDriver.manage().window().setSize(dimension);
//       打开chrome
//        webDriver.get("http://www.cctv.com");
        Thread.sleep(5000);
//        quit是完全关闭浏览器，关闭进程
//        webDriver.navigate().refresh();
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
//        webDriver.quit();
    }
    @Test
    public  void openBrowser1() throws InterruptedException {
//       打开chrome
        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
//        quit是完全关闭浏览器，关闭进程
        webDriver.navigate().back();
        Thread.sleep(3000);
        webDriver.navigate().forward();
        Thread.sleep(3000);
        webDriver.quit();
//        System.setProperties("webdriver.firefox.bin",);
//        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public  void openbrowser1() throws InterruptedException {
        webDriver.get("https://www.taobao.com");
        String s = webDriver.getCurrentUrl();
        System.out.println("获取到的url地址是" + s);
        Assert.assertEquals(s,"https://www.taobao.com");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void closedBroswer(){
        webDriver.quit();
    }
}
