package function;

import data.ItemData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.CartPage;

import java.util.ArrayList;
import java.util.List;

public class CartFunction extends CartPage {

    private Common common;
    public CartFunction(Common common) {
        this.common = common;
    }

    public void removeAllItems() {
        List<WebElement> removeBtns = common.findElements(cartRemoveBtnSel);
        if (removeBtns.isEmpty()) {
            System.out.println("List items is empty!");
        } else {
            for (int index = 0; index < removeBtns.size(); index++) {
                common.click(removeBtns.get(index));
            }
        }
    }

    public void clickOnCheckoutBtn() {
        common.click(checkoutBtnSel);
    }

    public void verifyAddToCartSuccessfully(List<ItemData> itemData) {
        if (itemData.isEmpty()) {
            throw new IllegalArgumentException("The list items is empty!");
        }

        List<ItemData> actualItems = new ArrayList<>();
        List<WebElement> actualItemElems = common.findElements(cartItemSel);
        if (actualItemElems.isEmpty()) {
            Assert.fail("[ERR] The list items on the Cart Page is empty!");
        } else {
            for (int index = 0; index < actualItemElems.size(); index++) {
                String actualTitle = common.getText(common.findElements(cartNameSel).get(index));
                double actualPrice = Double.parseDouble(common.getText(
                        common.findElements(cartPriceSel).get(index)).replace("$", ""));
                actualItems.add(new ItemData(actualTitle, actualPrice));
            }
        }

        boolean isActualAndExpectedItemSame = false;
        for (ItemData expectedItem : itemData) {
            for (ItemData actualItem : actualItems) {
                if (actualItem.getName().equalsIgnoreCase(expectedItem.getName()) && actualItem.getPrice() == expectedItem.getPrice()){
                    isActualAndExpectedItemSame = true;
                    break;
                }
            }
        }

        Assert.assertTrue(isActualAndExpectedItemSame,"[ERR] Actual and Expected item price is different!");
    }
}
