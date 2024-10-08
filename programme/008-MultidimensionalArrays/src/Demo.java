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
