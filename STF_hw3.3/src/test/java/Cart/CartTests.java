package Cart;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Search;

import static org.testng.AssertJUnit.assertEquals;

public class CartTests extends BaseTests {
    @Test
    public void checkCartStatus(){
        Cart status = homePage.clickCart();
        assertEquals(status.getText(), "YOUR SHOPPING BAG IS EMPTY.");
    }

    //let's add an item

    @Test
    public void testSuccessfulAddition(){
        Search searchpage = homePage.clickBtn();
        searchpage.search("polo");
        searchpage.ClickItem();
        searchpage.scrollDown();
        searchpage.SelSize();
        searchpage.AddtoBag();
       // searchpage.gotoCart();
       Cart cartic =searchpage.gotoCart();
         assertEquals(cartic.numofItems(), "(1 item)");
    }

    @Test
    public void remove(){
        //remove item
        Search searchpage = homePage.clickBtn();
        searchpage.search("polo");
        searchpage.ClickItem();
        searchpage.scrollDown();
        searchpage.SelSize();
        searchpage.AddtoBag();
        // searchpage.gotoCart();
        Cart cartic =searchpage.gotoCart();
        cartic.remove();
        assertEquals(cartic.getText(), "YOUR SHOPPING BAG IS EMPTY.");

    }

    @Test
    public void testAmountofMoney(){
        //checking price when with dropdown menu we increase the number of items
        Search searchpage = homePage.clickBtn();
        searchpage.search("polo");
        searchpage.ClickItem();
        searchpage.scrollDown();
        searchpage.SelSize();
        searchpage.AddtoBag();
        // searchpage.gotoCart();
        Cart cartic =searchpage.gotoCart();

        cartic.selectFromDropDown(2);

        assertEquals(cartic.amount(), 69.30);
    }
    @Test
    public void checkContShop(){
        Cart status = homePage.clickCart();
        status.clickGoShop();
        assertEquals(status.getUrl(), "https://usa.tommy.com/en");
    }





    @Test
    public void addingitems(){
        //testing addition of multiple items
        Search searchpage = homePage.clickBtn();
        searchpage.search("polo");
        searchpage.ClickItem();
        searchpage.scrollDown();
        searchpage.SelSize();
        searchpage.AddtoBag();
       // searchpage.GoBack();
        searchpage.search("polo");

        searchpage.next();
        searchpage.scrollDown();
        searchpage.SelSize();
        searchpage.AddtoBag();
       // searchpage.gotoCart();
        Cart cartik = searchpage.gotoCart();
      assertEquals(cartik.numofItemstwo(), "(2 items)");
    }

}
