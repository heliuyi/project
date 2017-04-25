package hly.day1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by HLY on 2017/4/7.
 */
public class findElementTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HLY\\IdeaProjects\\webdriver\\drives\\chromedriver.exe");
         driver = new ChromeDriver();

    }
    /*
    *打开百度页面
    * 定位搜素文本框，通过ID定位
    * */

    @Test
    public void byIDTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.id("kw"));

    }
    /*
   *打开百度页面
   * 定位搜素文本框，通过name定位
   * */
    @Test
    public void byNameTest(){
        driver.get("http://www.baidu.com");
       WebElement keyField = driver.findElement(By.name("wd"));
    }
     /*
   *打开百度页面
   * 定位搜素文本框，通过class属性定位
   * */
     @Test
     public void byClassTest(){
         driver.get("http://www.baidu.com");
         WebElement keyField = driver.findElement(By.className("wd"));
     }
     /*
     * By.linkText只有a标签才能使用
     * 打开百度页面
     *通过linkText来查找
     * */
     @Test
     public void byLinkTextTest(){
         driver.get("http://www.baidu.com");
         WebElement keyField = driver.findElement(By.linkText("糯米"));
     }

    /*
    * By.linkText只有a标签才能使用
    * 打开百度页面
    *通过partiallinkText来查找
    * */
    @Test
    public void byPartialLinkTextTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.partialLinkText("糯"));
    }
    /*
    * By.linkText只有a标签才能使用
    * 打开百度页面
    *通过Xpath来查找百度一下按钮
    * */
    @Test
    public void byXpathTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.xpath(".//*[@id='su']"));
    }

    /*
    * By.linkText只有a标签才能使用
    * 打开百度页面
    *通过CSS来查找百度图片
    * */
    @Test
    public void byCssTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.cssSelector("#lg>img"));
    }



    @AfterMethod
    public void colsefBrowser(){

        driver.quit();
    }



}
