package hly.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.RasterOp;
import java.util.List;

/**
 * Created by HLY on 2017/4/14.
 */
public class ActiosTest2 {
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
    * 打开百度
    * 在百度一下按钮上右键
    * */
    @Test

    public void righeClickTest(){
//        打开百度
        driver.get("http://www.baidu.com");
//        定位元素并实例化
      WebElement buttonBaidu = driver.findElement(By.id("su"));
//      实例化actions這个类
      Actions action = new Actions(driver);
//      在百度一下按钮 右键
      action.contextClick(buttonBaidu).perform();

    }
    /*
    * 双击
    * 1：打开百度
    * 2：在百度一下按钮上双击
    * */
    @Test

    public void doubleClickTest(){
//        打开百度
        driver.get("http://www.baidu.com");
//        定位元素并实例化
        WebElement buttonBaidu = driver.findElement(By.id("su"));
//      实例化actions這个类传入driver
        Actions action = new Actions(driver);
//      在百度一下按钮 右键*perform执行操作
        action.doubleClick(buttonBaidu).perform();

    }
    /*
    * 打开测试界面
    * 鼠标移动到actions按钮
    * 显示Hello worle
    * */
    @Test

    public void moveToTest() throws InterruptedException {
//        打开百度
        driver.get("file:///E:/%E8%BD%AF%E4%BB%B6/Tencent/783490349/FileRecv/selenium_html/index.html");
//        定位元素并实例化
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
//      实例化actions這个类传入driver
        Actions action = new Actions(driver);
//      鼠标移动到element实例化的按钮上然后执行*perform执行操作
        action.moveToElement(element).perform();
        Thread.sleep(3000);
//        定位显示的文本并获取文本值
        String hello = driver.findElement(By.xpath("//*[@id=\"over\"]/div")).getText();
//        校验预期与实际值
        Assert.assertEquals(hello,"Hello World!");


    }
    @Test
    public void testDrop() throws InterruptedException {
//        打开测试界面
        driver.get("file:///E:/%E8%BD%AF%E4%BB%B6/Tencent/783490349/FileRecv/selenium_html/dragAndDrop.html");
//      定位操作的元素
        WebElement element =  driver.findElement(By.id("drag"));
//        实例化actions這个类
      Actions actions = new Actions(driver);
//      调用actions這个类拖动的方法dragAdnDropBy,选择操作的元素，拖到的位置。加执行操作
      actions.dragAndDropBy(element,300,600).perform();
      Thread.sleep(3000);
    }
    @Test
    public void dropTest(){
//        打开测试界面
        driver.get("file:///E:/%E8%BD%AF%E4%BB%B6/Tencent/783490349/FileRecv/selenium_html/dragAndDrop.html");
//        通过ID定位操作的元素，
       WebElement element = driver.findElement(By.id("drag"));
//       通过xpath定位要拖到的位置
       WebElement element1 = driver.findElement(By.xpath("/html/body/h1"));
//       实例化一个actions类
       Actions actions = new Actions(driver);
//       调用actions类里的方法clickAndHold，操作的是要拖动的元素，moveToElement移动到element这个元素，执行
       actions.clickAndHold(element)
               .moveToElement(element1)
               .release(element)
               .perform();
    }
    @Test
    public void moreSelectTest() throws InterruptedException {
//        打开测试界面
        driver.get("file:///E:/%E8%BD%AF%E4%BB%B6/Tencent/783490349/FileRecv/selenium_html/index.html");
//        定位要操作的元素并给他好多方法
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
//       取出所有的元素
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
//       实例化actions方法
        Actions actions = new Actions(driver);
//       按住shift**Keys提供了键盘
        actions.keyDown(Keys.CONTROL)
//               点击第一个元素
                .click(list.get(1))
//               点击第三个元素
                .click(list.get(2))
//               释放shift
                .keyUp(Keys.CONTROL)
//               执行
                .perform();
        Thread.sleep(3000);


    }

    @Test
    public void savaHtml() throws AWTException, InterruptedException {
//        打开百度
        driver.get("http://www.baidu.com");
//        实例化robot這个类
        Robot robot = new Robot();
//        调用robot這个类的方法keyPress按住某个按钮，按住ctrl
        robot.keyPress(KeyEvent.VK_CONTROL);
//        调用robot这个类的方法keyPress,按住s
        robot.keyPress(KeyEvent.VK_S);
//        按住enter
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
//        释放键盘按住的值
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    @Test
    public void uploadTest() throws InterruptedException {
//        打开测试界面
        driver.get("file:///E:/%E8%BD%AF%E4%BB%B6/Tencent/783490349/FileRecv/selenium_html/index.html");
//        定位操作的元素，输入上传的文件地址及文件名
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\HLY\\Pictures\\80M58PICTcs_1024.jpg");
        Thread.sleep(5000);
    }

}
