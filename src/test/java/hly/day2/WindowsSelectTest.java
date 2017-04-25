package hly.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/11.
 */
public class WindowsSelectTest {
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
//    多窗口操作
//    打开测试页面
//    点击Open new windows
//    点击baidu
    @Test
    public void testWin() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
//        获取handles的值
        String handle1 = driver.getWindowHandle();
//        for循环 判断获取到的handles是否等于handlen1：*每打开一个windows窗口就会生成一个handles的值
        for (String handels : driver.getWindowHandles()) {
            if (handels.equals(handle1)) {
                continue;
            } else {
                driver.switchTo().window(handels);
            }
        }


        driver.findElement(By.linkText("baidu")).click();
    }
}
