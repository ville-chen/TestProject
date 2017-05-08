package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by admin on 2017/5/8.
 */
public class SeleniumTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.bin", "D:/developer/MozillaFirefox/firefox.exe");
        //System.setProperty("webdriver.chrome.driver", "D:\\developer\\Python36\\chromedriver.exe");
        WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        //driver.quit();
    }
}