package function;

import data.ItemData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.HomePage;

import java.security.SecureRandom;
import java.util.List;

public class HomePageFunction extends HomePage {

    private Common common;

    public HomePageFunction(Common common){
        this.common = common;
    }

    public void logout(){
        common.click(burgerMenuIconSel);
        common.click(logoutBtnSel);
    }
    public void clickOnShoppingCartBtn() {
        common.click(shoppingCartIconSel);
    }
    
    public ItemData addRandomItemToCart() {
        List<WebElement> items = common.findElements(itemListSel);
        if (items.isEmpty()) {
            Assert.fail("[ERR] The item list in the home page is empty!");
        }
        int random = new SecureRandom().nextInt(items.size());
        clickOnAddToCartButton(random);
        return new ItemData(getItemName(random),getItemPrice(random));
    }

    private String getItemName(int orderNum){
        return common.getText(common.findElements(itemNameSel).get(orderNum));
    }

    private double getItemPrice(int orderNum) {
        return Double.parseDouble(common.getText(common.findElements(itemPriceSel).get(orderNum)).replace("$", ""));
    }

    public void clickOnAddToCartButton(int orderNum){
        common.scrollDownElement(common.findElements(itemAddToCartBtnSel).get(orderNum));
        common.click(common.findElements(itemAddToCartBtnSel).get(orderNum));
    }

    public void verifyTotalItemInShoppingCart(int expectedResult){
        common.scrollUpElement(common.findElement(totalItemsInShoppingCartSel));
        int actualResult = Integer.parseInt(common.getText(totalItemsInShoppingCartSel));
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void clickOnRemoveButton() {
        if (common.getText(itemAddToCartBtnSel).equalsIgnoreCase("Remove")) {
            common.click(itemAddToCartBtnSel);
        } else {
            throw new IllegalArgumentException("This item is not added to cart!");
        }
    }

    public void verifyUserNagivateToHomePage() {
        Assert.assertTrue(common.isElementDisplayed(itemListSel));
    }


}
