package test.java.com.rentalproject.rental.model;

import main.java.com.rentalproject.rental.model.RentalAgreement;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RentalAgreementTest {

    @Test
    public void printAgreement() {
        RentalAgreement rentalAgreement = new RentalAgreement(
                "TEST_TOOL_CODE",
                "TEST_TOOL_TYPE",
                "TEST_BRAND",
                15,
                LocalDate.of(2024, 7, 3),
                LocalDate.of(2024, 7, 18),
                BigDecimal.valueOf(1.23),
                1,
                // Bogus charge to ensure big decimal formatting is happening as expected in thousands
                BigDecimal.valueOf(20000),
                35,
                BigDecimal.valueOf(3),
                BigDecimal.valueOf(4)
        );

        assertEquals("Tool code: TEST_TOOL_CODE\n" +
                "Tool type: TEST_TOOL_TYPE\n" +
                "Tool brand: TEST_BRAND\n" +
                "Rental days: 15\n" +
                "Check out date: 07/03/24\n" +
                "Due date: 07/18/24\n" +
                "Daily rental charge: $1.23\n" +
                "Charge days: 1\n" +
                "Pre-discount charge: $20,000.00\n" +
                "Discount percent: 35%\n" +
                "Discount amount: $3.00\n" +
                "Final charge: $4.00",
                rentalAgreement.printAgreement());
    }
}