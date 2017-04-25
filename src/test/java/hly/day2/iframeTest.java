package hly.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/11.
 */
public class iframeTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterTest
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    /*
    * 点击ifrome里面的baidu
    * */
    @Test
    public void ifromBaiduTest(){
        driver.get("file:///E:/selenium_html/index.html");
//        通过name 或者ID的方式 转交控制权
//        driver.switchTo().frame("aa");
//        通过webElement,先定位
       WebElement ifrom = driver.findElement(By.tagName("iframe"));
//       页面控制权转交给iframe
       driver.switchTo().frame(ifrom);
//       定位iframe里的baidu按钮并点击
        driver.findElement(By.linkText("baidu")).click();
    }
    @Test
    public void ifromBaiduTest1() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
//        通过name 或者ID的方式 转交控制权
        driver.switchTo().frame("aa");
//         定位按钮并点击
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
//        把drive控制权转交给原来的页面
        driver.switchTo().defaultContent();
//        定位按钮并点击
        driver.findElement(By.linkText("登陆界面")).click();
        Thread.sleep(3000);

    }
}
