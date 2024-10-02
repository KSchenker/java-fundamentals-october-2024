public class BmiCalculator {

    public static void main(String[] args) {
        // Aufruf von calculateBmi und Ausgabe des Ergebnis
        double bmi = calculateBmi(181, 80000);
        System.out.printf("Der BMI ist %.2f!\n", bmi);

    }

    public static double calculateBmi(int heightInCm, int weightInGrams) {
        // Formel: BMI = Körpergewicht in kg / (Körpergröße in Metern)^2
        // Tipp: Math.pow nutzen für Quadrieren
        double heightInMeters = heightInCm / 100.0;
        double weightInKilograms = weightInGrams / 1000.0;
        double bmi = weightInKilograms / Math.pow(heightInMeters, 2);
        return bmi;
    }

}
