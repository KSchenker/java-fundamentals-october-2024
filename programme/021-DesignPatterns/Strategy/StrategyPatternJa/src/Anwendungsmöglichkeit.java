public class Main {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment();
        ShoppingCart cart1 = new ShoppingCart(creditCard);
        cart1.pay(100);  // Ausgabe: Bezahlter Betrag mit Kreditkarte: 100

        PaymentStrategy paypal = new PayPalPayment();
        ShoppingCart cart2 = new ShoppingCart(paypal);
        cart2.pay(200);  // Ausgabe: Bezahlter Betrag mit PayPal: 200
    }
}
