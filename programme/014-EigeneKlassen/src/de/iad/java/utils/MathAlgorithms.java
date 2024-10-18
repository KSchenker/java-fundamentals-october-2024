package de.iad.java.utils;

// Eine Klasse die als final deklariert ist, kann nicht als
// Elternklasse dienen.
public final class MathAlgorithms {

    // Wir deklarieren den Konstruktor als privat.
    // Damit verhindern wir, dass Code außerhalb dieser Klasse
    // Objekte dieser Klasse erstellen kann.
    private MathAlgorithms() {
    }

    public static int leastCommonMultiple(int a, int b) {
        // Per Definition gilt kgV(0, b) = kgV(a, 0) = 0
        if (a == 0 || b == 0) {
            return 0;
        }
        // Aufgabe: Berechne das kleinste gemeinsame Vielfache (kgV) von a und b.
        // Hinweis: Es gibt eine mathematische Beziehung zwischen dem ggT(a, b) und dem kgV(a, b).
        // Es gilt: kgV(a, b) = | a * b | / ggT(a, b)
        // Wir wollen aber einen simplen Zählalgorithmus implementieren :-P
        a = Math.abs(a);
        b = Math.abs(b);
        int multipleOfA = a;
        int multipleOfB = b;

        while (multipleOfA != multipleOfB) {
            if (multipleOfA < multipleOfB) {
                multipleOfA += a;
            } else {
                multipleOfB += b;
            }
        }

        return multipleOfA;
    }

    public static int greatestCommonDivisor(int a, int b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("ggT(0,0) nicht definiert");
        }
        // An dieser Stelle wissen wir, dass mindestens eine der beiden
        // Zahlen ungleich Null sein muss.
        if (a == 0) return Math.abs(b);
        if (b == 0) return Math.abs(a);

        // Hinweis: Der ggT ist stets positiv und größer 0.
        // Wenn a oder b negativ ist, wird für die Berechnung
        // einfach der Betrag verwendet.

        // Wir verwenden den Algorithmus von Euklid.
        // Idee: Ziehe von der größeren Zahl die kleinere ab.
        // Mache das solange, bis beide Zahlen gleich groß sind.
        // Der größte Teiler ist dann genau diese Zahl.
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }


}
