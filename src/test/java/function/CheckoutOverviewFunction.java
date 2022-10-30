package function;

import data.ItemData;
import org.testng.Assert;
import page.CheckoutOverviewPage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CheckoutOverviewFunction extends CheckoutOverviewPage {

    private Common common;

    public CheckoutOverviewFunction(Common common) {
        this.common = common;
    }

    public void verifySubTotalItem(List<ItemData> items) {
        if(items.isEmpty()) {
            throw new IllegalArgumentException("The Item list is empty");
        } else {
            double subTotal = 0;
            for (ItemData item : items) {
                subTotal += item.getPrice();
            }
            double actualSubTotal = Double.parseDouble(common.getText(itemSubTotalPriceSel).replace("Item total: $", ""));
            //Verify sub total of items
            Assert.assertEquals(actualSubTotal, subTotal, "[ERR] Actual and expected sub total prices are different!");

            double actualTotal = Double.parseDouble(common.getText(itemTotalPriceSel).replace("Total: $", ""));
            double tax = Double.parseDouble(common.getText(taxPriceSel).replace("Tax: $", ""));

            //Verify total price of items after adding tax
            double expectedTotal = Double.parseDouble(new DecimalFormat("##.##").format(subTotal + tax));
            Assert.assertEquals(actualTotal, expectedTotal, "[ERR] Actual and Expected total prices are different!");
        }
    }

    public void clickOnFinishBtn() {
        common.click(finishBtnSel);
    }

    public void clickOnCancelBtn(){
        common.scrollDownElement(common.findElement(cancelBtnSel));
        common.click(cancelBtnSel);
    }
}
