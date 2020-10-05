package com.testng;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*执行一段JS代码*/
public class JSexe {
    WebDriver webDriver;
    @BeforeMethod
    public void opendBrowser(){
        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com");
    }
    @Test
    public void test_JS() throws InterruptedException {
        /*执行一段js代码*/
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeAsyncScript("document.getElementById(\"kw\").setAttribute(\"value\",\"人生自古谁无死\")");
        Thread.sleep(5000);

    }
    @AfterMethod
    public void closedBroswer() throws InterruptedException {
        webDriver.quit();
    }
}
