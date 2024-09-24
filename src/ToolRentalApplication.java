import java.time.LocalDate;

public class ToolRentalApplication {

    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService();

        // Renting multiple tools
        checkoutService.checkout("LADW", 5, 10, LocalDate.of(2024, 9, 1));  // Renting a Ladder for 5 days
        checkoutService.checkout("CHNS", 3, 20, LocalDate.of(2024, 7, 2));  // Renting a Chainsaw for 3 days
        checkoutService.checkout("JAKD", 7, 15, LocalDate.of(2024, 9, 5));  // Renting a Jackhammer for 7 days

        // Printing all rental agreements and total cost
        checkoutService.printAllRentalAgreements();
    }
}
