package de.iad.java;


import de.iad.java.utils.MathAlgorithms;
import static de.iad.java.utils.MathAlgorithms.greatestCommonDivisor;

public class FractionDemo {

    public static void main(String[] args) {

        // Mit Operator new erstellen wir ein neues Objekt von Klasse de.iad.java.Fraction und lassen es durch den
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

        System.out.println(greatestCommonDivisor(24, 64)); // 8
        System.out.println(MathAlgorithms.greatestCommonDivisor(-12, 4)); // 4
        System.out.println(MathAlgorithms.greatestCommonDivisor(19, 37)); // 1
        System.out.println(MathAlgorithms.greatestCommonDivisor(0, 37)); // 37
        System.out.println(MathAlgorithms.greatestCommonDivisor(37, 0)); // 37
        System.out.println(MathAlgorithms.greatestCommonDivisor(0, 0)); // 37

    }

}
