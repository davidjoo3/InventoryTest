public class Product {
    // instance variables
    private String name;
    private int id;
    private double price;
    private int quantity;

    //default constructor
    public Product() {
        this.name = "";
        this.id = 0;
        this.price = 0.0;
        this.quantity = 0;
    }

    //overloaded constructor
    public Product(String name, int id, double price, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    //getter and setter methods
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setPrice() {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    //toString method for deep comparison
    public String toString() {
        return "Product [name=" + name + ", id=" + id
                + ", price=" + price
                + ", quantity=" + quantity + "]";
    }

}
