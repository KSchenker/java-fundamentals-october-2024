package de.iad.test;

// Um eine Klasse aus einem anderen Package zu verwenden, müssten wir im Code den vollqualifizierten Namen der
// Klasse verwenden. Das ist jedoch sehr umständlich und macht den Code teilweise auch unleserlich. Um nur den
// Namen der Klasse verwenden zu können, müssen wir die Klasse "importieren".
// Die folgende import-Anweisung erlaubt uns das Symbol MathAlgorithms ohne Package-Präfix im Code zu nutzen.
// Eine import static Anweisung erlaubt es uns, ein statisches Feld oder eine statische Methode ohne Klassennamen
// zu verwenden.
// Die folgende import Anweisung ist streng genommen nicht notwendig, da die Klasse Fraction sich im selben Package
// befindet wie die Klasse FractionDemo.

import de.iad.math.Fraction;

import static java.lang.System.out;

public class FractionDemo {

    public static void main(String[] args) {

        // Mit Operator new erstellen wir ein neues Objekt von Klasse de.iad.math.Fraction und lassen es durch den
        // Konstruktor mit 2 Parametern initialisieren.
        Fraction half = new Fraction(1, 2);
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

        Fraction a = new Fraction(3, 4);
        Fraction b = new Fraction(5, 10);
        a.add(b);
        a.print();

        a.negate();
        a.print();
        a.negate();
        a.print();

        a.subtract(new Fraction(32, 16));
        a.print();

        new Fraction(13, 3).printAsMixedNumber();
        new Fraction(-13, 3).printAsMixedNumber();
        new Fraction(-13, -3).printAsMixedNumber();
        new Fraction(13, -3).printAsMixedNumber();
        new Fraction(15, -3).printAsMixedNumber();
        new Fraction(15, 3).printAsMixedNumber();

        Fraction.of(3, new Fraction(1, 3)).print();
        Fraction.of(3, new Fraction(6, 4)).print();
        out.println(new Fraction(1, 3).isImproper());
        out.println(new Fraction(2, 3).isImproper());
        out.println(new Fraction(3, 3).isImproper());
        out.println(new Fraction(4, 3).isImproper());
        out.println(new Fraction(4, 5).toDecimal());
        out.println(new Fraction(4, 6).toDecimal());

        out.println(Fraction.of(2, 3).compareTo(Fraction.of(4, 2)));
        out.println(Fraction.of(8, 4).compareTo(Fraction.of(4, 2)));
        out.println(Fraction.of(8, 4).compareTo(Fraction.of(1, 2)));
        out.println(Fraction.of(-8, 4).compareTo(Fraction.of(1, 2)));

        out.println(a.toString());
        out.println(a.hashCode());
        out.println(a.equals(a));

        Fraction x = Fraction.of(2, 3);
        Fraction y = Fraction.of(2, 3);
        out.println(x.equals(y)); // Wenn wir die equals Methode nicht überschreiben, kommt hier false heraus!
        out.println(x.hashCode());
        out.println(y.hashCode());
//        y.invert();
//        out.println(y.hashCode());
        out.println(x == y); // false
        out.println(x.equals(y)); // true
        out.println(y.equals(x)); // true
        out.println(x.equals(x)); // true
        out.println(x.equals("abc")); // false

        out.println(x);
        out.println(y);
        y.invert();
        out.println(y);
    }

}
