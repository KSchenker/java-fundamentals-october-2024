import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExceptionDemo {

    public static void main(String[] args) throws IOException {
        // In Java werden Fehler durch Objekte der Klasse Exception repräsentiert. Man unterscheidet
        // gewöhnliche Exceptions (man muss sie abfangen / checked exceptions) und ungewöhnliche Exceptions
        // (kann man abfangen / unchecked exceptions).

        // Beispiel für eine ungewöhnliche (unchecked) Exception: ArrayIndexOutOfBoundsException.
        // Der Compiler verlangt keine Fehlerbehandlung, da ein solcher Fehler durch sorgfältige Programmierung
        // verhindert werden kann.
        int[] numbers = {1, 2};
        System.out.println(numbers[4]);

        // Beispiel für gewöhnliche Exceptions (checked): IOException
        // Der Compiler zwingt uns diese Exception zu behandeln, da es durchaus erwartbar ist, dass der Dateizugriff
        // fehlschlägt (Datei nicht vorhanden, fehlende Rechte, bereits geöffnet etc.)
        // Nun haben wir 2 Möglichkeiten:
        // 1) Wir behandeln den Fehler an Ort und Stelle mit einer try-catch-finally Anweisung
        // 2) Wir delegieren die Fehlerbehandlung an den Aufrufer dieser Methode. In diesem Fall müssen wir hinter
        //    den Methodennamen eine throws-Klausel ergänzen. Diese Klausel definiert die nicht abgefangenen Exceptions.
        Files.readAllLines(Path.of("words.txt"));
    }

}
