package de.iad.java;

// Um eine Klasse aus einem anderen Package zu verwenden, müssten wir im Code den vollqualifizierten Namen der
// Klasse verwenden. Das ist jedoch sehr umständlich und macht den Code teilweise auch unleserlich. Um nur den
// Namen der Klasse verwenden zu können, müssen wir die Klasse "importieren".
// Die folgende import-Anweisung erlaubt uns das Symbol MathAlgorithms ohne Package-Präfix im Code zu nutzen.
import de.iad.java.utils.MathAlgorithms;
// Eine import static Anweisung erlaubt es uns, ein statisches Feld oder eine statische Methode ohne Klassennamen
// zu verwenden.
import static de.iad.java.utils.MathAlgorithms.greatestCommonDivisor;
// Die folgende import Anweisung ist streng genommen nicht notwendig, da die Klasse Fraction sich im selben Package
// befindet wie die Klasse FractionDemo.
import de.iad.java.Fraction;


public class FractionDemo {

    public static void main(String[] args) {

        // Mit Operator new erstellen wir ein neues Objekt von Klasse de.iad.java.Fraction und lassen es durch den
        // Konstruktor mit 2 Parametern initialisieren.
        Fraction half = new de.iad.java.Fraction(1, 2);
        half.print();
        System.out.println(half.isNegative()); // false
        Fraction negativeQuarter = new Fraction(-1, 4);
        negativeQuarter.print();
        System.out.println(negativeQuarter.isNegative()); // true
        Fraction threeQuarters = new Fraction(-3, -4);
        threeQuarters.print();
        System.out.println(threeQuarters.isNegative()); // false

        Fraction f = new Fraction(2, 1);
        f.print();
        f.invert();
        f.print(); // 1 / 2
        f.multiply(threeQuarters);
        f.print(); // -3 / -8

        Fraction copyOfF = new Fraction(f);
        copyOfF.print(); // -3 / -8
        new Fraction(123, -4567).print();


        Fraction g = new Fraction(2, 4);
        f.print(); // 3 / 8
        g.print(); // 2 / 4
        f.divide(g);
        g.print(); // 2 / 4
        f.print(); // 12 / 16
        f.multiply(new Fraction(2));
        f.print(); // 24 / 16
        f.divide(new Fraction(4));
        f.print(); // 24 / 64 = 6 / 16 = 3 / 8

        f.simplify();
        f.print();

        System.out.println(MathAlgorithms.leastCommonMultiple(4, 10)); // 20
        System.out.println(MathAlgorithms.leastCommonMultiple(-4, 10)); // 20
        System.out.println(MathAlgorithms.leastCommonMultiple(-4, -10)); // 20
        System.out.println(MathAlgorithms.leastCommonMultiple(0, -20)); // 0
        System.out.println(MathAlgorithms.leastCommonMultiple(3, 8)); // 0
        System.out.println(MathAlgorithms.leastCommonMultiple(8, 8)); // 0

    }

}
