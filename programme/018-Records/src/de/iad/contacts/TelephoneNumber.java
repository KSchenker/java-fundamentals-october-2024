package de.iad.contacts;

// Hinweis: Wir verwenden Strings für die Landes- und Ortsvorwahl, da hier führende Nullen gespeichert werden müssen.
// Bei der eigentlichen Anschlussnummer könnte man vermutlich auch einen int oder long nehmen.
public record TelephoneNumber(String countryCode, String areaCode, String number) {
    @Override
    public String toString() {
        // Erstelle die Telefonnummer im Format: +049 3741 123456
        // Hinweis: Wenn man die Landesvorwahl angibt, ist bei der Ortsvorwahl die führende Null wegzulassen.
        return "+%s %s %s".formatted(this.countryCode, this.areaCode.substring(1), number);
    }
}
