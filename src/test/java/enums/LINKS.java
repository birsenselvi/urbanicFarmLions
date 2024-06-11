package enums;


public enum LINKS {
    EXPECTED_LINKS("https://test.urbanicfarm.com/account/weekly-order",
            "https://test.urbanicfarm.com/account/home",
            "https://test.urbanicfarm.com/account/events",
            "https://test.urbanicfarm.com/account/home",
            "https://test.urbanicfarm.com/");


    private final String ScheduledDeliveryUrl;
    private final String SellShareTradeUrl;
    private final String EventsUrl;
    private final String AccountUrl;
    private final String UrbanicFarmTestUrl;

    LINKS(String scheduledDeliveryUrl, String sellShareTradeUrl, String eventsUrl, String accountUrl, String urbanicFarmTestUrl) {

        ScheduledDeliveryUrl = scheduledDeliveryUrl;
        SellShareTradeUrl = sellShareTradeUrl;
        EventsUrl = eventsUrl;
        AccountUrl = accountUrl;
        UrbanicFarmTestUrl = urbanicFarmTestUrl;
    }

    public String getScheduledDeliveryUrl() {
        return ScheduledDeliveryUrl;
    }

    public String getSellShareTradeUrl() {
        return SellShareTradeUrl;
    }

    public String getEventsUrl() {
        return EventsUrl;
    }


    public String getAccountUrl() {
        return AccountUrl   ;
    }

    public String getUrbanicFarmTestUrl() {
        return UrbanicFarmTestUrl;
    }
}
