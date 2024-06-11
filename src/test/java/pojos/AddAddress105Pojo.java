package pojos;

public class AddAddress105Pojo {

    private String address;
    private String city;
    private boolean isDefault;
    private boolean isSellerAddress;
    private String postal;
    private String state;
    private String title;

    public AddAddress105Pojo() {
    }

    public AddAddress105Pojo(String address, String city, boolean isDefault, boolean isSellerAddress, String postal, String state, String title) {
        this.address = address;
        this.city = city;
        this.isDefault = isDefault;
        this.isSellerAddress = isSellerAddress;
        this.postal = postal;
        this.state = state;
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isSellerAddress() {
        return isSellerAddress;
    }

    public void setSellerAddress(boolean sellerAddress) {
        isSellerAddress = sellerAddress;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "AddAddress_105Pojo{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", isDefault=" + isDefault +
                ", isSellerAddress=" + isSellerAddress +
                ", postal='" + postal + '\'' +
                ", state='" + state + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
