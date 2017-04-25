package hly.day1;

import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.testng.annotations.*;

/**
 * Created by HLY on 2017/3/29.
 */
public class TestNGDemo1 {
    //Beforetest在所有test运行之前都执行一次
    //BeforeMethod在程序之前之前运行一次
    //Aftertest在程序运行之后运行一次
    //AfterMethod在所有case运行后都运行一次

    @BeforeTest
    public void beforceTest01(){
        System.out.print("這是一个BeforceTest注解！");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.print("這是一个BeforeMethod注解！");
    }
     @Test
    public void testCase1(){
         System.out.print("這是@test的一个注解，case1！");
     }

     @Test
    public void testCase2(){
        System.out.print("這是@test的第二个注解，case2！");
     }
     @AfterTest
    public  void afterTest(){
        System.out.print("這是AfterTest的注解！");

     }
     @AfterMethod
     public  void afterMethod() {
         System.out.print("這是AfterMethod的注解！");
     }



}

