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
public class regeiseTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");


    }

    /* @AfterTest
     public void quitBrowser() throws InterruptedException {
         Thread.sleep(3000);
         driver.quit();
     }*/
    @Test
    public void regiseTest() {
//        打开页面后把drive的控制权转交给iframe"x-urs-iframe"
        driver.switchTo().frame("x-URS-iframe");
//        定位注册按钮点击
        driver.findElement(By.id("changepage")).click();
//        页面跳转到注册页面，获取当前页面的句柄值
        String handle1 = driver.getWindowHandle();
//         driger 切换到新的widow页面
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
//         使用时间戳，放到要输入的邮件地址跟手机号保证每次跑的脚本都是唯一的不需要手动更改
       String time =String.valueOf(System.currentTimeMillis()/100);
//         定位邮件地址，并输入
        driver.findElement(By.id("nameIpt")).sendKeys("time"+time);
//         定位密码，并输入
        driver.findElement(By.id("mainPwdIpt")).sendKeys("123qaz");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123qaz");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        driver.findElement(By.id("vcodeIpt")).sendKeys("asdf");
//         driver.findElement(By.id("sendMainAcodeBtn")).click();
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("1234");
        driver.findElement(By.id("mainRegA")).click();
//         显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainAcode\"]/span")));
//         获取短信验证的错误提示
        String error = driver.findElement(By.xpath("//*[@id=\"m_mainAcode\"]/span")).getText();
//         比较
        Assert.assertEquals(error, "  手机验证码不正确，请重新填写");

    }

    @AfterTest
    public void close() {

        driver.quit();

    }
}
