package enums;

public enum USER_INFO {
    SELLER_CREDENTIALS("seller_urban1@yopmail.com","Seller1//"),
    BUYER_CREDENTIAL("urbanicfarm1@yopmail.com","Urbanicfarm1/"),

    SELLEROMER_CREDENTIALS("seller_urban@mailsac.com","VHt*zzt*wQNu6XS"),
    BUYEROMER_CREDENTIAL("buyer_urban@mailsac.com","VHt*zzt*wQNu6XS"),
    SELLERGUL_CREDENTIAL("gulyalcin2022@gmail.com","Endemik38*"),


    PAYPAL_CREDENTIAL("sandbox@personal.example.com","NvR29+Ww"),

    SELLER2_CREDENTIALS("seller_urban2@yopmail.com","Seller2/"),
    BUYER("peummonnemane-5141@yopmail.com","e*y7G2xhsTVAi5u");



    private final String email;
    private final String password;

    USER_INFO(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
