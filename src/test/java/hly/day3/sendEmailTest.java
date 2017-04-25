package hly.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/17.
 */
public class sendEmailTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");


    }
    @Test
    public void sendEmail(){
//        登陆163
        LoginTest.login(driver,"18217185096","heliuyi520**" );

//        点击写信按钮
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        driver.findElement(By.className("js-component-emailcontainer nui-multiLineIpt C-multiLineIpt nui-ipt")).sendKeys("v_lyhe");
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("这是测试自动发送邮件");
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("D:\\test.jpg");
//       定位iframe
        WebElement fram = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(fram);
        driver.findElement(By.xpath("/html/body")).sendKeys("这是个内容");
//        drive控制权转接回来
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[text()='发送']"));
//        isDisplayed判断元素是否显示
       Boolean bl = driver.findElement(By.xpath(".//*[@class='sQ1']/h1[1]")).isDisplayed();
        Assert.assertTrue(bl);


    }
}
