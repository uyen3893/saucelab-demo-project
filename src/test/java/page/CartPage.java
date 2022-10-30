package page;

import org.openqa.selenium.By;

public class CartPage extends BasePage{

    protected static By cartListSel = By.cssSelector(".cart_list");
    protected static By cartItemSel = By.cssSelector(".cart_item");
    protected static By cartQuantitySel = By.cssSelector(".cart_quantity");
    protected static By cartNameSel = By.cssSelector(".inventory_item_name");
    protected static By cartPriceSel = By.cssSelector(".inventory_item_price");
    protected static By cartRemoveBtnSel = By.xpath("//button[contains(@class,'cart_button')]");

    protected static By checkoutBtnSel = By.cssSelector("#checkout");

}
