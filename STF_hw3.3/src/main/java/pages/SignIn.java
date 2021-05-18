package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {

    private WebDriver driver;
    private By button = By.xpath("//a[@id='WC_AccountDisplay_links_2']");
    private By emailAddress = By.xpath("//input[@id='WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
    private By password = By.xpath("//input[@id='WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
    private By errors = By.xpath("//div[@id='pageLevelMessage']");
    private By forgotPass = By.xpath("//a[@id='WC_AccountDisplay_links_1']");
    private By successfulLogin = By.xpath("//p[contains(text(),'Welcome, Blah Unkn')]");

    private By edit = By.xpath("//body/div[@id='page']/main[@id='contentWrapper']/div[@id='myAccountPage']/div[@id='contentWrapper']/div[@id='content']/div[@id='box']/div[@id='box']/div[@id='WC_MyAccountCenterLinkDisplay_box_1']/div[@id='WC_MyAccountCenterLinkDisplay_div_44']/h3[1]/a[1]");
    private By firstName = By.xpath("//input[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1']");
    private By submit = By.cssSelector("#WC_UserRegistrationUpdateForm_links_1");
    private By succeffulMessage = By.xpath("//div[contains(text(),'Personal Information has been updated successfully')]");

    public SignIn(WebDriver driver){
        this.driver = driver;
    }

    public void setEmailAddress(String email){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(emailAddress)));
        driver.findElement(emailAddress).sendKeys(email);
    }

    public void SetPassword(String pass){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(password)));
        driver.findElement(password).sendKeys(pass);
    }

    public void submit(){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(button)));
        driver.findElement(button).click();
    }

    public boolean Login() {

        return !driver.findElements(successfulLogin).isEmpty();
    }

    public boolean errorExists() {

        return !driver.findElements(errors).isEmpty();
    }
    public ForgotPassword goForgotPassword() {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(forgotPass)));
        driver.findElement(forgotPass).click();
        return new ForgotPassword(driver);
    }

    public void clickEdit(){
        driver.findElement(edit).click();
    }

    public void editFirstname(String newName){
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(newName);
    }

    public void Submit(){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submit)));
        driver.findElement(submit).click();
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }


    private void clickLink(String linkText){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(linkText))));
        driver.findElement(By.linkText(linkText)).click();
    }
    public void clickUpdate(){
        clickLink("UPDATE");

    }
    public String nameChange(){

        return driver.findElement(succeffulMessage).getText();
    }

}
