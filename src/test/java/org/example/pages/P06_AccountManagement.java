package org.example.pages;

import org.example.stepsDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P06_AccountManagement {

    WebDriver driver;

    public P06_AccountManagement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="FirstName")
    public WebElement firstname ;

    @FindBy(id ="LastName")
    public WebElement lastname ;

    @FindBy(id = "Email")
    public WebElement email ;

    @FindBy(id="Company")
    public WebElement company;

    @FindBy(id="Newsletter")
    public WebElement subscription ;

    @FindBy(id="save-info-button")
    public  WebElement save ;

    @FindBy(css = "p[class='content']")
    public WebElement success;
    @FindBy(css="a[href='/order/history']")
    public WebElement order_history ;


}
