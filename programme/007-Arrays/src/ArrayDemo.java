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
        int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19 };
        // Bei einer Variablenerstellung können wir die Elemente des Arrays in Kurzschreibweise ohne new-Operator angeben.
        int[] primes2 = {2, 3, 5, 7, 11 };

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
