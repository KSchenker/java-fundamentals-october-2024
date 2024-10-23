import java.util.Comparator;

public record Name(String firstName, String lastName) implements Comparable<Name> {

    // Ein statisches, finales Feld, dass eine Referenz auf ein Comparator-Objekt speichert.
    // Immer dann, wenn man Name-Objekte anhand des Vornamens sortieren möchte, kann man dieses
    // Feld nutzen.
    public static final Comparator<Name> FIRST_NAME_ORDER = new FirstNameOrder();

    @Override
    public String toString() {
        return "%s, %s".formatted(lastName, firstName);
    }

    @Override
    public int compareTo(Name other) {
        // Liefere einen negativen Wert falls this < other, 0 falls this.equals(other) und etwas Positives falls
        // this > other
        // Hinweis: Wir nutzen hier die compareTo Methode der Klasse String, um unsere eigene compareTo Methode
        // zu implementieren.
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        // Wenn sich die Nachnamen unterscheiden, dann gib das Vergleichsergebnis direkt zurück.
        if (lastNameComparison != 0) return lastNameComparison;
        // Wenn die Nachnamen gleich waren, vergleichen wir einfach die Vornamen.
        return this.firstName.compareTo(other.firstName);
    }

    // Diese geschachtelte Klasse dient als Comparator für Name-Objekte. Sie sortiert Name-Objekte aufsteigend
    // anhand ihrer Vornamen.
    static public class FirstNameOrder implements Comparator<Name> {
        @Override
        public int compare(Name first, Name second) {
            // Hier wird dieselbe Konvention wie bei compareTo verwendet. Negativer Rückgabewert bedeutet,
            // dass first < second ist. Ein echt positiver Rückgabewert bedeutet hingegen, dass first > second ist.
            // Der Rückgabewert 0 bedeutet first == second.
            int firstNameComparison = first.firstName.compareTo(second.firstName);
            if (firstNameComparison != 0) return firstNameComparison;
            return first.lastName.compareTo(second.lastName);
        }
    }


}
