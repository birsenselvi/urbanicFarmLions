package UrbanicFarm_Lions.extensions.org.openqa.selenium.WebElement;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.waitForVisibility;

@Extension
public class MyWebElement {
  public static void assertToastMessage(@This WebElement webElement, String expectedToastMessage)
  {
    waitForVisibility(webElement, 5);
    assertTrue("ToastMessage is not displayed", webElement.getText().contains(expectedToastMessage));
  }
}