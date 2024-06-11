package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class EventsPage extends CommonPage{

    @FindBy(xpath="//a[@class='Sidebar_smFont__16-hW Sidebar_section_btn__1sp6i h6 '][5]")
    public WebElement myEventsButton;
    @FindBy(xpath = "//button[@class='events-i-organize_btnCreate__2AWbt']")
    public WebElement createNewEvent;
    @FindBy(xpath="//input[@id='title']")
    public WebElement title;
    @FindBy(xpath="//button[@class='btn btn-outline-success mb-1']")
    public WebElement addButton;
    @FindBy(xpath = "//input[@class='form-control location-search-input']")
    public WebElement searchPlacesBox;
    @FindBy(xpath = "//input[@id='postal']")
    public WebElement zipCode;
    @FindBy(xpath = "//button[@class='btn btn-outline-success ml-3']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement toastAlert;
    //Dilek
    @FindBy(css = "//div[text()='You have successfully registered this event. Please check your email.']")
    public WebElement registeredTextMessage;
    @FindBy(css = "a[class*='Sidebar'][href*='events']")
    public WebElement eventButton;
    @FindBy(xpath = "(//button[.='Register'])[1]")
    public WebElement registerBtn;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement NumberOfAttendees;
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBoxTerms;
    @FindBy(css = "button[type='submit']")
    public WebElement approveButton;




}