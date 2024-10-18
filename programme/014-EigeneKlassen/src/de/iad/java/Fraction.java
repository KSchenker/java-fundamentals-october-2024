package de.iad.java;

// Eine Klasse ist ein benutzerdefinierter Referenzdatentyp.
// Eine Klasse ist ein Bauplan für Objekte.
// Jedes Objekt hat einen Zustand, ein Verhalten (Handlungskompetenz) und eine Identität.
// Objekte, deren Zustand unveränderlich ist, nennt man immutable, andernfalls mutable.
// Beispiele für immutable Objekte: Strings, LocalDate Objekte, LocalTime Objekte etc.
// Der Klassen-Entwickler entscheidet, ob seine Objekte immutable sind oder eben nicht.
// Der Klassen-Entwickler kann verhindern, dass Objekte seiner Klasse erstellt werden können.

// Der Zustand eines Objektes wird implementiert durch Instanzvariablen / Instanzfelder.
// Das Verhalten eines Objektes wird implementiert durch Instanzmethoden.
// Die Identität ist indirekt gegeben durch die Java Virtual Machine.

// Es ist auch möglich in einer Klasse Zustand zu speichern und Handlungskompetenz zu implementieren.
// In Java wird dies durch statische Felder und statische Methoden getan. Für alle statischen Felder und
// statischen Methoden gilt: Sie brauchen kein Objekt bzw. sind unabhängig von Objekten.
// Bsp.: Math.PI, Math.E, Math.pow, Math.min

public class Fraction {

    // Zustand eines de.iad.java.Fraction-Objekts -> Instanzfelder / Instanzvariablen
    // Hinweis: Instanzfelder werden automatisch bei Objekterstellung initialisiert und zwar mit
    // den Werten 0 (numerische Felder), false (boolesche Felder), null (Referenzfelder),
    // das Zeichen mit dem Kodierungswert 0 (für char Felder).
    int nominator; // Zähler
    int denominator; // Nenner

    // Ein Konstruktor ist eine "spezielle Methode" die ein neu erstelltes Objekt in einen
    // sinnvollen Anfangszustand bringt. Der Konstruktor kann nicht nachträglich für ein bereits
    // erstelltes Objekt erneut aufgerufen werden.
    // Achtung: Wenn der Klassen-Entwickler keinen Konstruktor implementiert, wird der Compiler
    // selbst einen Konstruktor erstellen, der jedoch "nichts macht" (Default Constructor). In den meisten Fällen ist das
    // nicht erwünscht.
    // Hinweis: Ein Konstruktor trägt immer den Namen der Klasse. Er hat keinen Rückgabedatentyp.
    // Hinweis: Sobald wir mindestens einen Konstruktor implementieren, wird der Compiler keinen
    // "Default Constructor" mehr erstellen.
    Fraction(int nominator, int denominator) {
        // Brüche mit Nenner = 0 sind nicht erlaubt.
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator (Nenner) darf nicht 0 sein!");
        }
        // Parameterwerte in den Instanzfeldern speichern.
        this.nominator = nominator;
        this.denominator = denominator;
    }

    Fraction(int nominator) {
        // Ein Konstruktor kann einen anderen Konstruktor aufrufen, indem er als
        // ERSTE Anweisung this als Methodennamen verwendet. Diese Technik nennt
        // man Konstruktor-Delegation.
        this(nominator, 1);
        // Hier könnten noch weitere Initialisierungen vorgenommen werden.
    }

    // Ein Copy-Constructor hat die Aufgabe ein bestehendes Objekt vollständig
    // zu kopieren.
    Fraction(Fraction fraction) {
        this.nominator = fraction.nominator;
        this.denominator = fraction.denominator;
    }

    // Verhalten / Handlungskompetenz von de.iad.java.Fraction-Objekten -> Instanzmethoden
    void print() {
        // Aufgabe: Verbessere die Ausgabe, indem du prüfst wie lang jeweils
        // der Zähler und der Nenner ist.
        // Tipp: Konvertiere Zähler und Nenner in einen String und lasse dir
        // dann die Länge des Strings geben.
        System.out.println();
        // Um die Bruchstrichlänge zu bestimmen, ermittle die Zeichenkettenlängen
        // des Zählers und Nenners.
        int positiveNominator = Math.abs(this.nominator);
        int positiveDenominator = Math.abs(this.denominator);
        int width = Math.max(
                String.valueOf(positiveNominator).length(),
                String.valueOf(positiveDenominator).length()
        );

        // Erstelle den Platzhalter %nd wobei n den Wert von width haben soll.
        // Nutze dann den Formatstring zur Ausgabe des Zählers.
        // Hinweis: %% steht für % und %d für einen numerischen Platzhalter.
        // Hinweis: +2 ist notwendig für die Ausgabe des Vorzeichens vor dem Bruchstrich.
        String formatString = "%%%dd\n".formatted(width + 2);
        System.out.printf(formatString, positiveNominator);
        // Den Bruchstrich geben wir einfach durch Wiederholungen von - an.
        // Hinweis: %-2s bedeutet: Gib Zeichenkette mit mindestens 2 Zeichen aus.
        // Falls Zeichen fehlen, fülle mit Leerzeichen auf. Schreibe den String
        // linksbündig (daher -2 statt nur 2).
        System.out.printf("%-2s", this.isNegative() ? "-" : "");
        System.out.println("─".repeat(width));
        // Ausgabe des Nenners analog zur Ausgabe des Zählers.
        System.out.printf(formatString, positiveDenominator);
        System.out.println();
    }

    void simplify() {
        // Aufgabe: Bestimme den größten gemeinsamen Teiler von Zähler und Nenner.
        // Dividiere anschließend Zähler und Nenner durch diesen Teiler.

    }

    void add(Fraction fraction) {

    }

    void subtract(Fraction fraction) {

    }

    void multiply(Fraction fraction) {
        // Aufgabe: Multipliziere diesen Bruch (this) mit dem Bruch fraction.
        this.nominator *= fraction.nominator;
        this.denominator *= fraction.denominator;
    }

    void divide(final Fraction fraction) {
        // Aufgabe: Implementiere die Division von this : fraction.
        // Die Division lässt sich mit der Multiplikation lösen, in dem man
        // den zweiten Operanden invertiert (Zähler/Nenner vertauscht)

        // Achtung: Wir müssen den Bruch fraction umdrehen. Um das vom Aufrufer
        // übergebene Objekt nicht zu verändern, erstellen wir zunächst eine Kopie.
        // Wir signalisieren dem Aufrufer dieser Methode durch den final Parameter,
        // dass wir den Objektzustand des Parameters nicht verändern werden.
        // Hinweis: final bewirkt lediglich, dass wir in Parameter fraction keine
        // andere Referenz speichern können. Ein nachträgliches Zuweisen ist also nicht
        // möglich.
        Fraction factor = new Fraction(fraction);
        // Nun drehen wir Zähler und Nenner der Kopie um.
        factor.invert();
        // Nun multiplizieren wir this mit dem umgedrehten Bruch.
        this.multiply(factor);
    }

    boolean isNegative() {
        // Aufgabe: Prüfe, ob der Bruch negativ ist.
        // Bsp.: -1/4 ist negativ, aber auch 1/-4, aber NICHT -1/-4
        return this.nominator * this.denominator < 0;
    }

    void invert() {
        // Aufgabe: Tausche Zähler und Nenner, aber wirf einen Fehler
        // wenn der Nenner dadurch 0 würde.
        if (this.nominator == 0) {
            throw new RuntimeException("Kann nicht invertieren, da Zähler 0 ist");
        }
        // Tausche Felder.
        int backup = this.nominator;
        this.nominator = this.denominator;
        this.denominator = backup;
    }


}
