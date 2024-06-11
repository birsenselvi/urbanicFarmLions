package pages;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static stepDefinitions.Hooks.driver;

public class AccountPage extends CommonPage{
    @FindBy(css = "[href=\"/account/home\"][class^='Sidebar']")
    public WebElement accountOnTheSideBar;
    @FindBy(id = "QRCode")
    public WebElement QRCode;
    @FindBy(xpath = "(//td[@class='Profile_td__w9cTI'])[2]")
    public WebElement fullNameOnAccountPage;
    @FindBy(css = ".pb-2")
    public WebElement emailOnAccountPage;
    @FindBy(css = "[type=\"button\"]")
    public WebElement editButton;
    @FindBy(id = "download_svg__download")
    public WebElement downloadButton;

    @FindBy(css = "span>[class=\"cursor-pointer\"]:first-child")
    public WebElement copyButton;

    @FindBy(css = "input[type='file']")
    public WebElement chooseFileButton;

    @FindBy(css = ".mt-3>button[class$='primary']")
    public WebElement saveButton;
    @FindBy(css = "div.Profile_avatarCont__33DKR>div>img[class=\"rounded-circle bg-white\"]")
    public WebElement profilePicture;

    @FindBy(css = "input[class=\"form-control \"]")
    public WebElement phoneNumberInput;

    @FindBy(css = "[title=\"Toggle the menu\"]")
    public WebElement toggleMenu;

    @FindBy(css = "[type=\"button\"][class*='secondary']")
    public WebElement cancelButton;

    @FindBy(css = "div.invalid-number-message")
    public WebElement invalidPhoneNumberMessage;

    @FindBy(css = "div>[role=\"alert\"]")
    public WebElement updateSuccessMessage;

    @FindBy(css = "tr>.Profile_phoneInputCont__1MutD")
    public WebElement phoneNumberText;
    public void uploadFile(){
        String filePath = System.getProperty("user.dir") + "/src/test/resources/download.jpg";
        chooseFileButton.sendKeys(filePath);
    }
    public void verifyFileUploaded(){

        Assert.assertEquals("download.jpg",chooseFileButton.getText());
    }


}
