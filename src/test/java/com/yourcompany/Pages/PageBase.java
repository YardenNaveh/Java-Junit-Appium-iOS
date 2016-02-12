package com.yourcompany.Pages;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;

/**
 * Created by mehmetgerceker on 12/22/15.
 */
public class PageBase {

    protected static void setCheckSwitchState(WebElement checkBox, boolean checked)
            throws InvalidElementStateException {
        String val = String.valueOf(checked? 1 : 0).toLowerCase();
        //we may wanna check if it is displayed and enabled, when performing actions.
        if (checkBox.isDisplayed() && checkBox.isEnabled()) {
            if (!checkBox.getAttribute("value").toLowerCase().equals(val)) {
                checkBox.click();
            }
        } else {
            throw new InvalidElementStateException("Checkbox by "
                    + checkBox.getAttribute("id")
                    + " is disabled!");
        }

    }

    protected static void clickButton(WebElement button) throws InvalidElementStateException {
        //we may wanna check if it is displayed and enabled, when performing actions.
        if (button.isDisplayed() && button.isEnabled()) {
            button.click();
        } else {
            throw new InvalidElementStateException("Button by "
                    + button.getAttribute("id")
                    + " is disabled or not displayed!");
        }
    }

    protected static void setTextInputValue(WebElement textElement, String value)
            throws InvalidElementStateException {
        //we may wanna check if it is displayed and enabled, when performing actions.
        if (textElement.isDisplayed() && textElement.isEnabled()) {
            textElement.sendKeys(value);
        } else {
            throw new InvalidElementStateException("Text input by "
                    + textElement.getAttribute("id")
                    + " is disabled or not displayed!");
        }
    }

    protected static boolean getSwitchState(WebElement toggleSwitch){
        String attr = toggleSwitch.getAttribute("value");
        return attr.contentEquals("1");
    }
}
