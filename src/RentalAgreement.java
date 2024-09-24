import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreement {
    private Tool tool;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private BigDecimal dailyRentalCharge;
    private int chargeDays;
    private BigDecimal preDiscountCharge;
    private int discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal finalCharge;

    public RentalAgreement(Tool tool, int rentalDays, LocalDate checkoutDate, int discountPercent) {
        this.tool = tool;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.discountPercent = discountPercent;
        this.dailyRentalCharge = tool.getDailyCharge();
        this.dueDate = checkoutDate.plusDays(rentalDays);
        this.chargeDays = calculateChargeDays();
        this.preDiscountCharge = dailyRentalCharge.multiply(new BigDecimal(chargeDays)).setScale(2, RoundingMode.HALF_UP);
        this.discountAmount = preDiscountCharge.multiply(new BigDecimal(discountPercent)).divide(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
        this.finalCharge = preDiscountCharge.subtract(discountAmount);
    }

    private int calculateChargeDays() {
        int chargeDays = 0;
        LocalDate currentDate = checkoutDate.plusDays(1);

        while (!currentDate.isAfter(dueDate)) {
            boolean isWeekend = currentDate.getDayOfWeek().getValue() >= 6;
            boolean isHoliday = isHoliday(currentDate);

            if ((tool.isChargesOnWeekends() || !isWeekend) && (tool.isChargesOnHolidays() || !isHoliday)) {
                chargeDays++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return chargeDays;
    }

    private boolean isHoliday(LocalDate date) {
        // Check for Independence Day
        if (date.getMonthValue() == 7 && (date.getDayOfMonth() == 4 || (date.getDayOfMonth() == 3 && date.getDayOfWeek().getValue() == 5) || (date.getDayOfMonth() == 5 && date.getDayOfWeek().getValue() == 1))) {
            return true;
        }

        // Check for Labor Day (First Monday in September)
        if (date.getMonthValue() == 9 && date.getDayOfWeek().getValue() == 1 && date.getDayOfMonth() <= 7) {
            return true;
        }

        return false;
    }

    public void printRentalAgreement() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");

        System.out.println("Tool code: " + tool.getToolCode());
        System.out.println("Tool type: " + tool.getToolType());
        System.out.println("Tool brand: " + tool.getBrand());
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Check out date: " + checkoutDate.format(formatter));
        System.out.println("Due date: " + dueDate.format(formatter));
        System.out.println("Daily rental charge: $" + dailyRentalCharge);
        System.out.println("Charge days: " + chargeDays);
        System.out.println("Pre-discount charge: $" + preDiscountCharge);
        System.out.println("Discount percent: " + discountPercent + "%");
        System.out.println("Discount amount: $" + discountAmount);
        System.out.println("Final charge: $" + finalCharge);
    }

    // Getter for final charge to compute the total in CheckoutService
    public BigDecimal getFinalCharge() {
        return finalCharge;
    }
}
