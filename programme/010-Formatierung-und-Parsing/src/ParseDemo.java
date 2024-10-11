import java.text.NumberFormat;
import java.text.ParseException;
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

    }

}
