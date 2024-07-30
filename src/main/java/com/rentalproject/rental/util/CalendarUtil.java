package main.java.com.rentalproject.rental.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class CalendarUtil {

    /**
     * Called observed holiday as business logic shifts specific holidays if they fall onto the weekend.
     * @param date
     * @return true if date is an observed holiday.
     */
    public static boolean isObservedHoliday(LocalDate date) {
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return isJuly4th(month, day, dayOfWeek) || isLaborDay(month, day, dayOfWeek);
    }

    private static boolean isJuly4th(Month month, int day, DayOfWeek dayOfWeek) {
        return month == Month.JULY && ((day == 4 && isWeekday(dayOfWeek)) || (day == 3 && dayOfWeek == DayOfWeek.FRIDAY) || (day == 5 && dayOfWeek == DayOfWeek.MONDAY));
    }

    private static boolean isLaborDay(Month month, int day, DayOfWeek dayOfWeek) {
        return month == Month.SEPTEMBER && dayOfWeek == DayOfWeek.MONDAY && day <= 7;
    }

    public static boolean isWeekday(DayOfWeek dayOfWeek) {
        return ! isWeekend(dayOfWeek);
    }

    public static boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
