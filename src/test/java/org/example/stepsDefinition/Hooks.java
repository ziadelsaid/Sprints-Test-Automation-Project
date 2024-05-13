package org.example.stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @Before
    public static void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        Thread.sleep(3000);

        driver.manage().window().maximize();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.navigate().to("https://demo.nopcommerce.com/");

        Thread.sleep(2000);
    }


    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
