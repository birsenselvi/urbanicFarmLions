package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class RegisterPage extends CommonPage {

    @FindBy(xpath = "//input[@name='zipCode']")
    public WebElement zipCode;
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    public WebElement registerSubmitButton;

    @FindBy(xpath = "//input[@id='registration_form_firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='registration_form_middlename']")
    public WebElement middleName;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertWelcome;

    @FindBy(xpath = "//input[@id='registration_form_lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='registration_form_email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='registration_form_plainPassword']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='registration_form_confirmPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButton;


//    @FindBy(css = ".mr-2")
//    public WebElement homeRegisterButton;


    @FindBy(xpath = " (//a[@href='/auth/register'])[1]")
    public WebElement Register;

    @FindBy(xpath = "//div[contains(text(),'Welcome!')]")
    public WebElement WelcomeAlert;


    public void assertRegisterPage() {
        Assert.assertEquals("https://test.urbanicfarm.com/account/weekly-order?register=1", driver.getCurrentUrl());
        System.out.println("Gidilen sayfanin Url-i" + " " + Driver.getDriver().getCurrentUrl());
    }

}

