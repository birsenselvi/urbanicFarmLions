package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.waitFor;


public class AddressPage extends CommonPage{
  @FindBy(css = "#addressTitle")
  public WebElement addressTitle;
  @FindBy(css = "#address")
  public WebElement address;
  @FindBy(css = "#states")
  public WebElement states;
  @FindBy(css = "#citiesDataIdAddAddress")
  public WebElement city;
  @FindBy(css = "#postal")
  public WebElement postalZip;
  @FindBy(css = "#isDefault")
  public WebElement markAsADeliveryAddressCheckBox;
  @FindBy(css = "#isSellerAddress")
  public WebElement markAsASellerAddressCheckBox;
  @FindBy(xpath = "//a[text()='Address']")
  public WebElement address1;
  @FindBy(xpath = "//span[contains(text(),'Walmart Supercenter, Park Place, Secaucus, NJ, USA')]")
  public WebElement walmart;
  @FindBy(xpath = "(//label[text()='Address Title*'])[2]")
  public WebElement addressTitleTitle;
  @FindBy(xpath = "(//label[contains(text(),'Address*')])[2]")
  public WebElement addressStarTitle;
  @FindBy(xpath = "(//label[contains(text(),'State*')])[2]")
  public WebElement stateTitle;
  @FindBy(xpath = "(//label[contains(text(),'City*')])[2]")
  public WebElement cityTitle;
  @FindBy(xpath = "(//label[contains(text(),'Postal/Zip*')])[2]")
  public WebElement postZip;
  @FindBy(xpath = "(//label[contains(text(),'Mark as a delivery address')])[2]")
  public WebElement markAsADeliveryAddressTitle;
  @FindBy(xpath = "(//label[contains(text(),'Mark as a sales address')])[2]")
  public WebElement markAsASalesAddressTitle;
  @FindBy(xpath = "//input[@id='addressTitle']")
  public WebElement  inputAddressTitle;
  @FindBy(xpath = "//input[@id='address']")
  public WebElement  inputAddress;
  @FindBy(xpath = "//input[@id='postal']")
  public WebElement  inputPostalZip;
  public void assertBackroundColor(WebElement webElement,String rgba){
      waitFor(2);
     // System.out.println("getAddressPage().inputState.getCssValue(\"background-color\") = " + getAddressPage().inputState.getCssValue("background-color"));
      //String expectedBackgroundColor="rgba(233, 236, 239, 1";
      String expectedBackgroundColor=rgba;
      String actualBackgroundColor=webElement.getCssValue("background-color");
      Assert.assertEquals(expectedBackgroundColor,actualBackgroundColor);

  }
  @FindBy(xpath = "//span[contains(text(),'My delivery address')")
  public WebElement txt;
  public void removeAddAdressInOthers(){
    getAddressPage().myDeliveryAddressHeader.click();
    String expected="My delivery address";
    String actual=getAddressPage().txt.getText();
    assertEquals(expected,actual);

  }
  @FindBy(xpath = "//button[text()='ADDRESSES']")
  public WebElement relevantAddressPagetxt;
  @FindBy(xpath = " //span[contains(text(),'My sales address')]")
  public WebElement relevantAddressPagetxtsales;
  @FindBy(xpath = "//button[contains(text(),'Remove')]")
  public WebElement removeButton2;
  @FindBy(css = "[role=\"alert\"][class*=\"Toastify__toast\"]")
  public WebElement toastmsg;
  @FindBy(xpath = "//button[@name='delivery']")
  public WebElement myDeliveryAddressHeader;
  @FindBy(xpath = "//button[contains(text(),'My Sales Address')]")
  public WebElement mySalesAddressHeader;
  @FindBy(xpath = "//button[contains(text(),'Others')]")
  public WebElement othersHeader;
  @FindBy(xpath = "//a[normalize-space()='Address']")
  public WebElement adressButton;
  @FindBy(xpath = "(//button[text()='Cancel'])[2]")
  public WebElement cancelButton;
  @FindBy(xpath = "//span[normalize-space()='Minneapolis, MN, USA']")
  public WebElement cityName;
  @FindBy(xpath =" //input[@id='postal']")
  public WebElement zipCode;
  @FindBy(xpath = "//button[@class='btn btn-outline-success']")
  public WebElement addNewAddressButton;
  @FindBy(xpath = "//input[@placeholder='Search Places ...']")
  public WebElement searchPlacesButton;
  @FindBy(xpath = "//span[contains(text(),'Loughborough University, Epinal Way, Loughborough,')]")
  public WebElement myAddressButton;
  @FindBy(xpath = "//span[normalize-space()='London Luton Airport (LTN), Airport Way, Luton, UK']")
  public  WebElement mySalesAddressBtn;
  @FindBy(xpath = "//input[@name='isDefault']")
  public  WebElement markAsADeliveryAddressButton;
  @FindBy(xpath = "//input[@id='isSellerAddress']")
  public  WebElement markAsASalesAddress;
  @FindBy(xpath = "//button[@type='submit']")
  public WebElement submitButton;

    @FindBy(css = "button[class='mr-2 btn btn-outline-warning']")
    public WebElement editButton;



    @FindBy(xpath = "//input[@id='addressTitle']")
    public  WebElement UpdatesAddressDetailsButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement successAlertButton;

    @FindBy(xpath = "//button[@class='btn btn-outline-danger']")
    public WebElement removeButton;

    @FindBy(xpath = "//button[@class='btn btn-primary ml-4']")
    public WebElement noButton;

    @FindBy(xpath = "//button[@class='btn btn-outline-danger']")
    public WebElement removeAgainButton;

    @FindBy(xpath = "//button[@class='btn btn-primary mr-4']")
    public WebElement yesButton;
    @FindBy(xpath = "//div[contains(text(),'Address deleted']")
    public WebElement successAlertButton2;

    @FindBy(css = "button[class='btn btn-outline-success ml-3']")
    public WebElement submitButton2;
    @FindBy(xpath = "//span[contains(text(),Troy,Ny)]")
    public WebElement myAddressButton2;
    @FindBy(xpath = "//button[@class='btn btn-outline-success']")
    public WebElement addNewAddressButton2;
    @FindBy(xpath= "//div[@class='alert alert-warning ']")
    public WebElement alerts;
    @FindBy(xpath= "//button[@name='sales']")
    public WebElement mySalesAddressButton;
    @FindBy(css= "button[name='nonSelected']")
    public WebElement othersButton;
    @FindBy(css="div[class=\"Toastify__toast-body toastr_custom-toastr__iiU37\"]")
    public WebElement toastAlert;
    @FindBy(css="div[class=\"Toastify__toast-body toastr_custom-toastr__iiU37\"]")
    public WebElement deletedToastAlert;




}










