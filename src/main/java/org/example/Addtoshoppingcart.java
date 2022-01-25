package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Addtoshoppingcart {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webDriver.get("https://www.bgshop.ru/");

        webDriver.manage().window().setSize(new Dimension(1464, 824));
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//a[text()='Каталог']")))
                .click()
                .build()
                .perform();
        webDriver.findElement(By.xpath("//li[contains(@class, 'nav-item')]//a[text()='Классическая и современная проза']")).click();
        webDriver.findElement(By.xpath("//a[text()='Классическая литература']")).click();

       List<WebElement> products = webDriver.findElements(By.xpath("// div [@ class = 'product']"));
       products.get(0).findElement(By.xpath("//span[@ class = 'btn btn-primary']")).click(); /* в корзину*/

        new WebDriverWait(webDriver, 4);

        Thread.sleep(10000);

        System.out.println("Actual card size = " + webDriver.findElements(By.xpath("//div[@ class = 'card shopping-cart']")).size());
        System.out.println("Expected card size = 1");
        webDriver.quit();

    }
}

