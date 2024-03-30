import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class StoreInventoryTest {

    private StoreInventory testInventory = new StoreInventory();

    @Test
    void addNewProduct() {
        testInventory.addNewProduct("Apple", 1, 2.99, 4);
        testInventory.addNewProduct("Banana", 2, 1.99, 3);
        testInventory.addNewProduct("Kiwi", 3, 3.99, 5);

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("Apple", 1, 2.99, 4));
        expected.add(new Product("Banana", 2, 1.99, 3));
        expected.add(new Product("Kiwi", 3, 3.99, 5));

        assertArrayEquals(convertToStringArray(expected), convertToStringArray(testInventory.getProductList()));
    }

    @Test
    void removeProductById() {
        testInventory.addNewProduct("Apple", 1, 2.99, 4);
        testInventory.addNewProduct("Banana", 2, 1.99, 3);
        testInventory.addNewProduct("Kiwi", 3, 3.99, 5);

        testInventory.removeProductById(2);

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("Apple", 1, 2.99, 4));
        expected.add(new Product("Kiwi", 3, 3.99, 5));

        assertArrayEquals(convertToStringArray(expected), convertToStringArray(testInventory.getProductList()));
    }

    @Test
    void updateQuantity() {
        testInventory.addNewProduct("Apple", 1, 2.99, 4);
        testInventory.addNewProduct("Banana", 2, 1.99, 3);
        testInventory.addNewProduct("Kiwi", 3, 3.99, 5);

        testInventory.updateQuantity("Banana", 10);

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("Apple", 1, 2.99, 4));
        expected.add(new Product("Banana", 2, 1.99, 10));
        expected.add(new Product("Kiwi", 3, 3.99, 5));

        assertArrayEquals(convertToStringArray(expected), convertToStringArray(testInventory.getProductList()));
    }

    @Test
    void viewCurrentInventory() {

        testInventory.addNewProduct("Apple", 1, 2.99, 4);
        testInventory.addNewProduct("Banana", 2, 1.99, 3);
        testInventory.addNewProduct("Kiwi", 3, 3.99, 5);

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("Apple", 1, 2.99, 4));
        expected.add(new Product("Banana", 2, 1.99, 3));
        expected.add(new Product("Kiwi", 3, 3.99, 5));

        StringBuilder expectedString = new StringBuilder();
        for (int i=0; i < expected.size(); i++) {
            expectedString.append("Product Name: " + expected.get(i).getName()
                    + " ID: " + expected.get(i).getId()
                    + " Price: " + expected.get(i).getPrice()
                    + " Quantity: " + expected.get(i).getQuantity() + "\n");
        }

        assertEquals(expectedString.toString(), testInventory.viewCurrentInventory());
    }

    @Test
    void CalculateTotal() {
        testInventory.addNewProduct("Apple", 1, 2.99, 4);
        testInventory.addNewProduct("Banana", 2, 1.99, 3);
        testInventory.addNewProduct("Kiwi", 3, 3.99, 5);

        String expected = "Total: 37.88";
        assertEquals(expected, testInventory.calculateTotal());
    }


    //converts ArrayList of Products into array of string for deep comparison
    private String[] convertToStringArray(List<Product> productList) {
        String[] products = new String[productList.size()];
        for (int i = 0; i < productList.size(); i++) {
            products[i] = productList.get(i).toString();
        }
        return products;
    }
}
