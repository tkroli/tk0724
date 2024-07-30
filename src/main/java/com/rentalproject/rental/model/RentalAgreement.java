package main.java.com.rentalproject.rental.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Simple agreement class that holds the calculated data and owns the ability to print the agreement.
 */
public class RentalAgreement {
    private final String toolCode;
    private final String toolType;
    private final String brand;
    private final int rentalDays;
    private final LocalDate checkoutDate;
    private final LocalDate dueDate;
    private final BigDecimal dailyRentalCharge;
    private final int chargeDays;
    private final BigDecimal preDiscountCharge;
    private final int discountPercent;
    private final BigDecimal discountAmount;
    private final BigDecimal finalCharge;

    public RentalAgreement(String toolCode, String toolType, String brand, int rentalDays, LocalDate checkoutDate, LocalDate dueDate,
                           BigDecimal dailyRentalCharge, int chargeDays, BigDecimal preDiscountCharge, int discountPercent, BigDecimal discountAmount, BigDecimal finalCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public String printAgreement() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        DecimalFormat currencyFormatter = new DecimalFormat("$#,##0.00");
        DecimalFormat percentFormatter = new DecimalFormat("#%");
        // Main idea of the method is to print to console, but offering returned string for ease of testing and
        // it makes general sense.
        String formattedAgreement = "Tool code: " + toolCode + '\n' +
                "Tool type: " + toolType + '\n' +
                "Tool brand: " + brand + '\n' +
                "Rental days: " + rentalDays + '\n' +
                "Check out date: " + checkoutDate.format(dateFormatter) + '\n' +
                "Due date: " + dueDate.format(dateFormatter) + '\n' +
                "Daily rental charge: " + currencyFormatter.format(dailyRentalCharge) + '\n' +
                "Charge days: " + chargeDays + '\n' +
                "Pre-discount charge: " + currencyFormatter.format(preDiscountCharge) + '\n' +
                "Discount percent: " + percentFormatter.format(discountPercent / 100.0) + '\n' +
                "Discount amount: " + currencyFormatter.format(discountAmount) + '\n' +
                "Final charge: " + currencyFormatter.format(finalCharge);
        System.out.println(formattedAgreement);
        return formattedAgreement;
    }

    public String getToolCode() { return toolCode; }
    public String getToolType() { return toolType; }
    public String getBrand() { return brand; }
    public int getRentalDays() { return rentalDays; }
    public LocalDate getCheckoutDate() { return checkoutDate; }
    public LocalDate getDueDate() { return dueDate; }
    public BigDecimal getDailyRentalCharge() { return dailyRentalCharge; }
    public int getChargeDays() { return chargeDays; }
    public BigDecimal getPreDiscountCharge() { return preDiscountCharge; }
    public int getDiscountPercent() { return discountPercent; }
    public BigDecimal getDiscountAmount() { return discountAmount; }
    public BigDecimal getFinalCharge() { return finalCharge; }

}
