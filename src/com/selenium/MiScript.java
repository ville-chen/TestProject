package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by admin on 2017/5/11.
 */
public class MiScript {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/developer/Python36/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            buyMi6s("https://detail.tmall.com/item.htm?spm=a1z10.1-b-s.w5003-15969925173.1.1712Ry&id=545865605975&scene=taobao_shop&skuId=3296026737646", driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.close();
            //driver.quit();
        }
    }

    public static void buyMi6s(String url, WebDriver driver) {
        //先登录
        driver.get("https://login.tmall.com/");
        try {
            //等待20s,完成登录和弹窗处理
            Thread.currentThread();
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS); //隐式等待时间不对
        //跳转到宝贝页面
        driver.get(url);
        //在秒杀开始前2分30秒内
        WebDriverWait wait = new WebDriverWait(driver, 150);
        By buyLocation = By.xpath(".//*[@id='J_LinkBuy']");
        WebElement buyBtn = driver.findElement(buyLocation);
        wait.until(ExpectedConditions.elementToBeClickable(buyLocation));
        //点击购买
        buyBtn.click();
        try {
            //运费险
            driver.findElement(By.xpath(".//*[@id='postageInsurance_0515bc544de83fa36a058025ca7cc41c']/div[2]/label/input")).click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //取消匿名
            driver.findElement(new By.ByXPath(".//*[@id='anonymous_1']/label/input")).click();
            //提交订单
            driver.findElement(new By.ByCssSelector(".go-btn")).click();
        }
    }

    /**
     * js插件脚本
     */
    private static String webDriverJs() {
        return "";
    }
}
