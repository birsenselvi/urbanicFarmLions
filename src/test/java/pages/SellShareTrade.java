package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellShareTrade extends CommonPage {
    @FindBy(css = ".Navbar_addHub__USGHm>span")
    public WebElement sellShareTrade;

    @FindBy(xpath = "//a[normalize-space()='Sell-Share-Trade']")
    public WebElement sellShareTrade2;

    @FindBy(xpath = "//a[text()='Scheduled Delivery']")
    public WebElement scheduledDelivery;
    @FindBy(xpath = "//span[text()='Sell-Share-Trade']")
    public WebElement sellShare;

    @FindBy(xpath = "//input[@name='zipcode']")
    public WebElement zipCode;
    @FindBy(xpath = "//button[text()='go']")
    public WebElement go;


    @FindBy(css = "a[href$='events'][class^='Sidebar']")
    public WebElement eventsOnTheSideBar;


    @FindBy(xpath = "//span[.='Sell-Share-Trade']")
    public WebElement sellShareTradeButton;

    @FindBy(css = ".ml-2")
    public WebElement logOutButton;

    @FindBy(css = ".section-2_title__1fvmB")
    public WebElement logOutPage;
    @FindBy(xpath = "//*[text()='Address']")
    public WebElement adress;

    @FindBy(xpath = "//*[text()='Sell-Share-Trade']")
    public WebElement sellShareTradeTitle;
    @FindBy(xpath = "//*[text()='Delivery & Pick up settings']")
    public WebElement deliveryPickUpSettingsTitle;
    @FindBy(xpath = "//*[text()='Subscriptions']")
    public WebElement subscriptionsTitle;
    @FindBy(xpath = "//*[text()='Orders']")
    public WebElement ordersTitle;
    @FindBy(xpath = "//*[text()='Events']")
    public WebElement eventsTitle;
    @FindBy(xpath = "//*[text()='My Events']")
    public WebElement myEventsTitle;
    @FindBy(xpath = "//*[text()='Scheduled Delivery']")
    public WebElement scheduledDeliveryTitle;
    @FindBy(xpath = "//*[text()='Delivery Scheduler']")
    public WebElement deliverySchedulerTitle;
    @FindBy(css = ".mr-4[href=\"/account/weekly-order\"]")
    public WebElement farmersMarket;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailButton;


    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordButton;


    @FindBy(xpath = "//@placeholder='Enter your zip code']")
    public WebElement LoginButton;


    @FindBy(xpath = "//input[@name='zipcode']")
    public WebElement zipCodeButton;


    @FindBy(xpath = "//button[@class='CheckDistrictModal_alazeaBtn__2yYBf ']")
    public WebElement goButton;

    @FindBy(xpath = "//a[@class='Navbar_textLink__f6_Al mr-4 ml-1']")
    public WebElement contactUsButton;

    @FindBy(xpath = "//div[@class='Navbar_addHub__USGHm']//span[contains(text(),'Sell-Share-Trade')]")
    public WebElement sell_share_tradeButton;

    @FindBy(xpath = "//a[@title='My Account']//img[@alt=\"mustafa's picture\"]")
    public WebElement userNameButton;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    public WebElement ContactUs1;

}
