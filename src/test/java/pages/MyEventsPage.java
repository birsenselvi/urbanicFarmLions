package pages;

import com.github.javafaker.Faker;
import enums.NEWEVENT_INFO;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import enums.COLOR;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JS_utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.*;

public class MyEventsPage extends CommonPage {
    Faker faker = new Faker();
    public String eventTitle;
    public String DilekEvent;

    @FindBy(css = "a[class*='Sidebar'][href*='events-i-organize']")
    public WebElement myEventsOnSidebar;
    @FindBy(css = "button[class*=\"events-i-organize_btnCreate\"]")
    public WebElement createNewEventsButton;
    @FindBy(id = "title")
    public WebElement titleForNewEvent;
    @FindBy(id = "address2")
    public WebElement addressInput;
    @FindBy(id = "date")
    public WebElement dateInput;
    @FindBy(id = "time")
    public WebElement timeInput;
    @FindBy(id = "fee")
    public WebElement feeInput;
    @FindBy(id = "duration")
    public WebElement durationInput;
    @FindBy(id = "attendeeLimit")
    public WebElement attendeeLimitInput;
    @FindBy(id = "tac")
    public WebElement termsAndConditionInput;
    @FindBy(css = "[type=\"submit\"]")
    public WebElement submitEventButton;
    @FindBy(css = "[class*='notificationNavContent']>span>svg:not(div[style=\"position: relative;\"]>div>span>svg)")
    public WebElement notificationIcon;
    @FindBy(css = "p[class*=\"notificationDownContentTitle\"]")
    public WebElement notificationContentTitle;
    @FindBy(css = ".Notifications_sliderNone__31Amf")
    public List<WebElement> unreadNotificationsList;
    @FindBy(css = ".Notifications_slider__CvU2V")
    public List<WebElement> readedNotificationsList;
    @FindBy(css = "div[class*='filterButtonContainer']>div:nth-of-type(2)>span")
    public WebElement markAllAsReadText;
    @FindBy(css = "p.Notifications_emptyText__3BV2W")
    public  WebElement noUnreadNotificationsText;
    @FindBy(css = "span[class*='notificationEmptyIcon']>svg>g>path[d*='M356']")
    public WebElement closeNotificationIcon;
    @FindBy(css = "div[style=\"visibility: visible;\"]>div div>button:nth-of-type(1)")
    public WebElement yesButtonToDelete;

    @FindBy(xpath = "//button[text()='Go Back']")
    public WebElement GoBackButton;

    @FindBy(xpath = "//div[text()='Please enter a valid title.']")
    public WebElement WarningMessageForTitle;

    @FindBy(xpath = "//div[text()='Please select an address.']")
    public WebElement WarningMessageForAddress;

    @FindBy(xpath = "//div[text()='Please fill this field']")
    public WebElement WarningMessageForDate;

    @FindBy(xpath = "//div[text()='Please fill this field']")
    public WebElement WarningMessageForTime;
    @FindBy(xpath = "//div[text()='Please enter a valid duration.']")
    public WebElement WarningMessageForDuration;

    @FindBy(xpath = "//div[text()='Please enter a valid attendee limit.']")
    public WebElement WarningMessageForAttendeeLimit;

    @FindBy(xpath = "//div[text()='Please enter valid terms and conditions.']")
    public WebElement WarningMessageForTermsAndConditions;



    @FindBy(xpath = " (//button[@name='delete'])[1]")
    private WebElement lastDeleteBtn;




    public void createNewEvent(){
        createNewEventsButton.click();
        waitFor(2);
        titleForNewEvent.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getEventTitle());
        addressInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAddress());
        dateInput.sendKeys(getTomorrowsDate());
        timeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTime());
        clearValue(feeInput);
        feeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getFee());
        durationInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getDuration());
        attendeeLimitInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAttendeeLimit());
        termsAndConditionInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTermsAndConditions());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForClickability(submitEventButton,5);
        JS_utilities.scrollAndClickWithJS(submitEventButton);


    }


    /**
     * This method is for to get date of tomorrow
     *
     * @author Yasemin
     * @since 01.03.2024
     */
    public String getTomorrowsDate() {
        // get a calendar instance, which defaults to "now"
        Calendar calendar = Calendar.getInstance();
        // get a date to represent "today"
        Date today = calendar.getTime();
        System.out.println("today:    " + today);
        // add one day to the date/calendar
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        // now get "tomorrow"
        Date tomorrow = calendar.getTime();
        //convert date to String
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(tomorrow);

        return date;

    }
    public void verifyNotificationWidgetDisplayed(){
        String expectedTitle="Notifications";
        String actualTitle=notificationContentTitle.getText();
        assertTrue(notificationContentTitle.isDisplayed());
        assertEquals(expectedTitle,actualTitle);
    }

    public void assertFilterButtonTextinNotificationWidget( String expectedText){
        WebElement webElement= driver.findElement(By.xpath("//span[contains(text(),'"+expectedText+"')]"));
        assertEquals(expectedText,webElement.getText());
    }
    public void verifyNoUnreadNotifications(String expectedText){
        assertEquals(expectedText,noUnreadNotificationsText.getText());
    }
    public void verifyNotificationReadOrNot(String expectedTooltipText){
        String read="Mark Read";
        String unread="Mark Unread";

        if(unreadNotificationsList.getFirst().getCssValue("background-color").equals(COLOR.NOTIFICATION_RADIO_BUTTON_GREEN.getHEX())){
            assertEquals(expectedTooltipText,read);
            unreadNotificationsList.getFirst().click();
        }else if(readedNotificationsList.getFirst().getCssValue("background-color").equals(COLOR.NOTIFICATION_RADIO_BUTTON_WHITE.getHEX())){
            assertEquals(expectedTooltipText,unread);
            readedNotificationsList.getFirst().click();
        }
    }

    public void deleteMyOwnEvent(){
        WebElement deleteMyOwnEvent=driver.findElement(By.xpath("//h5[text()='"+NEWEVENT_INFO.YASEMIN_NEWEVENT.getEventTitle()+"']/../div/div/div[2]/div/div/button[@name='delete']"));
        waitForVisibility(deleteMyOwnEvent,5);
        JS_utilities.scrollAndClickWithJS(deleteMyOwnEvent);
        yesButtonToDelete.click();

    }

    public void deleteDilekEvent(){
        WebElement deleteDilekEvent=lastDeleteBtn;
        JS_utilities.scrollAndClickWithJS(lastDeleteBtn);
        yesButtonToDelete.click();
    }



    //Hatice's locators and methods
    @FindBy(xpath = "//button[text()='My Scheduled Events']")
    private WebElement myScheduledEventsButton;

    @FindBy(xpath = "(//button[@class='btn btn-primary ml-4'])[1]")
    private WebElement noButtonForDelete;

    @FindBy(xpath = "//button[text()='Go Back']")
    private WebElement goBackButton;

    @FindBy(xpath = "(//h5[text()='Are you sure you want to delete this event ?'])[1]")
    private WebElement popUpMessageForDelete;

    @FindBy(xpath = "(//button[text()='Yes'])[1]")
    private WebElement yesButtonForDelete;

    @FindBy(xpath = "//div[text()='Event deleted']")
    private WebElement toastMessageAfterDelete;


    public void clickMyScheduledEventsButton(){
        myScheduledEventsButton.click();
    }

    public String getStringDateForUSA(){
        LocalDate localDate=LocalDate.now().plusDays(20);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return localDate.format(formatter);
    }

    public String eventName() {
        String eventName=faker.name().title();
        return eventName;
    }
    public void eventCreation(){
        createNewEventsButton.click();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        waitForClickability(submitEventButton, 5);

    }
    public void goBackButtonVisibility(){
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        waitForClickability(GoBackButton, 5);

    }

    public void createNewEventsForUSA() {
        eventTitle= eventName();

        createNewEventsButton.click();
        waitFor(2);
        titleForNewEvent.sendKeys(eventTitle);
        addressInput.sendKeys("3015");
        dateInput.sendKeys(getStringDateForUSA());
        timeInput.sendKeys("11:00");
        clearValue(feeInput);
        feeInput.sendKeys("40");
        durationInput.sendKeys("60");
        attendeeLimitInput.sendKeys("20");
        termsAndConditionInput.sendKeys("+10");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        waitForClickability(submitEventButton, 5);
        JS_utilities.scrollAndClickWithJS(submitEventButton);
    }

    public void createEventDilek(){

        createNewEventsButton.click();
        waitFor(2);
        titleForNewEvent.sendKeys("DilekEvent");
        addressInput.sendKeys("3015");
        dateInput.sendKeys(getTomorrowsDate());
        timeInput.sendKeys("11:00");
        clearValue(feeInput);
        feeInput.sendKeys("0");
        durationInput.sendKeys("60");
        attendeeLimitInput.sendKeys("20");
        termsAndConditionInput.sendKeys("ghjkdkddlldldld");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        waitForClickability(submitEventButton,5);
        actions.click(submitEventButton).build().perform();


    }


    public void clickOnDeleteForSelectedEvent() {
        driver.navigate().refresh();
        WebElement element = driver.findElement(By.xpath("//h5[text()='"+eventTitle+"']/..//button[text()='Delete']"));
        JS_utilities.scrollAndClickWithJS(element);
    }

    public void verifyThereIsNoButton(String buttonName) {
        waitForVisibility(noButtonForDelete,5);
        assertEquals(buttonName,noButtonForDelete.getText());
        Assert.assertTrue(noButtonForDelete.isEnabled());
    }

    public void verifyPopUpMessageForDelete(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();
        for (int i = 0; i < maps.size(); i++) {
            String popUpMessage = maps.get(i).get("PopUp Message");
            assertEquals(popUpMessage,waitForVisibility(popUpMessageForDelete,4).getText());
        }
    }

    public void clickYesForDelete(){
        yesButtonForDelete.click();
    }

    public void verifyToastMessageAfterDelete(String expectedToastMessage){
        waitForVisibility(toastMessageAfterDelete,5);
        assertEquals(expectedToastMessage,toastMessageAfterDelete.getText());
    }

    public void verifyThereIsNoEventAnymoreOnTheListOfEvent(String eventTitle){
        driver.navigate().refresh();
        boolean isElementFound=isElementWithTextPresent(eventTitle);
        assertFalse("element founded !",isElementFound);
    }

    private boolean isElementWithTextPresent(String eventTitle){
        try {
            WebElement element=driver.findElement(By.xpath("//h5[text()='"+eventTitle+"']"));
            JS_utilities.scrollIntoViewJS(element);
            return true; // if find the element
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false; // if could not find the element
        }
    }

    @FindBy(xpath = "//div[contains(text(),'Please enter a valid title.')]")
    public WebElement invalidTitleText;
    @FindBy(xpath = "//div[contains(text(),'Please fill this field')]")
    public WebElement invalidDateText;
    @FindBy(xpath = "//div[contains(text(),'Please fill this field')]")
    public WebElement invalidTimeText;
    @FindBy(xpath = "//div[contains(text(),'Please select an address.')]")
    public WebElement invalidAddressText;
    public void sendACharacterforTitle(){

        waitFor(2);
        titleForNewEvent.sendKeys("a");
        addressInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAddress());
        dateInput.sendKeys(getTomorrowsDate());
        timeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTime());
        clearValue(feeInput);
        feeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getFee());
        durationInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getDuration());
        attendeeLimitInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAttendeeLimit());
        termsAndConditionInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTermsAndConditions());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
    public void blankTitle(){

        waitFor(2);
        titleForNewEvent.sendKeys("");
        addressInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAddress());
        dateInput.sendKeys(getTomorrowsDate());
        timeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTime());
        clearValue(feeInput);
        feeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getFee());
        durationInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getDuration());
        attendeeLimitInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAttendeeLimit());
        termsAndConditionInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTermsAndConditions());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
    public void blankAddress(){

        waitFor(2);
        titleForNewEvent.sendKeys("Annual Parade");
        addressInput.sendKeys("");
        dateInput.sendKeys(getTomorrowsDate());
        timeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTime());
        clearValue(feeInput);
        feeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getFee());
        durationInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getDuration());
        attendeeLimitInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAttendeeLimit());
        termsAndConditionInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTermsAndConditions());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
    public void blankDate(){

        waitFor(2);
        titleForNewEvent.sendKeys("Annual Parade");
        addressInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAddress());
        dateInput.sendKeys("");
        timeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTime());
        clearValue(feeInput);
        feeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getFee());
        durationInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getDuration());
        attendeeLimitInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAttendeeLimit());
        termsAndConditionInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTermsAndConditions());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
    public void blankTime(){

        waitFor(2);
        titleForNewEvent.sendKeys("Annual Parade");
        addressInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAddress());
        dateInput.sendKeys(getTomorrowsDate());
        timeInput.sendKeys("");
        clearValue(feeInput);
        feeInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getFee());
        durationInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getDuration());
        attendeeLimitInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getAttendeeLimit());
        termsAndConditionInput.sendKeys(NEWEVENT_INFO.YASEMIN_NEWEVENT.getTermsAndConditions());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }

    @FindBy(xpath = "//article[@class='events-i-organize_accordionItem__1f2lO events-i-organize_accordionActive__3YSTx']/div[@class='events-i-organize_accordionItem__container__3037s']/div[1]//button[@name='cancel']")
    public WebElement CancelButton;

    @FindBy(css = ".Toastify__toast-body")
    public WebElement CancelMassage;

    @FindBy(css = "ScheduledEvents_canceled__3gHpw")
    public WebElement CanceledSign;

    @FindBy(xpath = "//h5[.='Are you sure you want to cancel this event ?']")
    public WebElement ConfirmationPopupMSJ;

    @FindBy(xpath = "(//button[.='Yes'])[1]")
    public WebElement yesButton;

    @FindBy(xpath = "(//button[.='No'])[1]")
    public WebElement noButton;

    @FindBy(css = ".Toastify__toast-body")
    public WebElement canceledMaessage;

    @FindBy(css = ".ScheduledEvents_canceled__3gHpw ")
    public WebElement canseledLableOnEvent;

    @FindBy(css = ".btn-outline-primary")
    public WebElement markAsCompletedButton;

    @FindBy(xpath = "//div[text()='Event marked as completed']")
    public WebElement completedMassage;

    @FindBy(css = ".btn-outline-info")
    public WebElement copyLinkButton;

    @FindBy(css = ".Toastify__toast-body")
    public WebElement eventLinkCopiedMSJ;

    @FindBy(xpath = "//span[text()='NEW']")
    public WebElement newLableOnEvent;


    @FindBy(xpath = "//a[.='My Events']")
    public WebElement MyEventsBTN;

    @FindBy(xpath = "//button[text()='Create New Event']")
    public WebElement CreateNewEventBTN;
    @FindBy(id = "address2")
    public WebElement adressInfoBox;

    @FindBy(xpath = "//a[.='My Events']")
    public WebElement myEventBTN;

    @FindBy(css = "#title")
    public WebElement titleOfEvent;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitEventBTN;

   /* public String eventTitle2;

    public String eventTitle2() {
        String eventTitle2 = faker.name().title();
        return eventTitle2;
        }
        */

    public void CreatesAnEvent() {
        createNewEventsButton.click();
        waitFor(2);
        titleOfEvent.sendKeys("Fresh supplies for market");
        adressInfoBox.sendKeys("3304");
        dateInput.sendKeys(getTomorrowsDate());
        timeInput.sendKeys("11:00");
        feeInput.sendKeys("40");
        durationInput.sendKeys("60");
        attendeeLimitInput.sendKeys("20");
        termsAndConditionInput.sendKeys("attendance to booked events are essential");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        waitForClickability(submitEventButton, 5);
        actions.click(submitEventButton).build().perform();
        //  submitEventBTN.click();


    }


}

