package pojos;

public class CreateEventPojo {
    private String title;
    private String date;
    private int fee;
    private int duration;
    private int attendeeLimit;
    private int addressId;
    private String tac;

    public CreateEventPojo(String title, String date, int fee, int duration, int attendeeLimit, int addressId, String tac) {
        this.title = title;
        this.date = date;
        this.fee = fee;
        this.duration = duration;
        this.attendeeLimit = attendeeLimit;
        this.addressId = addressId;
        this.tac = tac;
    }

    public CreateEventPojo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAttendeeLimit() {
        return attendeeLimit;
    }

    public void setAttendeeLimit(int attendeeLimit) {
        this.attendeeLimit = attendeeLimit;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    @Override
    public String toString() {
        return "EventPojo{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", fee=" + fee +
                ", duration=" + duration +
                ", attendeeLimit=" + attendeeLimit +
                ", addressId=" + addressId +
                ", tac='" + tac + '\'' +
                '}';
    }
}
