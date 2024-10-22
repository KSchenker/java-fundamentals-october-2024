package de.iad.contacts;

// Hinweis: Wir verwenden Strings für Hausnummer und Postleitzahl, da wir die führenden
// Nullen und Suffixe wie a, b abspeichern müssen.
public record Address(String street, String streetNumber, String zipCode, String city, String country) {
    @Override
    public String toString() {
        return
                """
                Straße      : %s
                Hausnummer  : %s
                Postleitzahl: %s
                Stadt       : %s
                Land        : %s""".formatted(this.street, this.streetNumber, this.zipCode, this.city, this.country);
    }
}
