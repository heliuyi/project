package hly.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/17.
 */
public class test1 {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");


    }
    /*
    * 正确登陆
    * */
    @Test
    public void loginSucessTest()  {
        LoginTest.login(driver,"meyoungtester","meyoung123**" );

        String logout =  driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");


    }
    /*
    * 错误登陆
    * */
    @Test
    public void loginSucessError(){
        LoginTest.login(driver,"meyoungtester","meyoung1231" );
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/.//*[@id='nerror']/div[2]")));
        String error =  driver.findElement(By.xpath("/.//*[@id='nerror']/div[2]")).getText();
        Assert.assertEquals(error,"帐号或密码错误");
    }
    /*
    * 封装登陆
    * */

    public static void login(WebDriver driver, String email ,String pwd){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }
}

