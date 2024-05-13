package org.example.stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_HomePage;
import org.example.pages.P04_CartManagement;
import org.example.pages.P05_Checkout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D06_CheckoutStep {

    WebDriver driver = Hooks.driver;
    P05_Checkout CheckoutPage = new P05_Checkout(Hooks.driver);
    P02_HomePage HomePage = new P02_HomePage(Hooks.driver);
    P04_CartManagement cartPage = new P04_CartManagement(Hooks.driver);

    @Given("user clicks on cart")
    public void navigateCartPage() {
        HomePage.topCart.click();
    }


    @Then("user should be directed to cart page")
    public void directedToCartPage() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/cart");
    }


    @When("user agree on terms and conditions")
    public void agreeOnTerms() {
        cartPage.acceptTerms.click();
    }

    @And("user clicks on checkout button")
    public void checkoutButton() {
        cartPage.checkout.click();
    }

    @And("user chooses country: {string}")
    public void nationality(String country) {
        CheckoutPage.countryList.click();
        Select select = new Select(CheckoutPage.countryList);
        select.selectByVisibleText(country);
    }

    @And("user enters city: {string}")
    public void userEntersCity(String city) {
        CheckoutPage.addressCity.sendKeys(city);
    }

    @And("user enters address: {string}")
    public void userEntersAddress(String address) {
        CheckoutPage.addressLine.sendKeys(address);
    }

    @And("user enters postal code: {string}")
    public void userEntersPostalCode(String postalCode) {
        CheckoutPage.postalCode.sendKeys(postalCode);
    }

    @And("user enters phone number: {string}")
    public void userEntersPhoneNumber(String phoneNum) {
        CheckoutPage.phoneNumber.sendKeys(phoneNum);
    }


    @And("user presses continue to save address")
    public void continueToSaveAddress() {
        CheckoutPage.newAddressButton.click();
    }

    @And("user chooses {string} shipping method")
    public void userChoosesShippingMethod(String method) {
        CheckoutPage.groundShippingMethod.click();
    }

    @And("user presses continue after choosing shipping method")
    public void continueAfterShippingMethod() {
        CheckoutPage.shippingMethodButton.click();
    }

    @And("user chooses {string} payment method")
    public void userChoosesPaymentMethod(String paymentMethod) {
        CheckoutPage.checkOrMoneyPaymentMethod.click();
    }


    @And("user presses continue after choosing payment method")
    public void continueAfterPaymentMethod() {
        CheckoutPage.paymentMethodButton.click();
        CheckoutPage.paymentInfoButton.click();
    }


    @Then("user should see overview information of order")
    public void overviewInformation() {
        Assert.assertEquals(CheckoutPage.cartItemInfo.getText(),"HTC One M8 Android L 5.0 Lollipop");
        Assert.assertEquals(CheckoutPage.cartTotalPrice.getText(),"$245.00");
    }


    @When("user presses confirm")
    public void userPressesConfirm() {
        CheckoutPage.confirmOrderButton.click();
    }


    @Then("user is redirected to checkout completed page")
    public void redirectedToCheckoutComplete() throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/checkout/completed");
    }

}
