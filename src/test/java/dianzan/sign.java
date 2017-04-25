package dianzan;

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
 * Created by HLY on 2017/4/19.
 */
public class sign {
    WebDriver driver;

    @BeforeMethod
    public void openDZ() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.11.110:8080/login.act");
    }
    @Test
    public void sign(){
        driver.findElement(By.id("mobile")).sendKeys("15666666666");
        driver.findElement(By.id("password")).sendKeys("258963");
        driver.findElement(By.id("vcode")).sendKeys("1111");
        driver.findElement(By.id("button")).click();
        //        显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"header_tagging\"]/a[1]")));
//        获取文本
        String faqixiangm = driver.findElement(By.xpath("//*[@class=\"header_tagging\"]/a[1]")).getText();
        Assert.assertEquals(faqixiangm, "返回网站首页");
    }
    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
