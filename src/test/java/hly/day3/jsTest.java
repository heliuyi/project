package hly.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/17.
 */
public class jsTest {
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
    @Test
    public void jsTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("var a = document.getElementById(\"kw\").setAttribute(\"value\",\"asdfgh\"); .document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\");");
        Thread.sleep(3000);
    }
}
