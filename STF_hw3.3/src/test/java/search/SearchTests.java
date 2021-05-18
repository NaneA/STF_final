package search;

import base.BaseTests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.Search;
import pages.SearchResults;
import pages.Home;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SearchTests extends BaseTests {
//testing two possible outcomes whether product exists or not
    @Test
    public void testSuccessfulSearch(){
        Search searchpage = homePage.clickBtn();
        searchpage.search("polo");
        assertEquals(searchpage.getSearchResults(), "RESULTS FOR POLO");
    }
     @Test
     public void noResults(){
         Search searchpage = homePage.clickBtn();
         searchpage.search("boxkik");
         assertEquals(searchpage.getWrongSearchResults(), "Sorry, we could not find any matching entries for \"boxkik\".");
     }


    @Test
    public void testCheckbox(){
        Search searchpage = homePage.clickBtn();
        searchpage.search("polo");
        searchpage.ClickCategories();
        searchpage.ClickCheck();
        assertEquals(searchpage.CheckboxCheck(), "Women");
    }

    @Test
    public void checkSidebar(){
        Search searchpage = homePage.clickBtn();
        searchpage.search("polo");
        assertTrue(searchpage.ContentExists());
    }


}
