package hly.day2;

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
 * Created by HLY on 2017/4/11.
 */
public class WatiTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
//        全局等待，当获取元素不能找到会等待10都会去等待。
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @AfterTest
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(9000);
        driver.quit();
    }

    /*
    * 打开测试界面
    * 点击wait按钮
    * 获取文本，并判断是否为”wait for display“
    *
    * */

    @Test
    public void waitTest(){
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();

       String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
    }
    @Test
    public void waitTest2(){
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
//        显示等待
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath( "//*[@id=\"display\"]/div")));

        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
    }
}
