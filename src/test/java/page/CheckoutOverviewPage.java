package page;

import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage {

    protected static By cartListSel = By.cssSelector(".cart_list");
    protected static By cartNameSel = By.cssSelector(".inventory_item_name");
    protected static By cartPriceSel = By.cssSelector(".inventory_item_price");
    protected static By itemSubTotalPriceSel = By.cssSelector(".summary_subtotal_label");
    protected static By taxPriceSel = By.cssSelector(".summary_tax_label");
    protected static By itemTotalPriceSel = By.cssSelector(".summary_total_label");
    protected static By finishBtnSel = By.cssSelector("#finish");
}
