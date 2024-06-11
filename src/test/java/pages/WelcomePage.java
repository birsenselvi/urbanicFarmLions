package pages;

import enums.USER_INFO;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigurationReader;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.waitFor;
import static utilities.ReusableMethods.waitForVisibility;

public class WelcomePage extends CommonPage {
    @FindBy(css = "a[href=\"/home\"][class*='Navbar']")
    private WebElement urbanicFarmText;
    @FindBy(css = "span.h4")
    private WebElement welcomeToUrbanicFarmPopUp;
    @FindBy(css = "p.ProductCard_userName__MaY5h")
    private List<WebElement> sellersNameListonProductCard;
    @FindBy(css = "div.flex-column>span.h6")
    private WebElement sellerNameOnSellerPage;
    @FindBy(css = "select#allCategories")
    private WebElement categoriesDropdown;
    @FindBy(css = "select#allCategories>option")
    private List<WebElement> categoriesListOnWelcomePage;
    @FindBy(css = "#searchMapButton")
    private WebElement searchButtonWelcomePage;
    @FindBy(css = "[class*='p-1'] [class*='ProductCard_minus']")
    private List<WebElement> minusIconsList;
    @FindBy(css = "[class*='p-1'] [class*='ProductCard_plus']")
    private List<WebElement> plusIconsList;
    @FindBy(css = "[class*='p-1'] [class*='addCartBtn']")
    public List<WebElement> addToCartBtnList;
    @FindBy(css = "[style=\"position: relative;\"]>svg")
    private WebElement basketIcon;
    @FindBy(css = "div[class*='Toastify__toast'][role='alert']")
    public WebElement toastMessage;
    @FindBy(css = "div[class*='p-1'] [class*='productTitle']")
    private List<WebElement> productTitleList;
    @FindBy(css = "td[class*='py-3'] button[class*='counter_plus']")
    private List<WebElement> increaseButtonListInBasket;


    public void clickOnUrbanicFarmText() {
        waitForVisibility(urbanicFarmText, 10);
        actions.click(urbanicFarmText).build().perform();
    }

    public void verifyWelcomePageDisplayed() {
        assertTrue(driver.getCurrentUrl().contains("https://test.urbanicfarm.com/home"));
    }

    public void closeWelcomeUrbanicFarmPopUp() {
        try {
            ReusableMethods.isElementPresent(welcomeToUrbanicFarmPopUp);
            welcomeToUrbanicFarmPopUp.click();
        } catch (Exception e) {
            System.out.println("No pop up");
        }
    }

    public void verifySellersNameDisplayedOnProductCardBox() {
        sellersNameListonProductCard.stream().forEach(sellerName -> {
            waitForVisibility(sellerName, 5);
            Assert.assertTrue(sellerName.isDisplayed());
        });
    }

    Random random = new Random();
    int randomSellerNameIndex;
    String expectedSellerName;

    public void clickOnRandomSellerFromWelcomePage() {
        randomSellerNameIndex = random.nextInt(sellersNameListonProductCard.size());
        expectedSellerName = sellersNameListonProductCard.get(randomSellerNameIndex).getText();
        sellersNameListonProductCard.get(randomSellerNameIndex).click();
    }

    public void verifySellerPageIsNavigated() {
        assertTrue(driver.getCurrentUrl().contains("https://test.urbanicfarm.com/point"));
        waitForVisibility(sellerNameOnSellerPage, 5);
        String actualSellerName = sellerNameOnSellerPage.getText();
        assertEquals(expectedSellerName, actualSellerName);
    }

    public void verifyAllCategories(List<String> expectedCategoriesList) {
        List<String> actualCategoriesList = ReusableMethods.getElementsText(categoriesListOnWelcomePage);
        assertTrue(actualCategoriesList.size() == expectedCategoriesList.size() &&
                expectedCategoriesList.containsAll(actualCategoriesList));
    }

    enum ALLCATEGORIESVALUES {
        VEGETABLES_AND_FRUITS_HUB,
        DAIRY_HUB,
        GARDENING_SERVICES_HUB,
        GARDENING_TOOLS_HUB,
        SEED_HUB,
        SEEDLING_AND_SAPLING_HUB,
        COMPOST_HUB,
        WORM_HUB,
        FERTILIZER_HUB,
        TREES_HUB,
        HERBS_AND_FLOWERS_HUB,
        MICROGREENS_HUB
    }

    Select select;

    public void selectaCategoryFromList() {
        select = new Select(categoriesDropdown);
        waitForVisibility(categoriesDropdown, 10);
        select.selectByValue(ALLCATEGORIESVALUES.HERBS_AND_FLOWERS_HUB.name());
        waitForVisibility(searchButtonWelcomePage, 10);
        // actions.click(searchButtonWelcomePage).perform();
        JS_utilities.clickElementByJS(searchButtonWelcomePage);
    }

    public void verifyExpectedCategorySelected() {
        select = new Select(categoriesDropdown);
        WebElement selectedOption = select.getFirstSelectedOption();
        String actualSelectedCategory = selectedOption.getText();
        assert categoriesListOnWelcomePage.stream().filter(
                t -> t.getAttribute("value").equals(ALLCATEGORIESVALUES.HERBS_AND_FLOWERS_HUB.name())).equals(actualSelectedCategory);
        waitFor(10);

    }

    public void assertQuantityIconsonWelcomePageProductsCardBox() {
        minusIconsList.stream().forEach(decreaseIcon -> {
            assertTrue("- icon is not functional", decreaseIcon.isEnabled());
        });
        plusIconsList.stream().forEach(increaseIcon -> {
            assertTrue("+ icon is not functional", increaseIcon.isEnabled());
        });
    }

    public void isAddToCardButtonFunctional() {
        assertTrue("Add to card button is not functional", addToCartBtnList.getFirst().isEnabled());
    }

    public void clickOnCartIcon() {
        waitForVisibility(basketIcon, 10);
        basketIcon.click();
    }

    public void clickIncreaseOuantityButton() {
        waitForVisibility(increaseButtonListInBasket.getFirst(), 10);
        increaseButtonListInBasket.getFirst().click();
    }


    //Meryem Locators
    @FindBy(tagName = "tspan")
    public WebElement urbanicFarmIcon;

    @FindBy(xpath = "//h4[.='Welcome to Urbanic Farm!']")
    public WebElement welcomePopUpMsg;

    @FindBy(css = ".SearchBarOptions_bannerText__11juY")
    public WebElement UrbanicFarmBanner;

    @FindBy(css = "[for='exampleFormControlSelect1']")
    public WebElement whatRULooking4Icon;

    @FindBy(css = "[for='location']")
    public WebElement searchInMilesIcon;

    @FindBy(xpath = "//label[.='Categories']")
    public WebElement categoriesIcon;

    @FindBy(css = (".SearchBarOptions_switchLabel__2o5U9"))
    public WebElement OrganicProduceIcon;

    @FindBy(css = ".SearchBarOptions_slider__1xZ3L")
    public WebElement OrganicProduceRadioBTN;

    @FindBy(id = "mapSearchBox")
    public WebElement searchBox;

    @FindBy(xpath = "//select[@id='location']")
    public WebElement searchInMilesDropdown;

    @FindBy(xpath = "//select[@id='allCategories']")
    public WebElement categoriesDropdownMenu;


    @FindBy(id = "searchMapButton")
    public WebElement searchButton;

    @FindBy(css = "[data-marker='marker1181'] .p-2 > .m-0")
    public WebElement priceInfo;

    @FindBy(css = "[data-marker='marker1648'] .p-2 > .m-0")
    public WebElement deliveryOption;

    @FindBy(xpath = "//div[@class='row m-0']/div[2]//span[.='Organic']")
    public WebElement unitType;

    @FindBy(xpath = "//div[@class='row m-0']/div[2]//p[@class='m-0 mb-1 text-start text-white ProductCard_productTitle__3K4rg']")
    public WebElement displayedResult4Apple;

    @FindBy(css = ".SearchBarOptions_sliderButton__1oak8 > [xmlns='http://www.w3.org/2000/svg']")
    public WebElement searchBarOptions;

    @FindBy(id = "sellerRate")
    public WebElement sellerRatingDropdown;

    @FindBy(id = "productRate")
    public WebElement productRatingDropdown;


    public void userGoesToHomePageAndLogsInWithBuyerENUM() {

        driver.get(ConfigurationReader.getProperty("url"));

        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);

        getLoginPage().loginButton.click();

        getLoginPage().loginMethod(USER_INFO.BUYEROMER_CREDENTIAL.getEmail(), USER_INFO.BUYEROMER_CREDENTIAL.getPassword());

    }

    public void userGoesToHomePageAndLogsInWithSellerENUM() {

        driver.get(ConfigurationReader.getProperty("url"));

        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);

        getLoginPage().loginButton.click();

        getLoginPage().loginMethod(USER_INFO.SELLEROMER_CREDENTIALS.getEmail(), USER_INFO.SELLEROMER_CREDENTIALS.getPassword());

    }

    //gul'locators
    @FindBy(xpath = "//table[@class='table table-borderless table-hover undefined']//tbody//tr//td[5]")
    public List<WebElement> removeProductFromCart;
    @FindBy(xpath = "//button[@class='collapsible_toggle__1oudq']")
    public WebElement enterPromoCode_button;
    @FindBy(css = "[placeholder='your promo code']")
    public WebElement enterPromoCode_text;
    @FindBy(id = "promo-code")
    public WebElement enterPromoCode_apply;
    @FindBy(xpath = "(//td[@class='text-end py-3'])[1]")
    public WebElement cartTotal_subtotal;
    @FindBy(xpath = "//p[@class='mb-0 pb-0']")
    public WebElement cartTotal_subtotal2;
    @FindBy(xpath = "(//td[@class='text-end py-3'])[3]")
    public WebElement cartTotal_total;
    @FindBy(css = "button.Basket_checkOutBtn__1946L")
    public WebElement proceedToCheckOut;
    @FindBy(css = "button.proceed_btn__vZFGE[type='button']")
    public WebElement next;


    //From MEHSETI

    @FindBy(css = "[title='Zip code should be digit']")
    public WebElement zipCodeWindow;

    @FindBy(xpath = "//button[@class='col-12 mt-2 w-75 btn btn-success FeaturedProductCard_addCartBtn__2QCpK']")
    public List<WebElement> addToCartList;

    @FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement nextButton;

    @FindBy(xpath = "//button[contains(text(),'Prev')]")
    public WebElement prevButton;


    @FindBy(css = "[class='proceed_step-text__6Z8TH']")
    public List<WebElement> proceedStepText;

    @FindBy(xpath = "//button[contains(text(),'Go To Payment')]")
    public WebElement goToPayment;

    @FindBy(css = "#inputFirstName")
    public WebElement firstname;

    @FindBy(css = ".Navbar_cartText__1jkrK")
    public WebElement ProductsNumbersAddedToBasket;

    @FindBy(xpath = "//td[@class='py-3 align-middle text-end']")
    public WebElement deleteProductfromBasket;

    @FindBy(xpath = "//p[contains(text(),'Payment successful')]")
    public WebElement paymentSuccessfull;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordPaypal;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailPaypal;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement loginForLoginPaypal;

    @FindBy(css = "#btnLogin")
    public WebElement loginPaypal;

    @FindBy(xpath = "//button[@id='btnLogin']")
    public WebElement loginButton;

    @FindBy(css = "#payment-submit-btn")
    public WebElement completePurchase;

    @FindBy(css = "[title='rate our service']")
    public WebElement rateOurServices;

    @FindBy(css = "[class='cursor-pointer']")
    public List<WebElement> star;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    public WebElement submitStar;

    @FindBy(xpath = "//a[contains(text(),'View order detail')]")
    public WebElement viewOrderDetail;

    @FindBy(css = ".collapsible_toggle__1oudq")
    public List<WebElement> ordererName;

    @FindBy(css ="header[class='card-header py-1 OrderCard_order-card-header__container__QAmfL']")
    public List<WebElement> orderDetail;

    @FindBy(css = "[class='list-group cursor-default']")
    public List<WebElement>orderStatus;

    @FindBy(xpath = "//a[contains(text(),'View order detail')]")
    public List<WebElement> lastOrderDetail;

    @FindBy(css = "[class='d-block text-muted']")
    public List<WebElement> deliveryInfo;

    @FindBy(xpath = "(//div[@class='Notifications_notificationNumContainer__myxVE'])[1]")
    public WebElement notificationNumber;

    @FindBy(css = "[class='Notifications_notificationDownIcon__2wt8u']")
    public WebElement closeNotification;
    @FindBy(xpath = "//span[contains(text(),'Mark all as read')]")
    public WebElement markAsRead;

    public void clickNextAndVerifyReviewAndAddress(int clickCount) {
        // Next butonuna belirtilen sayıda ardışık tıkla
        for (int i = 0; i < clickCount; i++) {
            nextButton.click();
        }
        boolean reviewFound = false;
        boolean addressFound = false;

        for (WebElement stepText : proceedStepText) {
            String text = stepText.getText();
            if (text.contains("Review")) {
                reviewFound = true;
            } else if (text.contains("Address")) {
                addressFound = true;
            }
        }
        Assert.assertTrue("Review step text not found after clicking Next button " + clickCount + " times.", reviewFound);
        Assert.assertTrue("Address step text not found after clicking Next button " + clickCount + " times.", addressFound);
    }

    public void clickPrevAndVerifyReviewAndAddress(int clickCount) {
        for (int i = 0; i < clickCount; i++) {
            prevButton.click();
        }
        boolean adressFound = false;
        boolean InformationFound = false;
        for (WebElement stepText : proceedStepText) {
            String text = stepText.getText();
            if (text.contains("Address")) {
                adressFound = true;
            } else if (text.contains("Information")) {
                InformationFound = true;
            }
        }
        Assert.assertTrue("Adress step text not found after clicking Prev button " + clickCount + " times.", adressFound);
        Assert.assertTrue("Information step text not found after clicking Prev button " + clickCount + " times.", InformationFound);
    }

    public void clickStars() {
        star.get(0).click();
        for (int i = 1; i < star.size(); i++) {
            star.get(i).click();
            ReusableMethods.waitFor(3);
        }

    }

    public void clearEmailField() {
        emailPaypal.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Tüm içeriği seç
        emailPaypal.sendKeys(Keys.BACK_SPACE); // Seçili içeriği sil
    }
    public void AssertionStatus(){


        }
    }








