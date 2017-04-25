package dianzan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/19.
 */
public class register {
    WebDriver driver;

    @BeforeMethod
    public void openDZ() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.11.110:8080/login.act");
    }

    @Test
    public void rejister() {
        driver.findElement(By.className("blue_color_blue")).click();
        /*String handle1 = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles);
        }*/
        driver.findElement(By.id("registermobile")).sendKeys("15899999999");
        driver.findElement(By.id("vcode")).sendKeys("1111");
        driver.findElement(By.id("scode")).sendKeys("111111");
        driver.findElement(By.id("password")).sendKeys("258963");
        driver.findElement(By.id("button")).click();
//        显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/header/div[1]/div[2]/a")));
//        获取文本
        String faqixiangm = driver.findElement(By.xpath("html/body/header/div[1]/div[2]/a")).getText();
        Assert.assertEquals(faqixiangm, "发起项目");
    }


    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}


