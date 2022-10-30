package page;

import org.openqa.selenium.By;

public class CheckoutInformationPage extends BasePage{

    protected static By firstnameInputSel = By.cssSelector("#first-name");
    protected static By lastnameInputSel = By.cssSelector("#last-name");
    protected static By postalCodeInputSel = By.cssSelector("#postal-code");
    protected static By continueBtnSel = By.cssSelector("input[name='continue']");
    protected static By cancelBtnSel = By.cssSelector("#cancel");
}
