package page;

import org.openqa.selenium.By;
/*统一页面管理，方便更改
* PO模型：
* 1.-----page层
* 2------逻辑层 Login（）发邮件（5个步骤）
* 2.-----业务层（我用xxx账号xx密码登陆）将多个方法抽取成一个方法
* 业务层代码比较少，比较少*/
public class email {
    public static By emailInput = By.name("email");
    public static By pwdInput = By.name("password");
    /*定义登陆按钮的定位方式  */
    public static By Login = By.id("dologin");
    /*定义去注册邮箱的定位方式*/
    public static By Rigister = By.linkText("注册网易邮箱");

}

