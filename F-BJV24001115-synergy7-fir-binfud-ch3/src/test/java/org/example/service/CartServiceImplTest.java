package org.example.service;

import org.example.model.Food;
import org.example.model.Items;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CartServiceImplTest {
    private CartService cartService;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        cartService = new CartServiceImpl();
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void addFoodToCart_ShouldAddItem() {
        Items foodItem = new Food("Test Food", 10, 1);
        cartService.addFoodToCart(foodItem);
        assertFalse(cartService.getCartItems().isEmpty(), "Cart should not be empty after adding item.");
        assertEquals(1, cartService.getCartItems().size(), "Cart should have one item after addition.");
        assertEquals(foodItem, cartService.getCartItems().get(0), "The added item should be in the cart.");
    }

    @Test
    void isCartEmpty_Initially_ShouldReturnTrue() {
        assertTrue(cartService.isCartEmpty(), "New cart should be empty.");
    }

    @Test
    void clearCart_WithItems_ShouldEmptyCart() {
        Items foodItem = new Food("Test Food", 10, 1);
        cartService.addFoodToCart(foodItem);
        assertFalse(cartService.isCartEmpty(), "Cart should not be empty after adding items.");
        cartService.clearCart();
        assertTrue(cartService.isCartEmpty(), "Cart should be empty after clearCart is called.");
    }

    @Test
    void getCartItems_AfterAddingItems_ShouldReturnAllItems() {
        Items foodItem1 = new Food("Test Food 1", 10, 1);
        Items foodItem2 = new Food("Test Food 2", 20, 2);
        cartService.addFoodToCart(foodItem1);
        cartService.addFoodToCart(foodItem2);
        List<Items> items = cartService.getCartItems();
        assertTrue(items.contains(foodItem1) && items.contains(foodItem2), "Cart should contain all added items.");
    }

    @Test
    void generateReceipt_WithItems_ShouldCreateReceiptFile() throws IOException {
        Items foodItem = new Food("Test Food", 10, 2);
        cartService.addFoodToCart(foodItem);
        ((CartServiceImpl) cartService).setReceiptFilePath(tempDir.resolve("receipt.txt"));
        cartService.generateReceipt();
        Path receiptPath = tempDir.resolve("receipt.txt");
        assertTrue(Files.exists(receiptPath), "Receipt file should be created.");
        String content = Files.readString(receiptPath);
        assertTrue(content.contains("Test Food"), "Receipt should contain the food item's name.");
        assertTrue(content.contains("20"), "Receipt should contain the correct total price.");
    }

    @Test
    void generateReceipt_EmptyCart_ShouldNotCreateReceiptFile() {
        cartService.clearCart();
        ((CartServiceImpl) cartService).setReceiptFilePath(tempDir.resolve("receipt.txt"));
        cartService.generateReceipt();
        Path receiptPath = tempDir.resolve("receipt.txt");
        assertFalse(Files.exists(receiptPath), "Receipt file should not be created if cart is empty.");
    }

    @Test
    void addNullItem_ShouldNotAddToCart() {
        cartService.addFoodToCart(null);
        assertTrue(cartService.getCartItems().isEmpty(), "Cart should remain empty when null is added.");
    }

    @Test
    void addMultipleItems_ShouldCorrectlyAggregateTotals() {
        Items foodItem1 = new Food("Bubur", 10000, 2);
        Items foodItem2 = new Food("Es Teh", 5000, 3);
        cartService.addFoodToCart(foodItem1);
        cartService.addFoodToCart(foodItem2);
        assertEquals(2, cartService.getCartItems().size(), "Cart should contain two items.");
        assertEquals(35000, cartService.getCartItems().stream().mapToInt(Items::getTotalPrice).sum(), "Total price should be correctly calculated.");
    }

    @Test
    void displayCartContents_WithItems_ShouldPrintDetails() {
        Items foodItem = new Food("Sandwich", 150, 2);
        cartService.addFoodToCart(foodItem);
        cartService.displayCartContents();
        String output = outContent.toString();
        assertTrue(output.contains("Sandwich") && output.contains("300"), "Output should contain item details and total price.");
    }

    @Test
    void displayCartContents_EmptyCart_ShouldPrintEmptyMessage() {
        cartService.displayCartContents();
        String output = outContent.toString();
        assertTrue(output.contains("Cart is empty"), "Output should indicate that the cart is empty.");
    }
}
