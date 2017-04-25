package hly.day1;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by HLY on 2017/4/5.
 */
public class ClosedBrowserTest {
    @Test
    public void clsedFirefox() throws InterruptedException{
        //设置firefox路径
        System.setProperty("webdriver.firefox.bin","E:\\Mozilla Firefox\\firefox.exe");
        //实例化打开 Firefox
        WebDriver driver = new FirefoxDriver();
        //等待5秒
        //Thread.sleep( millis: 5000);
        //关闭当前窗口
        driver.close();

    }
    @Test
    public void clsedFirefox2() throws InterruptedException{
        //设置firefox路径
        System.setProperty("webdriver.firefox.bin","E:\\Mozilla Firefox\\firefox.exe");
        //实例化打开 Firefox
        WebDriver driver = new FirefoxDriver();
        //等待5秒
        //Thread.sleep( millis: 5000);
        //完全退出浏览器
        driver.quit();

    }
    @Test
    public void clsedEdge() throws InterruptedException{
        //设置firefox路径
        System.setProperty("webdriver.firefox.bin","E:\\Mozilla Firefox\\firefox.exe");
        //实例化打开 Firefox
        WebDriver driver = new FirefoxDriver();
        //等待5秒
        //Thread.sleep( millis: 5000);
        //完全退出浏览器
        driver.quit();

    }

}
