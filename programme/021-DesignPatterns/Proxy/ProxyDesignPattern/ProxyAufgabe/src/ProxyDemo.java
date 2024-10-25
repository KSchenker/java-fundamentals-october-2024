// ------------------ DEMO ------------------------
public class ProxyDemo {
    public static void main(String[] args) {

        // Erstellung einer Person
        // Interface wird als Datentyp verwenden.
        // Das Interface stellt die Schnittstelle der beiden Klassen dar und kann deswegen von beiden gleichermaßen
        // verwertet werden.
        IPerson newPerson = new ProxyPerson("Kevin", "Schenker",
                "Maximilian-Welsch-Straße 2, 99084 Erfurt");


        // Zeigt das komplette Objekt an.
        newPerson.show();
        System.out.println();

        // Ausgabe der einzelnen Felder
        System.out.println(newPerson.getFirstName());
        System.out.println(newPerson.getLastName());
        System.out.println(newPerson.getAddress());
        System.out.println();

        // Änderung des Vornamens + Ausgabe
        newPerson.setFirstName("Hans");
        newPerson.show();

        // Änderung des Nachnamens + Ausgabe
        newPerson.setLastName("Schmidt");
        newPerson.show();

        // Änderung der Adresse + Ausgabe
        newPerson.setAddress("Maximilian-Kolbe-Straße 5, 99099 Erfurt");
        newPerson.show();

    }
}
