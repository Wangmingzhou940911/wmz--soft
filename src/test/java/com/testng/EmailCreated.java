package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.email;

import java.util.concurrent.TimeUnit;

public class EmailCreated {
    WebDriver webDriver;
    @BeforeMethod
    public void opendBrowser(){
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
        webDriver.manage().timeouts().implicitlyWait(300000, TimeUnit.SECONDS);
    }
    @Test
    public void Register_test(){
//        注册按钮测试
        /*注册按钮就是放在iframe框内，需要将控制权转交至iframe框*/
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"normalLoginTab\"]/div[1]/div[2]/a[1]"));
        webElement.click();
        /*此时页面跳转至另外页面，需要转交控制权*/
        String handle = webDriver.getWindowHandle();
        for(String handles : webDriver.getWindowHandles()){
            if(handles.equals(handle)){
                continue;
            }else {
                /*将控制权移交至其他页面*/
                webDriver.switchTo().window(handles);
            }
        }
        /*保证邮箱地址和手机号码是唯一的*/
        String time = String.valueOf(System.currentTimeMillis()/100) ;
        webDriver.findElement(By.id("username")).sendKeys("wmz" + time);
        webDriver.findElement(By.id("password")).sendKeys("wmz940911");
        webDriver.findElement(By.id("phone")).sendKeys(time);
        webDriver.findElement(email.Rigister).click();

    }
    @AfterMethod
    public void closeBroswer(){
        /*关闭浏览器*/
        webDriver.quit();
    }
}
