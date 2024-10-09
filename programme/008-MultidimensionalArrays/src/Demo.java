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

        int[][] table = spiral(7, 7);
        printTable(table);

        int[][] board = {
                { 1,  2,  3,  4,  5,  6},
                { 7,  8,  9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
        };
        System.out.println(Arrays.toString(getHorizontalLine(board, 0, 0, 3))); // [1, 2, 3]
        System.out.println(Arrays.toString(getHorizontalLine(board, 0, 0, 10))); // [1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(getHorizontalLine(board, 1, 2, 10))); // [9, 10, 11, 12]

        System.out.println(Arrays.toString(getVerticalLine(board, 0, 0, 10))); // [1, 7, 13]
        System.out.println(Arrays.toString(getVerticalLine(board, 0, 0, 2))); // [1, 7]
        System.out.println(Arrays.toString(getVerticalLine(board, 0, 0, 1))); // [1]
        System.out.println(Arrays.toString(getVerticalLine(board, 0, 0, 0))); // []
        System.out.println(Arrays.toString(getVerticalLine(board, 1, 2, 2))); // [9, 15]

        int[][] diagonals = getDiagonals(board, 0, 0, 10);
        printArray2D(diagonals); // [ [1, 8, 15], [1] ]
        diagonals = getDiagonals(board, 1, 3, 10);
        printArray2D(diagonals); // [ [10, 17], [10, 15] ]

        System.out.println(areAllEqual(new int[] { 2, 2, 2 })); // true
        System.out.println(areAllEqual(new int[] { 1, 1, 1 })); // true
        System.out.println(areAllEqual(new int[] { 1, 2, 1 })); // false
        System.out.println(areAllEqual(new int[] {  })); // true
        System.out.println(areAllEqual(new int[] { 0 })); // true

        board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 2, 0, 1, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0},
                {0, 1, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0},
        };
        System.out.println(hasConnectionOfFour(board));
    }

    public static void printTable(int[][] table) {
        for (int[] row : table) {
            for (int i = 0; i < row.length; ++i) {
                System.out.printf("%02d ", row[i]);
            }
            System.out.println();
        }
    }

    public static int[][] spiral(int totalRows, int totalColumns) {
        int[][] spiral = new int[totalRows][totalColumns];

        for (int i = 1; true; i++) {
            // Berechne linke obere und rechte untere Ecke der einzutragenden Zahl.
            int startRow = i - 1;
            int startColumn = i - 1;
            int endRow = totalRows - i;
            int endColumn = totalColumns - i;

            // Breche ab, falls für die Zahl "kein Platz" vorhanden ist.
            if (startRow > endRow || startColumn > endColumn) {
                break;
            }

            // Trage die beiden horizontalen Linien des "Rings" ein.
            for (int column = startColumn; column <= endColumn; column++) {
                spiral[startRow][column] = spiral[endRow][column] = i;
            }
            // Trage die beiden vertikalen Linien des "Rings" ein.
            for (int row = startRow; row <= endRow; row++) {
                spiral[row][startColumn] = i;
                spiral[row][endColumn] = i;
            }
        }

        return spiral;
    }

    public static boolean hasConnectionOfFour(int[][] board) {
        // Aufgabe: Prüfe, ob es auf dem Spielfeld mindestens eine 4er-Reihe gibt. Eine Reihe kann vertikal, horizontal
        // oder diagonal sein und besteht aus mindestens 4 gleichen Zahlen (ungleich 0).
        // Hinweis: Verwende die bereits implementierten Methoden getHorizontalLine, getVerticalLine, getDiagonals, areAllEqual
        // Hinweis: Die Zahl 0 bedeutet "nicht belegt" und soll ignoriert werden.
        final int LENGTH = 4;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                int cell = board[row][column];
                if (cell == 0){
                    // Ignoriere Zellen, die den Wert 0 enthalten.
                    continue;
                }
                // Ermittle ausgehend von der aktuellen Zelle alle möglichen 4er Reihen (horizontal, vertikal, diagonal)
                int[][] lines = {
                  getHorizontalLine(board, row, column, LENGTH),
                  getVerticalLine(board, row, column, LENGTH),
                  getDiagonals(board, row, column, LENGTH)[0],
                  getDiagonals(board, row, column, LENGTH)[1],
                };
                // Gibt es unter diesen Reihen mindestens eine, die 4 gleiche Elemente besitzt?
                for (int[] line : lines) {
                    if (line.length == LENGTH && areAllEqual(line)) {
                        System.out.printf("(%02d, %02d)\n", row, column);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean areAllEqual(int[] numbers) {
        // Aufgabe: Bestimme, ob alle Zahlen im Array numbers denselben Wert haben.
        // Hinweis: Wenn numbers leer sein sollte, gilt automatisch true.
        if (numbers.length == 0) {
            return true;
        }
        // Vergleiche alle Elemente mit dem ersten Element. Stellen wir eine Abweichung fest, geben wir false
        // zurück. Andernfalls müssen alle Elemente gleich gewesen sein.
        int firstValue = numbers[0];
        for (int value : numbers) {
            if (value != firstValue) {
                return false;
            }
        }
        return true;
    }

    public static int[] getHorizontalLine(int[][] board, int startRow, int startColumn, int maxLength) {
        // Aufgabe: Extrahiere höchstens maxLength Elemente aus dem Array board, beginnend an Position
        // (startRow, startColumn). Die Elemente sind in horizontaler Richtung nach rechts herauszuextrahieren.
        // Hinweis: Achte auf ungültige Indizes. Wenn nicht genügend Elemente vorhanden sind, dann gib entsprechend
        // weniger Elemente zurück.
        // Hinweis: Das board ist ein Array von "Zeilen-Arrays", d.h. board[0] ist die erste Zeile, board[1] die 2. Zeile.
        if (!isValidPosition(board, startRow, startColumn)) {
            return new int[] {};
        }
        // Berechne, wie viele Elemente wir theoretisch aus der Zeile herauskopieren können.
        int remaining = board[startRow].length - startColumn;
        // Berechne, wie viele Elemente wir tatsächlich herauskopieren können.
        int count = Math.min(maxLength, remaining);
        // Neues Array erstellen und Elemente hineinkopieren.
        int[] line = new int[count];
        for (int column = startColumn, lineIndex = 0; column < startColumn + count; column++, lineIndex++) {
            line[lineIndex] = board[startRow][column];
        }
        return line;
    }

    public static int[] getVerticalLine(int[][] board, int startRow, int startColumn, int maxLength) {
        // Aufgabe: Kopiere höchstens maxLength Elemente beginnend an Position (startRow, startColumn) aus dem Array board.
        // Die Elemente sind in vertikaler Richtung (nach unten) zu kopieren.
        if (!isValidPosition(board, startRow, startColumn)) {
            return new int[] {};
        }
        // Lege zunächst ein Array an, das maxLength Zahlen speichern kann.
        int[] line = new int[maxLength];
        // Befülle das Array line
        int i = 0;
        for (i = 0; i < maxLength; i++) {
            int row = startRow + i;
            // Wenn die Zeile nicht mehr im Spielbrett vorhanden ist, dann stoppen wir das "Befüllen" bzw. "Auslesen".
            if (!isValidPosition(board, row, startColumn)) {
                break;
            }
            line[i] = board[row][startColumn];
        }
        // "Kürze" das Array auf die Anzahl der tatsächlich geschriebenen Elemente.
        return Arrays.copyOf(line, i);
    }

    public static int[][] getDiagonals(int[][] board, int startRow, int startColumn, int maxLength) {
        // Aufgabe: Extrahiere die Elemente, die auf einer Diagonalen mit dem Element an Position (startRow, startColumn)
        // liegen (Startpunkt der Diagonalen). Gib sowohl die Diagonale von "links oben nach rechts unten" als auch die Diagonale "rechts oben nach links unten"
        // an den Aufrufer zurück. Jede Diagonale soll höchstens maxLength Elemente enthalten.
        if (!isValidPosition(board, startRow, startColumn)) {
            return new int[][] {};
        }
        int[][] result = new int[2][]; // [null, null]
        // Diagonale von links oben nach rechts unten
        int[] diagonal = new int[maxLength];
        int i = 0;
        for (i = 0; i < maxLength; ++i) {
            int row = startRow + i;
            int column = startColumn + i;
            if (isValidPosition(board, row, column)) {
                diagonal[i] = board[row][column];
            } else {
                break;
            }
        }
        // Speichere "gekürzte" Diagonale im Ergebnis-Array ab.
        result[0] = Arrays.copyOf(diagonal, i);
        // Ermittle Diagonale von rechts oben nach links unten.
        diagonal = new int[maxLength];
        for (i = 0; i < maxLength; i++) {
            int row = startRow + i;
            int column = startColumn - i;
            if (isValidPosition(board, row, column)) {
                diagonal[i] = board[row][column];
                continue;
            }
            break;
        }
        // Speichere "gekürzte Diagonale"
        result[1] = Arrays.copyOf(diagonal, i);
        // Ergebnis-Array an Aufrufer zurückgeben
        return result;
    }

    public static boolean isValidPosition(int[][] board, int row, int column) {
        // Aufgabe: Prüfe, ob die Position (row, column) innerhalb von board liegt.
        return row >= 0 && row < board.length && column >= 0 && column < board[row].length;
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

    private static void printVisitors(int[][] visitors) {
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
