package enums;

public enum NEWEVENT_INFO {
    YASEMIN_NEWEVENT("UrbanicFarmTestEvent","3015","11:00",
            "40","60","no terms and condtions","20"),
    NUR_NEWEVENT("","","","10","120","no smoke","100");

    private final String eventTitle;
    private final String address;
    private final String time;
    private final String fee;
    private final String duration;
    private final String termsAndConditions;
    private final String attendeeLimit;

    NEWEVENT_INFO(String eventTitle, String address, String time, String fee, String duration, String termsAndConditions, String attendeeLimit) {
        this.eventTitle = eventTitle;
        this.address = address;
        this.time = time;
        this.fee = fee;
        this.duration = duration;
        this.termsAndConditions = termsAndConditions;
        this.attendeeLimit = attendeeLimit;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getAddress() {
        return address;
    }

    public String getTime() {
        return time;
    }

    public String getFee() {
        return fee;
    }

    public String getDuration() {
        return duration;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public String getAttendeeLimit() {
        return attendeeLimit;
    }
}
