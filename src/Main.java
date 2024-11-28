public class Main {
    public static void main(String[] args) {
        // Create a new product
        Product product = new Product();

        // Prompt user for product information
        product.setId(((Number) InputUtils.getNumber("Enter Product ID: ")).intValue());
        product.setName(InputUtils.getString("Enter Product Name: "));
        product.setThumbnail(InputUtils.getString("Enter Path to Product Thumbnail: "));
        product.setPrice(((Number) InputUtils.getNumber("Enter Product Price: ")).doubleValue());
        product.setQty(((Number) InputUtils.getNumber("Enter Quantity in Stock: ")).intValue());
        product.setDescription(InputUtils.getString("Enter Product Description: "));

        // Display product details
        product.displayInfo();

        // Prompt user for order quantity
        int orderQty = ((Number) InputUtils.getNumber("Enter your order quantity: ")).intValue();

        // Check availability and place order
        if (orderQty <= 0) {
            System.out.println("Order failed. Order quantity must be greater than 0.");
        } else if (product.checkAvailability(orderQty)) {
            double totalPrice = product.placeOrder(orderQty);
            System.out.println("Order placed successfully!");
            System.out.println("Total Price: $" + totalPrice);
            System.out.println("Remaining Quantity: " + product.getQty());
        } else {
            System.out.println("Order failed. Insufficient quantity in stock.");
        }

        // Display updated product details
        product.displayInfo();
    }
}
