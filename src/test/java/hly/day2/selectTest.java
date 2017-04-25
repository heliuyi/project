package hly.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by HLY on 2017/4/11.
 */
public class selectTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();


    }
   /* @AfterTest
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }*/
    /*
    * 打开测试界面
    * 下拉选vivo
    * 第二次选择huawei
    * 第三次选择
    * */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
       WebElement selectE1 = driver.findElement(By.id("moreSelect"));
//       实例化select类
        Select select = new Select(selectE1);
//        通过索引选择下拉框：注释数字2代表从第0个开始选择第2个
        select.selectByIndex(2);
        Thread.sleep(3000);
//        通过属性value值来选择下拉框
        select.selectByValue("huawei");
        Thread.sleep(3000);
//        通过文本值来选择下拉框
        select.selectByVisibleText("iphone");
        Thread.sleep(3000);
    }
    /*
    *
    * */
}
