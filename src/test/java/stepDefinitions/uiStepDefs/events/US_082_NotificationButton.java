package stepDefinitions.uiStepDefs.events;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

import static stepDefinitions.Hooks.actions;


import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.waitForClickability;
import static utilities.ReusableMethods.waitForVisibility;

public class US_082_NotificationButton extends CommonPage {
    @Given("user clicks on My Events module on the side bar in homepage")
    public void userClicksOnMyEventsModuleOnTheSideBarInHomepage() {
        waitForVisibility(getMyEventsPage().myEventsOnSidebar,5);
        getMyEventsPage().myEventsOnSidebar.click();
    }

    @And("user creates a new event")
    public void userCreatesANewEvent() {
        getMyEventsPage().createNewEvent();
    }

    @And("user refreshes the page")
    public void userRefreshesThePage() {
        driver.navigate().refresh();
    }

    @And("user clicks on Notification icon on navbar")
    public void userClicksOnNotificationIconOnNavbar() {
        getMyEventsPage().notificationIcon.click();
    }

    @Then("user should see the notification page")
    public void userShouldSeeTheNotificationPage() {
        getMyEventsPage().verifyNotificationWidgetDisplayed();
    }

    @Then("{string} should be seen on the radio button of the new notification")
    public void shouldBeSeenOnTheRadioButtonOfTheNewNotification(String expectedText) {
        getMyEventsPage().verifyNotificationReadOrNot(expectedText);

    }

    @Then("{string} should be seen on top of the page")
    public void shouldBeSeenOnTopOfThePage(String expectedText) {
        getMyEventsPage().assertFilterButtonTextinNotificationWidget(expectedText);
    }

    @When("user clicks on Mark all as read")
    public void userClicksOnMarkAllAsRead() {
        getMyEventsPage().markAllAsReadText.click();
    }

    @Then("user should see {string}")
    public void userShouldSee(String expectedText) {
        getMyEventsPage().assertFilterButtonTextinNotificationWidget(expectedText);
    }

    @Then("user verifies that {string} is seen")
    public void userVerifiesThatIsSeen(String expectedText) {
        getMyEventsPage().verifyNoUnreadNotifications(expectedText);
    }

    @When("user clicks on close notification icon")
    public void userClicksOnCloseNotificationIcon() {
        waitForClickability(getMyEventsPage().closeNotificationIcon,2);
        actions.click(getMyEventsPage().closeNotificationIcon).build().perform();

    }
    @And("user deletes the event")
    public void userDeletesTheEvent() {
        getMyEventsPage().deleteMyOwnEvent();

    }


}