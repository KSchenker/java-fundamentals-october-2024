import java.util.Arrays;

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

    }

    public static int minIndex(int[] numbers) {
        // Aufgabe: Finde die kleinste Zahl im Array numbers und gib ihren Index an den Aufrufer zurück.
    }

    public static double average(int[] numbers) {
        // Aufgabe: Berechne den Durchschnitt der Zahlen im Array numbers und gib ihn an den Aufrufer zurück.
    }

    public static boolean isInAscendingOrder(int[] numbers) {
        // Prüfe, ob die Zahlen im Array numbers aufsteigend sortiert sind.
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
