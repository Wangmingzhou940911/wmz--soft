package com.testng;

import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/*常用的操作*/
public class Operation {
    WebDriver webDriver;
    @BeforeMethod
    public void opendeBrowser(){
        webDriver = new ChromeDriver();

    }
    @Test
    public void Actions_clilc() throws InterruptedException {
        webDriver.get("https:www.baidu.com");
        WebElement webElement =  webDriver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
//      获取当前url
        String s = webDriver.getCurrentUrl();
        webElement.click();
        Thread.sleep(5000);
//      校验
        Assert.assertEquals(s,"http://news.baidu.com/");
    }
    @Test
    public void sendKeyTest() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        WebElement webElement = webDriver.findElement(By.id("kw"));
        /*sendkeys */
        webElement.sendKeys("selenium");
        webDriver.findElement(By.id("su")).click();
        /*等待*/
//        Thread.sleep(5000);
        /*校验titile是否等于*/
        String titile = webDriver.getTitle();
        Assert.assertEquals(titile,"selenium_百度搜索");
    }
    @Test
    public void clear_input() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        WebElement webElement = webDriver.findElement(By.id("kw"));
        webElement.sendKeys("selenium");
        Thread.sleep(3000);
        webElement.clear();
       Thread.sleep(3000);
    }
    @Test
    public  void again_clear() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        String s = webDriver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[2]")).getText();
        Assert.assertEquals(s,"hao123");
        /*geText 是获取的文本标签中间的值*/
//        Thread.sleep(3000);
//        webElement.clear();
//        Thread.sleep(3000);
    }
    @Test
    /*getTagename*/
    public void get_Tagname(){
        webDriver.get("http://www.baidu.com");
        String s =  webDriver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(s,"input");
    }
    /*getAtrribute*/
    @Test
    public void get_Attribute(){
        webDriver.get("http://www.baidu.com");
        String s =  webDriver.findElement(By.id("su")).getAttribute("type");
        Assert.assertEquals(s,"submit");
    }
    /*isdisplaty*/
    @Test
    public void is_Display(){
        webDriver.get("http://www.baidu.com");
        Boolean s =  webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(s);
    }
    /*截图方法实现*/
    @Test
    public void Screetshot(){
        /*实现截图*/
        webDriver.get("http://www.baidu.com");
        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D://test.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @AfterMethod
    public void CloseBrowser(){
        webDriver.quit();
    }
}
