package org.example.pages;

import org.example.stepsDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_Checkout {
    public P05_Checkout(WebDriver driver){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement countryList;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement addressCity;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement addressLine;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement postalCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phoneNumber;

    @FindBy(className = "new-address-next-step-button")
    public WebElement newAddressButton;

    @FindBy(id = "shippingoption_0")
    public WebElement groundShippingMethod;

    @FindBy(className = "shipping-method-next-step-button")
    public WebElement shippingMethodButton;

    @FindBy(id = "paymentmethod_0")
    public WebElement checkOrMoneyPaymentMethod;

    @FindBy(className = "payment-method-next-step-button")
    public WebElement paymentMethodButton;

    @FindBy(className = "payment-info-next-step-button")
    public WebElement paymentInfoButton;

    @FindBy(xpath = "//table[@class=\"cart\"]//td[@class=\"product\"]/a")
    public WebElement cartItemInfo;

    @FindBy(xpath = "//span[@class=\"value-summary\"]/strong")
    public WebElement cartTotalPrice;

    @FindBy(className = "confirm-order-next-step-button")
    public WebElement confirmOrderButton;

}
