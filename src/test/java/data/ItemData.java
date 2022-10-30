package data;

public class ItemData {

    private String name;
    private double price;
    private int quantity;

    public ItemData(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ItemData{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
