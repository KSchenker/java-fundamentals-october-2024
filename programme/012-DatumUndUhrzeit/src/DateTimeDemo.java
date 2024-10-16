import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

public class DateTimeDemo {
    public static void main(String[] args) {

        // Die Local Klassen beziehen sich auf die Zeitzone des Computers, auf dem
        // das Java-Programm ausgeführt wird.
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        // Ein Objekt vom Typ LocalDateTime enthält Datum + Uhrzeit.
        System.out.println(LocalDateTime.now());
        // Wie spät ist es gerade in Toyko (Japan)?
        System.out.println(LocalDateTime.now(ZoneId.of("Asia/Tokyo")));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getYear()); // Jahr
        System.out.println(now.getMonthValue()); // Monat
        System.out.println(now.getDayOfMonth()); // Tag
        System.out.println(now.getMonth()); // Monatsobjekt

        Month m = Month.JANUARY;
        m = Month.DECEMBER;
        DayOfWeek d = DayOfWeek.FRIDAY;
        d = DayOfWeek.MONDAY;

        // Achtung: Die Klassen in package java.time sind in der Regel immutable. D.h. ein erstelltes
        // Objekt kann nicht mehr verändert werden. Jede Veränderung erzeugt stattdessen ein neues
        // Objekt. Das ist vergleichbar mit String-Objekten.
        LocalDate philippsBirthdate = LocalDate.of(1998, 2, 28);
        System.out.println(philippsBirthdate);
        // Gehört das Datum zu einem Schaltjahr?
        System.out.println(philippsBirthdate.isLeapYear());
        // 28.02.1998 + 1 Tag ergibt den 01.03.1998, da 1998 kein Schaltjahr ist.
        System.out.println(philippsBirthdate.plusDays(1));
        LocalDate nextDay = philippsBirthdate.plusDays(1);
        System.out.println(nextDay);

        // Klasse Period repräsentiert die Zeitspanne zwischen zwei LocalDate Objekten.
        Period period = Period.between(philippsBirthdate, LocalDate.now());
        System.out.println(period);
        System.out.printf("Philipp ist %d Jahre alt\n", period.getYears());
        // Wie viele Jahre, Monate und Tage muss ich vom aktuellen Datum abziehen, um
        // bei Philipps Geburtsdatum zu landen? Erstes Argument ist Startdatum und zweites
        // Argument ist Zieldatum.
        System.out.println(Period.between(LocalDate.now(), philippsBirthdate));

        // Wie viel Zeit noch bis 15 Uhr des aktuellen Tages?
        Duration timeDiff = Duration.between(LocalDateTime.now(), LocalDateTime.now().withHour(15).withMinute(0).withSecond(0));
        System.out.println(timeDiff);

        // Hier ist schön zu sehen, dass die Zeitzoneninformationen nicht in Local-Objekten gespeichert und bei
        // zukünftigen Berechnungen berücksichtigt werden.
        LocalDateTime germany = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        LocalDateTime japan = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(Duration.between(germany, japan)); // ungefähr 7 Stunden

        LocalDate attackDate = LocalDate.of(2001, 9, 11);
        LocalDate revengeDate = LocalDate.of(2001, 12, 3);
        // Die d1.compareTo(d2) Methode liefert einen negativen Wert, wenn d1 < d2.
        // Es liefert den Wert 0, wenn d1 == d2.
        // Es liefert einen Wert > 0, wenn d1 > d2.
        System.out.println(attackDate.compareTo(revengeDate)); // negative Zahl (d.h. attackDate liegt zeitlich vor revengeDate)
        System.out.println(revengeDate.compareTo(attackDate)); // echt positive Zahl (d.h. revengeDate liegt zeitlich nach attackDate)
        System.out.println(revengeDate.compareTo(revengeDate)); // exakt 0 (d.h. beide Daten sind gleich)

//        printMonth(YearMonth.now());
        printMonth(YearMonth.of(2023, 2));
        System.out.println();
        System.out.println();

        // Formatierung von Datum und Uhrzeit mit printf
        LocalDateTime rightNow = LocalDateTime.now();
        System.out.printf("%1$tH : %1$tM : %1$tS Datum: %1$td. %1$tB %1$tY\n", rightNow);

        // Formatierung von Datum und Uhrzeit mit der DateTimeFormatter Klasse.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        System.out.println(formatter.format(rightNow));
//        TemporalAccessor parsedDateTime = formatter.parse("06:35:22 01.03.1997");
//        System.out.println(parsedDateTime.getClass().getName());
        // Mit der DateTimeFormatter Klasse kann man auch Datums und Uhrzeiten parsen.
        // Dafür verwendet man am besten eine der LocalXXX Klassen und übergibt neben der zu parsenden
        // Zeichenkette auch das Formatter-Objekt.
        LocalDateTime parsed = LocalDateTime.parse("06:35:22 01.03.1997", formatter);
        System.out.println(parsed);

        // Umwandlung von Zeitpunkten zwischen unterschiedlichen Zeitzonen.
        ZoneId myTimezone = ZoneId.of("Europe/Berlin");
        ZoneId targetTimezone = ZoneId.of("Asia/Tokyo");
        LocalDateTime myTime = LocalDateTime.now();
        ZonedDateTime myTimeWithTimezone = myTime.atZone(myTimezone);
        // Methode withZoneSameInstant behält den Zeitpunkt bei, d.h. es wird keine Umrechnung durchgeführt,
        // sondern lediglich die Zeitzone verändert.
        ZonedDateTime targetTimeWithTimezone = myTimeWithTimezone.withZoneSameInstant(targetTimezone);
        System.out.println("Berlin: " + formatter.format(myTimeWithTimezone));
        System.out.println("Tokyo : " + formatter.format(targetTimeWithTimezone));

        printToday();
        printEndOfShow();
        petersBirthdate();

    }

    public static void printMonth(YearMonth x) {
        // Aufgabe: Gib eine tabellarische Ansicht der Jahr-Monat-Kombination x aus.
        // Oktober 2024
        // Mo Di Mi Do Fr Sa So
        //    01 02 03 04 05 06
        // 07 08 09 10 11 12 13 usw.
        System.out.printf("Monat: %s Jahr: %04d\n", x.getMonth(), x.getYear());
        System.out.println("Mo Di Mi Do Fr Sa So");
        System.out.println("-".repeat(20));

        // Ermittle Startdatum, Wochentag und Endedatum des Monats.
        LocalDate startDate = x.atDay(1);
        DayOfWeek dayOfStartDate = startDate.getDayOfWeek();
        LocalDate endDate = x.atEndOfMonth();
        // Gib Leeraum aus, um die erste Zeile entsprechend des Wochentages korrekt einzurücken.
        // Tag Montag hat den numerischen Wert 1, Dienstag den numerischen Wert 2 usw.
        System.out.print(" ".repeat((dayOfStartDate.getValue() - 1) * 3));
        // Gib nun die Tage des Monats in tabellarischer Form aus.
        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
            System.out.printf("%02d ", date.getDayOfMonth());
            // Falls wir gerade den Sonntag ausgegeben haben, fügen wir einen Zeilenumbruch ein.
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
            }
        }
    }

    // Aufgabe: Geben Sie das heutige Datum in der Form: Montag, 31.12 aus, also mit Wochentag aber ohne
    // Jahreszahl. Verwenden Sie einmal die printf Methode und die %t Platzhalter sowie einmal die Klasse
    // DateTimeFormatter.
    public static void printToday() {
        LocalDate today = LocalDate.now();
        System.out.printf("%1$tA, %1$td.%1$tm\n", today);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd.MM");
        System.out.println(formatter.format(today));
//        LocalDate tomorrow = today.plusDays(1);
//        System.out.println(formatter.format(tomorrow));
    }


    // Aufgabe 2: Ein Kinofilm beginnt um 19:30 Uhr und dauert 132 Minuten. Wann ist die Vorstellung beendet? (Duration)
    public static void printEndOfShow() {
        LocalTime startTime = LocalTime.of(19, 30);
        LocalTime endTime = startTime.plusMinutes(132); // 2h 12 min
        System.out.println(endTime);

        Duration duration = Duration.ofMinutes(132);
        endTime = startTime.plus(duration);
        System.out.println(endTime);
    }

    // Aufgabe 3: Peter ist am 17.03.1984 geboren. Wie alt ist Peter heute und in wie vielen Tagen findet sein
    // nächster Geburtstag statt? (Period, ChronoUnit.DAYS.between(zeitpunkt1, zeitpunkt2))
    public static void petersBirthdate() {
        LocalDate birthdate = LocalDate.of(1984, Month.MARCH, 17);
        LocalDate today = LocalDate.now();
        int age = Period.between(birthdate, today).getYears();
        System.out.printf("Peter ist %d Jahre alt\n", age);

        // Das Geburtsdatum von Peter im aktuellen Jahr.
        LocalDate birthdateInThisYear = birthdate.withYear(today.getYear());
        // Geburtsdatum von Peter im nächsten Jahr.
        LocalDate birthdateNextYear = birthdateInThisYear.plusYears(1);

        // Falls Peter noch nicht in diesem Jahr Geburtstag hatte, berechne die Anzahl Tage
        // bis zum Geburtstag in diesem Jahr, andernfalls die Tage bis zum Geburtstag nächstes Jahr.
        long daysUntilBirthday = 0;
        if (today.isBefore(birthdateInThisYear)) {
            daysUntilBirthday = ChronoUnit.DAYS.between(today, birthdateInThisYear);
        } else {
            daysUntilBirthday = ChronoUnit.DAYS.between(today, birthdateNextYear);
        }

        System.out.printf("Peter hat in %d Tagen seinen nächsten Geburtstag\n", daysUntilBirthday);
    }

}
