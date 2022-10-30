package function;

import org.testng.Assert;
import page.CheckoutCompletePage;

public class CheckoutCompleteFunction extends CheckoutCompletePage {

    private Common common;
    public CheckoutCompleteFunction(Common common) {
        this.common = common;
    }

    public void verifyUserOrderSuccessfully() {
        String expectedMessage = "THANK YOU FOR YOUR ORDER";
        String actualMessage = common.getText(completeMessageSel);
        Assert.assertEquals(actualMessage,expectedMessage, "[ERR] Actual and Expected Message is different!");
    }

    public void clickOnBackHomeBtn() {
        common.click(backHomeBtnSel);
    }
}
