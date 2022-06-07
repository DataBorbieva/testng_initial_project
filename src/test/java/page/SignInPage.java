package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='sds-heading--1 sds-page-section__title']")
    public WebElement singInHeader;

    @FindBy(xpath = "//p[@class='sds-page-section__title--sub signup-block']")
    public WebElement header2;

    @FindBy(xpath = "//input[@name='user[email]']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='user[email]']/following-sibling::label")
    public WebElement emailInputLabel;

    @FindBy(css = "#password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//input[@id='password']/following-sibling::label")
    public WebElement passwordInputLabel;

    @FindBy(className = "sds-helper-text")
    public WebElement passwordWarning;

    @FindBy(xpath = "//a[@href='/forgot_password/?email=']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[@class='sds-disclaimer ']")
    public WebElement privacyStatement;

    @FindBy(xpath = "//button[@class='sds-button']")
    public WebElement singInButton;

    @FindBy(xpath = "//h3[@class='social-title sds-heading--3']")
    public WebElement socialMediaHeader;


    @FindBy(xpath = "//a[@class='sds-button facebook-button']")
    public WebElement faceBookButton;

    @FindBy(xpath = "//a[@class='sds-button apple-button']")
    public WebElement appleButton;

    @FindBy(xpath = "//a[@class='sds-button google-button']")
    public WebElement googleButton;

    @FindBy(id = "email")
    public WebElement getEmailInputBox;

    @FindBy(id = "password")
    public WebElement getPasswordInputBox;

    @FindBy(css = ".sds-notification__content")
    public WebElement errorMessage;



}

