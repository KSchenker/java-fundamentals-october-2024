import java.util.Locale;

public class FormatDemo {

    public static void main(String[] args) {

        // Verwende die regionalen Einstellungen der USA als Voreinstellung.
        Locale.setDefault(Locale.US);

        // Methode format verwendet die per Voreinstellung gesetzte Locale.
        String text = String.format("Prozentsatz: %f", 14.67);
        System.out.println(text);
        // Aber wir können die zu verwendende Locale auch manuell angeben.
        text = String.format(Locale.GERMAN, "Prozentsatz: %f", 14.67);
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



    }

}
