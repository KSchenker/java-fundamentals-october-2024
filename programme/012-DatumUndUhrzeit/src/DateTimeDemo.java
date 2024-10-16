import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

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
//            daysUntilBirthday = Duration.between(today.atStartOfDay(), birthdateInThisYear.atStartOfDay()).toDays();
        } else {
            daysUntilBirthday = ChronoUnit.DAYS.between(today, birthdateNextYear);
//            daysUntilBirthday = Duration.between(today.atStartOfDay(), birthdateNextYear.atStartOfDay()).toDays();
        }

        System.out.printf("Peter hat in %d Tagen seinen nächsten Geburtstag\n", daysUntilBirthday);

        System.out.println(getStartOfFirstCalendarWeek(Year.of(2024)));
        System.out.println(getStartOfFirstCalendarWeek(Year.of(2023)));
        System.out.printf("%s bis %s\n",
                getStartOfFirstCalendarWeek(Year.of(2024)),
                getEndOfFirstCalendarWeek(Year.of(2024))
        );
        System.out.printf("%s bis %s\n",
                getStartOfFirstCalendarWeek(Year.of(2025)),
                getEndOfFirstCalendarWeek(Year.of(2025))
        );
        System.out.println(getStartOfLastCalendarWeek(Year.of(2024)));
        System.out.println();

        System.out.println(today);
        System.out.println(today.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println(today.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println(today.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(today.with(TemporalAdjusters.lastDayOfMonth()));
        // Bestimme ersten Donnerstag des aktuellen Monats.
        System.out.println(today.with(TemporalAdjusters.firstInMonth(DayOfWeek.THURSDAY)));
        // Bestimme letzten Donnerstag des aktuellen Monats.
        System.out.println(today.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY)));
        // Ermittle den nächsten Donnerstag.
        System.out.println(today.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)));
        // Ermittle den vorherigen Donnerstag.
        System.out.println(today.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
        // Bestimme nächsten Mittwoch. Falls der aktuelle Tag ein Mittwoch ist, gib ihn zurück.
        System.out.println(today.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)));

        System.out.println(getThirdThursday(Year.of(2024), Month.AUGUST));

    }

    // Aufgabe: Bestimme den DRITTEN Donnerstag eines Monats M in einem Jahr J. Verwende
    // die Mechanismen von TemporalAdjusters.
    public static LocalDate getThirdThursday(Year year, Month month) {
        LocalDate date = LocalDate.of(year.getValue(), month, 1);
        // Finde ersten Donnerstag des Monats und addiere 2 Wochen (14 Tage drauf).
        LocalDate firstThursday = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
        return firstThursday.plusWeeks(2);
    }

    // Aufgabe: Für ein gegebenes Jahr soll das Start und Enddatum der ersten Kalenderwoche berechnet werden.
    // Die erste Kalenderwoche eines Jahres J ist jene Woche, die MINDESTENS 4 Tage aus dem Jahr J enthält.
    // Hinweis: Der 1.1.J ist nicht immer ein Montag, d.h. er kann durchaus noch zur letzten KW des Vorjahres J-1
    // gehören.
    // Standard: ISO 8601: Nach dem ISO-Standard wird die erste Kalenderwoche als die Woche definiert,
    // die den ersten Donnerstag des Jahres enthält. Das bedeutet, dass der 4. Januar immer in der ersten Kalenderwoche liegt.
    public static LocalDate getStartOfFirstCalendarWeek(Year year) {
        // Ermittle den 4. Januar des neues Jahres.
        LocalDate fourthJanuary = LocalDate.of(year.getValue(), 1, 4);
        // Gehe nun solange Tag für Tag zurück, bis wir den Montag erreichen. Das ist dann der Beginn der Kalenderwoche 1.
        LocalDate start = fourthJanuary;
        while (start.getDayOfWeek() != DayOfWeek.MONDAY) {
            start = start.minusDays(1);
        }
        return start;
    }

    public static LocalDate getEndOfFirstCalendarWeek(Year year) {
        // Ermittle das Enddatum der ersten Kalenderwoche des Jahres.
        // Idee: Ermittle Beginn der Kalenderwoche und rechne 6 Tage drauf.
        return getStartOfFirstCalendarWeek(year).plusDays(6);
    }

    public static LocalDate getStartOfLastCalendarWeek(Year year) {
        // Ermittle das Startdatum der letzten Kalenderwoche des Jahres.
        // Idee: Ermittle Startdatum der 1. KW des Folgejahres und ziehe 7 Tage ab.
        return getStartOfFirstCalendarWeek(year.plusYears(1)).minusDays(7);
    }

    public static LocalDate getStartOfCalendarWeek(Year year, int weekNumber) {
        // Ermittle den Beginn der Kalenderwoche "weekNumber" (1-52/53).
        // Idee: Ermittle Startdatum der 1. KW des Jahres und rechne ein Vielfaches von 7 Tagen darauf.
        LocalDate start = getStartOfFirstCalendarWeek(year).plusDays(7 * (weekNumber - 1));
        return start;
    }

    // ISO Kalenderwochen und ISO Kalenderjahre
    // Der ISO 8601 Standard teilt ein Jahr in nicht überlappende Kalenderwochen ein, wobei
    // jede Kalenderwoche immer mit einem Montag beginnt. Ein Kalenderjahr besteht entweder aus
    // 52 oder aus 53 Kalenderwochen.
    //
    // Mit WeekFields.ISO.weekBasedYear und WeekFields.ISO.weekofWeekBasedYear
    // lässt sich das Kalenderjahr eines Datums und die Kalenderwoche
    // ermitteln.
    //
    // LocalDate.of(2024, 12, 30).get(WeekFields.ISO.weekBasedYear()) liefert 2025
    // LocalDate.of(2024, 12, 30).get(WeekFields.ISO.weekOfWeekBasedYear()) liefert 1
    // da der 30.12.2024 (Mo) schon zur 1.KW des Kalenderjahres 2025 gehört.
    //
    // LocalDate.of(2024, 12, 29).get(WeekFields.ISO.weekBasedYear()) liefert 2024
    // LocalDate.of(2024, 12, 29).get(WeekFields.ISO.weekOfWeekBasedYear()) liefert 52
    // Der 29.12.2024 (So) gehört noch zum Kalenderjahr 2024, da das Datum zur
    // 52. KW von 2024 gehört.


}
