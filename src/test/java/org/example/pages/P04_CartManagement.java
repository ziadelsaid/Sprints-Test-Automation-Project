package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P04_CartManagement {


    WebDriver driver;

    public P04_CartManagement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class=\"quantity up\"]")
    public WebElement increase;

    @FindBy(xpath = "//span[@class='value-summary']//strong")
    public WebElement total_price;

    @FindBy(xpath = "//tr[@class=\"order-subtotal\"]//td[@class=\"cart-total-right\"]//span[@class=\"value-summary\"]")
    public WebElement price;

    @FindBy(xpath = "//div[@class=\"quantity down\"]")
    public WebElement decrease;

    @FindBy(className = "remove-btn")
    public  WebElement remove;

    @FindBy(className = "no-data")
    public WebElement Empty;

    @FindBy(id = "termsofservice")
    public WebElement acceptTerms;

    @FindBy(id = "checkout")
    public WebElement checkout;



}
