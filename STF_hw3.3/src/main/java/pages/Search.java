package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.directory.SearchResult;

public class Search {
    private WebDriver driver;
    private By searchbox =By.xpath("//input[@id='SimpleSearchForm_SearchTerm']");
 //   private By searchText = By.xpath("//body/div[@id='page']/main[@id='contentWrapper']/div[1]/div[1]/div[3]/div[1]");

    private By Gender = By.xpath("//span[@id='navHeader_Gender_Label']");
    private By Price = By.xpath("//span[@id='navHeader_Price_Label']");
    private By checkboxWomen = By.xpath("//body/div[@id='page']/main[@id='contentWrapper']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[1]");
    private By searchText = By.xpath("//body/div[@id='page']/main[@id='contentWrapper']/div[1]/div[1]/div[3]/div[1]");
    private By checked = By.xpath("//body/div[@id='page']/main[@id='contentWrapper']/div[1]/div[1]/div[3]/div[1]");
    private By navbar = By.xpath("//body/div[@id='page']/main[@id='contentWrapper']/div[1]/div[2]/div[1]");

    private By item = By.xpath("//a[contains(text(),'Classic Fit Essential Solid Polo')]");
    private By wrongInput = By.xpath("//p[contains(text(),'Sorry, we could not find any matching entries for ')]");


   private By el = By.xpath("//body/div[@id='page']/main[@id='contentWrapper']/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/a[1]/img[2]");
   private By size = By.xpath("//li[@id='size_S_XS']");
   private By add = By.xpath("//a[@id='add2CartBtn']");
   private By nextItem = By.xpath("//a[contains(text(),'Custom Fit Essential Performance Polo')]");
   private By cartPage = By.xpath("//header/div[@id='stickyHeader']/div[3]/div[1]/div[1]/div[3]/div[4]/div[1]/a[1]/img[1]");

    public SearchResults gotoResultsPage(){
        clickXpath("//header/div[@id='stickyHeader']/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/a[1]/img[1]");
        return new SearchResults(driver);
    }
    public Search(WebDriver driver){
        this.driver = driver;
    }


    public void search(String searchItem){
        WebElement s = driver.findElement(searchbox);
        s.sendKeys(searchItem);
        s.submit();
    }

    public boolean ContentExists(){
        return !driver.findElements(navbar).isEmpty();
    }
    public String getSearchResults(){
        return driver.findElement(searchText).getText();
    }
    public String getWrongSearchResults(){return driver.findElement(wrongInput).getText();}
    public String CheckboxCheck(){
        return driver.findElement(checkboxWomen).getText();
    }


    public void ClickCategories(){
        driver.findElement(Gender).click();
    }

    public void ClickItem() {
          driver.findElement(item).click();
    }

    public void SelSize(){
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(size)));
        driver.findElement(size).click();
    }
    public void AddtoBag(){
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(add)));
        driver.findElement(add).click();
    }

    public void GoBack(){

        driver.navigate().back();
    }


    public void next(){
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(nextItem)));
        driver.findElement(nextItem).click();
    }
    public void ClickCheck(){
        driver.findElement(checkboxWomen).click();
    }

    public Cart gotoCart(){
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cartPage)));
        driver.findElement(cartPage).click();
        return new Cart(driver);
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }


    public void ClickElement(){
        driver.findElement(el).click();
    }
    private void clickXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
}
