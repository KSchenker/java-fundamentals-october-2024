import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        // Wir erstellen eine Referenzvariable namens array2D. Diese hat den Datentyp: "Array von Array von int".
        int[][] array2D = null;
        System.out.println(array2D); // null
        // Wir erstellen nun ein neues Array mit 5 Elementen. Jedes dieser Elemente ist eine Referenz auf
        // ein "Array von int" Objekt. Die Variable array2D referenziert dieses neue Array.
        array2D = new int[5][];
        System.out.println(array2D); // [[I@6acbcfc0
        System.out.println(Arrays.toString(array2D)); // [null, null, null, null, null]
        // Aus obiger Ausgabe ist folgendes erkennbar: Wenn wir ein Array erstellen, werden seine Elemente
        // automatisch initialisiert. Die Elemente von array2D sind Referenzen, die alle mit null initialisiert wurden.
        // Nun erstellen wir ein "Array von int" mit den Elementen 2, 1, 7, 2, 5 und lassen das erste Element des
        // Arrays array2D darauf verweisen.
        array2D[0] = new int[]{2, 1, 7, 2, 5};
        printArray2D(array2D);
        array2D[1] = new int[]{3, 0, 9};
        printArray2D(array2D);
        array2D[2] = new int[]{8};
        printArray2D(array2D);
        // Das Element an Position 3 soll auf dasselbe Array verweisen bzw. referenzieren wie sein Vorgängerelement.
        array2D[3] = array2D[2];
        printArray2D(array2D); // [[2, 1, 7, 2, 5], [3, 0, 9], [8], [8], null]

        // Zugriff auf erstes geschachteltes Array und alle weiteren.
        System.out.println(Arrays.toString(array2D[0])); // [2, 1, 7, 2, 5]
        System.out.println(Arrays.toString(array2D[1])); // [3, 0, 9]
        System.out.println(Arrays.toString(array2D[2])); // [8]
        System.out.println(Arrays.toString(array2D[3])); // [8]
        System.out.println(Arrays.toString(array2D[4])); // null

        // Nun greifen wir auf einzelne Elemente der geschachtelten Arrays zu.
        System.out.println(array2D[0][0]); // 2
        System.out.println(array2D[0][1]); // 1
        System.out.println(array2D[0][2]); // 7
        System.out.println(array2D[0][3]); // 2
        System.out.println(array2D[0][4]); // 5

        System.out.println(array2D[1][0]); // 3
        System.out.println(array2D[1][1]); // 0
        System.out.println(array2D[1][2]); // 9

        System.out.println(array2D[2][0]); // 8

        System.out.println(array2D[3][0]); // 8

        System.out.println(array2D[4]); // null

        int[][] visitors = {
                // 0: 9 Uhr 1: 10 Uhr 2: 11 Uhr 3: 12 Uhr 4: 14 Uhr 5: 15 Uhr 6: 16 Uhr
                { 20, 25, 25, 20, 15, 45, 5}, // Tag 1
                { 10, 12, 18, 20, 10, 12, 11}, // Tag 2
                { 25, 30, 35, 40, 40, 40, 20}, // Tag 3
        };
        printTable(visitors);
        System.out.println(getVisitorCount(visitors, 2, 11)); // 18
        System.out.println(getVisitorCount(visitors, 3, 15)); // 40
        System.out.println(getAverageVisitorsAtTime(visitors, 9)); // 18.33333
        System.out.println(getAverageVisitorsOnDay(visitors, 1)); // ~ 22.14
    }

    private static double getAverageVisitorsAtTime(int[][] visitors, int time) {
        // Aufgabe: Berechne die durchschnittliche Besucheranzahl zum Zeitpunkt "time".
        // Tipp: Verwende die Methode getVisitorCount.
        double sum = 0;
        for (int i = 0; i < visitors.length; i++) {
            int day = i + 1;
            sum += getVisitorCount(visitors, day, time);
        }
        return sum / visitors.length;
    }

    private static double getAverageVisitorsOnDay(int[][] visitors, int day) {
        // Aufgabe: Berechne die durchschnittliche Besucheranzahl am Tag "day".
        // Tipp: Verwende die Methode getVisitorCount.
        int[] times = {9, 10, 11, 12, 14, 15, 16};
        double sum = 0;
        for (int aTime : times) {
            sum += getVisitorCount(visitors, day, aTime);
        }
        return sum / times.length;
    }

    private static int getVisitorCount(int[][] visitors, int day, int time) {
        // Aufgabe: Aus der Besuchertabelle visitors soll die Besucherzahl zum Zeitpunkt "time" am Tag "day"
        // zurück an den Aufrufer geliefert werden. day ist eine Zahl im Bereich 1-31. Der Parameter time
        // darf die Werte 9, 10, 11, 12, 14, 15, 16 annehmen.

        // Validiere die Parameter, d.h. prüfe ob die übergebenen Werte im definierten Bereich liegen.
        if (day < 1 || day > 31 || time < 9 || time > 16 || time == 13) {
            // Normalerweise würden wir an dieser Stelle eine Exception auslösen. Im Moment begnügen wir uns
            // einfach mit einem negativen Return-Wert.
            return -1;
        }
        // Hat die Tabelle Daten für den gewünschten Tag? Falls nicht, geben wir auch einfach einen negativen Wert
        // an den Aufrufer zurück, ohne eine Exception auszulösen.
        if ((day - 1) >= visitors.length) {
            return -1;
        }
        // Wandle die Uhrzeit in einen Spaltenindex um.
        int timeIndex = switch (time) {
          case 9 -> 0;
          case 10 -> 1;
          case 11 -> 2;
          case 12 -> 3;
          case 14 -> 4;
          case 15 -> 5;
          case 16 -> 6;
          default -> 0; // Kann nicht auftreten, aber ist notwendig, um Warnung des Compilers aufzuheben.
        };
        // Daten auslesen
        return visitors[day - 1][timeIndex];
    }

    private static void printTable(int[][] visitors) {
        // Aufgabe: Gib jeden Tag auf der Kommandozeile aus. Format: Tag xx: [20, 25, ... ]
        int[] times = {9, 10, 11, 12, 14, 15, 16};
        for (int aTime : times) {
            System.out.printf("\t\t%02d", aTime);
        }
        System.out.println();
        for (int day = 0; day < visitors.length; day++) {
            //System.out.printf("Tag %02d: %s\n", day + 1, Arrays.toString(visitors[day]));
            System.out.printf("Tag %02d: ", day + 1);
            for (int count : visitors[day]) {
                System.out.printf("%02d\t\t", count);
            }
            System.out.println();
        }
    }


    public static void tableOfRows() {
        // Modelliere folgende Tabelle als zweidimensionalen Array
        // dessen Elemente vollständige ZEILEN abbilden:
        // 20 25 10
        // 33 56 87
        // 12 08 00
        // 00 00 01
        int[][] table = {
                {20, 25, 10}, // Zeile 1
                {33, 56, 87}, // Zeile 2
                {12, 8, 0}, // Zeile 3
                {0, 0, 1}, // Zeile 4
        };
    }

    public static void tableOfColumns() {
        // Modelliere folgende Tabelle als zweidimensionalen Array
        // dessen Elemente vollständige SPALTEN abbilden:
        // 20 25 10
        // 33 56 87
        // 12 08 00
        // 00 00 01
        int[][] table = new int[3][4]; // 3 Spalten-Arrays mit jeweils 4 Elementen
        // Erste Spalte initialisieren
        table[0][0] = 20;
        table[0][1] = 33;
        table[0][2] = 12;
        table[0][3] = 0;
        // Zweite Spalte initialisieren
        table[1][0] = 25;
        table[1][1] = 56;
        table[1][2] = 8;
        table[1][3] = 0;
        // Dritte Spalte initialisieren
        table[2][0] = 10;
        table[2][1] = 87;
        table[2][2] = 0;
        table[2][3] = 1;
        // Obige Schreibweise ist sehr aufwändig. Wir können sogenannte
        // Array-Initializer verwenden, um es wesentlich kürzer zu
        // formulieren.
        int[][] table2 = {
                {20, 33, 12, 0}, // Spalte 1
                {25, 56, 8, 0}, // Spalte 2
                {10, 87, 0, 1}, // Spalte 3
        };
        // Beim nachträglichen Neuzuweisen muss zumindest der Datentyp mit new Operator angegeben werden.
        table2 = new int[][] {
                {20, 33, 12, 0}, // Spalte 1
                {25, 56, 8, 0}, // Spalte 2
                {10, 87, 0, 1}, // Spalte 3
        };
    }

    public static void printArray2D(int[][] data) {
        System.out.print("[");
        for (int[] array : data) {
            System.out.print(Arrays.toString(array));
            System.out.print(", ");
        }
        System.out.println("]");
    }

}
