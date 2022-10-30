package page;

import org.openqa.selenium.By;

public class BasePage {

    //Header's selectors
    protected static By burgerMenuIconSel = By.cssSelector("#react-burger-menu-btn");
    protected static By shoppingCartIconSel = By.cssSelector("#shopping_cart_container");
    protected static By totalItemsInShoppingCartSel = By.cssSelector("#shopping_cart_container > a > span");

    //Menu Side Bar's selectors
    protected static By allItemsBtnSel = By.cssSelector("#inventory_sidebar_link");
    protected static By aboutBtnSel = By.cssSelector("#about_sidebar_link");
    protected static By logoutBtnSel = By.cssSelector("#logout_sidebar_link");
    protected static By resetBtnSel = By.cssSelector("#reset_sidebar_link");
    protected static By cancelBtnSel = By.cssSelector("#cancel");

    //Footer's selectors
    protected static By socialMediaBtnSel = By.cssSelector(".social");
}
