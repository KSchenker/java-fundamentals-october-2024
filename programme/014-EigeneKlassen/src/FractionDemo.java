public class FractionDemo {

    public static void main(String[] args) {

        // Mit Operator new erstellen wir ein neues Objekt von Klasse Fraction und lassen es durch den
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

    }

}
