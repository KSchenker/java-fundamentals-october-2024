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
