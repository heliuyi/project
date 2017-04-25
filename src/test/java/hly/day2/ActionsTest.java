package hly.day2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.PackageUtils;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

/**
 * Created by HLY on 2017/4/10.
 */
public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
        driver = new ChromeDriver();


    }

    @Test
    public void clickTest() throws InterruptedException {
//        打开点赞
        driver.get("http://www.dianzan.it" );
//        定位专题按钮
        WebElement newslink = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div/a[2]"));
//        点击新闻按钮
        newslink.click();
//        获取当前页面url
        String url = driver.getCurrentUrl();

//        校验url是否一致
        Assert.assertEquals(url,"http://www.dianzan.it/specialindex.act");


    }
    /*
    * 打开点赞网站
    * 输入点赞
    * 点击搜索
    * 校验
    * */
    @Test
    public void sendkeysTest(){
//        打开点赞网
        driver.get("http://www.dianzan.it");
//        定位搜素框
        WebElement keys =  driver.findElement(By.id("globalSearchName"));
//        在搜素框输入“点赞”
        keys.sendKeys("点赞");
//        定位搜素按钮
        WebElement button = driver.findElement(By.xpath("/html/body/header/div[1]/div[1]/a"));
//        点击搜索按钮
        button.click();
//     获取实际值“获取title方法”
       String title = driver.getTitle();
//     WebElement text = driver.findElement(By.xpath("//*[@id=\"con1_1\"]/div[1]/div[1]/h4"));
//        校验预期值跟实际值
       Assert.assertEquals(title,"点赞");
    }
    @Test
    public void sendkeysTest2() throws InterruptedException {
//        打开点赞网
        driver.get("http://www.baidu.com");
//        定位搜素框
        Thread.sleep(9000);
        WebElement keys =  driver.findElement(By.id("kw"));
//        在搜素框输入“selenium”
        keys.sendKeys("selenium");
//        定位搜素按钮
        WebElement button = driver.findElement(By.id("su"));
//        点击搜索按钮
        button.click();
//     获取实际值“获取title方法”
        String title = driver.getTitle();
//     WebElement text = driver.findElement(By.xpath("//*[@id=\"con1_1\"]/div[1]/div[1]/h4"));
//        校验预期值跟实际值
        Assert.assertEquals(title,"selenium_百度搜索");
    }
    /*
    * 清空输入的文本“clear ”
    *
    * */
    @Test
    public void clearTest2() throws InterruptedException {
//        打开点百度
        driver.get("http://www.baidu.com");
//        定位搜素框
        Thread.sleep(9000);
        WebElement keys =  driver.findElement(By.id("kw"));
//        在搜素框输入“selenium”
        keys.sendKeys("selenium");
//        等待3s
        Thread.sleep(3000);
//        清空输入
        keys.clear();
    }
    /*
    * 打开百度首页
    * 获取新闻文本
    *
    * */
    @Test
    public void clearTest() throws InterruptedException {
//        打开点百度
        driver.get("http://www.baidu.com");
//        等待
        Thread.sleep(9000);
        String text = driver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(text, "新闻");


    }

    /*
    * 打开百度首页
    * 获取文本框的tagname
    * 校验是否为input
    *
    *
    * */
    @Test
    public void getTagNameTest() throws InterruptedException {
//        打开百度
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
//        定位元素并获取tagName
       String  tagName = driver.findElement(By.id("kw")).getTagName();
//       校验tagname
       Assert.assertEquals(tagName,"input");



    }


    /*
    * 打开百度
    * 判断按钮的文本是否是百度一下
    * */
    @Test
    public void getTest() throws InterruptedException {
//        打开百度
        driver.get("http://www.baidu.com");
//        等待
        Thread.sleep(9000);
//        定位按钮并获取默认文本值
       String  attvalue = driver.findElement(By.id("su")).getAttribute("value");
//       校验
       Assert.assertEquals(attvalue,"百度一下");
    }

//    判断一个元素是否展示
    /*
    * 打开百度首页
    * 判断是否显示百度一下按钮
    * */
    @Test
    public void isDisplayedTest() throws InterruptedException {
//        打开百度
        driver.get("http://www.baidu.com");
//        等待
        Thread.sleep(9000);
//        定位百度一下按钮，判断文本是否显示
       Boolean b = driver.findElement(By.id("su")).isDisplayed();
//       校验是否显示
       Assert.assertTrue(b);

    }
    /*
    * 判断选择框是否选取isSelected
    * */
    @Test
    public void isSelected() throws InterruptedException {
//        打开测试地址
        driver.get("file:///E:/selenium_html/index.html");
//        定位选择框
       WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
//       等待
       Thread.sleep(3000);
//       点击选择
       element.click();
//       判断是否选择isSelected
      Boolean b = element.isSelected();
//        校验是否正确"assertTrue"
       Assert.assertTrue(b);

    }
    /*
    * 判断按钮是否是被激活状态
    * 打开测试页面
    * 判断submint按钮是否处于未激活状态
    * */
    @Test
    public void isEnableTest(){
//        打开测试页面
        driver.get("file:///E:/selenium_html/index.html");
//        定位按钮并判断是否选中
       Boolean b1 = driver.findElement(By.name("buttonhtml")).isEnabled();
//       校验是否没有选中“assertFalse”
       Assert.assertFalse(b1);
    }
    /*
    * 截图百度首页
    * */
    @Test
    public void shotTest(){
        driver.get("http://www.baidu.com");
        File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\test.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @AfterTest
     public void quitBrowser(){
       driver.quit();
     }

}
