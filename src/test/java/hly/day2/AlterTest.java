package hly.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.java2d.d3d.D3DRenderQueue;

import javax.swing.plaf.PanelUI;

/**
 * Created by HLY on 2017/4/11.
 */
public class AlterTest {
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
    *
    * 1：打开测试主页
    * 2：点击alter按钮
    * 3：点击确定按钮
    * */
    @Test
    public void alertTest() throws InterruptedException {
//        打开测试页面
        driver.get("file:///E:/selenium_html/index.html");
//        定位alert按钮并点击
        driver.findElement(By.className("alert")).click();
//        等待
        Thread.sleep(3000);
        //        把页面的控制权转交给alert弹窗
        Alert alert = driver.switchTo().alert();
//        点击弹窗的确定按钮
        alert.accept();
    }
    /*
    * 1：打开测试页面
    * 2：点击confirm
    * 3：在弹窗上点击取消按钮
    * 4：再次点击确定按钮
    *
    * */
    @Test
    public void confirmTest() throws InterruptedException {
//        打开测试页面
        driver.get("file:///E:/selenium_html/index.html");
//        定位按钮并点击
        driver.findElement(By.className("confirm")).click();
//        等待
        Thread.sleep(3000);
//        把页面的控制权转交给alert弹窗
       Alert alert = driver.switchTo().alert();
//       点击取消
       alert.dismiss();
//       等待
        Thread.sleep(3000);
//        点击确定
        alert.accept();
    }
    /*
    * 1：打开测试页面
    * 2：点击prompt
    * 3：在 弹窗输入文本
    * 4：点击确定
    * 5：再次点击确定
    *
    * */

    @Test
    public void promptTest() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\MicrosoftWebDriver.exe");
        WebDriver webDriver = new EdgeDriver();
//        打开测试页面
        driver.get("file:///E:/selenium_html/index.html");
//        定位操作按钮并点击
        driver.findElement(By.className("prompt")).click();
//        等待3s
        Thread.sleep(3000);
//        把页面控制权转接给弹窗
       Alert alert = driver.switchTo().alert();
//       在弹窗输入内容
       alert.sendKeys("这是什么？");
//       等待3s
        Thread.sleep(3000);
//        弹窗内点击确定
       alert.accept();
//       等待
        Thread.sleep(3000);
//        弹窗内点击确定
       alert.accept();
        Thread.sleep(3000);
       driver.quit();

    }

    /*
    * 1：获取弹窗内的提示文本
    *
    * */
    @Test
    public void alertTest1() throws InterruptedException {
//        打开测试页面
        driver.get("file:///E:/selenium_html/index.html");
//        定位并点击
        driver.findElement(By.className("alert")).click();
//        等待
        Thread.sleep(3000);
//        把页面控制权转交给弹窗
       Alert alert = driver.switchTo().alert();
//       获取文本
      String text = alert.getText();
//      操作弹窗的确定按钮
      alert.accept();
//      校验获取的文本与预期值是否一致
        Assert.assertEquals(text,"请点击确定");
    }

}
