package data;

public class CheckoutData {

    private String firstname;
    private String lastname;
    private int postalCode;

    public CheckoutData(String firstname, String lastname, int postalCode){
        this.firstname = firstname;
        this.lastname = lastname;
        this.postalCode = postalCode;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "CheckoutData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
