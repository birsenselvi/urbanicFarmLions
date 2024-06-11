package pages;

import enums.USER_INFO;
import myInterface.IPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import java.util.List;
import java.util.stream.Collectors;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

public class ProductPage extends CommonPage implements IPage {

    @Override
    public void Login() {
        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 2);
        getLoginPage().loginButton.click();
        getLoginPage().loginMethod(USER_INFO.BUYEROMER_CREDENTIAL.getEmail(), USER_INFO.BUYEROMER_CREDENTIAL.getPassword());

    }

    public void sendZipcode() {
        ReusableMethods.waitForVisibility(getLoginPage().zipcodeGo, 2);
        getLoginPage().zipcodeGo.sendKeys("95170");
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void assertProductNamePriceStockUnit() {
        Assert.assertTrue(getProductPage().addNewProduct_Price.isDisplayed());
        Assert.assertTrue(getProductPage().addNewProduct_Name.isDisplayed());
    }

    @FindBy(xpath = "//a[contains(text(),'Your products/services')]")
    public WebElement yourProductService_navbar;

    @FindBy(xpath = "//div[@class='row m-0 p-2 align-items-center']/span")
    public List<WebElement> allhubs;

    @FindBy(xpath = "//a[contains(@class,'HubManagement_productTitle__2ke7R')]")
    public List<WebElement> allAddedProducts;

    @FindBy(xpath = "//datalist[@id='productName']/option")
    public List<WebElement> allProductsNames;

    @FindBy(xpath = "//span[contains(@class,'HubManagement_badge__2jPOb')]")
    public List<WebElement> allProductsStatus;

    @FindBy(css = "[class*='font-weight']")
    public List<WebElement> eklenmisUrunlerinIsimleri;

    @FindBy(xpath = "//input[@id='selectProductName']")
    public WebElement addNewProduct_Name;

    @FindBy(xpath = "//input[@id='hubManagePrice']")
    public WebElement addNewProduct_Price;

    @FindBy(xpath = "//input[@id='hubManageStock']")
    public WebElement addNewProduct_Stock;

    @FindBy(xpath = "//select[@id='selectProductUnit']")
    public WebElement addNewProduct_Unit;

    @FindBy(xpath = "//button[@id='hubManageSaveButton']")
    public WebElement addNewProduct_Submit;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement update;

    @FindBy(xpath = "//a[@class='btn btn-danger']")
    public WebElement delete;

    @FindBy(css = "[name='isOrganic']")
    public WebElement organicButton;

    @FindBy(css = "[name='isTrade']")
    public WebElement TradeButton;

    @FindBy(css = "#hubManageTradeDesc")
    public WebElement DescreptionTrade;
    @FindBy(xpath = "(//span[@class='UpdateProduct_slider__2ZAUg UpdateProduct_round__14rjT'])[1]")
    public WebElement organic;

    @FindBy(xpath = "(//span[@class='UpdateProduct_slider__2ZAUg UpdateProduct_round__14rjT'])[2]")
    public WebElement trade;

    @FindBy(xpath = "//input[@name='tradeDescription']")
    public WebElement tradeDescription;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement price;

    @FindBy(xpath = "//select")
    public WebElement unitType;

    @FindBy(css = "div[class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement updatedAlert;

    @FindBy(xpath = "(//div[@class='text-center mb-2']/a)[1]")
    public WebElement yes;

    @FindBy(xpath = "(//div[@class='text-center mb-2']/a)[2]")
    public WebElement no;

    @FindBy(xpath = "//div[contains(text(),'has been successfully deleted')] ")
    public WebElement deleteAlert;
    @FindBy(xpath = "//h3")
    public WebElement lastApprovedProduct;

    @FindBy(xpath ="//a[contains(text(),'Your requested products/services')]")
    public WebElement yourRequestedProductsServices;



    public String eklenebilecekUrun() {
        List<String> allProducts = allProductsNames
                .stream()
                .map(t -> t.getAttribute("value"))
                .collect(Collectors.toList());

        List<String> addedProducts = allAddedProducts
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        allProducts.removeAll(addedProducts);
        String eklenecekUrun = allProducts.getFirst();
        return eklenecekUrun;
    }

    public String getState(String productName) {
        return driver.findElement(By.xpath("//a[@title='" + productName + "']/../../span")).getText();

    }

    @Override
    public void Clickname() {
        // Eklenmiş ürünlerin isimlerini ve statülerini aliyor
        List<String> eklenmisUrunIsimleri = eklenmisUrunlerinIsimleri.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> productStatusList = allProductsStatus.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

// Son onaylanmış bir ürünün ismini bulup ona tıkliyor
        int sonOnaylanmisIndex = -1;
        for (int i = 0; i < productStatusList.size(); i++) {
            if (productStatusList.get(i).equals("APPROVED")) {
                sonOnaylanmisIndex = i;
            }
        }

        if (sonOnaylanmisIndex != -1) {
            String productName = eklenmisUrunIsimleri.get(sonOnaylanmisIndex);
            WebElement productElement = eklenmisUrunlerinIsimleri.get(sonOnaylanmisIndex);
            JS_utilities.scrollAndClickWithJS(productElement);
            ReusableMethods.waitFor(3);
            System.out.println("Clicked on the last approved product: " + productName);
        } else {
            System.out.println("No approved product found!");
        }
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        if (check && !element.isSelected()) {
            element.click();
        } else if (!check && element.isSelected()) {
            element.click();
        }
    }
}










