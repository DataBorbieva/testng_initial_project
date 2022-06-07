package scripts;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Project_02 extends Base{
    final String expectedHeading1 = "Sign in";
    final String expectedHeading2 = "New to Cars.com? Sign up. Are you a dealer?";
    final String expectedEmail = "Email";
    final String expectedPassword = "Password";
    final String expectedErrorWarning = "Minimum of eight characters";
    final String expectedPrivacyStatement = "By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.";
    final String expectedSocialMediaHeader = "Connect with social";
    final String expectedFaceBookButtonText = "Sign in with Facebook";
    final String expectedGoogleButtonText = "Sign in with Google";
    final String expectedAppleButtonText = "Sign in with Apple";
    final String inputEmail= "johndoe@gmail.com";
    final String inputPassword = "abcd1234";
    final String getExpectedErrorWarning = "We were unable to sign you in.\nYour email or password was not recognized. Try again soon.";



    @Test(priority = 1, description = "Test Case 1: Validate Cars.com Sign in page form")
    public void validateEmailAndPasswordForCars() {
        driver.get("https://www.cars.com/");

        carsHomePage.singInButton.click();

        assertEquals(carsSingInPage.singInHeader.getText(), expectedHeading1);
        assertEquals(carsSingInPage.header2.getText(), expectedHeading2);
        assertEquals(carsSingInPage.emailInputLabel.getText(), expectedEmail);
        assertTrue(carsSingInPage.emailInputBox.isEnabled() && carsSingInPage.emailInputBox.isDisplayed());
        assertTrue(carsSingInPage.passwordInputBox.isEnabled() && carsSingInPage.passwordInputBox.isDisplayed());
        assertEquals(carsSingInPage.passwordInputLabel.getText(), expectedPassword);
        assertEquals(carsSingInPage.passwordWarning.getText(),expectedErrorWarning);
        assertTrue(carsSingInPage.passwordWarning.isDisplayed());
        assertTrue(carsSingInPage.forgotPasswordLink.isEnabled());
        assertEquals(carsSingInPage.privacyStatement.getText(),expectedPrivacyStatement);
        assertTrue(carsSingInPage.passwordWarning.isDisplayed());
        assertTrue(carsSingInPage.singInButton.isEnabled() &&carsSingInPage.singInButton.isDisplayed());

    }

    @Test(priority = 2,description = "Test Case 2: Validate Cars.com Sign in page social media section")
    public void validateSocialMediaPage(){
        driver.get("https://www.cars.com/");
        carsHomePage.singInButton.click();

        assertEquals(carsSingInPage.socialMediaHeader.getText(),expectedSocialMediaHeader);

        assertEquals(carsSingInPage.faceBookButton.getText(),expectedFaceBookButtonText);
        assertTrue(carsSingInPage.faceBookButton.isDisplayed() && carsSingInPage.faceBookButton.isEnabled());

        assertEquals(carsSingInPage.appleButton.getText(),expectedAppleButtonText);
        assertTrue(carsSingInPage.appleButton.isDisplayed() && carsSingInPage.appleButton.isEnabled());

        assertEquals(carsSingInPage.googleButton.getText(),expectedGoogleButtonText);
        assertTrue(carsSingInPage.googleButton.isDisplayed() && carsSingInPage.googleButton.isEnabled());

    }

    @Test(priority = 3,description = "Test Case 3: Validate user cannot sign in to Cars.com with invalid")
    public void validateThatUserCannotLoginWithInvalidCredentials(){
        driver.get("https://www.cars.com/");
        carsHomePage.singInButton.click();
        carsSingInPage.getEmailInputBox.sendKeys(inputEmail);
        carsSingInPage.getPasswordInputBox.sendKeys(inputPassword);
        carsSingInPage.singInButton.click();
        assertEquals( carsSingInPage.errorMessage.getText(),getExpectedErrorWarning);
    }
}

