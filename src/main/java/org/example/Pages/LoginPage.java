package org.example.Pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[contains(@class, 'error')]")
    private WebElement error;

    public LoginPage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUsername(String text){
        username.sendKeys(text);
        return this;
    }

    public LoginPage enterPassword(String text){
        password.sendKeys(text);
        return this;
    }

    public LoginPage tryInvalidLogin(){
        submitBtn.click();
        return this;
    }

    public WebElement getError() {
        return error;
    }
}
