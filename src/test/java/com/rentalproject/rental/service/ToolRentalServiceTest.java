package test.java.com.rentalproject.rental.service;

import main.java.com.rentalproject.rental.model.RentalAgreement;
import main.java.com.rentalproject.rental.repository.InMemoryToolRepository;
import main.java.com.rentalproject.rental.service.ToolRentalService;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ToolRentalServiceTest {

    /*
        Normally would not call these test1,2…etc., but wanted to be obvious which test were the required ones.
     */

    @Test
    public void testCheckout_requiredTest1() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> toolRentalService.checkout("JAKR", LocalDate.of(2015, 9, 3), 5, 101));

        assertEquals("Discount percent must be between 0 and 100.", ex.getMessage());
    }

    @Test
    public void testCheckout_requiredTest2() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        RentalAgreement rentalAgreement = toolRentalService.checkout("LADW", LocalDate.of(2020, 7, 2), 3, 10);

        assertEquals("LADW", rentalAgreement.getToolCode());
        assertEquals("Ladder", rentalAgreement.getToolType());
        assertEquals("Werner", rentalAgreement.getBrand());
        assertEquals(3, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2020, 7, 2), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2020, 7, 5), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(1.99), rentalAgreement.getDailyRentalCharge());
        assertEquals(2, rentalAgreement.getChargeDays());
        assertEquals(BigDecimal.valueOf(3.98), rentalAgreement.getPreDiscountCharge());
        assertEquals(10, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(.40).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(3.58), rentalAgreement.getFinalCharge());
    }

    @Test
    public void testCheckout_requiredTest3() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        RentalAgreement rentalAgreement = toolRentalService.checkout("CHNS", LocalDate.of(2015, 7, 2), 5, 25);

        assertEquals("CHNS", rentalAgreement.getToolCode());
        assertEquals("Chainsaw", rentalAgreement.getToolType());
        assertEquals("Stihl", rentalAgreement.getBrand());
        assertEquals(5, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2015, 7, 2), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2015, 7, 7), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(1.49), rentalAgreement.getDailyRentalCharge());
        assertEquals(3, rentalAgreement.getChargeDays());
        assertEquals(BigDecimal.valueOf(4.47), rentalAgreement.getPreDiscountCharge());
        assertEquals(25, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(1.12).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(3.35), rentalAgreement.getFinalCharge());
    }

    @Test
    public void testCheckout_requiredTest4() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        RentalAgreement rentalAgreement = toolRentalService.checkout("JAKD", LocalDate.of(2015, 9, 3), 6, 0);

        assertEquals("JAKD", rentalAgreement.getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getToolType());
        assertEquals("DeWalt", rentalAgreement.getBrand());
        assertEquals(6, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2015, 9, 3), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2015, 9, 9), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getDailyRentalCharge());
        assertEquals(3, rentalAgreement.getChargeDays());
        assertEquals(BigDecimal.valueOf(8.97), rentalAgreement.getPreDiscountCharge());
        assertEquals(0, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(8.97), rentalAgreement.getFinalCharge());
    }

    @Test
    public void testCheckout_requiredTest5() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        RentalAgreement rentalAgreement = toolRentalService.checkout("JAKR", LocalDate.of(2015, 7, 2), 9, 0);

        assertEquals("JAKR", rentalAgreement.getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getToolType());
        assertEquals("Ridgid", rentalAgreement.getBrand());
        assertEquals(9, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2015, 7, 2), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2015, 7, 11), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getDailyRentalCharge());
        assertEquals(5, rentalAgreement.getChargeDays());
        assertEquals(BigDecimal.valueOf(14.95), rentalAgreement.getPreDiscountCharge());
        assertEquals(0, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(14.95), rentalAgreement.getFinalCharge());
    }

    @Test
    public void testCheckout_requiredTest6() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        RentalAgreement rentalAgreement = toolRentalService.checkout("JAKR", LocalDate.of(2020, 7, 2), 4, 50);

        assertEquals("JAKR", rentalAgreement.getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getToolType());
        assertEquals("Ridgid", rentalAgreement.getBrand());
        assertEquals(4, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2020, 7, 2), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2020, 7, 6), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getDailyRentalCharge());
        assertEquals(1, rentalAgreement.getChargeDays());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getPreDiscountCharge());
        assertEquals(50, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(1.50).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(1.49), rentalAgreement.getFinalCharge());
    }


    @Test
    public void testCheckout_invalidToolCode() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> toolRentalService.checkout("UNKNOWN", LocalDate.of(2024, 7, 3), 1, 10));

        assertEquals("Invalid tool code.", ex.getMessage());
    }

    @Test
    public void testCheckout_rentalDayNotPositive() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> toolRentalService.checkout("JAKR", LocalDate.of(2024, 7, 3), 0, 10));


        assertEquals("Rental day count must be 1 or greater.", ex.getMessage());
    }

    /**
     * Interesting use case from the spec - since all days rented aren't charge days they get it for free.
     */
    @Test
    public void testCheckout_chargeDaysZero() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        RentalAgreement rentalAgreement = toolRentalService.checkout("JAKR", LocalDate.of(2024, 7, 3), 1, 0);

        assertEquals("JAKR", rentalAgreement.getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getToolType());
        assertEquals("Ridgid", rentalAgreement.getBrand());
        assertEquals(1, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2024, 7, 3), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2024, 7, 4), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getDailyRentalCharge());
        assertEquals(0, rentalAgreement.getChargeDays());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getPreDiscountCharge());
        assertEquals(0, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getFinalCharge());
    }

    /**
     * Test following from the above scenario - ensuring discount percent doesn't behave weirdly.
     */
    @Test
    public void testCheckout_discountOnZeroCharge() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        RentalAgreement rentalAgreement = toolRentalService.checkout("JAKR", LocalDate.of(2024, 7, 3), 1, 50);

        assertEquals("JAKR", rentalAgreement.getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getToolType());
        assertEquals("Ridgid", rentalAgreement.getBrand());
        assertEquals(1, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2024, 7, 3), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2024, 7, 4), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getDailyRentalCharge());
        assertEquals(0, rentalAgreement.getChargeDays());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getPreDiscountCharge());
        assertEquals(50, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getFinalCharge());
    }

    @Test
    public void testCheckout_fullyDiscounted() {
        ToolRentalService toolRentalService = new ToolRentalService(new InMemoryToolRepository());

        RentalAgreement rentalAgreement = toolRentalService.checkout("JAKR", LocalDate.of(2024, 7, 3), 10, 100);

        assertEquals("JAKR", rentalAgreement.getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getToolType());
        assertEquals("Ridgid", rentalAgreement.getBrand());
        assertEquals(10, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2024, 7, 3), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2024, 7, 13), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getDailyRentalCharge());
        assertEquals(6, rentalAgreement.getChargeDays());
        assertEquals(BigDecimal.valueOf(17.94).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getPreDiscountCharge());
        assertEquals(100, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(17.94).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.UNNECESSARY), rentalAgreement.getFinalCharge());
    }
}