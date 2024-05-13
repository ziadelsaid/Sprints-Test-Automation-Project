package org.example.pages;

import org.example.stepsDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_Login {

    public P03_Login(WebDriver driver){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(className = "login-button")
    public WebElement loginButton;

    @FindBy(id = "RememberMe")
    public WebElement rememberMeSelect;

}
