package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElement {
    WebDriver webDriver;
    @BeforeMethod
    public void opendBrowser(){
        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com");
    }
    @Test
    public void ByidTest(){
       WebElement input =  webDriver.findElement(By.id("kw"));
    }
    @Test
//    通过name来查找
    public void Byname(){
        WebElement e = webDriver.findElement(By.name("wd"));
    }
    @Test
    public void Byclass(){
        WebElement e = webDriver.findElement(By.className("hot-title"));
    }
    @Test
//    通过超链接来定位文本位置，只能是<a></a>标签
    public void ByLinkedtest(){
        WebElement e = webDriver.findElement(By.linkText("学术"));
    }
    /*部分文本标签*/
    @Test
    public void BypareLinktest(){
        WebElement e = webDriver.findElement(By.partialLinkText("学"));
    }
    @Test
    public void ByTageName(){
        List<WebElement> e = webDriver.findElements(By.tagName("input"));
        System.out.println(e.size());
    }
    @Test
    public void Byxpath(){
        List<WebElement> E = (List<WebElement>) webDriver.findElements(By.xpath("//*[@id=\"kw\"]"));
        System.out.println(E.size());
    }
    /*有id就用id,id 可能是随机数字*/
    @Test
    public void Byxpaths(){
        List<WebElement> e = webDriver.findElements(By.xpath("//*[@id=\"s-top-left\"]/a"));
        System.out.println(e.size());
        String s = e.get(0).getText();
        System.out.println(s);
        for(int i = 0; i < e.size();i++){
            String tempstring = e.get(i).getText();
            System.out.println(tempstring + "字段");
        }
    }
    //*[@id="s-top-left"]/a[1]
    @Test
    public void BycssSelector(){
        List<WebElement> e =  webDriver.findElements(By.cssSelector("#lg"));
        System.out.println(e);

    }
    @AfterMethod
       public void closedBroswer(){
        webDriver.quit();
    }

}
