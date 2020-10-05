package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/*双击，右键*/
public class Actions {
    WebDriver webDriver;
    @BeforeMethod
    public void opendBrowser(){
        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com");
    }
    @Test
    public void RightClick(){
        /*在百度上按钮右键*/
        WebElement webElement =  webDriver.findElement(By.id("su"));
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(webDriver);
        /*点击右键，将代点击的元素传入到该方法中去,分为传参和不传参两种，不传参代表的是当前默认页面*/
        actions.contextClick().perform();
//      actions.contextClick(webElement).perform();
    }
    @Test
    public void DoubletClick(){
        /*在百度上按钮双键*/
        WebElement webElement =  webDriver.findElement(By.id("su"));
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(webDriver);
        actions.doubleClick(webElement);
//        actions.contextClick(webElement).perform();
    }
    @Test
    public void mousemove() throws InterruptedException {
        /*鼠标移动*/
        webDriver.get("file:///E:/Baiduyun%20download/index.html ");
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(webDriver);
        actions.moveToElement(webElement).perform();
    }
    @Test
    public void testDrop(){
        /*元素实现拖拽*/
        webDriver.get("file:///E:/Baiduyun%20download/dragAndDrop.html");
        WebElement webElement =   webDriver.findElement(By.id("drag"));
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(webDriver);
        actions.dragAndDropBy(webElement,500,500).perform();
    }
    @Test
    public void testDrop_loacte() throws InterruptedException {
        webDriver.get("file:///E:/Baiduyun%20download/dragAndDrop.html");
        Thread.sleep(2000);
        WebElement webElement =   webDriver.findElement(By.id("drag"));
        WebElement webElement1 = webDriver.findElement(By.xpath("/html/body/h1"));
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(webDriver);
        /*
        * 1.先按住第一个元素不放
        * 2.移动至指定位置
        * 3.释放该元素
        * 4.执行该方法---peform*/
        actions.clickAndHold(webElement).moveToElement(webElement1).release(webElement).perform();
        Thread.sleep(5000);
    }
    @Test
    public  void SelectedMultiselect() throws InterruptedException {
        /*下拉框多选*/
        webDriver.get("file:///E:/Baiduyun%20download/index.html ");
        WebElement webElement = webDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        /*1.先拿到下拉框中所有的元素
        * 2.Actions 提供了一共虚拟键盘，先按住shift键，然后选中第一个，第三个值
        * 3.再释放shift键*/
        List<WebElement> list = (List<WebElement>) webDriver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        System.out.println(list.size());
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(webDriver);
        /*Keys.SHIFT会默认选中一到三个*/
//        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();
        /*默认第一个是选中的*/

        actions.keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.SHIFT).perform();
        Thread.sleep(5000);
    }
    @Test
    public void test_RobotClass() throws AWTException, InterruptedException {
        /*模拟组合操作*/
        Robot robot = new Robot();
        /*按住control键*/
        robot.keyPress(KeyEvent.VK_CONTROL);
        /*再按住s键*/
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(2000);
        /*按下保存键*/
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        int KeyS = (int) new Character('s');
        System.out.println(KeyS);
    }
    @Test
    public void UploadFile() throws InterruptedException {
        /*上传文件*/
        webDriver.get("file:///E:/Baiduyun%20download/index.html ");
        webDriver.findElement(By.id("load")).sendKeys("C:\\Users\\admin\\Desktop\\备战秋招\\个人简历\\证件照");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void closedBroswer() throws InterruptedException {
        Thread.sleep(3000);

        webDriver.quit();
    }
}
