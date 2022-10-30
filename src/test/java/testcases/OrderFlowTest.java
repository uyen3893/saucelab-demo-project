package testcases;

import data.CheckoutData;
import data.ItemData;
import data.UserData;
import function.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderFlowTest extends TestBase {


    @BeforeMethod
    public void prepare() {
        checkoutData = checkoutInformationFunction.getCheckoutList();
        userData = loginFunction.getUserList();
        loginFunction.login(userData[0].getUsername(), userData[0].getPassword());
    }

    @Test
    public void verifyAddOneItemToCart() {
        List<ItemData> itemList = new ArrayList<>();
        for (int index = 0; index < 1; index++) {
            itemList.add(homePageFunction.addRandomItemToCart());
        }
        System.out.println(itemList);
        homePageFunction.verifyTotalItemInShoppingCart(itemList.size());
        homePageFunction.clickOnShoppingCartBtn();
        cartFunction.verifyAddToCartSuccessfully(itemList);
        cartFunction.clickOnCheckoutBtn();
        checkoutInformationFunction.inputInformation(checkoutData[0]);
        checkoutInformationFunction.clickOnContinueBtn();
        checkoutOverviewFunction.verifySubTotalItem(itemList);
        checkoutOverviewFunction.clickOnFinishBtn();
        checkoutCompleteFunction.verifyUserOrderSuccessfully();
        checkoutCompleteFunction.clickOnBackHomeBtn();
    }

    @Test
    public void verifyAddTwoItemsToCart() {
        List<ItemData> itemList = new ArrayList<>();
        for (int index = 0; index < 2; index++) {
            itemList.add(homePageFunction.addRandomItemToCart());
        }
        System.out.println(itemList);
        homePageFunction.verifyTotalItemInShoppingCart(itemList.size());
        homePageFunction.clickOnShoppingCartBtn();
        cartFunction.verifyAddToCartSuccessfully(itemList);
        cartFunction.clickOnCheckoutBtn();
        checkoutInformationFunction.inputInformation(checkoutData[0]);
        checkoutInformationFunction.clickOnContinueBtn();
        checkoutOverviewFunction.verifySubTotalItem(itemList);
        checkoutOverviewFunction.clickOnFinishBtn();
        checkoutCompleteFunction.verifyUserOrderSuccessfully();
        checkoutCompleteFunction.clickOnBackHomeBtn();
    }

    @Test
    public void verifyUserCancelAtCheckoutOverviewPage(){
        List<ItemData> itemList = new ArrayList<>();
        for (int index = 0; index < 2; index++) {
            itemList.add(homePageFunction.addRandomItemToCart());
        }
        System.out.println(itemList);
        homePageFunction.verifyTotalItemInShoppingCart(itemList.size());
        homePageFunction.clickOnShoppingCartBtn();
        cartFunction.verifyAddToCartSuccessfully(itemList);
        cartFunction.clickOnCheckoutBtn();
        checkoutInformationFunction.inputInformation(checkoutData[0]);
        checkoutInformationFunction.clickOnContinueBtn();
        checkoutOverviewFunction.verifySubTotalItem(itemList);
        checkoutOverviewFunction.clickOnCancelBtn();
        homePageFunction.verifyUserNagivateToHomePage();
    }

    @AfterMethod
    public void cleanUpItem() {
        homePageFunction.clickOnShoppingCartBtn();
        cartFunction.removeAllItems();
    }

}
