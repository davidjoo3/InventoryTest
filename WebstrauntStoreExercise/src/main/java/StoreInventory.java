import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoreInventory {
    //instance variable
    private List<Product> productList;

    //default constructor
    public StoreInventory() {
        productList = new ArrayList<Product>();
    }

    //Add a new product to the inventory
    public void addNewProduct(String productName, int id, double price, int quantity) {
        productList.add(new Product(productName, id, Math.round(price * 100.0) / 100.0, quantity));
    }

    //Remove a product from the inventory by its ID
    public String removeProductById(int id) {
        if (productList.size() == 0) {
            return "Inventory is empty";
        }

        for (Product product : productList) {
            if (product.getId() == id) {
                String removedProductName = product.getName();
                productList.remove(product);
                return removedProductName + " has been removed from the inventory";
            }
        }

        return "No product with such ID in the inventory";
    }

    //Update the quantity of a product in the inventory by its name
    public void updateQuantity(String productName, int quantity) {
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                product.setQuantity(quantity);
            }
        }
    }

    //Returns current inventory as a string
    public String viewCurrentInventory() {
        StringBuilder result = new StringBuilder();
        for (Product product : productList) {
            result.append("Product Name: " + product.getName()
                                    + " ID: " + product.getId()
                                    + " Price: " + product.getPrice()
                                    + " Quantity: " + product.getQuantity() + "\n");
        }
        return result.toString();
    }

    //Calculate and display the total value of the inventory
    public String calculateTotal() {
        double total = 0.0;
        for (Product product : productList) {
            total += (product.getPrice() * (double)product.getQuantity());
        }
        total = Math.round(total * 100.0) / 100.0;
        return "Total: " + Double.toString(total);
    }

    public List<Product> getProductList() {
        return productList;
    }
}
