package main.java.com.rentalproject.rental.service;

import main.java.com.rentalproject.rental.model.RentalAgreement;
import main.java.com.rentalproject.rental.model.Tool;
import main.java.com.rentalproject.rental.model.ToolType;
import main.java.com.rentalproject.rental.repository.ToolRepository;
import main.java.com.rentalproject.rental.util.CalendarUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class ToolRentalService {

    private final ToolRepository toolRepository;

    public ToolRentalService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public RentalAgreement checkout(String toolCode, LocalDate checkoutDate, int rentalDays, int discountPercent) throws IllegalArgumentException {
        if (rentalDays < 1) throw new IllegalArgumentException("Rental day count must be 1 or greater.");
        if (discountPercent < 0 || discountPercent > 100) throw new IllegalArgumentException("Discount percent must be between 0 and 100.");

        Tool tool = toolRepository.lookupToolByCode(toolCode);
        if (tool == null) throw new IllegalArgumentException("Invalid tool code.");
        ToolType toolType = tool.getToolType();

        LocalDate dueDate = checkoutDate.plusDays(rentalDays);

        BigDecimal dailyCharge = toolType.getDailyCharge();
        int chargeDays = getChargeDays(checkoutDate, dueDate, toolType);
        // Per spec, pre discount charge's resulting total must be rounded half up to cents.
        BigDecimal preDiscountCharge = dailyCharge.multiply(BigDecimal.valueOf(chargeDays)).setScale(2, RoundingMode.HALF_UP);
        // Per spec, round half up here as well.
        BigDecimal discountAmount = preDiscountCharge.multiply(BigDecimal.valueOf(discountPercent)).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
        BigDecimal finalCharge = preDiscountCharge.subtract(discountAmount);

        return new RentalAgreement(toolCode, toolType.getToolTypeName(), tool.getBrand(), rentalDays, checkoutDate, dueDate,
                dailyCharge, chargeDays, preDiscountCharge, discountPercent, discountAmount, finalCharge);
    }

    private static int getChargeDays(LocalDate checkoutDate, LocalDate dueDate, ToolType toolType) {
        int chargeDays = 0;

        // Per spec, need to count from day after checkout through and including due date
        for (LocalDate date = checkoutDate.plusDays(1); !date.isAfter(dueDate); date = date.plusDays(1)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            boolean isWeekend = CalendarUtil.isWeekend(dayOfWeek);
            boolean isHoliday = CalendarUtil.isObservedHoliday(date);

            if ((toolType.isChargesOnHolidays() && isHoliday)
                    || (toolType.isChargesOnWeekends() && isWeekend)
                    || (toolType.isChargesOnWeekdays() && !isWeekend && !isHoliday)) {
                chargeDays++;
            }
        }
        return chargeDays;
    }
}
