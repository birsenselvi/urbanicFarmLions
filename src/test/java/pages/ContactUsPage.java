package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends CommonPage{

    // WelcomePage -- Header bolumu -- contactUs text
    @FindBy(xpath ="(//a[@class='Navbar_textLink__f6_Al mr-4'])[5]")
    public WebElement contactUsWelcomePage;
   // WelcomePage -- Header bolumu -- contactUs text tiklanir -- Get In Touch title
    @FindBy(xpath ="//h2[@class='ContactUs_title__elsQ3']")
    public WebElement getInTouchTitle;
    // WelcomePage -- Header bolumu -- contactUs text tiklanir -- Your Name textbox
    @FindBy(xpath ="//input[@placeholder='Your Name']")
    public WebElement yourNameBox;
    // WelcomePage -- Header bolumu -- contactUs text tiklanir -- Your Email textbox
    @FindBy(xpath ="//input[@placeholder='Your Email']")
    public WebElement yourEmailBox;
    // WelcomePage -- Header bolumu -- contactUs text tiklanir -- Subject textbox
    @FindBy(xpath ="//input[@placeholder='Subject']")
    public WebElement subjectBox;
    // WelcomePage -- Header bolumu -- contactUs text tiklanir -- Message textbox
    @FindBy(xpath ="//textarea[@placeholder='Message']")
    public WebElement messageBox;
    // WelcomePage -- Header bolumu -- contactUs text tiklanir -- sendMessageButon
    @FindBy(xpath ="//button[@class='ContactUs_alazeaBtn__1JQKf mb-5']")
    public WebElement sendMessageButon;
    // WelcomePage -- Header bolumu -- contactUs text tiklanir -- pleaseValidName
    @FindBy(xpath ="//div[contains(text(),'Please enter a valid name.')]")
    public WebElement pleaseValidName;
 // WelcomePage -- Header bolumu -- contactUs text tiklanir -- pleaseValidEmail
 @FindBy(xpath ="//div[contains(text(),'Please enter a valid email address.')]")
 public WebElement pleaseValidEmail;
 // WelcomePage -- Header bolumu -- contactUs text tiklanir -- Please enter a message with at least 10 characters.yazisi
 @FindBy(xpath ="//div[contains(text(),'Please enter a message with at least 10 characters.')]")
 public WebElement pleaseTenCharacters;
 // WelcomePage -- Header bolumu -- contactUs text tiklanir -- Basarili giris yazisi
 @FindBy(xpath ="//div[@role='alert']")
 public WebElement thanksForYourMessageText;



}
