package hly.day3;

import LoginPage.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by HLY on 2017/4/17.
 */
public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");
//        全局等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
    /*
    * 正确登陆
    * */
    @Test
    public void loginSucessTest() throws InterruptedException {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("meyoungtester");
        driver.findElement(By.name("password")).sendKeys("meyoung123**");
        driver.findElement(By.id("dologin")).click();
        Thread.sleep(9000);

        String logout =  driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");


    }
    public void loginSucessTestPO() throws InterruptedException {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(LoginPage.emailInput).sendKeys("meyoungtester");
        driver.findElement(LoginPage.pwdInput).sendKeys("meyoung123**");
        driver.findElement(LoginPage.loginButton).click();
        Thread.sleep(9000);

        String logout = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout, "退出");
    /*
    * 错误登陆
    * */
        /*@Test
        public void loginsureError() {

            LoginTest.login(driver, "meyoungtester", "meyoung123");

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/./*//*[@id='nerror']/div[2]")));
            String error = driver.findElement(By.xpath("/./*//*[@id='nerror']/div[2]")).getText();
            Assert.assertEquals(error, "帐号或密码错误");


        }*/
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
    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
