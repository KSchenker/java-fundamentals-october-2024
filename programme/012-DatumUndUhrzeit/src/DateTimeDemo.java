import java.time.*;

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


    }
}
