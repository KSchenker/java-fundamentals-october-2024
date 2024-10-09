import java.util.Arrays;
import java.util.Random;


public class ArrayDemo {
    public static void main(String[] args) {

        // Arrays haben folgende Eigenschaften:
        // - homogen (d.h. alle Elemente haben denselben Datentyp)
        // - strukturell unveränderlich (d.h. die Länge kann nachträglich nicht geändert werden)
        // - jedes Element ist durch seinen Index eindeutig ansprechbar
        // - der Zugriff auf die Elemente ist wahlfrei und performant
        // - die Elemente liegen direkt hintereinander im Speicher
        // - Arrays sind in Java Referenzdatentypen, d.h. jedes Array ist ein Objekt

        // Die Variable numbers hat den Datentyp "Array von int".
        int[] numbers = null; // Steht der Wert null in einer Referenzvariable, referenziert sie kein Objekt.
        numbers = new int[5]; // Operator new erstellt ein neues Objekt. Hier wird ein neues "Array von 5 int"-Objekt erstellt.
        numbers[0] = 10;
        numbers[1] = 9;
        numbers[numbers.length - 1] = 8; // Speichere die 8 im letzten Element des Arrays.
        System.out.println(Arrays.toString(numbers));
        System.out.println(numbers[1 + 1]);
        // System.out.println(numbers);

        int[] otherNumbers = numbers; // Hier wird nur die Referenz auf das Array kopiert, aber nicht das Array selbst!!!
        System.out.println(Arrays.toString(otherNumbers));
        otherNumbers[0] = 11;
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(otherNumbers));

        // Nun erstellen wir eine echte Kopie des Arrays, das Variable otherNumbers referenziert.
        // Die Variable copyOfOtherNumbers referenziert dieses neue kopierte Array Objekt.
        int[] copyOfOtherNumbers = Arrays.copyOf(otherNumbers, otherNumbers.length);
        System.out.println(Arrays.toString(copyOfOtherNumbers));
        otherNumbers[0] = 33;
        System.out.println(Arrays.toString(otherNumbers));
        System.out.println(Arrays.toString(copyOfOtherNumbers)); // Bleibt unberührt von obiger Änderung, da es eine Kopie ist.

        System.out.println(arrayToString(otherNumbers));

        // Die Elemente eines Arrays lassen sich bei dessen Erstellung direkt angeben.
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        // Bei einer Variablenerstellung können wir die Elemente des Arrays in Kurzschreibweise ohne new-Operator angeben.
        int[] primes2 = {2, 3, 5, 7, 11};

        String[] names = {"alice", "bob", "charlie", "damian"};
        double[] revenues = {2321.3, 3, 1022, 1.2e-6};
        boolean[] flags = {true, false, true, true};

        int[] sample = {2, 6, 1, 0, 4};
        System.out.println(minIndex(sample)); // 3
        System.out.println(average(sample)); // 2.6
        System.out.println(isInAscendingOrder(sample)); // false
        int[] sortedNumbers = {2, 2, 3, 6, 10, 11};
        System.out.println(isInAscendingOrder(sortedNumbers)); // true

        int[] evenNumbers = {0, 2, 4, 6, 8, 10};
        swap(evenNumbers, 1, 3); // tausche Element 2 und 6 aus
        System.out.println(Arrays.toString(evenNumbers));
        swap(evenNumbers, 0, evenNumbers.length - 1); // tausche 0 mit 10
        System.out.println(Arrays.toString(evenNumbers));
        evenNumbers = new int[]{0, 2, 4, 6, 8, 10};
        reverse(evenNumbers);
        System.out.println(Arrays.toString(evenNumbers));

        primes = new int[]{2, 3, 5, 7, 11, 13};
        System.out.println(linearSearch(primes, 3)); // 1
        System.out.println(linearSearch(primes, 13)); // 5
        System.out.println(linearSearch(primes, 19)); // -1

        numbers = new int[]{2, 3, 7, 3, 2, 1, 3};
        System.out.println(Arrays.toString(searchAll(numbers, 3))); // [1, 3, 6]
        System.out.println(Arrays.toString(searchAll(numbers, 10))); // []

        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffle(numbers);
        System.out.println(Arrays.toString(numbers));

        numbers = new int[]{5, 1, 4, 9, 8, 6};
        bubblesort(numbers);
        System.out.println(Arrays.toString(numbers));

        numbers = new int[]{4, 7, 5, 3, 9, 1, 2};
        insertionSort(numbers);
        System.out.println(Arrays.toString(numbers));

        numbers = new int[]{4, 7, 5, 3, 9, 1, 2};
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%02d ", fibonacci(i));
        }
        System.out.println();

        numbers = new int[]{2, 1, 4, 5, 7};
        System.out.println(recursiveSum(numbers)); // 19

        System.out.println(recursiveProduct(numbers)); // 280

        System.out.println(factorial(5)); // 120
        System.out.println(factorial(10)); // 120

        System.out.println(reverseString("Java ist toll!"));
        System.out.println(reverseString("Lagerregal"));
        System.out.println(reverseString("Rentner"));

        numbers = new int[]{6, 8, 2, 5, 9, 1, 7, 3, 4};
        int[] orderedNumbers = quicksort(numbers);
        System.out.println(Arrays.toString(orderedNumbers));

        int[] numbersA = {1, 2, 3, 4};
        int[] numbersB = {9, 8, 7};
        int[] numbersC = {11, 22};
        int[] allNumbers = concatenate(numbersA, numbersB, numbersC, numbersA);
        System.out.println(Arrays.toString(allNumbers));

        numbers = new int[]{5, 1, 3, 7, 4};
        System.out.println(isUnique(numbers)); // true
        numbers = new int[]{5, 1, 3, 1, 7, 4};
        System.out.println(isUnique(numbers)); // false

        System.out.println(Arrays.toString(slice(numbers, 2, 10))); // [3, 1, 7, 4, 5, 1, 3, 1, 7, 4]

        numbers = new int[]{3, 4, 1, 8, 7, 5, 9};
        bubblesort(numbers);
        System.out.println(Arrays.toString(numbers));
        for (int n : numbers) {
            System.out.println(binarySearch(numbers, n));
        }
        System.out.println(binarySearch(numbers, 10)); // -1
    }

    public static int binarySearch(int[] numbers, int n) {
        // Suche die Zahl n im AUFSTEIGEND SORTIERTEM Array "numbers" und gib ihren Index an den Aufrufer zurück.
        // Falls die Zahl n nicht im Array enthalten ist, gib -1 zurück.
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (numbers[middle] == n) {
                return middle;
            } else if (numbers[middle] > n) {
                // Wir reduzieren den Suchbereich und verkleinern die rechte Grenze des Suchbereichs.
                end = middle - 1;
            } else {
                // Wir reduzieren den Suchbereich, indem wir die linke Grenze des Suchbereichs vergrößern.
                start = middle + 1;
            }
        }
        return -1;
    }

    public static boolean isUnique(int[] numbers) {
        // Aufgabe: Bestimme, ob das Array numbers nur aus Unikaten besteht, also keine Zahl mehrfach vorkommt.
        // Einschränkung: Das Array soll vorher nicht sortiert werden.
        for (int i = 0; i < numbers.length; i++) {
            // Vergleiche nun mit allen Zahlen, die auf das Element an Stelle i folgen.
            // Hinweis: Wir brauchen nicht bei 0 beginnen, da die Elemente vor Stelle i bereits geprüft wurden und keine
            // Duplikate hatten.
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    // Duplikat wurde gefunden!
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] slice(int[] numbers, int beginIndex, int length) {
        // Aufgabe: Extrahiere beginnend bei Index "beginIndex" insgesamt length Elemente und speichere sie
        // in einem neuen Array ab. Der neue Array soll dem Aufrufer zurückgegeben werden.
        // Besonderheiten: length darf beliebig lang sein. Wenn mehr Elemente extrahiert werden sollen als vorhanden sind,
        // dann soll die Extraktion wieder von vorne beginnen (wir behandeln numbers so, als wiederhole es sich unendlich oft)
        // Beispiel: numbers = {1, 2, 3, 4}  slice(numbers, 1, 7) liefert [2, 3, 4, 1, 2, 3, 4]
        int[] result = new int[length];
        // Index i ist der Index für das Array numbers und j ist der Index für das Ergebnisarray result.
        for (int i = beginIndex, j = 0; j < length; i = (i + 1) % numbers.length, j++) {
            result[j] = numbers[i];
        }
        return result;
    }

    public static int[] concatenate(int[]... arrays) {
        // Der Parameter arrays ist ein Array von "Array von int". Er enthält alle Arrays, die
        // beim Aufruf dieser Funktion vom Aufrufer angegeben werden.
        int totalLength = 0;
        // Berechne die Gesamtlänge aller Arrays mit einer for-each Schleife.
        for (int[] anArray : arrays) {
            totalLength += anArray.length;
        }
        // Erstelle das Ergebnis-Array mit der passenden Länge.
        int[] result = new int[totalLength];
        int next = 0; // Die Position, an der die nächste Zahl im Array result zu speichern ist.
        // Füge nun alle Elemente aller Arrays nacheinander in das Ergebnis-Array ein.
        for (int[] anArray : arrays) {
            for (int n : anArray) {
                result[next] = n;
                next++;
            }
        }
        return result;
    }

    public static int[][] partition(int[] numbers) {
        // Wir teilen das Array numbers in 3 Teile: das erste Array enthält alle Zahlen kleiner als das gewählte
        // Pivotelement. Danach folgt das Pivotelement als Array. Danach folgt ein weiteres Array, das alle Elemente
        // enthält, die mindestens so groß wie das Pivotelement sind.
        // Wähle ein Pivotelement aus und suche alle Zahlen, die kleiner und größer gleich dem Pivotelement sind.
        int pivot = numbers[0];
        // Im Array left tragen wir alle Zahlen ein, die kleiner als das Pivotelement sind.
        int[] left = new int[numbers.length - 1];
        int nextLeft = 0; // Position, an der nächste Zahl im Array left zu speichern ist.
        // Im Array right tragen wir alle Zahlen ein, die mindestens so groß wie das Pivotelement sind.
        int[] right = new int[numbers.length - 1];
        int nextRight = 0; // Position, an der nächste Zahl im Array right zu speichern ist.
        // Ordne die Zahlen in left bzw. right ein.
        for (int i = 1; i < numbers.length; ++i) {
            if (numbers[i] < pivot) {
                left[nextLeft] = numbers[i];
                nextLeft++;
            } else {
                right[nextRight] = numbers[i];
                nextRight++;
            }
        }
        // Die Arrays left und right werden nun "gekürzt", d.h. nicht verwendete Zellen werden entfernt. Wir erreichen
        // dies durch Kopieren.
        left = Arrays.copyOf(left, nextLeft); // kopiere nur die ersten nextLeft Elemente.
        right = Arrays.copyOf(right, nextRight); // kopiere nur die ersten nextRight Elemente.

        // Alle drei Komponenten werden an den Aufrufer zurückgegeben.
        return new int[][] {
          left, new int[] { pivot}, right
        };

    }

    public static int[] quicksort(int[] numbers) {
        // Quicksort ist ein vergleichsbasiertes Sortierverfahren, das sowohl in-place als auch out-of-place
        // implementiert werden kann. Es ist in der Regel nicht stabil. Quicksort ist deutlich schneller
        // als Insertion Sort, Bubble Sort und Selection Sort, kann aber im schlechtesten Fall trotzdem quadratische
        // Laufzeit haben.

        // Wir implementieren Quicksort in einer rekursiven out-of-place Variante.
        if (numbers.length == 0) {
            return numbers;
        }

        int[][] parts = partition(numbers);
        // Sortiere left und right rekursiv.
        int[] left = quicksort(parts[0]);
        int pivot = parts[1][0];
        int[] right = quicksort(parts[2]);

        // Wir setzen nun das Gesamtergebnis aus dem sortierten left Array, dem Pivotelement und dem sortierten
        // right Array zusammen. Wir bilden quasi "left + pivot + right"
        int[] sortedNumbers = concatenate(left, new int[]{pivot}, right);
        return sortedNumbers;
    }

    public static int sum(int[] numbers) {
        // Dieser Algorithmus arbeitet iterativ. Er berechnet die Summe schrittweise durch Wiederholungen.
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    public static int recursiveSum(int[] numbers) {
        // Trivialfälle: Array ist leer, dann ist die Summe 0.
        if (numbers.length == 0) {
            return 0;
        }
        // Kopiere alle Elemente aus numbers, bis auf das erste Element.
        int[] subarray = Arrays.copyOfRange(numbers, 1, numbers.length);
        // Um die Gesamtsumme zu berechnen, berechnen wir zunächst die Summe des kleineren Arrays und addieren
        // dann das erste Element dazu.
        return numbers[0] + recursiveSum(subarray);
    }

    public static int recursiveProduct(int[] numbers) {
        // Aufgabe: Berechne das Produkt der Zahlen im Array numbers rekursiv.
        if (numbers.length == 1) {
            return numbers[0];
        }
        // Multipliziere das Produkt des kleineren Arrays mit dem Element an Position 1.
        return numbers[0] * recursiveProduct(Arrays.copyOfRange(numbers, 1, numbers.length));
    }

    public static int factorial(int n) {
        // Aufgabe: Berechne die Fakultät von n, also 1 * 2 * 3 * ... * (n-1) * n rekursiv.
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static String reverseString(String s) {
        // Aufgabe: Kehre die Zeichen in einem String s um. Verwende Rekursion.
        // Tipp: Die Klasse String hat eine Methode namens substring, mit der man Teilbereiche aus einer Zeichenkette
        // extrahieren kann.
        if (s.equals("")) {
            return "";
        }
        // Drehe den Rest-String um und hänge das erste Element an das Ende.
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static int fibonacci(int n) {
        // Trivialfälle behandeln (diese sind das Abbruchkriterium für einen sich selbst aufrufenden Algorithmus)
        if (n <= 2) {
            // Hier werden die Fälle fibonacci(1) = 1 und fibonacci(2) = 1 abgedeckt.
            return 1;
        }
        // Bei einem rekursiven Algorithmus berechnen wir zuerst die Lösung eines weniger komplexen Problems.
        // Mit Hilfe dieser Teillösung berechnen wir dann die Lösung des komplexeren Problems. Dies entspricht dem
        // Prinzip "Teile und herrsche" (Divide and Conquer).
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void selectionSort(int[] numbers) {
        // Selection Sort ist ein vergleichsbasiertes Sortierverfahren mit quadratischer Laufzeit. Es benötigt
        // keinen zusätzlichen Speicher und ist demzufolge ein in-place Verfahren. Je nach Implementierung ist
        // Selection Sort stabil oder instabil.
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            // Suche das Minimum im Bereich [i, length - 1]
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            // Vertausche das kleinste Element mit Position i.
            swap(numbers, i, minIndex);
        }
    }

    public static void insertionSort(int[] numbers) {
        // Insertion Sort ist ein stabiles, vergleichsbasiertes Sortierverfahren mit quadratischer Laufzeit.
        // Zudem arbeitet es in-place, also ohne zusätzlichen Speicher.
        // Wir beginnen das Einfügen bei der zweiten Zahl, also bei Index 1.
        for (int i = 1; i < numbers.length; i++) {
            int n = numbers[i]; // Die Zahl, die eingefügt werden soll.
            int j;
            for (j = i; j >= 1 && numbers[j - 1] > n; j--) {
                // Verschiebe den Vorgänger um eine Position nach rechts und schaffe somit "Platz" für die einzufügende
                // Zahl n.
                numbers[j] = numbers[j - 1];
            }
            // Die Zahl an korrekte Stelle einfügen.
            numbers[j] = n;
        }
    }

    public static void bubblesort(int[] numbers) {
        // Bubble Sort ist ein stabiles, vergleichsbasiertes Sortierverfahren mit quadratischer Zeitkomplexität.
        // Es benötigt keinen zusätzlichen Speicher, der von der Länge des zu sortierenden Arrays abhängig ist.
        // Demzufolge handelt es sich bei Bubble Sort um ein In-Place-Sortierverfahren.
        for (int boundary = numbers.length - 1; boundary >= 1; boundary--) {
            boolean swapped = false;
            // Starte einen neuen Durchlauf.
            for (int i = 0; i < boundary; i++) {
                // Vergleiche Element an Stelle i mit Element an Stelle i + 1
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, i, i + 1);
                    swapped = true;
                }
            }
            // Falls im Durchlauf kein Tausch stattfand, ist die Zahlenfolge bereits aufsteigend sortiert.
            // Wir können uns weitere Durchläufe sparen und den Algorithmus vorzeitig beenden.
            if (!swapped) {
                return;
            }
        }
    }

    public static void shuffle(int[] numbers) {
        Random generator = new Random(); // Einen Pseudo-Zufallszahlengenerator erstellen.
        for (int i = 0; i < numbers.length - 1; i++) {
            // Zufallszahl im Bereich [i, numbers.length - 1] erzeugen.
            int randomIndex = generator.nextInt(i, numbers.length); // Achtung: Zweiter Wert ist schon exklusiv.
            // Tausche Element an Position i mit Element an Position randomIndex
            swap(numbers, randomIndex, i);
        }

    }

    public static int linearSearch(int[] numbers, int element) {
        // Aufgabe: Suche im Array numbers das Element "element" und gib seinen Index an den Aufrufer zurück.
        // Falls das gesuchte Element mehrfach vorkommt, gib einfach nur die erste Position / Index zurück.
        // Falls das gesuchte Element nicht vorkommt, gib den Wert -1 an den Aufrufer zurück.
        // Vorgabe: Verwende die for Schleife.
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static int[] searchAll(int[] numbers, int element) {
        // Aufgabe: Finde alle Vorkommen des Elements "element" im Array numbers und gib die Indizes als Array an
        // den Aufrufer zurück.
        // Tipp: Zähle erst einmal alle Vorkommen von element im Array. Verwende diese Anzahl, um das Array zu erstellen.
        int count = 0;
        for (int n : numbers) {
            if (n == element) {
//                count = count + 1;
//                count += 1;
                count++; // Inkrement-Operator (erhöht Variable um 1)
            }
        }
        int[] indices = new int[count];
        int next = 0; // Position an der im Array indices der nächste Index eingetragen werden soll.
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == element) {
                indices[next] = i;
                next++;
            }
        }
        return indices;
    }

    public static int minIndex(int[] numbers) {
        // Aufgabe: Finde die kleinste Zahl im Array numbers und gib ihren Index an den Aufrufer zurück.
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static double average(int[] numbers) {
        // Aufgabe: Berechne den Durchschnitt der Zahlen im Array numbers und gib ihn an den Aufrufer zurück.
        double sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum / numbers.length;
    }

    public static boolean isInAscendingOrder(int[] numbers) {
        // Prüfe, ob die Zahlen im Array numbers aufsteigend sortiert sind.
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] numbers, int a, int b) {
        // Aufgabe: Tausche die Elemente an den Stellen/Indizes a und b im Array numbers.
        int backup = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = backup;
    }

    public static void reverse(int[] numbers) {
        // Aufgabe: Kehre die Reihenfolge der Elemente im Array um. Verwende dafür eine herkömmliche for-Schleife.

        // Eine Variante mit 2 Laufvariablen und Methode swap.
//        for (int a = 0, b = numbers.length - 1; a < numbers.length / 2; a++, b--) {
//            swap(numbers, a, b);
//        }

        // Eine Variante mit einer Laufvariablen und ohne die swap-Methode.
        for (int i = 0; i < numbers.length / 2; i++) {
            int backup = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = backup;
        }
    }

    public static String arrayToString(int[] numbers) {
        String result = "[";
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
            if (i < numbers.length - 1) {
                result += ", ";
            }
        }
        return result + "]";
    }
}
