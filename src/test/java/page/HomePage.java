package page;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    protected static By productSortDropdownSel = By.cssSelector(".product_sort_container");
    protected static By itemListSel = By.cssSelector(".inventory_item");
    protected static By itemNameSel = By.cssSelector(".inventory_item_name");
    protected static By itemPriceSel = By.cssSelector(".inventory_item_price");
    protected static By itemAddToCartBtnSel = By.xpath("//button[contains(@class,'btn_inventory')]");

}
