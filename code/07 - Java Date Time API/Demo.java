// Issues With the Existing Date/Time APIs
// 1) Thread safety – The Date and Calendar classes are not thread safe, leaving
// developers to deal with the headache of hard-to-debug concurrency issues and to
// write additional code to handle thread safety. On the contrary, the new Date and
// Time APIs introduced in Java 8 are immutable and thread safe, thus taking
// that concurrency headache away from developers.

// 2) API design and ease of understanding – The Date and Calendar APIs are poorly
// designed with inadequate methods to perform day-to-day operations.
// The new Date/Time API is ISO-centric and follows consistent domain models
// for date, time, duration and periods. There are a wide variety of utility
// methods that support the most common operations.

// 3) ZonedDate and Time – Developers had to write additional logic to
// handle time-zone logic with the old APIs, whereas with the new APIs,
// handling of time zone can be done with Local and ZonedDate/Time APIs.

// ********************************************************
// LocalDate
// ********************************************************
// The LocalDate represents a date in ISO format (yyyy-MM-dd) without time.
// We can use it to store dates like birthdays and paydays.
// An instance of current date can be created from the system clock:
LocalDate localDate = LocalDate.now();

// And we can get the LocalDate representing a specific day, month and year by
// using the of method or the parse method. For example, these code snippets
// represent the LocalDate for February 20, 2015:
LocalDate.of(2015, 02, 20);
LocalDate.parse("2015-02-20");

// The LocalDate provides various utility methods to obtain a variety of information.
// Let's have a quick peek at some of these API methods.
// The following code snippet gets the current local date and adds one day:
LocalDate tomorrow = LocalDate.now().plusDays(1);

// This example obtains the current date and subtracts one month.
// Note how it accepts an enum as the time unit:
LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);

// In the following two code examples, we parse the date “2016-06-12”
// and get the day of the week and the day of the month respectively.
// Note the return values — the first is an object representing the DayOfWeek, while the second is an int representing the ordinal value of the month:
DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();

// We can test if a date occurs in a leap year, for example the current date:
boolean leapYear = LocalDate.now().isLeapYear();

// Also, the relationship of a date to another can be determined to occur before
// or after another date:
boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));

boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));

// Finally, date boundaries can be obtained from a given date.
// In the following two examples, we get the LocalDateTime that represents
// the beginning of the day (2016-06-12T00:00) of the given date and the
// LocalDate that represents the beginning of the month (2016-06-01) respectively:

LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();

LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
        .with(TemporalAdjusters.firstDayOfMonth());


// ********************************************************
// LocalTime
// ********************************************************

// ********************************************************
// LocalDateTime
// ********************************************************


