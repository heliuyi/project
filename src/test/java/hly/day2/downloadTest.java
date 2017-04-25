package hly.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/14.
 */
public class downloadTest {
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
    * 下载搜狗输入法
    * 保存到F盘
    * */
    @Test
    public void download() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
       WebElement keys = driver.findElement(By.id("wd"));
        keys.sendKeys("搜狗输入法下载");
        driver.findElement(By.id("su")).click();
        driver.findElement(By.xpath("//*[@id=\"1\"]/div[2]/div/div[1]/div[2]/p[6]/a")).click();
        Thread.sleep(9000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
        Thread.sleep(5000);











    }
    @Test
    public void downloadTest(){
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList","2");
        firefoxProfile.setPreference("browser.download.dir","D:\\soft");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-strea,,applica");
    }
}
