package com.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*数据驱动*/
public class DataDriverTest {
    @DataProvider(name = "loginuesr")
    public Object[][] data1(){
        return new Object[][]{{"use1","pwd1"},{"user2","pwd2"}};
    }
    @Test(dataProvider = "loginuesr")
    public void logintest(String user,String pwd){
        System.out.println("user----" + user);
        System.out.println("pwd----" + pwd);
    }
}
