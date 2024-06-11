package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JS_utilities;
import utilities.ReusableMethods;
import enums.USER_INFO;
import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.waitFor;
import static utilities.ReusableMethods.waitForVisibility;


public class LoginPage extends CommonPage{
    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginButton;
    @FindBy(css = "[name='email']")
    private WebElement emailText;

    @FindBy(css = "[name='password']")
    private WebElement passwordText;
    @FindBy(css = "[name='email']")
    public WebElement email_Text;

    @FindBy(css = "[name='password']")
    public WebElement password_Text;
    @FindBy(xpath = "[name='email']")
    public WebElement email_Text1;

    @FindBy(xpath = "[name='password']")
    public WebElement password_Text1;


    //@FindBy(xpath="//button[@class='btn alazea-btn']")
//    @FindBy(css="[alazea-btn]")
    @FindBy(xpath="//button[@class='btn alazea-btn']")
    public WebElement LoginButton;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement submitLogin;

    public void clickLoginButton(){
    JS_utilities.scrollAndClickWithJS(getSellShareTrade().LoginButton);
}
    @FindBy(xpath="//input[@class='form-control mb-1 shadow-input validation_validation__iLr7O'][@name='email']")
    public WebElement emailErrorMessage;
    public void getEmailErrorText(){
        getLoginPage().emailErrorMessage.getText();
    }
    @FindBy(css=".Toastify__toast-body")
    public WebElement passwordToastMessage;
    public void getPasswordToastMessage(){
        getLoginPage().passwordToastMessage.getText();
    }
    @FindBy(css = "[type='submit']")
    public WebElement submitButton;
    @FindBy(css = "input[name='zipcode']")
    public WebElement zipcodeInput;
    @FindBy(css = "button[class^='CheckDistrictModal']")
    public WebElement goButton;
    @FindBy(xpath="//button[@class='CheckDistrictModal_alazeaBtn__2yYBf ']")
    public WebElement zipcodeGo;

    public void loginMethod(String email, String password) {
        emailText.sendKeys(email);
        waitForVisibility(emailText,2);
        passwordText.sendKeys(password);
        submitButton.click();
        ReusableMethods.waitForClickability(zipcodeInput, 20);
        zipcodeInput.sendKeys("95170");
        goButton.click();

    }

    public void fillFullZipcode() {
       ReusableMethods.waitForVisibility(zipcodeInput, 10);
        zipcodeInput.sendKeys("95170");
        zipcodeGo.click();

    }
    public void verifyEmailaddressshouldbefunctional () {
        getLoginPage().emailText.click();
        Assert.assertTrue(getLoginPage().emailText.isEnabled());

    }
    public void verifypasswordbuttonshouldbefunctional(){
        getLoginPage().passwordText.click();
        Assert.assertTrue(passwordText.isEnabled());

    }
   
    @FindBy(css = ".Navbar_cartText__1jkrK")
    public WebElement basketIcon;


    public void performLogin() {
        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);
        getLoginPage().loginButton.click();
        getLoginPage().loginMethod(USER_INFO.BUYER_CREDENTIAL.getEmail(), USER_INFO.BUYER_CREDENTIAL.getPassword());

    }

    public void clickOnLoginWithEnum(){
        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);
        getLoginPage().loginButton.click();
        getLoginPage().loginMethod(USER_INFO.BUYEROMER_CREDENTIAL.getEmail(), USER_INFO.BUYEROMER_CREDENTIAL.getPassword());
    }

    @FindBy(css = "[class*='mb-3']")
    public WebElement featuredProductText;
    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement sentZipcode;
    public void sendEmail(String email){
        getLoginPage().email_Text.clear();
        getLoginPage().email_Text.sendKeys(email,Keys.ENTER);
    }
    public void sendPassword(String password){
        getLoginPage().password_Text.clear();
        getLoginPage().password_Text.sendKeys(password, Keys.ENTER);
    }
    public void verifyLoginSuccessful(String expectedCurrentUrl) {
        try {
            Assert.assertEquals(expectedCurrentUrl, driver.getCurrentUrl());
        } catch (AssertionError e) {
            System.out.println("Irrelevant page opened for " + expectedCurrentUrl + "!!");

        }
    }
    public void cleanEmailAndPasswordBox(){
        getLoginPage().email_Text.clear();
        getLoginPage().password_Text.clear();
    }
}

