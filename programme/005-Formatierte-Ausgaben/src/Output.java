import java.util.Locale;

public class Output {

    public static void main(String[] args) {
        // printf kann formatierte Ausgaben auf der Kommandozeile erstellen.
        // Dazu benötigt sie einen Format-String als erstes Argument. Dieser Format-String
        // kann beliebig viele Platzhalter enthalten (beginnen mit %). Die Werte für die
        // Platzhalter werden als zusätzliche Argumente an die printf Funktion übergeben.
        System.out.printf("Der BMI ist %.2f!\n", 25.41);
        // Beispiel mit 3 Platzhaltern. %d ist ein Platzhalter für ganze Zahlen, wobei die
        // Zahl im Dezimalsystem ausgegeben wird.
        System.out.printf("%d + %d = %d\n", 2, 5, 2 + 5);
        // Der Platzhalter %x gibt eine ganze Zahl als Hexadezimalzahl aus. Schreibt man
        // das x groß, wird die Hexadezimalzzahl in Großbuchstaben ausgegeben.
        System.out.printf("%x + %x = %X\n", 12, 15, 12 + 15);
        // Der Platzhalter %s wird für Zeichenketten verwendet.
        // Die Methode Integer.toBinaryString wandelt einen int-Wert in eine Binärzahl um. Der Rückgabedatentyp ist
        // String.
        System.out.printf("%s + %s = %s\n",
                Integer.toBinaryString(12), Integer.toBinaryString(15),
                Integer.toBinaryString(12 + 15));
        // Die ganze Zahl -1 hat die Kodierung 111....111 (32 Einsen)
        System.out.println(Integer.toBinaryString(-1));

        // Schreibt man vor einen Platzhalter eine Zahl, so definiert diese die Feldbreite bzw. die Mindestanzahl
        // an auszugebenden Zeichen. Standardmäßig werden fehlende Zeichen von links mit Leerzeichen aufgefüllt.
        // Setzt man vor die Feldbreite zusätzlich die Ziffer 0, so wird statt eines Leerzeichens die 0 zum Auffüllen
        // verwendet. Setzt man vor die Feldbreite ein Minuszeichen, dann wird der Wert linksbündig ausgegeben, statt
        // rechtsbündig.
        System.out.printf("%-3d + %03d = %5d", 2, 5, 7);

        String name = "Max Müller";
        int age = 25;
        int employeeId = 123;
        boolean isManager = false;
        char gender = 'm';
        double taxRate = 15.2341;

        // Aufgabe: Gib die obigen Variableninhalte mit der printf Funktion auf der Kommandozeile aus.
        // Verwende dafür Platzhalter. Platzhalter: %s, %d, %b, %c, %f, %%
        // Aufgabe: Gib den Text "Max Mustermann ist 25 Jahre alt. Er wird mit 15.23% besteuert" aus.
        // Verwende auch hier Platzhalter und die korrekten Variablen.
        System.out.printf("\n\n%s\n", name);
        System.out.printf("%d\n", age);
        System.out.printf("%06d\n", employeeId); // 000123
        System.out.printf("%b\n", isManager);
        System.out.printf("%c\n", gender);
        System.out.printf("%07.2f\n", taxRate); // 0015.23
        System.out.printf("%s ist %d Jahre alt. Er wird mit %.2f%% besteuert\n", name, age, taxRate);


    }
}
