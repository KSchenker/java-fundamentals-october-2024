import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class ExceptionDemo {

    public static void main(String[] args) throws IOException {
        //introduction();
        //f();
        //System.out.println(readNumberV3("Welches Jahr haben wir", 3));
//        playLotto();
//        printEmployeeInfo("   ", 20, "CGA-0123-ab");
    }

    private static void introduction() throws IOException {
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

    public static void f() {
        System.out.println("f startet");
        g();
        System.out.println("f endet");
    }

    public static void g() {
        System.out.println("g startet");
        // Die try-Anweisung besteht aus mindestens einem Block. Der erste Block enthält Anweisungen, deren Exceptions
        // wir behandeln möchten. Danach folgen ggf. mehrere catch-Blöcke. Jeder catch-Block kann sich um eine oder
        // mehrere Exeptions "kümmern" bzw. diese "behandeln".
        try {
            h();
            // Hier können noch weitere Anweisungen stehen. Diese werden jedoch nur dann ausgeführt, wenn h()
            // keine Exceptions auslöst.
        } catch (RuntimeException e) {
            // Hier erfolgt die Fehlerbehandlung für Exceptions vom Typ RuntimeException. Das schließt auch alle
            // Exceptions ein, deren Klassen Nachfahren von RuntimeException sind. e ist hier ein frei gewählter
            // Name für das Exception-Objekt, das ausgelöst bzw. per "throw" delegiert wurde.
            System.out.println("Beim Aufruf von h ist etwas schief gegangen. Sorry");
            System.out.println("Die Meldung der Exception lautet: " + e.getMessage());
            // Wenn wir den Fehler nicht vollständig beheben können, dann geben wir das Exception einfach an unseren
            // Aufrufer weiter (manuelle Delegation).
            // Hier gibt es 2 Möglichkeiten: Entweder wir geben das Original-Exception-Objekt e per throw e; weiter
            // oder wir verpacken e nochmals in eine andere und ggf. abstraktere Exception.
            throw new RuntimeException("Interner Fehler", e);
        }
        // Diese Anweisung wird nur dann ausgeführt, wenn alle Anweisungen im try-Block vollständig ausgeführt wurden
        // oder wenn die im try-Block ausgelöste Exception von einem catch-Block vollständig behandelt wurde.
        System.out.println("g endet");
    }

    public static void h() {
        System.out.println("h startet");
        // Exceptions sind Objekte von Klassen, die direkt oder indirekt von Klasse Exception abstammen.
        var myException = new RuntimeException("Oops! Kernel panic!");
        // Die Anweisung throw "löst eine Exception aus".
        throw myException;
        // System.out.println("h endet"); <-- Diese Anweisung kann nicht mehr ausgeführt werden!
    }

    public static int readNumber(String prompt, int tries) {
        // Aufgabe: Gib den Prompt (Eingabeaufforderung) auf der Kommandozeile aus. Lasse den Nutzer anschließend
        // eine Zahl eingeben. Falls es sich um keine Zahl handelt, soll er weitere Eingabemöglichkeiten erhalten.
        // Wenn er jedoch tries mal keine Zahl eingibt, soll eine RuntimeException ausgelöst werden mit der Meldung
        // "Konnte keine Zahl einlesen".
        // Hinweise: Nutze Scanner, try-catch, throw new RuntimeException
        Scanner scanner = new Scanner(System.in);
        while (tries > 0) {
            tries--;
            System.out.printf("%s: ", prompt);
            try {
                int number = scanner.nextInt();
                scanner.close();
                return number;
            } catch (InputMismatchException e) {
                // "Verschlucke" die fehlerhafte Eingabe, so dass die Zeichen nicht beim nächsten Eingabeversuch
                // versehentlich gelesen werden.
                scanner.next();
                System.out.println("Das war keine Zahl!");
            }
        }
        scanner.close();
        throw new RuntimeException("Benutzer hat keine Zahl eingegeben");
    }

    public static int readNumberV2(String prompt, int tries) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (tries > 0) {
                try {
                    tries--;
                    System.out.printf("%s: ", prompt);
                    int number = scanner.nextInt();
                    System.out.println("Jetzt wird die eingelesene Zahl an den Aufrufer zurückgegeben");
                    return number;
                } catch (InputMismatchException e) {
                    System.out.println("Das war keine Zahl!");
                    scanner.next(); // Fehlerhafte Eingabe "verschlucken"
                }
            }
            throw new RuntimeException("Benutzer wollte einfach keine Zahl eingeben");
        } finally {
            // Der finally Block enthält Anweisungen, die IMMER ausgeführt werden. Es spielt keine Rolle, ob
            // die Anweisungen im try-Block mit oder ohne Exception ausgeführt wurden. Demzufolge eignet sich der
            // finally Block hervorragend für Bereinigungsaufgaben wie z.B. Ressourcenfreigaben.
            // Selbst wenn innerhalb eines catch-Blockes eine return-Anweisung ausgeführt wird, werden die Anweisungen
            // in finally noch kurz vorher ausgeführt.
            // Ausführungsreihenfolge: 1) try-Block 2) ggf. ein catch-Block 3) finally-Block
            System.out.println("Scanner wird nun geschlossen");
            scanner.close();
        }
    }

    // Variante, die die Fehlerbehandlung von der eigentlichen Anwendungslogik versucht möglichst gut zu trennen.
    private static int tryReadNumber(String prompt, Scanner scanner) {
        System.out.printf("%s: ", prompt);
        return scanner.nextInt();
    }

    public static int readNumberV3(String prompt, int tries) {
        // Die try-with-resources Anweisung kann man sich wie eine try-finally Anweisung vorstellen, die automatisch
        // angeforderte Ressourcen per close-Methode schließt. Um die Ressourcen zu definieren, besitzt diese
        // Anweisung eine Art "Ressourcenliste", die in runde Klammern eingeschlossen wird.
        // Hinweis: Natürlich kann eine try-with-resources Anweisung auch catch-Blöcke angeben.
        // Ausführungsreihenfolge ist: 1) try-Block 2) Automatisches Closen der Ressourcen 3) ggf. catch-Block 4) ggf. finally Block
        try (Scanner scanner = new Scanner(System.in)) {
            while (tries > 0) {
                tries--;
                try {
                    return tryReadNumber(prompt, scanner);
                } catch (InputMismatchException e) {
                    scanner.next();
                    System.out.println("Das war keine Zahl");
                }
            }
            throw new RuntimeException("Benutzer hat keine Zahl eingegeben");
        } finally {
            // Wenn dieser Block ausgeführt wird, sind alle Ressourcen bereits geschlossen.
            System.out.println("Scanner wurde geschlossen");
        }
    }

    // Aufgabe: Schreibe eine Methode, die den Nutzer Lotto spielen lässt. Der Nutzer soll 6 verschiedene Zahlen
    // im Bereich 1-49 eingeben. Wenn der Nutzer eine falsche Eingabe macht, ist dies abzufangen und der Nutzer darauf
    // hinzuweisen (entweder gibt Nutzer keine Zahl ein oder eine Zahl in einem ungültigen Bereich). Wenn der Nutzer
    // dieselbe Zahl mehrfach wählt, ist dies ebenfalls ein Fehler. Zum Schluss sind alle 6 gewählten Lottozahlen
    // in aufsteigender Reihenfolge auszugeben auf dem Terminal.
    // Hinweis: Nur die InputMismatchException ist abzufangen! Die restlichen "Fehler" kann man durch if-Abfragen
    // behandeln.
    public static void playLotto() {
        int[] numbers = new int[6];
        int[] sortedNumbers = new int[6];
        int count = 0;

        while (count < 6) {
            // Für die readLottoNumbers Methode müssen die eingegebenen Zahlen sortiert sein.
            sortedNumbers = Arrays.copyOf(numbers, numbers.length);
            Arrays.sort(sortedNumbers);
            int n = readLottoNumber(sortedNumbers);
            // Numbers speichert die Zahlen in ursprünglicher Reihenfolge.
            numbers[count] = n;
            count++;
        }
        Arrays.sort(numbers);
        System.out.printf("Deine Lottozahlen: %s\n", Arrays.toString(numbers));
    }

    private static int readLottoNumber(int[] takenNumbers) {
        // Hinweis: Wir entscheiden uns hier dazu, den Scanner nicht zu schließen, da wir von System.in lesen.
        // Würden wir den Scanner schließen, würde auch System.in geschlossen. Dadurch wären aber weitere
        // Eingaben auf dem Terminal nicht mehr möglich.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.printf("Gib eine Zahl im Bereich 1-49 ein: ");
                String input = scanner.nextLine().strip();
                int number = Integer.parseInt(input);
                if (number < 1 || number > 49) {
                    System.out.println("Das ist keine Lottozahl. Bitte wiederholen.");
                } else if (Arrays.binarySearch(takenNumbers, number) >= 0) {
                    System.out.println("Du hast diese Zahl schon genannt!");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Das war keine Zahl. Bitte wiederholen.");
            }
        }
    }

    public static void printEmployeeInfo(String name, int age, String employeeId) {
        // Die Hilfsmethode requireNonNull aus Klasse Objects prüft, ob ein Parameter den Wert null hat und
        // löst in diesem Fall eine NullPointerException mit der bereitgestellten Fehlermeldung aus.
        Objects.requireNonNull(name, "Parameter name darf nicht null sein");
        Objects.requireNonNull(employeeId, "Parameter employeeId darf nicht null sein");
        // Weitere Parameter validieren.
        if (name.isBlank()) {
            throw new IllegalArgumentException("Der Name ist leer oder besteht nur aus Leerzeichen");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Das Alter muss im Intervall [0, 120] liegen!");
        }
        System.out.printf("Name: %s Alter: %d Mitarbeiter-ID: %s\n", name, age, employeeId.toUpperCase());
    }
}



