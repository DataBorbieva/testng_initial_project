package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;
import page.SignInPage;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {
    WebDriver driver;

    WebDriverWait explicitWait;
    FluentWait fluentWait;
    HomePage carsHomePage;
    SignInPage carsSingInPage;
    //Page objects declarations


    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver("chrome");
        explicitWait = new WebDriverWait(driver, 30);
        fluentWait =  new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
        carsHomePage = new HomePage(driver);
        carsSingInPage = new SignInPage(driver);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}

