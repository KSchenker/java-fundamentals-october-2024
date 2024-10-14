import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {

        // Erstelle ein neues Scanner-Objekt, dessen Datenquelle der
        // Standard Input Stream (System.in) sein soll.
        Scanner s = new Scanner(System.in);
        System.out.print("Wie heißt du: ");
        // Lasse den Scanner eine ganze Zeile lesen. Weitere Zeichen verbleiben
        // im Datenstrom.
        String name = s.nextLine();
        System.out.printf("Hallo %s\n", name);
        System.out.print("Wie alt bist du: ");
        // Lasse den Scanner den nächsten Integer aus dem Datenstrom lesen.
        // Der Scanner stoppt beim ersten Zeichen, dass keine Ziffer ist. Die übrigen
        // Zeichen verbleiben im Puffer / Datenstrom.
        int age = s.nextInt();
        System.out.printf("Du bist %d Jahre alt!\n", age);
        System.out.print("Wie viele Jahre bist du schon in der Umschulung: ");
        int years = s.nextInt();
        System.out.printf("Du bist schon %d Jahre in der Umschulung\n", years);

        s.close();
    }
}
