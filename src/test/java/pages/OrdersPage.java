package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;

import static stepDefinitions.Hooks.driver;


public class OrdersPage extends CommonPage {
    public void clickFarmersMarketButton() {

        getSellShareTrade().farmersMarket.click();
    }

    public void clickOrdersButton() {

        getSellShareTrade().ordersTitle.click();
    }

    public void verifyOrderButtonIsClickable() {

        Assert.assertTrue(getSellShareTrade().ordersTitle.isDisplayed());
    }

    @FindBy(css = ".mb-2:first-of-type")
    public WebElement orderQuickView;

    public void variousContentInTheOrderQuickView() {

        System.out.println(orderQuickView.getText());
    }

    @FindBy(xpath = "//section[1]//article[1]//section[1]//div[2]//div[1]//div[2]//span[2]")
    public WebElement unitPrice;
    @FindBy(xpath = "//section[1]//article[1]//section[1]//div[2]//div[1]//div[2]//span[3]")
    public WebElement qty;
    @FindBy(xpath = "//section[1]//article[1]//section[1]//div[2]//div[1]//div[2]//span[4]")
    public WebElement unitTotal;

    @FindBy(xpath = "//section[1]//article[1]//section[1]//div[2]//div[1]//div[1]//img[1]")
    public WebElement imageOrder;


    public void productNamePriceStockUnitImage() {
        List<String> actual=Arrays.asList("Unit Price: $0.20", "Qty: 1lb", "Unit Total: $0.20");
        List<String> expected=Arrays.asList(unitPrice.getText(), qty.getText(), unitTotal.getText());
        Assert.assertEquals(actual, expected);
        Assert.assertTrue(imageOrder.isDisplayed());
    }

    @FindBy(xpath = "//section[1]//article[1]//section[1]//div[2]//div[1]//div[2]//span[5]")
    public WebElement rateOfProduct;

    public void rateOfProductButtonIsFunctional() {

        Assert.assertTrue(rateOfProduct.isEnabled());
    }

    @FindBy(xpath = "//section[1]//header[1]//article[2]//section[1]//div[1]//a[1]")
    public WebElement viewOrderDetails;
    @FindBy(xpath = "//a[@class='text-capitalize text-success']")
    public WebElement rateTheSeller;

    public void ClickViewOrderDetailsButtonAndRateTheSeller() {
        viewOrderDetails.click();
        rateTheSeller.click();
    }

    public void verifyRateTheSellerIsClickable() {

        Assert.assertTrue(getOrdersPage().rateTheSeller.isEnabled());

    }

    @FindBy(css = ".bQSYRq")
    public WebElement yourComment;
    @FindBy(css = ".mt-2[title='The rating count should be more than 0(zero)']")
    public WebElement submitInRateTheSellerBox;

    @FindBy(xpath = "//div[@class='bg-info p-1 rounded mb-3']//span//*[name()='svg']")
    public WebElement allStars;

    public void verifyRatetheSellerScreenIsOpened() {
        Assert.assertTrue(getOrdersPage().yourComment.isEnabled());
        Assert.assertTrue(getOrdersPage().submitInRateTheSellerBox.isEnabled());
        Assert.assertTrue(getOrdersPage().allStars.isEnabled());

    }

    public void verifyClickRatingStarsToSee() {

        Actions action=new Actions(driver);
        List<WebElement> all_stars=driver.findElements(By.xpath("//div[@class='bg-info p-1 rounded mb-3']//*[local-name()='svg']"));
        for (int i=0; i < 5; i++) {
            action.moveToElement(all_stars.get(i)).build().perform();
            if (i == 4) {
                action.moveToElement(all_stars.get(i)).build().perform();
            }
        }
    }
}




