import java.math.BigDecimal;

public class Tool {
    private String toolCode;
    private String toolType;
    private String brand;
    private BigDecimal dailyCharge;
    private boolean chargesOnWeekends;
    private boolean chargesOnHolidays;

    public Tool(String toolCode, String toolType, String brand, BigDecimal dailyCharge, boolean chargesOnWeekends, boolean chargesOnHolidays) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
        this.dailyCharge = dailyCharge;
        this.chargesOnWeekends = chargesOnWeekends;
        this.chargesOnHolidays = chargesOnHolidays;
    }

    // Getters
    public String getToolCode() { return toolCode; }
    public String getToolType() { return toolType; }
    public String getBrand() { return brand; }
    public BigDecimal getDailyCharge() { return dailyCharge; }
    public boolean isChargesOnWeekends() { return chargesOnWeekends; }
    public boolean isChargesOnHolidays() { return chargesOnHolidays; }
}
