public class Converter {
    public static void main(String[] args) {

        // Erstelle eine neue int-Variable namens celsius und initialisiere sie mit dem Wert 24.
        int celsius = 24;
        // F = C * 9 / 5 + 32 (Umwandlung von Grad Celsius in Fahrenheit)
        double fahrenheit = celsius * 9.0 / 5 + 32.0;
        // Gib Wert der Variablen fahrenheit auf Kommandozeile aus.
        System.out.println(fahrenheit);

        // Aufgabe: Implementiere die Formel für die Umwandlung von Fahrenheit in Grad Celsius
        celsius = (int)((fahrenheit - 32.0) * 5.0 / 9);
        System.out.println(celsius);

        {
            // Jede Variable hat einen Gültigkeitsbereich - im englischen auch Scope genannt.
            // Jeder Anweisungsblock {} erstellt einen neuen Scope, in dem Variablen erstellt
            // werden können. Nachdem ein Block abgearbeitet wurde, werden i.d.R. die Variablen
            // wieder freigegeben.
            int x = 10;
            System.out.println(x);
        }
        // Der Zugriff auf Variable x ist hier im äußeren Scope nicht mehr möglich. Die Variable
        // x existiert nur im oberen inneren Scope (definiert durch {})
        // System.out.println(x);

        // Die Klasse Math stellt viele gängige mathematische Funktionen zur Verfügung.
        double result = Math.pow(3, 7); // entspricht 3 hoch 7
        System.out.println(result);
        result = Math.sqrt(5); // berechnet Quadrat-Wurzel aus 5.
        System.out.println(result);
        result = Math.pow(5, 1.0 / 3); // 3te Wurzel aus 5 berechnen.
        System.out.println(result);
        System.out.println(5 * 3 + 7); // Ausdrücke als Argumente für Funktionen erlaubt.

        // Schlüsselwort final definiert eine Variable als "Konstante".
        final double pi = 3.14;
        // pi = 3; // Nachträglich können wir der Variablen pi nichts zuweisen, da sie final ist.

        System.out.println(calculateDistance(2, 3, 10, 10));
        System.out.println(calculateDistance(-2, 3, 10, 10));

    } // Ende von main

    public static double calculateDistance(double ax, double ay, double bx, double by) {
        double deltaX = ax - bx; // horizontale Differenz zwischen den Punkten a und b
        double deltaY = ay - by; // vertikale Differenz zwischen den Punkten a und b
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY); // Differenz zwischen a und b
        // Der Inhalt der Variablen distance wird an den Aufrufer dieser Funktion
        // zurückgegeben.
        return distance;
    }

}
