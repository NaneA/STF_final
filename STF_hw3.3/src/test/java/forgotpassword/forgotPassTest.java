package forgotpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPassword;

import static org.testng.AssertJUnit.assertEquals;

public class forgotPassTest extends BaseTests {
    @Test
    public void Text(){
        ForgotPassword forgotPass = homePage.clickLogin().goForgotPassword();
        assertEquals(forgotPass.getTitleText(), "MY ACCONT");
        //This is intentionally written wrong for the screenshot
    }
}
