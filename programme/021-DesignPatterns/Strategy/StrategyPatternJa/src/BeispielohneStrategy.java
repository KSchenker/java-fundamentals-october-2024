public class BeispielohneStrategy {
    // Der Code prüft den Wert der Variable paymentMethod, um zu entscheiden, welche Art der Zahlung durchgeführt
    // werden soll. Diese if-else-Kaskade funktioniert wie folgt:

    if (paymentMethod.equals("CreditCard")) {
        // if (paymentMethod.equals("CreditCard")): Wenn paymentMethod den Wert "CreditCard" hat, dann wird die
        // Code-Ausführung in den Block geleitet, der Kreditkartenzahlungen enthält. In diesem Block wäre dann der Code
        // für die Kreditkartenzahlung unterzubringen.

    } else if (paymentMethod.equals("Paypal")) {
        // PayPal-Zahlung else if (paymentMethod.equals("Paypal")): Wenn paymentMethod stattdessen "Paypal" ist,
        // führt der Code stattdessen die PayPal-Zahlung aus, indem er den entsprechenden Block betritt.

    } else if (paymentMethod.equals("Cash")) {
        // Barzahlung else if (paymentMethod.equals("Cash")): Falls die Variable paymentMethod den Wert "Cash" hat,
        // wird der Code für Barzahlung ausgeführt.
    }
}
// Fällt keiner dieser Fälle zu, passiert nichts, da keine weitere Bedingung abgefragt wird.

// Für jede neue Zahlungsmethode müsste eine neue else if-Bedingung hinzugefügt werden, was den Code unnötig erweitert
// und unübersichtlicher macht.
// Das Open-Closed-Prinzip der SOLID-Prinzipien besagt, dass eine Klasse offen für Erweiterungen, aber geschlossen für
// Änderungen sein sollte. In diesem Fall müssten wir die BeispielohneStrategy-Klasse ändern, um eine neue
// Zahlungsmethode hinzuzufügen, was das Open-Closed-Prinzip verletzt.
// in diesem Code ist BeispielohneStrategy für alle Zahlungslogiken verantwortlich. Das bedeutet, dass der Code für
// jede Zahlungsart direkt in dieser Klasse untergebracht wäre