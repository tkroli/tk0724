package main.java.com.rentalproject.rental.model;

import java.math.BigDecimal;

/**
 * Type of tool e.g. jackhammer, chainsaw etc.  Holds the common attributes common to types of tools.
 */
public class ToolType {
    private final String toolTypeName;
    private final BigDecimal dailyCharge;
    private final boolean chargesOnWeekdays;
    private final boolean chargesOnWeekends;
    private final boolean chargesOnHolidays;

    public ToolType(String toolTypeName, BigDecimal dailyCharge, boolean chargesOnWeekdays, boolean chargesOnWeekends, boolean chargesOnHolidays) {
        this.toolTypeName = toolTypeName;
        this.dailyCharge = dailyCharge;
        this.chargesOnWeekdays = chargesOnWeekdays;
        this.chargesOnWeekends = chargesOnWeekends;
        this.chargesOnHolidays = chargesOnHolidays;
    }

    public String getToolTypeName() { return toolTypeName; }
    public BigDecimal getDailyCharge() { return dailyCharge; }
    public boolean isChargesOnWeekdays() { return chargesOnWeekdays; }
    public boolean isChargesOnWeekends() { return chargesOnWeekends; }
    public boolean isChargesOnHolidays() { return chargesOnHolidays; }
}
