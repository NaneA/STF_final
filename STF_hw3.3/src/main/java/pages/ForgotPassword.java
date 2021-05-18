package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    private WebDriver driver;
    private By text = By.xpath("/html[1]/body[1]/div[3]/main[1]/div[5]/h1[1]");

    public ForgotPassword(WebDriver driver){
        this.driver = driver;
    }

    public String getTitleText(){
        return driver.findElement(text).getText();
    }
}
