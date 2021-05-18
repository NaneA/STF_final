package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Home {

    private WebDriver driver;

    public Home(WebDriver driver){
        this.driver = driver;
    }
    public SignIn clickLogin(){
        clickLink("SIGN IN");
        return new SignIn(driver);
    }

    public Cart clickCart(){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//header/div[@id='stickyHeader']/div[3]/div[1]/div[1]/div[3]/div[4]/div[1]/a[1]/img[1]"))));
        driver.findElement(By.xpath("//header/div[@id='stickyHeader']/div[3]/div[1]/div[1]/div[3]/div[4]/div[1]/a[1]/img[1]")).click();
        return new Cart(driver);
    }

    public Search clickBtn(){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//header/div[@id='stickyHeader']/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/a[1]/img[1]"))));
        driver.findElement(By.xpath("//header/div[@id='stickyHeader']/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/a[1]/img[1]")).click();
        return new Search(driver);

    }
    private void clickLink(String linkText){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(linkText))));
        driver.findElement(By.linkText(linkText)).click();
    }

    private void clickXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
}
