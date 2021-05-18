package signin;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.SignIn;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SuccessfulSigninTest extends BaseTests {


    @Test
    public void successfulSignIn(){
        SignIn signinPage = homePage.clickLogin();
        signinPage.setEmailAddress("daseraua@gmail.com");
        signinPage.SetPassword("Blah1234A");
        signinPage.submit();
        signinPage.clickEdit();
        signinPage.editFirstname("Meeh");
        signinPage.scrollDown();
        signinPage.Submit();
        //unfortunately despite all efforts I couldn't reach to Submit button I
        //but if it did the test would be like this
        assertEquals(signinPage.nameChange(), "Personal Information has been updated successfully.");
    }
}
