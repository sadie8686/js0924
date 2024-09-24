import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    private List<RentalAgreement> rentalAgreements = new ArrayList<>();

    public RentalAgreement checkout(String toolCode, int rentalDayCount, int discountPercent, LocalDate checkoutDate) {
        if (rentalDayCount < 1) {
            throw new IllegalArgumentException("Rental day count must be 1 or greater.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount percent must be between 0 and 100.");
        }

        Tool tool = getToolByCode(toolCode);
        RentalAgreement agreement = new RentalAgreement(tool, rentalDayCount, checkoutDate, discountPercent);
        rentalAgreements.add(agreement);
        return agreement;
    }

    private Tool getToolByCode(String toolCode) {
        // Normally, this would be a lookup from a database or similar.
        switch (toolCode) {
            case "CHNS":
                return new Tool("CHNS", "Chainsaw", "Stihl", new BigDecimal("1.49"), false, true);
            case "LADW":
                return new Tool("LADW", "Ladder", "Werner", new BigDecimal("1.99"), true, false);
            case "JAKD":
                return new Tool("JAKD", "Jackhammer", "DeWalt", new BigDecimal("2.99"), false, false);
            case "JAKR":
                return new Tool("JAKR", "Jackhammer", "Ridgid", new BigDecimal("2.99"), false, false);
            default:
                throw new IllegalArgumentException("Invalid tool code.");
        }
    }

    // Method to print all rental agreements and total cost
    public void printAllRentalAgreements() {
        BigDecimal totalCost = BigDecimal.ZERO;

        for (RentalAgreement agreement : rentalAgreements) {
            agreement.printRentalAgreement();
            System.out.println();  // Adding a new line for better readability
            totalCost = totalCost.add(agreement.getFinalCharge());
        }

        System.out.println("Total cost for all rentals: $" + totalCost.setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
