import base.BaseTests;
import org.testng.annotations.Test;
import pages.SignIn;

import static org.testng.Assert.assertTrue;
// I accidentally wrote edit page functions in SussessfulSigninTest
public class EditPageTests extends BaseTests {


    @Test
    public void successfulSignIn(){
        SignIn signinPage = homePage.clickLogin();
        signinPage.setEmailAddress("daseraua@gmail.com");
        signinPage.SetPassword("Blah1234A");
        signinPage.submit();

        assertTrue(signinPage.Login());
    }
}
