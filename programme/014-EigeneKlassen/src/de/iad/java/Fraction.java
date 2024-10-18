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

import de.iad.java.utils.MathAlgorithms;

import java.util.Objects;

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

    void printAsMixedNumber() {
        // Aufgabe: Wenn ein Bruch eine Zahl > 1 beschreibt, dann soll
        // der Bruch mit 2 Komponenten ausgegeben werden: Der ganzzahlige
        // Anteil und der restliche Anteil.
        // Bsp.: 14 / 3 = 4 und 2/3
        int wholes = Math.abs(this.nominator / this.denominator);
        int rest = Math.abs(this.nominator % this.denominator);
        String sign = this.isNegative() ? "-" : "";
        if (rest == 0) {
            System.out.printf("%s%d\n",sign, wholes);
        } else {
            System.out.printf("%s%d und %d/%d\n", sign, wholes, rest,
                    Math.abs(this.denominator));
        }
    }

    void simplify() {
        // Aufgabe: Bestimme den größten gemeinsamen Teiler von Zähler und Nenner.
        // Dividiere anschließend Zähler und Nenner durch diesen Teiler.
        int gcd = MathAlgorithms.greatestCommonDivisor(this.nominator, this.denominator);
        this.nominator /= gcd;
        this.denominator /= gcd;
    }

    void add(Fraction fraction) {
        // Aufgabe: Implementiere die Addition this + fraction.
        // Tipp: Verwende hierfür leastCommonMultiple
        // Hinweis: Grundsätzlich kann man auch das Produkt als gemeinsamen Nenner verwenden.
        int lcm = MathAlgorithms.leastCommonMultiple(this.denominator, fraction.denominator);
        int newNominator = this.nominator * (lcm / this.denominator);
        newNominator += fraction.nominator * (lcm / fraction.denominator);
        this.nominator = newNominator;
        this.denominator = lcm;
        this.simplify();
    }

    void negate() {
        // Wechsle das Vorzeichen des Bruchs, indem entweder Zähler oder Nenner
        // negiert werden.
        this.denominator *= -1;
    }

    void subtract(final Fraction fraction) {
        // Aufgabe: Implementiere die subtract Methode mit Hilfe der add-Methode.
        Fraction copy = new Fraction(fraction);
        copy.negate();
        this.add(copy);
    }

    void multiply(Fraction fraction) {
        // Aufgabe: Multipliziere diesen Bruch (this) mit dem Bruch fraction.
        this.nominator *= fraction.nominator;
        this.denominator *= fraction.denominator;
        this.simplify();
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
        this.simplify();
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

    int compareTo(Fraction fraction) {
        // Aufgabe: Wenn this < fraction, dann muss ein negativer Wert zurückgegeben werden.
        // Wenn this > fraction, muss ein echt positiver Wert zurückgegeben werden.
        // Falls this und fraction gleich sind, gib 0 zurück.
        // Tipp: Nutze Subtraktion und Vorzeichencheck ;-)
        Fraction copy = new Fraction(fraction);
        copy.simplify();
        this.simplify();
        double diff = this.toDecimal() - fraction.toDecimal();
        return diff < 0
                ? -1
                : diff == 0
                ? 0
                : 1;
    }

    double toDecimal() {
        return (double)this.nominator / this.denominator;
    }

    boolean isProper() {
        // True, falls Zähler kleiner als Nenner (ein "echter Bruch")
        // Hinweis: Nur Absolutwerte von Zähler und Nenner betrachten.
        return Math.abs(this.nominator) < Math.abs(this.denominator);
    }

    boolean isImproper() {
        // True, falls Zähler >= Nenner. (ein "unechter Bruch")
        // Hinweis: Betrachte nur Absolutwerte.
        return Math.abs(this.nominator) >= Math.abs(this.denominator);
    }

    static Fraction of(int wholes, Fraction fraction) {
        // Aufgabe: Erstelle ein neues Fraction-Object
        // bestehend aus den angegebenen Ganzen (wholes) und dem restlichen
        // Bruchteil (fraction). Also wir sollen aus einer gemischten Zahl
        // einen herkömmlichen Bruch erstellen.
        int nominator = wholes * fraction.denominator;
        nominator += fraction.nominator;
        return new Fraction(nominator, fraction.denominator);
    }

    static Fraction of(int nominator, int denominator) {
        return new Fraction(nominator, denominator);
    }

    // Wenn eine Klasse eine Methode einer Vorfahren-Klasse überschreiben will,
    // dann definiert sie die Methode in ihrer eigenen Typdefinition / Rumpf.
    // Achtung: Zusätzlich sollte man vor die überschriebene Methode die
    // Annotation @Override angeben. Dadurch prüft der Compiler, dass wir nicht
    // versehentlich eine neue Methode definieren, statt eine existierende zu überschreiben.
    @Override
    public int hashCode() {
        // Wenn zwei Objekte a und b gleich sind, also wenn a.equals(b) true liefert, dann
        // muss auch a.hashCode() == b.hashCode() gelten.
        // Aber: Wenn a.hashCode() == b.hashCode() gilt, dann bedeutet das nicht, dass
        // unbedingt a.equals(b) == true ist.
        // Wir schreiben hier keine eigene Hashfunktion, sondern verwenden eine
        // im JDK bereits implementierte Hashfunktion Objects.hash.
        // Die hash Funktion bildet einen Hashwert aus dem Zustand dieses Objektes.
        return Objects.hash(this.nominator, this.denominator);
    }

    @Override
    public boolean equals(Object other) {
        // Wenn das zu vergleichende Objekt wir selbst sind, dann ist das Ergebnis
        // selbstverständlich true.
        if (this == other) return true;
        // Falls other null ist, können wir keinen Vergleich durchführen. Das Ergebnis ist
        // also false.
        if (other == null) return false;
        // Prüfe, ob die Referenzvariable other auf ein Objekt vom Typ Fraction verweist.
        if (other instanceof Fraction fraction) {
            // Wir nutzen unsere bereits implementierte compareTo-Methode. Falls diese 0
            // liefert, handelt es sich um zwei "gleiche" Objekte.
            return this.compareTo(fraction) == 0;
        }
        // Das zu vergleichende Objekt ist kein Fraction-Objekt, also kann keine Gleichheit
        // bestehen.
        return false;
    }

    @Override
    public String toString() {
        return "%s {nominator=%d, denominator=%d} #%x".formatted(
          this.getClass().getName(), this.nominator, this.denominator, this.hashCode()
        );
    }
}
