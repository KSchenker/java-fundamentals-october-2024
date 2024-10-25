package Taxi;

import javax.swing.text.Element;

// Besucher-Interface
interface Visitor {
    void besuch(Kunde kunde);  // Methode zum Besuchen eines Kunden
}

// Konkretes Element (Kunde) Klasse
class Kunde  {
    private String name;  // Name des Kunden

    // Konstruktor: Der Kunde wird mit einem Namen erstellt
    public Kunde(String name) {
        this.name = name;
    }

    // Getter-Methode: Gibt den Namen des Kunden zurück
    public String getName() {
        return name;
    }

    // Methode, die einen Besucher akzeptiert
    public void accept(Visitor besucher) {
        // Der Besucher besucht den Kunden
        besucher.besuch(this);
    }
}

// Konkreter Besucher (Taxi) Klasse
class Taxi implements Visitor {
    // Methode, um einen Kunden zu besuchen
    @Override
    public void besuch(Kunde kunde) {
        // Gibt aus, dass das Taxi für den Kunden kommt
        System.out.println("Taxi kommt für Kunde: " + kunde.getName());
        // Der Kunde wird transportiert
        transport(kunde);
    }

    // Methode, um den Kunden zu transportieren
    public void transport(Kunde kunde) {
        // Gibt aus, dass der Kunde mit dem Taxi transportiert wird
        System.out.println("Kunde " + kunde.getName() + " wird mit dem Taxi transportiert.");
    }
}

// Taxizentrale Klasse
class Taxizentrale {
    // Methode, um ein Taxi zu einem Kunden zu senden
    public void sendeTaxi(Kunde kunde, Visitor taxi) {
        // Gibt aus, dass der Kunde ein Taxi ruft
        System.out.println("Kunde ruft Taxi: " + kunde.getName());
        // Der Kunde akzeptiert das Taxi
        kunde.accept(taxi);
    }




    public static void main(String[] args) {
        // Zwei Kunden erstellen
        Kunde kunde1 = new Kunde("Ali");
        Kunde kunde2 = new Kunde("Lisa");
        Kunde kunde3 = new Kunde("David");

        // Taxi und Taxizentrale Objekte erstellen
        Taxi taxi = new Taxi();
        Taxizentrale zentrale = new Taxizentrale();

        // Taxi für den ersten Kunden senden
        zentrale.sendeTaxi(kunde1, taxi);  //  für Ali geschickt
        // Taxi für den zweiten Kunden senden
        zentrale.sendeTaxi(kunde2, taxi);  //  für Lisa geschickt
        zentrale.sendeTaxi(kunde3,taxi);
    }
}
