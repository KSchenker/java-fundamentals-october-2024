public class BeispielmitStrategy {

    // Zuerst das Strategy Interface
    // Das Interface PaymentStrategy definiert eine einzige Methode
    public interface PaymentStrategy {
        void pay(int amount);
    } // Zweck: Das INterface ist ein Vertrag, der beschreibt das jede Bezahlstrategie eine pay-Methode implementieren
      // muss, die einen Betrag (ammount) als Parameter erwartet.
      // Es zwingt jede Klasse, welche die PaymentStrategy implementiert, diese Methode zu definieren und somit die
      // Logik für die Bezahlung zu konkretisieren.


    // Danach die Implementierungen der Strategien CreditCardPayment und PayPalPayment
    // Die beiden Klassen CreditCardPayment und PayPalPayment implementieren das PaymentStrategy Interface.
    // Jede Klasse stellt eine spezifische Implementierung der pay-Methode dar.

    public class CreditCardPayment implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("Kreditkarte bezahlen: " + amount);
        } // Diese Klasse implementiert die pay-Methode für Kreditkartenzahlungen
          // Die Methode gibt eine Meldung auf der Konsole aus, die den bezahlten Betrag zusammen mit dem Hinweis
          // "Bezahlter Betrag mit Kreditkarte" zeigt.
    }
    // Dies Klasse imlplementiert die pay-Methode für PayPal-Zahlungen
    public class PayPalPayment implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("PayPal bezahlen: " + amount);
        }
    } // Beide Klassen spezifizieren, wie sie die Zahlung abwickeln, haben aber keine Verbindung zur Klasse,
      // die diese Strategie verwendet
    public class ApplePay implements PaymentStrategy {
        public void pay(int ammount) {
            System.out.println("ApplePayment bezahlen" + ammount);
        }
    }
    // Und dann die Verwendung des Strategien (Context-Klasse)
    // Die ShoppingCart-Klasse fungiert als "Context" und nutzt eine PaymentStrategy, um die Zahlungsweise zu bestimmen.
    public class ShoppingCard {
        private PaymentStrategy paymentStrategy;  // paymentStrategy ist eine Referenz auf das PaymentStrategy Interface
                              // Dadurch kann ShoppingCart eine beliebige Implementierung von PaymentStrategy verwenden.

        public ShoppingCard(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;  // Konstruktor der ShoppingCart-Klasse. Hier wird die
                              // paymentStrategy beim Erstellen eines ShoppingCart-Objekts übergeben. Dies ermöglicht es
                              // beim Erzeugen des Einkaufswagens eine spezifische Bezahlstrategie festzulegen.
        }
        public void makePayment(int amount) {
            paymentStrategy.pay(amount); // Methode: pay(int amount): Die pay-Methode in ShoppingCart ruft die
                                         // pay-Methode des aktuell gesetzten PaymentStrategy-Objekts auf und leitet
                                         // den Zahlungsbetrag (amount) weiter.
        }
    }  // Das bedeutet, dass ShoppingCart die Details der spezifischen Bezahlmethode nicht kennt und nicht kennen muss
       // sie kennt nur das PaymentStrategy Interface. Dies fördert die Flexibilität und Wiederverwendbarkeit des Codes.
}
// Das Strategy Pattern erlaubt es, eine Methode flexibel zu wechseln, ohne die eigentliche ShoppingCart-Klasse zu
// ändern. So kann man leicht neue Bezahlmethoden hinzufügen (z. B. googlePay, o.ä.), indem man eine neue Klasse
// schreibt, die PaymentStrategy implementiert. ShoppingCart bleibt davon unberührt,
// da nur das Interface PaymentStrategy benutzt wird.
