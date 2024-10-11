import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

public class ParseDemo {

    public static void main(String[] args) throws ParseException {
        // Beim Parsing geht es darum, aus einem Text einen Wert zu erzeugen.

        // Variante 1: Man nutzt die Wrapper-Klassen der primitiven Datentypen
        // Achtung: Die im folgenden genannten parse Methoden berücksichtigen keine regionalen Einstellungen (Locale).
        byte b = Byte.parseByte("12"); // Interpretiere Zeichenkette als Dezimalzahl (Basis/Radix = 10)
        System.out.println(b);
        b = Byte.parseByte("0F", 16); // Interpretiere Zeichenkette als Hexadezimalzahl (Basis/Radix = 16)
        System.out.println(b);
        System.out.println(Short.parseShort("123"));
        System.out.println(Integer.parseInt("123"));
        System.out.println(Long.parseLong("123"));
        System.out.println(Double.parseDouble("-12.3134"));
        // System.out.println(Double.parseDouble("-12,34")); // Exception: Es wird ein Punkt statt eines Kommas erwartet.
        System.out.println(Boolean.parseBoolean("true")); // true
        System.out.println(Boolean.parseBoolean("false")); // false
        // Hinweis: Character hat keine parse-Methode, da Text ja aus Charactern besteht.

        // Variante 2: Wir nutzen die NumberFormat-Klasse, um regionale Einstellungen zu berücksichtigen.
        // Ein Objekt vom Typ NumberFormat hat eine parse-Methode, mit der wir alle numerischen Werte parsen können.
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.GERMANY);
        Number n = numberFormat.parse("-1.223,34");
        double d = n.doubleValue(); // Wandle die Number in ein double um.
        System.out.println(d);
        System.out.printf("%f\n", d);
        int i = n.intValue(); // Wandle die Number in einen int um.
        System.out.println(i);

        String fileContents = """
                Mustermann;Max;2001-03-12;19.5;m
                Wonderland ;Alice;1999-02-05;14.25;f
                "Ban Jonsey";"Bob";1990-01-30;12;m""";

        // Aufgabe: Zerlege den Dateiinhalt in mehrere Datensätze (Zeilen). Trenne die Zeilen wiederum in mehrere
        // Felder auf (getrennt durch ;). Entferne führende und nachfolgenden Leeraum (Whitespace). Entferne führende und nachfolgende
        // Hochkommas "". Das Jahr, der Monat und der Tag sollen als Integer geparst werden. Der Steuersatz als double.
        // Das Geschlecht ist als char zu speichern.
        String[] lines = fileContents.split("\n");
        for (String aLine : lines) {
            String[] fields = aLine.split(";");
            // Bereinige die Felder
            for (int index = 0; index < fields.length; index++) {
                String field = fields[index];
                // Entferne Leerraum am Anfang und am Ende.
                field = field.strip();
                // Entferne ein führendes "
                if (field.startsWith("\"")) {
                    field = field.substring(1);
                }
                // Entferne ein am Ende stehendes "
                if (field.endsWith("\"")) {
                    field = field.substring(0, field.length() - 1);
                }
                // Speichere das transformierte im Array zurück.
                fields[index] = field;
            }
            // Trenne das Datumsfeld in seine Bestandteile auf.
            String[] dateParts = fields[2].split("-");
            // Wandle die einzelnen Bestandteile in Zahlen um.
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            // Ermittle den Steuersatz als double
            double taxRate = Double.parseDouble(fields[3]);
            // Ermittle das Geschlecht als Character
            char gender = fields[4].charAt(0);
            // Gib die Daten formatiert aus
            System.out.printf("Nachname: %-20s Vorname: %8s Geburtsdatum: %02d.%02d.%04d Steuersatz: %.2f Geschlecht: %c\n",
                    fields[0], fields[1], day, month, year, taxRate, gender);
        }

    }

}
