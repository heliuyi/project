package dianzan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/19.
 */
public class launch {
    WebDriver driver;
    @BeforeMethod
    public void launch1(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.11.110:8080/login.act");
        driver.findElement(By.id("mobile")).sendKeys("15888888888");
        driver.findElement(By.id("password")).sendKeys("258963");
        driver.findElement(By.id("vcode")).sendKeys("1111");
        driver.findElement(By.id("button")).click();
        //        显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"header_tagging\"]/a[1]")));
//        获取文本
        String yanzheng = driver.findElement(By.xpath("//*[@class=\"header_tagging\"]/a[1]")).getText();
        Assert.assertEquals(yanzheng, "返回网站首页");
    }
    @Test
    public void launch2() throws InterruptedException {
//        返回首页
        driver.findElement(By.xpath("//*[@class=\"header_tagging\"]/a[1]")).click();
        Thread.sleep(3000);
//        发起项目
        driver.findElement(By.xpath("//*[@class=\"header_right\"]/a[1]")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("reward_selection")));

     WebElement element =   driver.findElement(By.xpath(".//*[@id='parentCategory_ul']/li"));
        Select select = new Select(element);
        select.selectByIndex(2);







//        driver.findElement(By.xpath(".//*[@id='draftform']/section/div/div/div[1]/div[1]/ul/li/div[2]")).click();
        /*driver.findElement(By.xpath("./*//*[@id='draftform']/section/div/div/div[1]/div[2]/a")).click();
        driver.findElement(By.xpath("./*//*[@id='category_ul']/li/div[3]")).click();
        driver.findElement(By.id("next_bt")).click();
       WebElement iframe = driver.findElement(By.tagName("iframe"));
       driver.switchTo().frame(iframe);
       driver.findElement(By.linkText("点击上传项目图片")).click();
*/


    }

}
