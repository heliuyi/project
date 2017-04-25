package hly.day1;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

/**
 * Created by HLY on 2017/4/5.
 */
public class BrowserActionTest {
    WebDriver driver;

    /*
    * 打开edge浏览器
    *打开百度首页
    * 关闭浏览器
    * */
    @Test
    public void getTest(){
//        设置edge路径
        System.setProperty("webdriver.edge.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\MicrosoftWebDriver.exe");
//        打开edge
         driver = new EdgeDriver();
//        打开百度
        driver.get("http://www.baidu.com");
//        等待5s
//        Thread.sleep(millis: 5000);
//        关闭浏览器
        driver.quit();
    }
    /*
    * 打开edge浏览器
    *打开百度首页
    * 后退
    * 关闭浏览器
    *
    *
    * */
    @Test
    public void backTest() throws InterruptedException {
//        设置edge路径
        System.setProperty("webdriver.edge.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\MicrosoftWebDriver.exe");
//        打开edge
        driver = new EdgeDriver();
//        打开百度
        driver.get("http://www.baidu.com");
//        等待3s
        Thread.sleep(3000);
//        后台
        driver.navigate().back();
//        等待3s
        Thread.sleep(3000);
//        关闭浏览器
        driver.quit();
    }
    @Test
     /*
    * 打开edge浏览器
    *打开百度首页
    * 前进
    * 关闭浏览器
    * */
    public void forwardTest() throws InterruptedException {
//        设置edge路径
        System.setProperty("webdriver.edge.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\MicrosoftWebDriver.exe");
//        打开edge
        driver = new EdgeDriver();
//        打开百度
        driver.get("http://www.baidu.com");
//        等待3s
        Thread.sleep(3000);
//        后台
        driver.navigate().forward();
//        等待3s
        Thread.sleep(3000);
//        关闭浏览器
        driver.quit();
    }
    /*
    * 打开firefox浏览器
    *打开google
    * 刷新
    * 关闭浏览器
    * */
    @Test
    public void refreshTest() throws InterruptedException {
//       设置edge路径
        System.setProperty("webdriver.edge.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\MicrosoftWebDriver.exe");
//        打开edge
       driver = new EdgeDriver();
//        打开谷歌
        driver.get("http://www.google.com.hk");
//        等待3s
        Thread.sleep(3000);
//        刷新
        driver.navigate().refresh();
//        等待3s
        Thread.sleep(3000);
//        关闭浏览器
        driver.quit();
    }

  /*
    * 打开edge浏览器
    *打开百度
    * 设置窗口大小600*800
    * 最大化
    * 等待3s
    * 关闭浏览器
    * */

    @Test
    public void winTest() throws InterruptedException {
//        设置edge路径
        System.setProperty("webdriver.edge.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\MicrosoftWebDriver.exe");
//        打开edge
        driver = new EdgeDriver();
//        设置浏览器打开尺寸
        Dimension dimension = new Dimension(600,800);
//        实例化dimension
        driver.manage().window().setSize(dimension);

//        等待3s
        Thread.sleep(3000);
//        最大化窗口
        driver.manage().window().maximize();
//        等待3s
        Thread.sleep(3000);
//        退出浏览器
        driver.quit();
    }
//    获取当前URL
    /*
    * 打开edge浏览器
    *打开百度
    * 等待3s
    * 获取当前页面的URL
    * 校验当前页面URL是不是百度地址
    * 关闭浏览器
    * */



    @Test
    public void getURLTest() {
//       设置edge路径
        System.setProperty("webdriver.edge.driver", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\MicrosoftWebDriver.exe");
//        打开edge
        driver = new EdgeDriver();
//        打开百度
        driver.get("http://www.baidu.com");
//        获取url
//        driver.getCurrentUrl();有返回值
        String url = driver.getCurrentUrl();
//        打印获取的地址
        System.out.print("获取到的URL是： " + url);
//        校验地址
        Assert.assertEquals(url, "http://www.baidu.com/");
        driver.quit();
    }
    @AfterTest//所有程序执行完最后关闭浏览器
    public void close(){
        driver.quit();
    }
    @BeforeMethod//所有程序开始之前先执行
    public void openEdge(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\MicrosoftWebDriver.exe");
//        打开edge
        driver = new EdgeDriver();

    }

}
