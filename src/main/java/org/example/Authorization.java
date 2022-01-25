package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Authorization {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");            /* не загр картинка*/

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
       webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);          /*не явные ожидания*/
        webDriver.get("https://www.bgshop.ru/");

        webDriver.manage().window().setSize(new Dimension(1464,824));

        By authFormLocator = By.xpath("//form[contains(@class,'bootstrap-frm2')]");
new WebDriverWait(webDriver,5).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));

        WebElement authForm =webDriver.findElement(authFormLocator);

        webDriver.findElement(By.xpath("//*[@id='icon_cab1']")).click();

        authForm.findElement(By.xpath("//*[@id='email-modal']")).sendKeys("Pirozhok");
        authForm.findElement(By.name("Password")).sendKeys("Zqxwce");
        authForm.findElement(By.xpath("//i[contains(@class, 'fas fa-sign-in-alt')]")).click();
        Thread.sleep(3000);
        webDriver.quit();
    }
}


