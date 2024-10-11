import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class FormatDemo {

    public static void main(String[] args) {

        // Verwende die regionalen Einstellungen der USA als Voreinstellung.
        Locale.setDefault(Locale.GERMANY);

        // Methode format verwendet die per Voreinstellung gesetzte Locale.
        String text = String.format("Prozentsatz: %f", 14.67);
        System.out.println(text);
        // Aber wir können die zu verwendende Locale auch manuell angeben.
        text = String.format(Locale.US, "Prozentsatz: %f", 14.67);
        System.out.println(text);

        // Ein Formatspezifizierer (Platzhalter) sieht
        // wie folgt aus:  %[argument_index$][flags][width][.precision]conversion
        System.out.printf("%f%n", 12.34); // conversion = f, conversion = n
        System.out.printf("%.4f%n", 12.34); // precision = 4, conversion  = f
        System.out.printf("%10.4f%n", 12.34); // width = 10, precision = 4, conversion = f
        System.out.printf("%+10.4f%n", -12.34); // flags = +, width = 10, precision = 4, conversion = f
        System.out.printf("%+010.4f%n", 12.34); // flags = +0, width = 10, precision = 4, conversion = f
        System.out.printf("%+-10.4f%n", 12.34); // flags = +-, width = 10, precision = 4, conversion = f
        // argument_index = 1, conversion = f;  arg=1,width=10,precision=2,con=f ; arg=1, flags=+0,width=10,con=f
        System.out.printf("%1$f %1$10.2f %1$+010f%n", 12.34);
        System.out.println("%1$f %1$10.2f %1$+010f".formatted(12.34));

        // Wir lassen uns ein NumberFormat Objekt für die Region USA geben.
        // Mit dem NumberFormat-Objekt können wir numerische Werte in Zeichenketten umwandeln.
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(numberFormat.format(12.34)); //$12.34
        numberFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(numberFormat.format(12.34)); // 12,34 €
        numberFormat = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(numberFormat.format(2500123)); // 3M
        numberFormat = NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.SHORT);
        System.out.println(numberFormat.format(2500123)); // 3 Mio.

        // Mit der statischen Methode String.valueOf können wir auch Werte in Zeichenketten umwandeln.
        // Vorsicht: valueOf berücksichtigt in den meisten Fällen nicht die regionalen Einstellungen (Locale).
        System.out.println(String.valueOf(12.34)); // 12.34
        System.out.println(String.valueOf(false)); // false
        System.out.println(String.valueOf(2)); // 2

        // Alle Klassen erben direkt oder indirekt von der Klasse java.lang.Object. Dadurch hat jedes Objekt
        // eine Instanzmethode namens toString. Diese Methode gibt eine Repräsentation des Objekts als Zeichenkette
        // zurück. Diese Zeichenkette ist in der Regel aber nicht für den Benutzer des Programms gedacht.
        System.out.println(numberFormat.toString()); // java.text.CompactNumberFormat@b3870928

        // Primitiven Datentypen: byte, short, int, long, float, double, boolean, char
        float f = 2;
        System.out.println(Byte.SIZE); // Wrapper-Klasse für den primitiven Datentyp byte
        System.out.println(Short.SIZE); // Wrapper-Klasse für den primitiven Datentyp short
        System.out.println(Integer.SIZE); // Wrapper-Klasse für den primitiven Datentyp int
        System.out.println(Float.SIZE); // Wrapper-Klasse für den primitiven Datentyp float
        System.out.println(Double.SIZE); // Wrapper-Klasse für den primitiven Datentyp double
        System.out.println(Boolean.getBoolean("false")); // Wrapper-Klasse für den primitiven Datentyp boolean
        System.out.println(Character.SIZE); // Wrapper-Klasse für den primitiven Datentyp char
        System.out.println(Character.toLowerCase('C')); // c
        System.out.println(Character.isDigit('2')); // true

        int[] results = countAlphanumericCharacters("Maxi123 .-+"); // [3, 4]
        System.out.println(Arrays.toString(results));


    }

    public static int[] countAlphanumericCharacters(String text) {
        // Aufgabe: Schreibe eine Methode, die eine Zeichenkette empfängt und zählt, wie viele Ziffern und Buchstaben
        // sich darin befinden. Nutze als Hilfsmittel die Methoden der Klasse Character.
        int totalDigits = 0;
        int totalLetters = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                totalDigits++;
            } else if (Character.isLetter(c)) {
                totalLetters++;
            }
        }
        return new int[]{totalDigits, totalLetters};
    }

}
