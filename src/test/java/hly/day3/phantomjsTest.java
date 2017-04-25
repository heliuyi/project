package hly.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import java.util.WeakHashMap;

/**
 * Created by HLY on 2017/4/17.
 */
public class phantomjsTest {
    @Test
    public void pjsTest() throws InterruptedException {
        System.setProperty("phantomjs.binary.path", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(3000);
        String a = driver.getTitle();
        System.out.print(a);
        driver.quit();

    }
}