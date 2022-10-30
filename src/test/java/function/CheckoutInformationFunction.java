package function;

import data.CheckoutData;
import data.UserData;
import page.CheckoutInformationPage;

public class CheckoutInformationFunction extends CheckoutInformationPage {

    private Common common;

    public CheckoutData[] getCheckoutList() {
        String fileLocation = "/src/test/java/data/CheckoutData.json";
        return common.buildDataObjectFrom(fileLocation, CheckoutData[].class);
    }
    public CheckoutInformationFunction(Common common){
        this.common = common;
    }

    public void inputInformation(CheckoutData checkoutData) {
        common.sendkey(firstnameInputSel, checkoutData.getFirstname());
        common.sendkey(lastnameInputSel, checkoutData.getLastname());
        common.sendkey(postalCodeInputSel, String.valueOf(checkoutData.getPostalCode()));
    }

    public void clickOnContinueBtn() {
        common.click(continueBtnSel);
    }
}
