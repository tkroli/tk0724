package test.java.com.rentalproject.rental.util;

import main.java.com.rentalproject.rental.util.CalendarUtil;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarUtilTest {

    @Test
    public void testJuly4th_notCorrectDate() {
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2024, 1, 1)));
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2024, 1, 4)));
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2024, 7, 1)));
    }

    @Test
    public void testJuly4th_weekday() {
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2024, 7, 3)));
        assertTrue(CalendarUtil.isObservedHoliday(LocalDate.of(2024, 7, 4)));
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2024, 7, 5)));
    }

    @Test
    public void testJuly4th_saturday() {
        assertTrue(CalendarUtil.isObservedHoliday(LocalDate.of(2020, 7, 3)));
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2020, 7, 4)));
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2020, 7, 5)));
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2020, 7, 6)));
    }

    @Test
    public void testJuly4th_sunday() {
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2021, 7, 2)));
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2021, 7, 3)));
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2021, 7, 4)));
        assertTrue(CalendarUtil.isObservedHoliday(LocalDate.of(2021, 7, 5)));
    }

    @Test
    public void testLaborDay() {
        // Test first monday in another month
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2023, 8, 7)));

        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2024, 9, 1)));
        assertTrue(CalendarUtil.isObservedHoliday(LocalDate.of(2024, 9, 2)));
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2024, 9, 3)));

        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2023, 9, 3)));
        assertTrue(CalendarUtil.isObservedHoliday(LocalDate.of(2023, 9, 4)));
        assertFalse(CalendarUtil.isObservedHoliday(LocalDate.of(2023, 9, 5)));
    }

}