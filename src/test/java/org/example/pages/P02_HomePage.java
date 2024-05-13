package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P02_HomePage {
    WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public static By registerButton(){

        return By.cssSelector("a[href=\"/register?returnUrl=%2F\"]");
    }

    public By addToWishListButtons(){
        return By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]");
    }

    public By addToWishListSuccesMessage(){
        return By.cssSelector("div[class=\"bar-notification success\"]");
    }

    public By wishListItemsNo(){
        return By.cssSelector("span[class=\"wishlist-qty\"]");
    }

    @FindBy(className = "ico-login")
    public WebElement loginButton;

    @FindBy(id = "small-searchterms")
    public WebElement searchField;

    @FindBy(xpath = "//button[@class='button-1 search-box-button']")
    public WebElement searchButton;

    public By computersCategory(){
        return By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]");
    }

    public By desktopsSubCategory(){
        return By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/desktops\"]");
    }

    @FindBy(xpath = "//div[@class='page-title']")
    public WebElement titleOfSelectedCategory;

    public WebElement addToCartButton(String itemName) {
        return driver.findElement(By.xpath("//a[text()=\"" + itemName + "\"]/parent::h2/parent::div//button[text()=\"Add to cart\"]"));
    }

    public List<WebElement> itemsInCart() {
        return driver.findElements(By.xpath("//div[@class=\"items\"]//div[@class=\"name\"]//a"));
    }

    @FindBy(xpath = "//a[@href=\"/electronics\"]")
    public WebElement electronicsCategory;

    @FindBy(xpath = "//div[@class=\"sub-category-item\"]//a[@href=\"/camera-photo\"][text()=\" Camera & photo \"]")
    public WebElement camerasCategory;

    public WebElement successBarClose(){

        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class=\"close\"]")));
        } catch (Exception ignored) {
        }

        return element;
    }

    @FindBy(id = "topcartlink")
    public WebElement topCart;

    @FindBy(className = "cart-label")
    public WebElement cart;

    @FindBy(className="ico-account")
    public WebElement accountinfo ;
}
