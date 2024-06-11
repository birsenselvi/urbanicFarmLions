package pages;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

import static org.junit.Assert.*;
import static stepDefinitions.Hooks.driver;


public class HomePage extends CommonPage {


    @FindBy(xpath = "(//li/a[@href='/account/weekly-order'])[3]")
    public WebElement footer_ScheduledDelivery;

    public void verifyFooterLinks(String expectedCurrentUrl) {
        try {
            Assert.assertEquals(expectedCurrentUrl, driver.getCurrentUrl());
        } catch (AssertionError e) {
            System.out.println("Irrelevant page opened for " + expectedCurrentUrl + "!!");

        }

    }


    //Mehseti's locators
    @FindBy(xpath = "(//button[@class='btn text-uppercase'][1])")
    public WebElement sellbutton;

    @FindBy(xpath = "//button[contains(text(),'share')]")
    public WebElement sharebutton;

    @FindBy(xpath = "//button[contains(text(),'trade')]")
    public WebElement tradebutton;

    @FindBy(css = " div.section-5_btn__2qFR0 > button")
    public WebElement registerNowButton;

    @FindBy(css = " div.Footer_social-links__FYd8U a:nth-child(2) ")
    public WebElement linkedinButton;

    @FindBy(css = ".mr-4[href='/contact-us']")
    public WebElement contacUsInHomePage;
    @FindBy(xpath = "//h2[@class='ContactUs_title__elsQ3']")
    public WebElement getInTouch;
    @FindBy(xpath = "//a[@class=\"d-block\"]")
    public WebElement address;
    @FindBy(xpath = "//address[contains(text(),\"UrbanicFarm Inc., 1159 Kelez Dr San Jose, California, 95120, United States\")]")
    public WebElement insideOfAddress;


    @FindBy(css = "div.Footer_social-links__FYd8U a:nth-child(1)")

    public WebElement facebookIcon;
    @FindBy(xpath = "div[@class='x1i10hfl x1ejq31n xd10rxx x1sy0etr x17r0tee x1ypdohk xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8 x1hl2dhg xggy1nq x87ps6o x1lku1pv x1a2a7pz x6s0dn4 x14yjl9h xudhj91 x18nykt9 xww2gxu x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x78zum5 xl56j7k xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 xc9qbxq x14qfxbe x1qhmfi1']")
    public WebElement closeButtonOfRelevantWindowOfFacebook;

    @FindBy(xpath = "//a[@class='Navbar_textLink__f6_Al mr-4'][normalize-space()='Blog']")
    public WebElement blogButton;

    @FindBy(xpath = "//button[@class='section-7_btn1__YvVpM']")
    public WebElement whatsNewsButton;

    @FindBy(xpath = "//button[normalize-space()='Post Your Goods']")
    public WebElement postYourGoodsButton;


    // US008HomePageOprations
    @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div/a[contains(text(),\"About Us\")]")
    public WebElement accountUsOfTheHeader;
    @FindBy(xpath = "//h2[contains(text(),\"OUR SERVICES\")]")
    public WebElement ourServicestxt;
    @FindBy(xpath = "//a[contains(text(),\"contact us\")]")
    public WebElement contactUsOfFooter;

    @FindBy(xpath = "//*[text()='Support the local food movement']")
    public WebElement LocalSellerDiscover;


    @FindBy(xpath = "//h2[@class='ContactUs_title__elsQ3']")
    public WebElement getInTouchTxt;


    @FindBy(xpath = "(//a[@href='/account/weekly-order'])[1]")
    public WebElement FarmersMarket;

    @FindBy(xpath = "//a[@href='/auth/login?route=/account/weekly-order']")
    public WebElement PopUpClose;

    @FindBy(xpath = "//p[contains(text(),'Sell Your Products')]")
    public WebElement sellYourProduct;
    @FindBy(css = "[href='/mobile']:not(li.text-capitalize>[href='/mobile'])")
    public WebElement getTheApp;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[4]/div[3]/article/header/h1")
    public WebElement socialNetworking;


    // gul's locators
    @FindBy(xpath = "//ul[@class='Footer_listCon__29kxp pl-0']//a[text()='Farmers Market']")
    public WebElement farmersMarketFooter;
    @FindBy(xpath = "//div[@class='CheckDistrictModal_x-btn__sVOij']//a")
    public WebElement PopUp;
    @FindBy(xpath = "//a[@href='/terms-of-service']")
    public WebElement TermsOfService;
    @FindBy(xpath = "//span[@class='Navbar_cartText__1jkrK']")
    public WebElement go_to_cart_button;

    // Hazel's locators
    @FindBy(css = ".Section11_shopButton__WbZY9")
    public WebElement registerNowBtn;

    @FindBy(css = ".SocialLogins_login_btn__2b3rz")
    public WebElement signInWithGoogle;


    //Meryem's Locators
    @FindBy(xpath = "//h2[.='Invest in UrbanicFarm']")
    public WebElement investInUrbanicFarmButton;

    @FindBy(css = ".section-9_gofunderButton__32gaj")
    public WebElement goWefunderButton;

    @FindBy(xpath = "//a[.='Privacy policy']")
    public WebElement privacyPolicyLink;

    @FindBy(css = ".mb-5")
    public WebElement PrivacyPolicyPage;

    @FindBy(xpath = "//*[text()='Support the local food movement']")
    public WebElement DiscoverLocalVendors;


    @FindBy(css = ".btn")
    public WebElement logInBTN;

    @FindBy(css = "[href='/account/hub']")
    public WebElement yourProductService_navbar;


    //Hatice's locators
    @FindBy(xpath = "//a[text()='about us']")
    public WebElement aboutUsButtonOnTheFooter;


    public void assertAboutUsButtonIsClickable() {
        ReusableMethods.verifyElementEnabled(aboutUsButtonOnTheFooter);
    }

    public void assertAboutUsPageIsVisible(String actualUrlOfAboutUsPage) {
        actualUrlOfAboutUsPage = driver.getCurrentUrl();
        String expectedUrlOfAboutUs = "https://test.urbanicfarm.com/about";
        assertEquals(expectedUrlOfAboutUs, actualUrlOfAboutUsPage);
    }


    //Mehseti's operations

    public void assertUrlHompage() {
        Assert.assertEquals("https://test.urbanicfarm.com/", driver.getCurrentUrl());

    }


    public void assertionRegisterPage() {

        String currentTitle= driver.getTitle().toLowerCase();
        assertTrue(currentTitle.contains("register"));
    }


    public void assertLinkedin() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("linkedin.com"));

    }


    // Hazel's locators(2)
    @FindBy(xpath = "//div[@class='Footer_footer-col__2BbbT']//a[@href='https://urbanicfarm.com/blog/']")
    public WebElement footerBlogBtn;

    @FindBy(xpath = "//h1[@style='color: white;']")
    public WebElement textOfBlogPage;

    @FindBy(xpath = "//a[@href='tel:+16696965906']")
    public WebElement phone;

    @FindBy(xpath = "//ul[@class='Footer_listCon__29kxp pl-0']/li[6]/span")
    public WebElement phoneNumber;

    @FindBy(css = ".mr-2")
    public WebElement homeRegisterButton;


}



