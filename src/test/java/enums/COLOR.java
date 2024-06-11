package enums;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public enum COLOR {
    BOX_SHADOW_PINK("#ff000040","rgba(255, 0, 0, 0.25) 0px 0px 0px 4px"),
    BOX_SHADOW_BLUE("#0d6efd40","rgba(13, 110, 253, 0.25) 0px 0px 0px 4px"),
    NOTIFICATION_RADIO_BUTTON_GREEN("#7fcd57",""),
    NOTIFICATION_RADIO_BUTTON_WHITE("#fff","");
    private String HEX;

    private String RGBA;


    COLOR(String HEX, String RGBA) {
        this.HEX = HEX;
        this.RGBA = RGBA;
    }
    public String getHEX() {
        return HEX;
    }

    public String getRGBA() {
        return RGBA;
    }

    public void assertBorderColor(WebElement webElement){
        String actuelBoxColor = webElement.getCssValue("box-shadow");
        assertEquals(this.getRGBA(),actuelBoxColor);

    }

}
