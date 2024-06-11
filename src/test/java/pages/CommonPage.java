package pages;

import org.openqa.selenium.support.PageFactory;


import static stepDefinitions.Hooks.driver;

public abstract class CommonPage {

//<HomeRegisterButton>
    public CommonPage() {
        PageFactory.initElements(driver, this);
    }
    private HomePage homePage;
    private LoginPage loginPage;

    private RegisterPage registerPage;
    private AccountPage accountPage;
    private AddressPage addressPage;
    private DeliveryPickupSeetingsPage deliveryPickupSeetingsPage;
    private EventsPage eventsPage;
    private OrdersPage ordersPage;
    private ScheduledDeliveryPage scheduledDeliveryPage;
    private SellShareTrade sellShareTrade;

    private ProductPage productPage;

    //private HomeRegister homeRegisterButton;
    private WelcomePage welcomePage;
    private MyEventsPage myEventsPage;

private ContactUsPage contactUsPage; // cagla



    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
    public RegisterPage getRegisterPage(){
        if(registerPage==null){
            registerPage=new RegisterPage();
        }
        return registerPage;
    }
    public LoginPage getLoginPage(){
        if(loginPage==null){
            loginPage=new LoginPage();
        }
        return loginPage;
    }
    public AddressPage getAddressPage(){
        if(addressPage==null){
            addressPage=new AddressPage();
        }
        return addressPage;
    }
    public AccountPage getAccountPage(){
        if(accountPage==null){
            accountPage=new AccountPage();
        }
        return accountPage;
    }
    public DeliveryPickupSeetingsPage getDeliveryPickupSeetingsPage(){
        if(deliveryPickupSeetingsPage==null){
            deliveryPickupSeetingsPage=new DeliveryPickupSeetingsPage();
        }
        return deliveryPickupSeetingsPage;
    }
    public ScheduledDeliveryPage getScheduledDeliveryPage(){
        if(scheduledDeliveryPage==null){
            scheduledDeliveryPage=new ScheduledDeliveryPage();
        }
        return scheduledDeliveryPage;
    }
    public EventsPage getEventsPage(){
        if(eventsPage==null){
            eventsPage=new EventsPage();
        }
        return eventsPage;
    }
    public OrdersPage getOrdersPage(){
        if(ordersPage==null){
            ordersPage=new OrdersPage();
        }
        return ordersPage;
    }
    public SellShareTrade getSellShareTrade(){
        if(sellShareTrade==null){
            sellShareTrade=new SellShareTrade();
        }
        return sellShareTrade;
    }

    public WelcomePage getWelcomePage() {
        if (welcomePage == null) {
            welcomePage= new WelcomePage();
        }
        return welcomePage;
    }


    public ProductPage getProductPage(){
        if(productPage==null){
            productPage=new ProductPage();
        }
        return productPage;
    }

    public MyEventsPage getMyEventsPage() {
        if(myEventsPage==null){
        myEventsPage=new MyEventsPage();}
        return myEventsPage;
    }
    public ContactUsPage getContactUsPage() {
        if(contactUsPage==null){
            contactUsPage=new ContactUsPage();}
        return contactUsPage;
    }

}